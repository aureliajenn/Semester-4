#include "TodoItem.hpp"
    
TodoItem::TodoItem(const std::string& name) : Activity(name) , isDone(false) {};
    
// Override metode dari base class
int TodoItem::complete() {
    if (isDone) {
        return 0;
    }
    isDone = true;
    return 10;
};

std::string TodoItem::getStatus() const {
    if (!isDone) {
        return "[TODO] " + name + " - Belum";
    } else {
        return "[TODO] " + name + " - Selesai";
    }
};

TodoItem::~TodoItem() {
    cout << "Menghapus TodoItem " << name << endl;
};

