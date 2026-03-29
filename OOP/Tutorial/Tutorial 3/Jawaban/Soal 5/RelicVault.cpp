#include "RelicVault.hpp"
#include <cctype>

RelicVault::RelicVault(size_t capacity) : maxCapacity(capacity) {}

void RelicVault::validateName(const std::string& name) const {
    if (name.size() < 3) {
        throw InvalidRelicException(name, "nama terlalu pendek");
    }
    for (char c : name) {
        if (std::isdigit(static_cast<unsigned char>(c))) {
            throw InvalidRelicException(name, "mengandung angka");
        }
    }
}

void RelicVault::push(const std::string& name) {
    validateName(name);
    if (stack.size() >= maxCapacity) {
        throw FullVaultException(maxCapacity);
    }
    stack.push_back(name);
}

std::string RelicVault::pop() {
    if (stack.empty()) {
        throw EmptyVaultException();
    }
    std::string item = stack.back();
    stack.pop_back();
    return item;
}

std::string RelicVault::top() const {
    if (stack.empty()) {
        throw EmptyVaultException();
    }
    return stack.back();
}

size_t RelicVault::size() const {
    return stack.size();
}

size_t RelicVault::capacity() const {
    return maxCapacity;
}

bool RelicVault::empty() const {
    return stack.empty();
}
