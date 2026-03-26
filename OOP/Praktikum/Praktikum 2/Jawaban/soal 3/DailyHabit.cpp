#include "DailyHabit.hpp"

DailyHabit::DailyHabit(const std::string& name) : Activity(name), streak(0) {};

int DailyHabit::complete() {
    streak++;
    return streak*10;
};

std::string DailyHabit::getStatus() const {
    return "[HABIT] " + name + " - Streak: " + to_string(streak);
}

DailyHabit::~DailyHabit() {
    cout << "Menghapus DailyHabit " << name << endl;
};