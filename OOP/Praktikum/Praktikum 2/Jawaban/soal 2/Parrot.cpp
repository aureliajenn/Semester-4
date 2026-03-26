#include "Parrot.hpp"

Parrot::Parrot(string name, int age, int vocabulary) : Pet(name, age), vocabulary(vocabulary){
    cout << "[PARROT] " << name << " entered knowing " << to_string(vocabulary) << " words" << endl;
};

Parrot::~Parrot(){
    cout << "[PARROT] " << name << " squawks goodbye" << endl;
};

void Parrot::makeSound() const {
    cout << "[SOUND] " << name << ": Squawk! I know " << to_string(vocabulary) << " words!" << endl;
};
void Parrot::play() {
    vocabulary += 1;
    happiness += 10;
    cout << "[PLAY] " << name << " learns a new word! Vocabulary: " << to_string(vocabulary) << ", Happiness: " << to_string(happiness) << endl;
};
void Parrot::feed() {
    happiness +=3;
    cout << "[FEED] " << name << " eats seeds! Happiness: "<< to_string(happiness) << endl;
};