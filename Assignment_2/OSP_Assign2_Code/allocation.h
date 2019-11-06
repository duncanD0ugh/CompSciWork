#ifndef OSP_ASSIGN_1
#define OSP_ASSIGN_1

#include <unistd.h>
#include <stdlib.h>
#include <string>
#include <list>

void *alloc(size_t chunk_size);
void dealloc(void *memoryLocation);
void setStrategy(std::string strat);
size_t spaceInFreed();
int amountInFreed();
void readLockStart();
void readLockEnd();
void writeLockStart();
void writeLockEnd();

#endif // OSP_ASSIGN_1
