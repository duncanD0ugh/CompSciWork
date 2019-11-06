#include "allocation.h"
#include <list>
#include <iostream>

    struct memoryChunk
    {
        void* memoryLocation;
        size_t memorySize;
    };

static std::list<memoryChunk> freedList;
static std::list<memoryChunk> allocList;
std::string strategy;

void setStrategy(std::string strat)
{
    strategy = strat;
}

void* alloc(size_t chunk_size)
{
    void* returnAddress;
    memoryChunk newChunk;
    newChunk.memorySize = chunk_size;

    if(freedList.empty())
    {
        returnAddress = sbrk(chunk_size);
        newChunk.memoryLocation = returnAddress;
        allocList.push_back(newChunk);
    }
    else
    {
        memoryChunk temp;
        bool foundSpace = false;
        
        if(strategy == "firstfit") 
        {
            std::list<memoryChunk>::iterator it = freedList.begin();
            std::list<memoryChunk>::iterator allocated = freedList.end();

            while(it != freedList.end())
            {
                if(it->memorySize >= chunk_size)
                {
                    allocated = it;
                    foundSpace = true;
                    break;
                }
                ++it;
            }
            if(foundSpace)
            {
                newChunk.memoryLocation = allocated->memoryLocation;
                returnAddress = newChunk.memoryLocation;

                temp.memoryLocation = (void*)((bool*)allocated->memoryLocation + chunk_size/sizeof(bool));
                temp.memorySize = allocated->memorySize - chunk_size;
                
                freedList.erase(allocated);
                allocList.push_back(newChunk);
                freedList.push_back(temp);
            }
            else
            {
                returnAddress = sbrk(chunk_size);
                newChunk.memoryLocation = returnAddress;
                allocList.push_back(newChunk);
            }
            
        }
        else if(strategy == "bestfit")
        {
            std::list<memoryChunk>::iterator it = freedList.begin();
            std::list<memoryChunk>::iterator allocated = freedList.end();

            while(it != freedList.end())
            {
                if(it->memorySize >= chunk_size)
                {
                    if(it->memorySize < temp.memorySize)
                    {
                        allocated = it;
                    }
                }
                ++it;
            }
            if(foundSpace)
            {
                newChunk.memoryLocation = allocated->memoryLocation;
                returnAddress = newChunk.memoryLocation;

                temp.memoryLocation = (void*)((bool*)allocated->memoryLocation + chunk_size/sizeof(bool));
                temp.memorySize = allocated->memorySize - chunk_size;
                
                freedList.erase(allocated);
                allocList.push_back(newChunk);
                freedList.push_back(temp);
            }
            else
            {
                returnAddress = sbrk(chunk_size);
                newChunk.memoryLocation = returnAddress;
                allocList.push_back(newChunk);
            }        
        }
        else if(strategy == "worstfit")
        {
            std::list<memoryChunk>::iterator it = freedList.begin();
            std::list<memoryChunk>::iterator allocated = freedList.end();
            while(it != freedList.end())
            {
                if(it->memorySize >= chunk_size)
                {
                    if(it->memorySize > temp.memorySize)
                    {
                        allocated = it;
                    }
                }
                ++it;
            }
            if(foundSpace)
            {
                newChunk.memoryLocation = allocated->memoryLocation;
                returnAddress = newChunk.memoryLocation;

                temp.memoryLocation = (void*)((bool*)allocated->memoryLocation + chunk_size/sizeof(bool));
                temp.memorySize = allocated->memorySize - chunk_size;
                
                freedList.erase(allocated);
                allocList.push_back(newChunk);
                freedList.push_back(temp);
            }
            else
            {
                returnAddress = sbrk(chunk_size);
                newChunk.memoryLocation = returnAddress;
                allocList.push_back(newChunk);
            }          
        }
    }
    return returnAddress;
}

void dealloc(void* location)
{
    memoryChunk toFree;
    std::list<memoryChunk>::iterator it = allocList.begin();
    
    while(it != allocList.end() && it->memoryLocation != location)
    {
        ++it;
    }
    if(it != allocList.end())
    {
        toFree = *it;
        freedList.push_back(toFree);
        allocList.erase(it);
    }
    else
    {
        abort();
    }
}

size_t spaceInFreed()
{
    std::list<memoryChunk>::iterator it = freedList.begin();
    size_t total;
    while(it != freedList.end())
    {
        total = total + it->memorySize;
        ++it;
    }
    return total;
}

int amountInFreed()
{
    std::list<memoryChunk>::iterator it = freedList.begin();
    size_t total;
    while(it != freedList.end())
    {
        ++total;
        ++it;
    }
    return total;
}