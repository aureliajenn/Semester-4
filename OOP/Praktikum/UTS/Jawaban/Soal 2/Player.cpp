#include "Player.hpp"
#include "Formatter.hpp"
using namespace std;

Player::Player(const string& name, int age, const string& contractEnd, const string& position, int stamina, double rating)
    : ClubMember(name, age, contractEnd), position(position), stamina(stamina), rating(rating) {}

double Player::calculateWage() const {
    return rating * 10000.0;
}

Player::~Player() {
    Formatter::log("~Player", name, "training log freed.");
}