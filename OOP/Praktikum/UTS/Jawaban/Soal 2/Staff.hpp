#pragma once
#include "ClubMember.hpp"
#include <string>
using namespace std;

class Staff : public virtual ClubMember {
protected:
    string coachingLicense;
    string department;

public:
    Staff(const string& name, int age, const string& contractEnd, const string& license, const string& dept);

    double calculateWage() const override;
    virtual string getSpecialty() const = 0;

    virtual ~Staff();
};