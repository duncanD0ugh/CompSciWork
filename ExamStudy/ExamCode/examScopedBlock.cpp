//block
int scoping()
{
    int x = 5;
    cout << x << endl;
    {
        int x = 2;
        cout << x << endl;
    }
    cout << x << endl;
}
//x = 5, 2, 5