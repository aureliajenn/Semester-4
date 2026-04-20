#ifndef SAFE_BOX_HPP
#define SAFE_BOX_HPP

#include <iostream>
#include <functional>
#include <vector>
#include <algorithm>
#include "SafeBoxException.hpp"
using namespace std;

template<typename T>
class SafeBox {
private:
    vector<T> items;
    int cap;
    function<bool(const T&)> validator;

public:
    SafeBox(int capacity, function<bool(const T&)> validator = nullptr)
        : cap(capacity), validator(validator) {}

    void store(const T& item) {
        if (validator && !validator(item)) {
            throw InvalidItemException<T>(item);
        }
        if ((int)items.size() >= cap) {
            throw BoxFullException(cap);
        }
        items.push_back(item);
    }

    T retrieve() {
        if (items.empty()) throw BoxEmptyException();
        T val = items.back();
        items.pop_back();
        return val;
    }

    T peek() const {
        if (items.empty()) throw BoxEmptyException();
        return items.back();
    }

    void reverse() {
        if (items.empty()) throw BoxEmptyException();
        std::reverse(items.begin(), items.end());
    }

    int size() const { return (int)items.size(); }
    int capacity() const { return cap; }
    bool isEmpty() const { return items.empty(); }

    friend ostream& operator<<(ostream& os, const SafeBox<T>& box) {
        os << "[";
        for (int i = 0; i < (int)box.items.size(); i++) {
            if (i > 0) os << ", ";
            os << box.items[i];
        }
        os << "]";
        return os;
    }
};

template<typename T>
int safeMerge(SafeBox<T>& src, SafeBox<T>& dst) {
    int moved = 0;
    while (!src.isEmpty()) {
        T item = src.retrieve();
        try {
            dst.store(item);
            moved++;
        } catch (BoxFullException&) {
            break;
        }
    }
    return moved;
}

#endif