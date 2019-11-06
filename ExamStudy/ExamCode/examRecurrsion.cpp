int number = 10;
foo(number);
/*--------------------------------*/
foo(int a)
{
    --a;
    if(a = 0)
    {
        cout << "DONE" << endl;
    }
    else
    {
        foo(a);
    }
}