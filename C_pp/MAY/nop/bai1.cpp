// Nguyễn Thị Ngọc Huyền - 725105092 - K72E2
#include<iostream>
#include<cctype>

using namespace std;

void loaiBoKhoangTrang(string &s) {
    while (s[0] == ' ') {
        s.erase(0, 1);
    }
    while (s[s.length()] == ' ') {
        s.erase(s.length() - 1, 1);
    }
    cout << s << endl;
}

void capital(string& s) {
    for (int i = 0; i < s.length(); i++) {
        if (i == 0 || s[i-1] == ' ') {
            s[i] = toupper(s[i]);
        } else {
            s[i] = tolower(s[i]);
        }
    }
    cout << s;
}

int main() {
    string s;
    getline(cin, s);
    loaiBoKhoangTrang(s);
    capital(s);
    return 0;
}