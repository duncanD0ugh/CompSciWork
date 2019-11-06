#include "allocation.h"
#include <iostream>
#include <list>
#include <ctime>
#include <random>
#include <time.h>

#define EXIT_SUCCESS    0

int main(int argc, char* argv[])
{
    std::string arg2;
    if(argc != 3)
    {
        // show_usage();
        return 1;
    }
    else
    {
        std::string arg1 = argv[1];
        arg2 = argv[2];

        if(arg1 == "-s" && (arg2 == "firstfit" || arg2 == "bestfit" || arg2 == "worstfit"))
        {
            setStrategy(arg2);
        }
        else
        {
            // show_usage();
            return 1;
        }
    }

    //EXPERIMENT START
    int nine = 90000;
    int three = 30000;
    int six = 60000;
    int one = 10000;
    int two = 20000;

    void* newList[90000];
    int count = 0;
    int freedCount = 0;
    clock_t begin;
    clock_t end;
    int* intPtr;
    bool* boolPtr;
    long long int* longLongIntPtr;

    //Allocation - some new
    for(int i = 0; i < nine; ++i)
    {
        if(i < three)
        {
            intPtr = (int*)alloc(sizeof(int));
            *intPtr = 100*i;
            newList[i] = (void*)intPtr;
        }
        else if(i > three && i < six)
        {
            boolPtr = (bool*)alloc(sizeof(bool));
            *boolPtr = true;
            newList[i] = (void*)boolPtr;
        }
        else
        {
            longLongIntPtr = (long long int*)alloc(sizeof(long long int));
            *longLongIntPtr = 8446744073709551614;
            newList[i] = (void*)longLongIntPtr;
        }
        ++count;
    }
    std::cout << "Allocated [" << count << "] elements" << std::endl;

    //Deallocation - some old
    for(int j = 0; j < nine; ++j)
    {
        if(j % 2 == 0)
        {
            dealloc(newList[j]);
            ++freedCount;
            --count;
        }
    }
    std::cout << "Deallocated: [" << freedCount << "] items" << std::endl;

    //Reallocation - some new
    std::cout << "----------------------------------------------" << std::endl;
    std::cout << "Re Allocation Time" << std::endl;
    std::cout << "Strategy: [" << arg2 << "]" << std::endl; 

    begin = clock();
    for(int i = 0; i < three; ++i)
    {
        if(i < one)
        {
            intPtr = (int*)alloc(sizeof(int));
            *intPtr = i;
        }
        else if( i > one && i < two)
        {
            boolPtr = (bool*)alloc(sizeof(bool));
            *boolPtr = false;
        }
        else
        {
            longLongIntPtr = (long long int*)alloc(sizeof(long long int));
            *longLongIntPtr = 1;
        }
        --freedCount;
        ++count;
    }
    end = clock();

    std::cout << "Re-allocated : [300] elements using " << "strategy: [" << arg2 << "]" << std::endl;
    double elapsed_secs = double(end - begin) / (CLOCKS_PER_SEC);
    std::cout << "Time taken: [" << elapsed_secs << "]" << std::endl;
    std::cout << "Amount of elements in freedlist: [" << amountInFreed() << "]" << std::endl;
    std::cout << "Space Left in freedlist: [" << spaceInFreed() << "]" << std::endl;
    //EXPERIMENT END


    return EXIT_SUCCESS;
}