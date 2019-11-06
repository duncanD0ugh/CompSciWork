//#ifndef //header file name
#include <iostream>
#include <fstream>
#include <string>

void helloWorld()
{
    std::cout << "Hello World" << std::endl; //Print out using std::cout "Hello World"
}

void arrayCount()
{
    int arrayC[2] = {16, 2};
    int count = 2;

    for (int i = 0; i < count; ++i)
    {
        std::cout << arrayC[i] << "\n";
    }
}

void pointerExam()
{
    int pointA = 0;
    int pointB = 7;
    int *ptr = NULL;
    int *aPtr = &pointA;
    int *bPtr = &pointB;

    std::cout << "POINTER EXAMPLE"
              << "\n"
              << std::endl;
    std::cout << ptr << " - ptr" << std::endl;
    if (ptr != NULL)
    {
        *ptr = 10;
    }

    ptr = &pointB;

    std::cout << pointB << " - pointB" << std::endl;
    std::cout << pointA << " - pointA" << std::endl;
    std::cout << ptr << " - Memory Address of pointB through prt" << std::endl;
    std::cout << &pointA << " - Memory Address of pointA" << std::endl;
    std::cout << &pointB << " - Memory Address of pointB" << std::endl;

    int pointTemp = *aPtr;
    *aPtr = *bPtr;
    *bPtr = pointTemp;

    std::cout << *aPtr << " - Swapped pointA to pointB(Value)" << std::endl;
    std::cout << *bPtr << " - Swapped pointB to pointA(Value)" << std::endl;
}

void writeFile()
{
    std::string filename("text.txt");
    std::ofstream outFile;
    outFile.open(filename);
    outFile << "Read Succ" << std::endl;
    outFile << "This is a new line" << std::endl;
    outFile.close();
}

void readFile()
{
    std::string line;
    std::ifstream myfile("text.txt");
    if (myfile.is_open())
    {
        while (getline(myfile, line))
        {
            std::cout << line << '\n';
        }
        myfile.close();
    }

    else
        std::cout << "Unable to open file";
}

void appendFile()
{
    std::string filename("text.txt");
    std::ofstream outFile;
    outFile.open(filename, std::ofstream::app);
    outFile << "Appending to File" << std::endl; //adds new line
    outFile.close();
}

int main()
{
    arrayCount();
    helloWorld();
    pointerExam();
    writeFile();
    readFile();
    appendFile();
    readFile();
    return 0;
}

//#endif //Ending ifndef