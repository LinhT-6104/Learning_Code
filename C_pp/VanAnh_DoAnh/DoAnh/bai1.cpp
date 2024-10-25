// Đỗ Thị Ngọc Ánh - 725105018 - K72E1
#include<iostream>
using namespace std;

void thongKe(int mangDem[], string tu) {
    int soLuongTu = tu.length(); 
    if (soLuongTu >= 1 && soLuongTu <= 7) {
        mangDem[soLuongTu - 1]++;  
    }
}

void demTu(int mangDem[], string s) {
    string tu = "";
    for (int i = 0; i < s.length(); i++) {
        if ((s[i] >= 'A' && s[i] <= 'Z') || (s[i] >= 'a' && s[i] <= 'z')) {
            tu += s[i]; 
        } else if (s[i] == ' ' || s[i] == ',' || s[i] == '.') {
            if (tu.length() > 0) {
                thongKe(mangDem, tu);  
                tu = "";  
            }
        }
    }
}

int main() {
    string s;
    getline(cin, s);
    
    int mangThongKe[7] = {0};
    
    demTu(mangThongKe, s);

    cout << "Tan so xuat hien cac tu: ";
    for (int i = 0; i < 7; i++) {
        cout << i + 1 << "[" << mangThongKe[i] << "]" << " ";
    }

    return 0;
}
