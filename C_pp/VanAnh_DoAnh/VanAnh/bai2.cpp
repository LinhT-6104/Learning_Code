// Nguyễn Lê Vân Anh - 725105010 - K72E1
#include<iostream>
#include<fstream>
#include<algorithm>
#include<cmath>
#include<vector>

using namespace std;

// dong 1 output
void GiaTriGanNhat(vector<int> a, int x,  ofstream &fout) {
    int valueMin = abs(x - a[0]);
    int ketQua;
    for (int i = 1; i < a.size(); i++) {
        if (abs((x - a[i])) <= valueMin && a[i] != x) {
            valueMin = abs(x - a[i]);
            ketQua = a[i];
        }
    }
    fout << ketQua << endl;
}

// dong 2 output
bool sapXep(const int &a1, const int &a2) {
    return a1 <= a2;
}

void inManHinh(vector<int> &a, ofstream &fout) {
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

    GiaTriGanNhat(arr, x, fout);

    sort(arr.begin(), arr.end(), sapXep);

    inManHinh(arr, fout);

    finp.close();
    fout.close();
    return 0;
}