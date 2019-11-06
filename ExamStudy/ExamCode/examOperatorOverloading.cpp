//Cleaner to interpret
//String class has arithmitic operation for + already

//Comparison operators
bool type::operator==(const Class& rhs) const;
bool Vector::operator==(const Vector& rhsVec) const;

bool type::operator<(const Class& rhs) const;

//Access operators
type& operator[](const int index);
double& operator[](const int index); //double because in the example its a vector of doubles

//Self modifying arithmetic operators //return *this
Object& operator+=(const Object& rhs);

Object& operator+=(int rhs);

//New arithmetic operators
Object operator+(const Object& rhs) const; //needs to create a new obejct then make it lhs + rhs //return *this

//Assignment operator
Object& operator=(const Object& rhs); //return *this

//Increment operators
    //Pre
    Object& operator++();
    //Post
    Object operator++(int);

//Stream operators
std::ostream& operator<<(std::ostream& os, other& vec);