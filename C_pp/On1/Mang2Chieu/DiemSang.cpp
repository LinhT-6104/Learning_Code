#include<iostream>
#include<fstream>

using namespace std;

void out_array(int m, int n, int a[][100]) {
    // in mang 2 chieu
    for (int i = 0 ; i < m ; i++) {
        for (int j = 0 ; j < n ; j++) {
            cout << a[i][j] << " ";
        }
        cout << endl;
    }
}

void darknest_point(int m, int n, int a[][100]) {
    int min = a[0][0];
    for (int i = 0 ; i < m ; i++) {
        for (int j = 0 ; j < n ; j++) {
            if (a[i][j] < min) {
                min = a[i][j];
            }
        }
    }
    cout << "Diem toi nhat: " << min << endl;
}

void lightest_point(int m, int n, int a[][100]) {
    int max = a[0][0];
    for (int i = 0 ; i < m ; i++) {
        for (int j = 0 ; j < n ; j++) {
            if (a[i][j] > max) {
                max = a[i][j];
            }
        }
    }
    cout << "Diem sang nhat: " << max << endl;
}

void find_point(int m, int n, int a[][100]) {
    int count = 0;
    for (int i = 0 ; i < m ; i++) {
        for (int j = 0 ; j < n ; j++) {
            if (a[i][j] < 70) {
                count++;
            }
        }
    }
    cout << count;
}

int main() {
    ifstream finp("anh.dat");
    // file
    if (finp.fail()) {
        cout << "Mo file anh.dat khong thanh cong!\n";
        return 1;
    } else {
        cout << "Mo file anh.dat thanh cong!\n";
    }

    int m, n;
    finp >> m >> n;
    int a[100][100];
    
    // doc mang 2 chieu
    for (int i = 0 ; i < m ; i++) {
        for (int j = 0 ; j < n ; j++) {
            finp >> a[i][j];
        }
    }

    darknest_point(m, n, a);
    lightest_point(m, n, a);
    find_point(m,n,a);


    return 0;
}