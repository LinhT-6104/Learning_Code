#include <iostream>
#include <cmath>

using namespace std;

double S2(int n) {
    if (n == 1) {
        return sqrt(3); // Trường hợp cơ bản
    }
    return sqrt(3 + S2(n - 1)); // Đệ quy
}

int main() {
    cout << S2(3);
    return 0;
}