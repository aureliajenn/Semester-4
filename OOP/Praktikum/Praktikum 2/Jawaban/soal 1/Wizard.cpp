#include "Wizard.hpp"
#include <iostream>
using namespace std;

Wizard::Wizard(string name, int hp, int power, string staffName): Maiar(name, hp, power), staffName(staffName) {}

void Wizard::describe() const {
    cout << "Wizard [" << getName() << "] | HP: " << getHp() << " | Staff: " << staffName << endl;
}

void Wizard::cast() const {
    cout << getName() << " channels " << getPower() << " power through " << staffName << "!" << endl;
}

Wizard::~Wizard() {}
