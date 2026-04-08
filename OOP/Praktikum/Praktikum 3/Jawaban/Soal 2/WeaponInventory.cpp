#include "WeaponInventory.hpp"
using namespace std;

void WeaponInventory::add(const string &id, const string &name, const string &type, int damage, int rarity) {
    weapons.emplace_back(id, name, type, damage, rarity);
}

bool WeaponInventory::remove(const string &id) {
    auto it = find_if(weapons.begin(), weapons.end(),
                      [&id](const Weapon &w) { return w.id == id; });
    if (it == weapons.end()) return false;
    weapons.erase(it);
    return true;
}

const Weapon *WeaponInventory::find(const string &id) const {
    auto it = find_if(weapons.begin(), weapons.end(),
                      [&id](const Weapon &w) { return w.id == id; });
    if (it == weapons.end()) return nullptr;
    return &(*it);
}

void WeaponInventory::update(const string &id, const string &name, const string &type, int damage, int rarity) {
    auto it = find_if(weapons.begin(), weapons.end(),
                      [&id](const Weapon &w) { return w.id == id; });
    if (it == weapons.end()) return;
    it->name   = name;
    it->type   = type;
    it->damage = damage;
    it->rarity = rarity;
}

void WeaponInventory::sort() {
    std::sort(weapons.begin(), weapons.end(), [](const Weapon &a, const Weapon &b) {
        if (a.rarity != b.rarity) return a.rarity > b.rarity;
        if (a.damage != b.damage) return a.damage > b.damage;
        return a.id < b.id;
    });
}

long long WeaponInventory::totalDamage(const string &type) const {
    return accumulate(weapons.begin(), weapons.end(), 0LL,
                      [&type](long long sum, const Weapon &w) {
                          return sum + (w.type == type ? w.damage : 0);
                      });
}

int WeaponInventory::countByRarity(int minRarity) const {
    return count_if(weapons.begin(), weapons.end(),
                    [minRarity](const Weapon &w) { return w.rarity >= minRarity; });
}

void WeaponInventory::printByType(const string &type) const {
    bool found = false;
    for_each(weapons.begin(), weapons.end(), [&](const Weapon &w) {
        if (w.type == type) {
            cout << w.id << "|" << w.name << "|" << w.type << "|" << w.damage << "|" << w.rarity << "\n";
            found = true;
        }
    });
    if (!found) cout << "EMPTY\n";
}

void WeaponInventory::print() const {
    if (weapons.empty()) {
        cout << "EMPTY\n";
        return;
    }
    for_each(weapons.begin(), weapons.end(), [](const Weapon &w) {
        cout << w.id << "|" << w.name << "|" << w.type << "|" << w.damage << "|" << w.rarity << "\n";
    });
}

int WeaponInventory::upgradeAll(const string &type, int bonusDamage) {
    int count = 0;
    for_each(weapons.begin(), weapons.end(), [&](Weapon &w) {
        if (w.type == type) {
            w.damage += bonusDamage;
            count++;
        }
    });
    return count;
}