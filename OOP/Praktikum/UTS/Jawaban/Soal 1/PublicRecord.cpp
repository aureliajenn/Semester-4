#include "PublicRecord.hpp"
using namespace std;
PublicRecord::PublicRecord(string author, int key) : BaseRecord(author, key) {}

int PublicRecord::calculateClearance() const {
    return 0;
}