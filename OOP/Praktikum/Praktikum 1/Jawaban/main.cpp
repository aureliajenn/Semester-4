#include "Paper.hpp"

int main(){
    Paper *a = new Paper('A');
    Paper *b = new Paper('B');
    Paper *c = new Paper('C');
    Paper *ccc = new Paper(*c);
    a->fold();
    b->fold();
    c->fold();
    c->glue();
    delete a;
    c->setName('X');
    ccc->fold();
    ccc->glue();
    delete ccc;
    delete c;
    delete b;
    return 0;
}