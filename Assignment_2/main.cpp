#include "allocation.h"
#include <iostream>
#include <list>
#include <ctime>
#include <random>
#include <time.h>

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

#define EXIT_SUCCESS 0
#define EXIT_FAILURE 1
#define NUMTHREADS 5

void *experiment(void *voidStar);
std::string arg2;

int main(int argc, char *argv[])
{
    //SETTING STRATEGY
    if (argc != 3)
    {
        return EXIT_FAILURE;
    }
    else
    {
        std::string arg1 = argv[1];
        arg2 = argv[2];

        if (arg1 == "-s" && (arg2 == "firstfit" || arg2 == "bestfit" || arg2 == "worstfit"))
        {
            setStrategy(arg2);
        }
        else
        {
            return 1;
        }
    }

    //CREATING THREADS
    pthread_t threads[NUMTHREADS];
    int count;

    for (count = 0; count < NUMTHREADS; ++count)
    {
        int result = pthread_create(&threads[count], NULL, experiment, NULL);

        if (result != 0)
        {
            fprintf(stderr, "%s\n", strerror(result));
            return EXIT_FAILURE;
        }
    }

    //JOINING THREADS
    for (count = 0; count < NUMTHREADS; ++count)
    {
        int result = pthread_join(threads[count], NULL);

        if (result != 0)
        {
            fprintf(stderr, "%s\n", strerror(result));
            return EXIT_FAILURE;
        }
    }

    return EXIT_SUCCESS;
}

void *experiment(void *voidStar)
{
    int multi = 10000;
    int initial = 10*multi;
    int one = 1*multi;
    int two = 2*multi;
    int three = 3*multi;

    void *newList[100000];
    int count = 0;
    int freedCount = 0;

    clock_t begin;
    clock_t end;

    int *intPtr;
    bool *boolPtr;
    long long int *longLongIntPtr;

    //Allocation - some new
    for (int i = 0; i < initial; ++i)
    {
        // std::cout << "1: " << i << std::endl;
        if (i < initial/3)
        {
            intPtr = (int *)alloc(sizeof(int));
            *intPtr = 100 * i;
            newList[i] = (void *)intPtr;
        }
        else if (i > initial/3 && i < (initial/3)*2)
        {
            boolPtr = (bool *)alloc(sizeof(bool));
            *boolPtr = true;
            newList[i] = (void *)boolPtr;
        }
        else
        {
            longLongIntPtr = (long long int *)alloc(sizeof(long long int));
            *longLongIntPtr = 8446744073709551614;
            newList[i] = (void *)longLongIntPtr;
        }
        ++count;
    }

    //Deallocation - some old
    for (int j = initial - 1; j > -1; --j)
    {
        if (j % 2 == 0)
        {
            // std::cout << "2: " << j << std::endl;
            dealloc(newList[j]);
            ++freedCount;
            --count;
        }
    }

    //Reallocation - some new
    begin = clock();
    for (int i = 0; i < initial/2; ++i)
    {
        // std::cout << "3: " << i << std::endl;
        if (i < one)
        {
            intPtr = (int *)alloc(sizeof(int));
            *intPtr = i;
        }
        else if ((i > one) && (i < two))
        {
            boolPtr = (bool *)alloc(sizeof(bool));
            *boolPtr = false;
        }
        else if((i > two) && (i < three))
        {
            longLongIntPtr = (long long int *)alloc(sizeof(long long int));
            *longLongIntPtr = 1;
        }
        --freedCount;
        ++count;
    }
    end = clock();
    double elapsed_secs = double(end - begin) / (CLOCKS_PER_SEC);

    std::cout << "----------------------------------------------" << std::endl;
    std::cout << "Thread [" << pthread_self() << "]" << std::endl;
    std::cout << "Allocated [" << initial << "] elements" << std::endl;
    std::cout << "Deallocated: [" << initial/2 << "] elements" << std::endl;
    std::cout << "Re Allocation Time" << std::endl;
    std::cout << "Strategy: [" << arg2 << "]" << std::endl;
    std::cout << "Re-allocated : [" << three << "] elements using "
              << "strategy: [" << arg2 << "]" << std::endl;
    std::cout << "Time taken: [" << elapsed_secs << "]" << std::endl;
    std::cout << "Amount of elements in freedlist: [" << amountInFreed() << "]" << std::endl;
    std::cout << "Space Left in freedlist: [" << spaceInFreed() << "]" << std::endl;

    return NULL;
}