#include<iostream>
#include<fstream>

using namespace std;

struct matHang
{
    int x;
    int w;
};

void cau1(int n, matHang MH[], ofstream &fout) {
    int count = 0;
    for (int i = 0 ; i < n; i++) {
        if (MH[i].x >= 20)  count++;
    }
    fout << count << endl;
}

void cau2(int n, matHang MH[], ofstream &fout) {
    // tim max
    int max = MH[0].x;
    for (int i = 1 ; i < n; i++) {
        if (MH[i].x > max) {
            max = MH[i].x;
        }
    }
    // tim w cac max
    for (int i = 0 ; i < n; i++) {
        if (MH[i].x == max) {
            fout << MH[i].w << " ";
        }
    }
}

int main() {
    // file
    ifstream finp;
    finp.open("hanghoa.inp");
    ofstream fout;
    fout.open("hanghoa.out");

    // ktra
    if (finp.fail()) {
        cout << "Khong mo file hanghoa.inp thanh cong!"; 
    }
    if (fout.fail()) {
        cout << "Khong mo file hanghoa.out thanh cong!";
    }

    int n;
    finp >> n;

    // Doc du lieu
    matHang MH[n];
    // x
    for (int i = 0; i < n; i++) {
        finp >> MH[i].x;
    }
    // w
    for (int i = 0; i < n; i++) {
        finp >> MH[i].w;
    }

    // 1
    cau1(n, MH, fout);

    // 2
    cau2(n, MH, fout);

    finp.close();
    fout.close();
    return 0;
}