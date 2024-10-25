#include<iostream>
#include<fstream>
#include<string>

using namespace std;

// VanAnh[0] -> chữ thường
// VanAnh[1] -> chữ hoa
// VanAnh[2] -> chữ số
// VanAnh[3] -> kí tự

void count_S(int VanAnh[], string s, ifstream &finp, ofstream &fout) {
    while (!finp.eof()) {
        finp >> s;
        for (int i = 0 ; i < s.length(); i++) {
            if (s[i] >= 'a' && s[i] <= 'z') {
                VanAnh[0] += 1;
            }
            else if (s[i] >= 'A' && s[i] <= 'Z')
            {
                VanAnh[1] += 1;
            }
            else if (s[i] >= '0' && s[i] <= '9')
            {
                VanAnh[2] += 1;
            }
            else {
                VanAnh[3] += 1;
            }
        }
    }
    for (int i = 0 ; i < 4; i++) {
        fout << VanAnh[i] << endl;
    }
}

int main() {
    // file
    ifstream finp;
    finp.open("mahoa.inp");
    ofstream fout;
    fout.open("mahoa.out"); 

    // ktra
    if (finp.fail()) {
        cout << "Khong the mo file mahoa.inp thanh cong!";
        return 1;
    } else {
        cout << "Mo file mahoa.inp thanh cong!";
    }
    if (fout.fail()) {
        cout << "Khong the mo file mahoa.out thanh cong!";
        return 1;
    } else {
        cout << "Mo file mahoa.out thanh cong!";
    }

    // dem
    string s;
    int VanAnh[4] = {0,0,0,0};

    count_S(VanAnh, s, finp, fout);

    return 0;
}