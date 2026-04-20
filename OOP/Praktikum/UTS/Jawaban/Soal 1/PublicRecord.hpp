#ifndef PUBLIC_RECORD_HPP
#define PUBLIC_RECORD_HPP

#include "BaseRecord.hpp"
using namespace std;

class PublicRecord : public BaseRecord {
public:
    PublicRecord(string author, int key);
    int calculateClearance() const override;
};

#endif