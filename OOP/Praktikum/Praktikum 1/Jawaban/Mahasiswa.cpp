#include <iostream>
#include <string>
using namespace std;

class Mahasiswa {
private:
    string name;
    string nim;
    float ipk;
    int total_sks;

public:
    static int counter;
    Mahasiswa() {
        name = "NPC";
        nim = "135" + to_string(counter);
        counter++;
        ipk = 0;
        total_sks = 0;
    }

    Mahasiswa(string name) {
        this->name = name;
        nim = "135" + to_string(counter);
        counter++;
        ipk = 0;
        total_sks = 0;
    }

    void tambahNilai(float nilai, int sks) {
        ipk = (ipk * total_sks + nilai * sks) / (total_sks + sks);
        total_sks += sks;
    }

    void info() {
        printf("INFORMASI MAHASISWA\n");
        printf("Nama: %s\n", name.c_str());
        printf("NIM: %s\n", nim.c_str());
        printf("IPK: %.2f\n", ipk);
        printf("SKS: %d\n", total_sks);
    }
};

int Mahasiswa::counter = 0;