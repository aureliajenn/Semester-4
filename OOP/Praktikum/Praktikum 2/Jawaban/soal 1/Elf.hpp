#pragma once
#include "Creature.hpp"

class Elf : public Creature {
private:
    int grace;
public:
    Elf(string name, int hp, int grace);
    void describe() const override;
    int getGrace() const;
    virtual ~Elf();
};
