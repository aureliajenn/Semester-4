#pragma once
#include "Creature.hpp"

class Maiar : private Creature {
protected:
    using Creature::name;
    using Creature::hp;
    Maiar(const string& name, int hp, int power);

private:
    int power;

public:
    using Creature::getName;
    using Creature::getHp;
    int getPower() const;
    void describe() const override;
    virtual ~Maiar() = default;
};
