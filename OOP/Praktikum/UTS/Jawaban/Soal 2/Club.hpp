#pragma once
#include "ClubMember.hpp"
#include <string>
#include <vector>
using namespace std;

class Club {
private:
    string clubName;
    vector<ClubMember*> roster;

public:
    Club(string name);

    void addMember(ClubMember* member);
    void printSquadReport() const;
    void runTraining() const;

    ~Club();
};