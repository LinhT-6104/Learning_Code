#include<iostream>

using namespace std;

// string VANANH(string &s) {
//     for (int i = 0 ; i < s.length(); i++) {
//         if (s[i] >= 'a' && s[i] <= 'z') {
//             s[i] -= 32;
//         }
//         else {
//             s[i] += 32;
//         }
//     }
//     return s;
// }

bool kiemTra(string s) {
    return (s.rfind("d") != -1);
}

void hienThi(string s) {
    if (kiemTra(s) == false) {
        cout << -1;
    } else {
        for (int i = 0; i < s.length(); i++) {
            if(s[i] == 'd') {
                cout << i << " ";
            }
        }
    }
}

int main() {
    // s = "abcdef" 
    // ktra d có trong xâu không? 
    // nếu có hãy in ra index ? 
    // nếu không hãy in -1
    string s = "adcdef";

    // cout << VANANH(s);
    hienThi(s);

    return 0;
}