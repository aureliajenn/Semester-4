#pragma once
#include "Maiar.hpp"

class Balrog : public Maiar {
private:
    string whipName;

public:
    Balrog(string name, int hp, int power, string whipName);
    void describe() const override;
    void rage() const;
    ~Balrog();
};
