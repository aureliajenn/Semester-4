#include "CommentsManager.hpp"
#include <algorithm>
using namespace std;

void CommentsManager::kickSpammer(int threshold_score) {
    chat_log_.erase(
        remove_if(chat_log_.begin(), chat_log_.end(),
            [&](const Comment& c) {
                auto it = reputation_.find(c.getUsername());
                return it != reputation_.end() && it->second > threshold_score;
            }
        ),
        chat_log_.end()
    );
}

// Cetak semua kata blacklist yang ditemukan di chat beserta username pelakunya
void CommentsManager::printViolation() {
    bool ada_pelanggaran = false;

    for_each(chat_log_.begin(), chat_log_.end(),
        [&](const Comment& c) {
            for_each(c.getWords().begin(), c.getWords().end(),
                [&](const string& word) {
                    if (blacklist_.count(word)) {
                        cout << "kata \"" << word << "\" oleh akun \"" << c.getUsername() << "\"\n";
                        ada_pelanggaran = true;
                    }
                }
            );
        }
    );

    if (!ada_pelanggaran) {
        cout << "TIDAK ADA PELANGGARAN\n";
    }
}

string CommentsManager::quizWinner(const set<string>& passwords) {
    auto it = find_if(chat_log_.begin(), chat_log_.end(),
        [&](const Comment& c) {
            return any_of(c.getWords().begin(), c.getWords().end(),
                [&](const string& word) {
                    return passwords.count(word) > 0;
                }
            );
        }
    );

    return (it != chat_log_.end()) ? it->getUsername() : "BELUM ADA PEMENANG";
}

void CommentsManager::upVIPComment() {
    stable_partition(chat_log_.begin(), chat_log_.end(),
        [](const Comment& c) {
            return c.isVip();
        }
    );
}