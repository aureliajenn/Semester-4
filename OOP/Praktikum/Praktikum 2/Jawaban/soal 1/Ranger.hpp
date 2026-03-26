#pragma once
#include "Elf.hpp"

class Ranger : public Elf {
private:
    int arrows;
public:
    Ranger(string name, int hp, int grace, int arrows);
    void describe() const override;
    void shoot();
    ~Ranger();
};
