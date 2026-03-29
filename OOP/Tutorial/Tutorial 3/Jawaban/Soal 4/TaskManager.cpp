#include "TaskManager.hpp"

void TaskManager::add(const string& id, const string& title, int priority, int duration) {
    tasks.emplace_back(id, title, priority, duration);
}

void TaskManager::add(const Task& task) {
    tasks.push_back(task);
}

void TaskManager::update(const string& id, const string& title, int priority, int duration) {
    auto it = find_if(tasks.begin(), tasks.end(), [&](const Task& t) {
        return t.getId() == id;
    });
    if (it != tasks.end()) {
        it->setTitle(title);
        it->setPriority(priority);
        it->setDuration(duration);
    }
}

bool TaskManager::remove(const string& id) {
    auto it = find_if(tasks.begin(), tasks.end(), [&](const Task& t) {
        return t.getId() == id;
    });
    if (it == tasks.end()) return false;
    tasks.erase(it);
    return true;
}

const Task* TaskManager::find(const string& id) const {
    auto it = find_if(tasks.begin(), tasks.end(), [&](const Task& t) {
        return t.getId() == id;
    });
    return (it != tasks.end()) ? &(*it) : nullptr;
}

void TaskManager::sort() {
    std::sort(tasks.begin(), tasks.end(), [](const Task& a, const Task& b) {
        if (a.getPriority() != b.getPriority()) return a.getPriority() > b.getPriority();
        if (a.getDuration() != b.getDuration()) return a.getDuration() < b.getDuration();
        return a.getId() < b.getId();
    });
}

long long TaskManager::totalDuration(long long minPriority) const {
    return accumulate(tasks.begin(), tasks.end(), 0LL, [&](long long sum, const Task& t) {
        return sum + (t.getPriority() >= minPriority ? t.getDuration() : 0);
    });
}

void TaskManager::print(const string& keyword) const {
    bool found = false;
    for_each(tasks.begin(), tasks.end(), [&](const Task& t) {
        if (t.getTitle().find(keyword) != string::npos) {
            cout << t.getId() << "|" << t.getTitle() << "|" << t.getPriority() << "|" << t.getDuration() << "\n";
            found = true;
        }
    });
    if (!found) cout << "EMPTY\n";
}

void TaskManager::print() const {
    if (tasks.empty()) {
        cout << "EMPTY\n";
        return;
    }
    for_each(tasks.begin(), tasks.end(), [](const Task& t) {
        cout << t.getId() << "|" << t.getTitle() << "|" << t.getPriority() << "|" << t.getDuration() << "\n";
    });
}