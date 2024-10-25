#include <iostream>
#include <iomanip>

using namespace std;

void inBangCuuChuong() {
    // In tiêu đề cột
    cout << "  x|";
    for (int i = 1; i <= 10; ++i) {
        cout << setw(4) << i;
    }
    cout << endl;

    // In dòng kẻ
    cout << "---|";
    for (int i = 1; i <= 10; ++i) {
        cout << "----";
    }
    cout << endl;

    // In bảng cửu chương
    for (int i = 1; i <= 10; ++i) {
        cout << setw(2) << i << " |"; // In số bên trái bảng
        for (int j = 1; j <= 10; ++j) {
            cout << setw(4) << i * j; // setw là một hàm cho phép giới hạn độ rộng của một giá trị được xuất lên màn hình.
        }
        cout << endl;
    }
}

int main() {
    inBangCuuChuong();
    return 0;
}


