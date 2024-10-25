#include<iostream>
#include<fstream>

using namespace std;

struct TREE
{
    int index;
    float height;
};

void input_file(int n, TREE cay[], ifstream &finp) {
    for (int i = 0; i < n; i++) {
        finp >> cay[i].height;
        cay[i].index = i+1;
    }
}

void file_out(int n , TREE cay[], ofstream &fout) {
    for (int i = 0; i < n; i++) {
        fout << cay[i].index << " ";
    }
    fout << endl;
    for (int i = 0; i < n; i++) {
        fout << cay[i].height << " ";
    }
}

void sorting(int n, TREE cay[]) {
    for (int i = 0; i < n-1; i++) {
        for (int j = i+1; j < n ; j++) {
            if (cay[i].height > cay[j].height) {
                swap(cay[i], cay[j]);
                // int tmp = cay[i].height;
                // cay[i].height = cay[j].height;
                // cay[j].height = tmp;
            }
        }
    }
}

int main() {
    ifstream finp("TREE.INP");
    ofstream fout("TREE.OUT");
    
    int n;
    finp >> n;

    TREE cay[n];

    // Doc file
    input_file(n, cay, finp);
    sorting(n, cay);
    file_out(n, cay, fout);

    finp.close();
    fout.close();
    return 0;
}