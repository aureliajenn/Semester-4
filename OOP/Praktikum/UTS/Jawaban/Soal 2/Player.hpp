#pragma once
#include "ClubMember.hpp"
#include <string>
using namespace std;

class Player : public virtual ClubMember {
protected:
    string position;
    int stamina;
    double rating;

public:
    Player(const string& name, int age, const string& contractEnd, const string& position, int stamina, double rating);

    double calculateWage() const override;
    virtual double calculateRating() const = 0;

    virtual ~Player();
};