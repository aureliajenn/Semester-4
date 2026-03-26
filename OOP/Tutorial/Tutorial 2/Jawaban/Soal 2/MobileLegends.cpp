#include <iostream>
#include "Hero.hpp"
#include "Tigreal.hpp"
#include "Layla.hpp"

int main(){
    Layla *l1 = new Layla(10,1000);
    l1->useSkill();
    Layla *lc1 = new Layla(*l1);
    l1->heal(5);

    Layla *l2 = new Layla(50,200);
    l2->moveTo(15,30);

    Layla *lc3 = l2;
    *lc3 = *lc1;
    Tigreal *t1 = new Tigreal(200,10);
    t1->moveTo(5,15);
    t1->taunt(10);
    Tigreal *tc1 = new Tigreal(*t1);

    Tigreal *t2 = new Tigreal(400,20);
    t2->sacredHammer();
    Tigreal *tc2 = new Tigreal(*t2);

    t1->useSkill();
    t2->useSkill();

    Tigreal *t3 = new Tigreal(300,15);
    t3->moveTo(10,20);

    Tigreal *tc3 = new Tigreal(*t3);
    t3->taunt(5);

    delete tc3;
    delete lc3;
    delete lc1;
    delete l1;
    delete t3;
    delete tc2;
    delete t2;
    delete tc1;
    delete t1;
}
