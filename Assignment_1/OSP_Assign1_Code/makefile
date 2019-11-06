.default: all

all: allocation

clean:
	rm -rf allocation *.o *.dSYM

allocation: allocation.o main.o
	g++ -Wall -pedantic -std=c++17 -g -O -o $@ $^

%.o: %.cpp
	g++ -Wall -pedantic -std=c++17 -g -O -c $^