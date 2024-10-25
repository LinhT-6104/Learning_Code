#include<iostream>
#include<fstream>
#include<cmath>

using namespace std;

struct Billiard
{
    string name;
    int elo_2023;
    int elo_2024;
    int chenhLech;
};

void inputBilliard(int n, Billiard coThu[], ifstream &finp) {
    for (int i = 0; i < n ; i++){
        finp.ignore();
        getline(finp, coThu[i].name);
        finp >> coThu[i].elo_2023;
        finp >> coThu[i].elo_2024;
        coThu[i].chenhLech = abs(coThu[i].elo_2023 - coThu[i].elo_2024);
    }
}

// Cau a:
void maxChenhLech(int n, Billiard coThu[], ofstream &fout) {
    // Tim max
    int max = coThu[0].chenhLech;
    for (int i = 1; i < n; i++) {
        if (coThu[i].chenhLech > max) {
            max = coThu[i].chenhLech;
        }
    }

    // Tim co thu thoa man
    for (int i = 1; i < n; i++) {
        if (coThu[i].chenhLech == max) {
            fout << coThu[i].name << endl;
        }
    }
}

// Cau b:
void equalChenhLech(int n, Billiard coThu[], ofstream &fout) {
    for (int i = 0 ; i < n-1; i++) {
        for (int j = i+1 ; j < n; j++) {
            if (coThu[i].chenhLech == coThu[j].chenhLech) {
                fout << coThu[i].name << " - " << coThu[j].name << endl;
            }
        }
    }
}

int main() {
    // Goi file
    ifstream finp("billiard.inp");
    ofstream fout("billiard.out");
    
    // Check file
    if (finp.fail()) {
        cout << "Mo file billiard.inp khong thanh cong\n";
        return 1;
    } else {
        cout << "Mo file billiard.inp thanh cong\n";
    }
    if (fout.fail()) {
        cout << "Mo file billiard.out khong thanh cong\n";
        return 1;
    } else {
        cout << "Mo file billiard.out thanh cong\n";
    }

    int n;
    finp >> n;
    Billiard coThu[n];
    inputBilliard(n, coThu, finp);

    // Cau 1
    maxChenhLech(n, coThu, fout);

    // Cau 2
    equalChenhLech(n, coThu, fout);

    return 0;
}