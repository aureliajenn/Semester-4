#pragma once
#include "Maiar.hpp"

class Wizard : private Maiar {
private:
    string staffName;

public:
    Wizard(string name, int hp, int power, string staffName);
    using Maiar::getName;
    using Maiar::getHp;
    using Maiar::getPower;
    void describe() const override;
    void cast() const;
    ~Wizard();
};
