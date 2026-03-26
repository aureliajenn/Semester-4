#include "Maiar.hpp"
#include <iostream>
using namespace std;

Maiar::Maiar(const string& name, int hp, int power): Creature(name, hp), power(power) {}

int Maiar::getPower() const {
    return power;
}

void Maiar::describe() const {
    cout << "Maiar [" << getName() << "] | HP: " << getHp() << " | Power: " << getPower() << endl;
}
