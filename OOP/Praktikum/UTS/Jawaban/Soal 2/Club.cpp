#include "Club.hpp"
#include "Player.hpp"
#include "Staff.hpp"
#include <iostream>
using namespace std;

Club::Club(string name) : clubName(name) {}

void Club::addMember(ClubMember* member) {
    roster.push_back(member);
}

void Club::printSquadReport() const {
    cout << "\n======================================\n";
    cout << "  " << clubName << " - Squad Report\n";
    cout << "======================================\n";
    for (ClubMember* m : roster) {
        cout << m->getProfile() << "\n";
    }
}

void Club::runTraining() const {
    cout << "\n--- Match Day Actions ---\n";
    for (ClubMember* m : roster) {
        m->work();
    }
}

Club::~Club() {
    cout << "\n--- Releasing Club Roster ---\n";
    for (ClubMember* m : roster) {
        delete m;
    }
}