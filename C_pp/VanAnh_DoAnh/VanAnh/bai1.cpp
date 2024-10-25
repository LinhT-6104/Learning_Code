// Nguyễn Lê Vân Anh - 725105010 - K72E1
#include<iostream>
using namespace std;

int demSoLuongTu(string s) {
    return s.length(); 
}

void addCount(int mangDem[], string tu) {
    int soLuongTu = demSoLuongTu(tu); 
    if (soLuongTu >= 1 && soLuongTu <= 7) {
        mangDem[soLuongTu - 1]++;
    }
}

void dem(int mangDem[], string s) {
    string tu = "";
    for (int i = 0; i < s.length(); i++) {
        if ((s[i] >= 'A' && s[i] <= 'Z') || (s[i] >= 'a' && s[i] <= 'z')) {
            tu += s[i];  
        } else if ((s[i] == ' ' || s[i] == ',' || s[i] == '.') && !tu.empty()) {
            addCount(mangDem, tu);
            tu = ""; 
        }
    }
    if (!tu.empty()) {
        addCount(mangDem, tu);
    }
}

int main() {
    string s;
    getline(cin, s);

    int mangDem[7] = {0};  
    
    dem(mangDem, s);

    cout << "Tan so xuat hien cac tu: ";
    for (int i = 0; i < 7; i++) {
        cout << i + 1 << "[" << mangDem[i] << "]" << " ";
    }

    return 0;
}
