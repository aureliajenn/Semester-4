#ifndef RELIC_VAULT_HPP
#define RELIC_VAULT_HPP

#include <string>
#include <vector>
#include "VaultException.hpp"

class RelicVault {
private:
    std::vector<std::string> stack;
    size_t maxCapacity;

    void validateName(const std::string& name) const;

public:
    RelicVault(size_t capacity);

    void push(const std::string& name);
    std::string pop();
    std::string top() const;
    size_t size() const;
    size_t capacity() const;
    bool empty() const;
};

#endif
