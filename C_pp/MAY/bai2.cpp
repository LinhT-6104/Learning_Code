// Nguyễn Thị Như Mây - 725105123 - K72E3
#include<iostream>
#include<fstream>
#include<vector>

using namespace std;

// dong 1 output
void sum(vector<int> a, ofstream &fout) {
    int s = 0;
    for (int i = 0 ; i < a.size(); i++) {
        if (i % 2 == 0) {
            s += a.at(i);
        }
    }
    fout << s << endl;
}

// dong 2 output
bool check(vector<int> a, int i) {
    for (int j = 0; j < i; j++) {
        if (a[i] == a[j]) 
            return false;
    }
    return true;
}
void khac_nhau(vector<int> a, ofstream &fout) {
    for (int i = 0; i < a.size(); i++) {
        if (check(a, i)) {
            fout << a[i] << " ";
        }
    }
}

int main() {
    ifstream finp("songuyen.inp");
    ofstream fout("songuyen.out");
    if (finp.fail()) {
        cout << "Khong the mo file songuyen.inp thanh cong!";
        return 0;
    } 
    if (fout.fail()) {
        cout << "Khong the mo file songuyen.out thanh cong!";
        return 0;
    } 

    int n;
    finp >> n;
    vector<int> arr;
    int a;
    while (!finp.eof()) {
        finp >> a;
        arr.push_back(a);
    }

    sum(arr, fout);
    khac_nhau(arr, fout);

    finp.close();
    fout.close();
    return 0;
}