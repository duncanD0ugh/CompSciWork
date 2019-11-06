//Function that exists within the inner scope of another function
auto compare = [](int i, int j)
{
    bool retBool = false;
    if(j > i)
    {
        retBool = true;
    }
    return retBool;
};
//Use auto instead of (bool(int, int))

int i;
auto compareToI = [&i](int j)
{
    bool retBool = false;
    if(j > i)
    {
        retBool = true;
    }
    return retBool;
};
//Capturing the reference to i instead of using it as a parameter