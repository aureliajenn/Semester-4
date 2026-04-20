#include "InternalRecord.hpp"
using namespace std;

InternalRecord::InternalRecord(string author, int key): BaseRecord(author, key) {}

int InternalRecord::peekSecurity() const {
    return BaseRecord::calculateClearance() * 2;
}