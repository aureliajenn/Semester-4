#include "VaultException.hpp"

VaultException::VaultException(const std::string& msg) : message(msg) {}

const char* VaultException::what() const noexcept {
    return message.c_str();
}

EmptyVaultException::EmptyVaultException()
    : VaultException("Error: Vault kosong") {}

FullVaultException::FullVaultException(size_t capacity)
    : VaultException("Error: Vault sudah penuh"), cap(capacity) {}

size_t FullVaultException::getCapacity() const noexcept {
    return cap;
}

InvalidRelicException::InvalidRelicException(const std::string& name, const std::string& reason)
    : VaultException("Error: Nama relic tidak valid - " + reason), relicName(name) {}

const std::string& InvalidRelicException::getRelicName() const noexcept {
    return relicName;
}