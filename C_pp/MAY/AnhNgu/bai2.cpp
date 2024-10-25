// Anh - 725... - K72E1
#include<iostream>
#include<fstream>
#include<vector>

using namespace std;

void tinhTong(vector<int> v) {
	int sum = 0;
	for (int i = 0; i < v.size(); i++) {
		if (i % 2 == 0) {
			sum += v[i];
		}
	}
	cout << sum;
}

int main() {
	// Mo file
	ifstream finp("songuyen.inp");
//	ofstream fout("songuyen.out");
	
	// ktra 
//	if (finp.fail()) {
//		cout << "Khong the mo file songuyen.inp";
//		return 1;
//	} else {
//		cout << "Mo file songuyen.inp thanh cong";
//	}
//	if (fout.fail()) {
//		cout << "Khong the mo file songuyen.out";
//		return 1;
//	}
	
	int n;
	finp >> n;
	
	vector<int> v;
	int a;
	while (!finp.eof()) {
		finp >> a;
		v.push_back(a);
	}
	
	for (int i = 0; i < v.size(); i++) {
		cout << v[i] << " ";
	}
	
	tinhTong(v);
	
	// Dong file
	finp.close();
//	fout.close();
	return 0;
}
