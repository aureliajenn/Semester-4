#include "Penganan.hpp"
#include <stdio.h>

int Penganan::uang = 0;
int Penganan::n_rumah = 0;

// ctor tanpa parameter
// inisialisasi seluruh koefisien dengan nilai 0
Penganan::Penganan() {
    keik = 0;
    panekuk = 0;
}

// ctor dengan parameter
Penganan::Penganan(int keik, int panekuk) {
    this->keik = keik;
    this->panekuk = panekuk;
}

//mengembalikan bagian jumlah keik
int Penganan::GetKeik() const {
    return keik;
}

// mengembalikan bagian jumlah panekuk
int Penganan::GetPanekuk() const {
    return panekuk;
}

// mengisi bagian keik
void Penganan::SetKeik(int keik) {
    this->keik = keik;
}

// mengisi bagian panekuk
void Penganan::SetPanekuk(int panekuk) {
    this->panekuk = panekuk;
}

// operator overloading

// operator+ 
Penganan operator+ (const Penganan& a, const Penganan& b) {
    Penganan::n_rumah++;
    return Penganan(a.keik + b.keik, a.panekuk + b.panekuk);
}

// operator-
Penganan operator- (const Penganan& a, const Penganan& b) {
    int jualKeik = (a.keik    >= b.keik)    ? b.keik    : a.keik;
    int jualPanekuk = (a.panekuk >= b.panekuk) ? b.panekuk : a.panekuk;
    Penganan::uang += jualKeik * 51 + jualPanekuk * 37;
    return Penganan(a.keik - jualKeik, a.panekuk - jualPanekuk);
}

// operator^
Penganan operator^ (const Penganan& a, const int n) {
    int sumbangKeik = (a.keik    >= n) ? n : a.keik;
    int sumbangPanekuk = (a.panekuk >= n) ? n : a.panekuk;
    int kurangKeik = n - sumbangKeik;
    int kurangPanekuk = n - sumbangPanekuk;
    Penganan::uang -= kurangKeik * 51 + kurangPanekuk * 37;
    return Penganan(a.keik - sumbangKeik, a.panekuk - sumbangPanekuk);
}

// operator^ (sifat komutatif)
Penganan operator^ (const int n, const Penganan& a) {
    return a ^ n;
}

// mengembalikan jumlah uang yang diperoleh
int Penganan::JumlahUang() {
    return uang;
}

// mengembalikan jumlah kunjungan ke rumah
int Penganan::HitungNRumah() {
    return n_rumah;
}

// mencetak isi kantong
// Jangan lupa tambahkan endline di akhir print
// Contoh:
// 0keik-0panekuk
// 111keik-122panekuk
void Penganan::Print() {
    printf("%dkeik-%dpanekuk\n", keik, panekuk);
}