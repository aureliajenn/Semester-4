#ifndef SECURE_VAULT_RECORD_HPP
#define SECURE_VAULT_RECORD_HPP

#include "BaseRecord.hpp"
using namespace std;

class SecureVaultRecord : private BaseRecord {
public:
    SecureVaultRecord(string author, int key);
};

#endif