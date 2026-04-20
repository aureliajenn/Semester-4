#include "Staff.hpp"
#include "Formatter.hpp"
using namespace std;

Staff::Staff(const string& name, int age, const string& contractEnd, const string& license, const string& dept)
    : ClubMember(name, age, contractEnd), coachingLicense(license), department(dept) {}

double Staff::calculateWage() const {
    return 50000.0;
}

Staff::~Staff() {
    Formatter::log("~Staff", name, "session record freed.");
}