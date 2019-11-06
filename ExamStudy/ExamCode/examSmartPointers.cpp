//Self managed objects delete themselves with all pointers (references) to it go
//i.e. if an object had only smart pointers, and they go out of scope, the object is deleted
    //Unique pointers make it that only one unique pointer can point to a single objects
    //Shared pointers allow multiple shared pointers to point to a single object

#include <memory>

int a = 10;

int* number = &a;
std:shared_ptr<int> number = std::make_shared<int>(a);
//takes a, as a copy, so a copy constructor should be pre made to ensure a deep copy of all of a's contents)
//or takes a pointer on its own, = ptr.
