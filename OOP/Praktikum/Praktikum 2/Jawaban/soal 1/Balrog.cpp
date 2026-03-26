#include "Balrog.hpp"
#include <iostream>
using namespace std;

Balrog::Balrog(string name, int hp, int power, string whipName): Maiar(name, hp, power), whipName(whipName) {}

void Balrog::describe() const {
    cout << "Balrog [" << getName() << "] | HP: " << getHp() << " | Power: " << getPower() << " | Whip: " << whipName << endl;
}

void Balrog::rage() const {
    cout << getName() << " cracks " << whipName << " with " << getPower() << " power!" << endl;
}

Balrog::~Balrog() {}
