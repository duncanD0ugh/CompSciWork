#include <random>

int min = 1;
int max = 10;
int seed = 100;

// std::default_random_engine engine(seed);
std::random_device engine;
std::uniform_int_distribution<int> uniform_dist(min, max);

int value = -1;
for (int i = 0; i != 10; ++i) {
    value = uniform_dist(engine);
    cout << "Randomly-chosen value: " << value << endl;
}