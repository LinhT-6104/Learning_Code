// Nguyễn Thị Như Mây - 725105123 - K72E3
#include<iostream>

using namespace std;

// a
void delete_space(string &s) {
    while (s[0] == ' ') {
        s.erase(0, 1);
    }
    while (s[s.length()-1] == ' ') {
        s.erase(s.length() - 1, 1);
    }
    cout << s << endl;
}

// b
void cew(string s) {
    for (int i = 0; i < s.length(); i++) {
        if (i == 0 or s[i-1] == ' ') {
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
    delete_space(s);
    cew(s);
    return 0;
}