#include "allocation.h"
#include <list>
#include <iostream>
#include <pthread.h>

struct memoryChunk
{
    void *memoryLocation;
    size_t memorySize;
    pthread_mutex_t chunkMutex = PTHREAD_MUTEX_INITIALIZER;
};

enum Strategy
{
    FIRSTFIT,
    BESTFIT,
    WORSTFIT
};
static std::list<memoryChunk> freedList;
static std::list<memoryChunk> allocList;
Strategy strategy;
int readers = 0;
int writers = 0;
int waitingReaders = 0;
int waitingWriters = 0;
static pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;
static pthread_cond_t readCond = PTHREAD_COND_INITIALIZER;
static pthread_cond_t writeCond = PTHREAD_COND_INITIALIZER;

void setStrategy(std::string strat)
{
    if (strat == "firstfit")
    {
        strategy = FIRSTFIT;
    }
    else if (strat == "bestfit")
    {
        strategy = BESTFIT;
    }
    else if (strat == "worstfit")
    {
        strategy = WORSTFIT;
    }
    else
    {
        std::cout << "Invalid strategy, arg2" << std::endl;
        abort();
    }
}

void *alloc(size_t chunk_size)
{
    void *returnAddress = nullptr;
    memoryChunk newChunk;
    newChunk.memorySize = chunk_size;
    if (freedList.empty())
    {
        pthread_mutex_lock(&mutex);
        returnAddress = sbrk(chunk_size);
        newChunk.memoryLocation = returnAddress;
        allocList.push_back(newChunk);
        pthread_mutex_unlock(&mutex);
    }
    else
    {
        readLockStart();
        memoryChunk tempMemoryChunk;
        bool foundSpace = false;
        bool endAlloc = true;
        if (strategy == FIRSTFIT)
        {
            std::list<memoryChunk>::iterator it = freedList.begin();
            std::list<memoryChunk>::iterator allocated = freedList.end();
            while (it != freedList.end())
            {
                if (it->memorySize >= chunk_size)
                {
                    if (pthread_mutex_trylock(&(it->chunkMutex)) == 0)
                    {
                        allocated = it;
                        endAlloc = false;
                        break;
                    }
                }
                ++it;
            }
            writeLockStart();
            it = freedList.begin();
            foundSpace = false;
            if (!endAlloc)
            {
                while (it != freedList.end())
                {
                    if (it->memoryLocation == allocated->memoryLocation)
                    {
                        foundSpace = true;
                        break;
                    }
                    ++it;
                }
            }
            if (foundSpace)
            {
                newChunk.memoryLocation = allocated->memoryLocation;
                returnAddress = newChunk.memoryLocation;

                tempMemoryChunk.memoryLocation = (void *)((bool *)allocated->memoryLocation + chunk_size / sizeof(bool));
                tempMemoryChunk.memorySize = allocated->memorySize - chunk_size;
                pthread_mutex_unlock(&(allocated->chunkMutex));
                freedList.erase(allocated);
                allocList.push_back(newChunk);
                freedList.push_back(tempMemoryChunk);
            }
            else
            {
                returnAddress = sbrk(chunk_size);
                newChunk.memoryLocation = returnAddress;
                allocList.push_back(newChunk);
            }
            writeLockEnd();
        }

        else if (strategy == BESTFIT)
        {
            std::list<memoryChunk>::iterator it = freedList.begin();
            std::list<memoryChunk>::iterator allocated = freedList.end();

            while (it != freedList.end())
            {
                if (it->memorySize >= chunk_size)
                {
                    if (it->memorySize < tempMemoryChunk.memorySize)
                    {
                        if (pthread_mutex_trylock(&(it->chunkMutex)) == 0)
                        {
                            allocated = it;
                            endAlloc = false;
                            if (it->memorySize == tempMemoryChunk.memorySize)
                            {
                                break;
                            }
                        }
                    }
                }
                ++it;
            }
            writeLockStart();
            it = freedList.begin();
            foundSpace = false;
            if (!endAlloc)
            {
                while (it != freedList.end())
                {
                    if (it->memoryLocation == allocated->memoryLocation)
                    {
                        foundSpace = true;
                        break;
                    }
                    ++it;
                }
            }

            if (foundSpace)
            {
                newChunk.memoryLocation = allocated->memoryLocation;
                returnAddress = newChunk.memoryLocation;

                tempMemoryChunk.memoryLocation = (void *)((bool *)allocated->memoryLocation + chunk_size / sizeof(bool));
                tempMemoryChunk.memorySize = allocated->memorySize - chunk_size;

                freedList.erase(allocated);
                allocList.push_back(newChunk);
                freedList.push_back(tempMemoryChunk);
            }
            else
            {
                returnAddress = sbrk(chunk_size);
                newChunk.memoryLocation = returnAddress;
                allocList.push_back(newChunk);
            }
            writeLockEnd();
        }

        else if (strategy == WORSTFIT)
        {
            std::list<memoryChunk>::iterator it = freedList.begin();
            std::list<memoryChunk>::iterator allocated = freedList.end();

            while (it != freedList.end())
            {
                if (it->memorySize >= chunk_size)
                {
                    if (it->memorySize > tempMemoryChunk.memorySize)
                    {
                        if (pthread_mutex_trylock(&(it->chunkMutex)) == 0)
                        {
                            allocated = it;
                            endAlloc = false;
                        }
                    }
                }
                ++it;
            }

            writeLockStart();
            it = freedList.begin();
            foundSpace = false;
            if (!endAlloc)
            {
                while (it != freedList.end())
                {
                    if (it->memoryLocation == allocated->memoryLocation)
                    {
                        foundSpace = true;
                        break;
                    }
                    ++it;
                }
            }

            if (foundSpace)
            {
                newChunk.memoryLocation = allocated->memoryLocation;
                returnAddress = newChunk.memoryLocation;

                tempMemoryChunk.memoryLocation = (void *)((bool *)allocated->memoryLocation + chunk_size / sizeof(bool));
                tempMemoryChunk.memorySize = allocated->memorySize - chunk_size;

                freedList.erase(allocated);
                allocList.push_back(newChunk);
                freedList.push_back(tempMemoryChunk);
            }
            else
            {
                returnAddress = sbrk(chunk_size);
                newChunk.memoryLocation = returnAddress;
                allocList.push_back(newChunk);
            }
            writeLockEnd();
        }
    }
    return returnAddress;
}

void dealloc(void *location)
{
    pthread_mutex_lock(&mutex);
    memoryChunk toFree;
    std::list<memoryChunk>::iterator it = allocList.begin();
    while (it != allocList.end() && it->memoryLocation != location)
    {
        ++it;
    }
    if (it != allocList.end())
    {
        toFree = *it;
        freedList.push_back(toFree);
        allocList.erase(it);
    }
    else
    {
        abort();
    }
    pthread_mutex_unlock(&mutex);
}

size_t spaceInFreed()
{
    std::list<memoryChunk>::iterator it = freedList.begin();
    size_t total = 0;
    while (it != freedList.end())
    {
        total = total + it->memorySize;
        ++it;
    }
    return total;
}

int amountInFreed()
{
    std::list<memoryChunk>::iterator it = freedList.begin();
    size_t total = 0;
    while (it != freedList.end())
    {
        ++total;
        ++it;
    }
    return total;
}

void readLockStart()
{
    pthread_mutex_lock(&mutex);
    while (writers > 0)
    {
        ++waitingReaders;
        pthread_cond_wait(&readCond, &mutex);
        --waitingReaders;
    }
    ++readers;
    pthread_mutex_unlock(&mutex);
}

void writeLockStart()
{
    pthread_mutex_lock(&mutex);
    --readers;
    while (readers > 0 || writers > 0)
    {
        ++waitingWriters;
        pthread_cond_wait(&writeCond, &mutex);
        --waitingWriters;
    }
    ++writers;
    pthread_mutex_unlock(&mutex);
}

void writeLockEnd()
{
    pthread_mutex_lock(&mutex);
    --writers;
    if (waitingWriters == 0 && waitingReaders > 0)
    {
        pthread_cond_signal(&readCond);
    }
    else if (readers == 0 && waitingWriters > 0)
    {
        pthread_cond_signal(&writeCond);
    }
    pthread_mutex_unlock(&mutex);
}