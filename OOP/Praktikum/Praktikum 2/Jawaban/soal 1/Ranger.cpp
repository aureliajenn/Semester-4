#include "Ranger.hpp"
#include <iostream>
using namespace std;

Ranger::Ranger(string name, int hp, int grace, int arrows): Elf(name, hp, grace), arrows(arrows) {}

void Ranger::describe() const {
    cout << "Ranger [" << name << "] | HP: " << hp << " | Grace: " << getGrace() << " | Arrows: " << arrows << endl;
}

void Ranger::shoot() {
    cout << name << " draws an arrow (grace: " << getGrace() << ") and fires! Arrows left: " << (arrows - 1) << endl;
    arrows--;
}

Ranger::~Ranger() {}
