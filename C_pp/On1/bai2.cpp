#include <iostream>
using namespace std;

struct SinhVien {
    string ten;
    double diemTK;
};

int main() {
    // Khai báo một đối tượng
    SinhVien sv1;
    sv1.ten = "Nguyen Van A";
    sv1.diemTK = 8.5;

    // Truy cập thành viên của đối tượng trực tiếp
    cout << "Ten: " << sv1.ten << ", Diem TK: " << sv1.diemTK << endl;

    // Khai báo một con trỏ đến đối tượng
    SinhVien* ptr = &sv1; // ptr trỏ đến sv1

    // Truy cập thành viên thông qua con trỏ
    cout << "Ten: " << ptr->ten << ", Diem TK: " << ptr->diemTK << endl;

    return 0;
}
