// Đỗ Thị Ngọc Ánh - 725105018 - K72E1
#include<iostream>
#include<fstream>
#include<cmath>
#include<vector>

using namespace std;

// dong 1 output
void Nearest(vector<int> a, int x,  ofstream &fout) {
    int ganNhat = abs(a[0] - x);
    int result;
    for (int i = 1; i < a.size(); i++) {
        if (a[i] != x && abs(a[i] - x) <= ganNhat) {
            ganNhat = abs(a[i] - x);
            result = a[i];
        }
    }
    fout << result << endl;
}

// dong 2 output
void sapXep(vector<int> &a) {
    for (int i = 0 ; i < a.size() - 1; i++) {
        for (int j = i+1; j < a.size(); j++) {
            if (a[i] > a[j]) {
                swap(a[i], a[j]);
            }
        }
    }
}
void inketQua(vector<int> &a, ofstream &fout) {
    for (int i = 0 ; i < a.size(); i++) {
        fout << a[i] << " ";
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

    int x;
    finp >> x;
    vector<int> arr;
    int a;
    while (!finp.eof()) {
        finp >> a;
        arr.push_back(a);
    }

    Nearest(arr, x, fout);

    sapXep(arr);

    inketQua(arr, fout);

    finp.close();
    fout.close();
    return 0;
}