#pragma once
#include <string>
#include <iostream>
using namespace std;

class Creature {
protected:
    string name;
    int hp;

public:
    Creature(const string& name, int hp);

    string getName() const;
    int    getHp()   const;

    virtual void describe() const = 0;
    virtual ~Creature() = default;
};