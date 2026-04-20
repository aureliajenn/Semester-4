#pragma once
#include "Player.hpp"
#include "Staff.hpp"
using namespace std;

class PlayerCoach : public Player, public Staff {
private:
    int yearsAsPlayer;
    bool isCurrentlyPlaying;

public:
    PlayerCoach(const string& name, int age, const string& contractEnd, const string& position, int stamina, double rating, const string& license, int yearsAsPlayer, bool isCurrentlyPlaying);

    void work() const override;
    double calculateRating() const override;
    string getSpecialty() const override;
    double calculateWage() const override;
    string getProfile() const override;

    ~PlayerCoach();
};