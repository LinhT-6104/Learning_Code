#include<iostream>
#include<fstream>
#include<cmath>
using namespace std;
struct cothu{
	string name;
	int elo_2023;
	int elo_2024;
	int chenhlech;	
};
void input(int n, cothu bill[],ifstream &finp){
	for(int i = 0; i < n ; i++){
		finp.ignore();
		getline(finp,bill[i].name);
		finp>> bill[i].elo_2023;
		finp>>bill[i].elo_2024;
		bill[i].chenhlech = abs(bill[i].elo_2023 - bill[i].elo_2024);
	}
}
void max_chenhlech(int n, cothu bill[],ofstream &fout){
	int max = bill[0].chenhlech;
	for (int i = 0; i < n ; i++){
		if(bill[i].chenhlech > max){
			max = bill[i].chenhlech;
		}
	}
	for (int i = 0; i < n ; i++){
		if(bill[i].chenhlech == max){
			fout << bill[i].name<< endl;
		}
	}
	
}
void sosanh(int n,cothu bill[],ofstream &fout ){
	for (int i = 0; i < n-1 ; i++){
		for(int j = i+1; j < n; j++){
			if (bill[i].chenhlech == bill[j].chenhlech){
				fout << bill[i].name << " - " << bill[j].name<< endl;
			}
		}
	}
}
int main(){
	ifstream finp;
	finp.open("billiard.inp");
	ofstream fout;
	fout.open("billiard.out");
	if(!finp.fail()){
		cout << "mo file thanh cong" << endl;
	} else{
		cout <<"mo file khong thanh cong" << endl;
        return 1;
	}
	if(!fout.fail()){
		cout << "ghi file thanh cong" << endl;
	} else{
		cout <<"ghi file khong thanh cong" << endl;
        return 1;
	}
	
	int n;
	finp >> n;
	cothu bill[n];
	input(n, bill,finp);
	max_chenhlech(n,bill,fout);
	sosanh(n,bill,fout);
	for(int i = 0; i < n ; i ++){
		
	}
	return 0;
}