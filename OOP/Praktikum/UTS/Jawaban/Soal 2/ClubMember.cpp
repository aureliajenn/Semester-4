#include "ClubMember.hpp"
#include "Formatter.hpp"
#include <iostream>
using namespace std;

ClubMember::ClubMember(const string& name, int age, const string& contractEnd)
    : name(name), age(age), contractEnd(contractEnd)
{
}

ClubMember::~ClubMember() {
    Formatter::log("~ClubMember", name, "contract record cleared.");
}