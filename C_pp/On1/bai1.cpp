#include<iostream>
#include<fstream>
#include<algorithm>

using namespace std;

struct SinhVien
{
    string ten;
    double diemTK;
};


bool filter(SinhVien sv) {
    int index = sv.ten.rfind(" ");
    return (sv.ten.substr(index+1) == "Hoang" && sv.diemTK >= 8.0);
}

void nhapTT_SV(SinhVien sv[], int n) {
    for (int i = 0; i < n; i++) {
        cout << "Nhap thong tin sinh vien " << i+1 << endl;
        cout << "Ho va ten: ";
        cin.ignore();
        getline(cin, sv[i].ten);
        cout << "Diem tong ket: ";
        cin >> sv[i].diemTK;
    }
}

void nhapTT_SV_file(SinhVien sv[], int n, ifstream &finp) {
    finp.ignore();
    for (int i = 0; i < n; i++) {
        getline(finp, sv[i].ten);
        finp >> sv[i].diemTK;
        finp.ignore();
    }
}

void output_MH(SinhVien sv[], int n) {
    for (int i = 0; i < n; i++) {
        cout << sv[i].ten << endl;
    }
}

void output_File(SinhVien sv[], int n, ofstream &fout) {
    for (int i = 0; i < n; i++) {
        if (filter(sv[i])) {
            fout << "Ho ten sinh vien: " << sv[i].ten << "\n"
                << "Diem tong ket: " << sv[i].diemTK << "\n";
        }
    }
}

bool sorting(SinhVien &sv1, SinhVien &sv2) {
    if (sv1.diemTK == sv2.diemTK) {
        return sv1.ten < sv2.ten;
    }
    return sv1.diemTK < sv2.diemTK;
}

int main() {
    // File
    ofstream fout;
    fout.open("sinhvien.txt");
    ifstream finp;
    finp.open("data_sinhvien.txt");

    // check mo file
    if (fout.fail()) {
        cout << "Khong the mo file sinhvien.txt!";
        return 1;
    }
    if (finp.fail()) {
        cout << "Khong the mo file data_sinhvien.txt!";
        return 1;
    }

    // data
    int n;  finp >> n;

    SinhVien sv[n];
    nhapTT_SV_file(sv, n, finp);

    // output
    // output_MH(sv, n);
    output_File(sv, n, fout);

    // sort
    sort(sv, sv + n, sorting);
    output_MH(sv, n);

    finp.close();
    fout.close();
    return 0;
}