// Nguyễn Thị Như Mây - 725105123 - K72E3
#include<iostream>
#include<fstream>
#include<algorithm>

using namespace std;

struct high_tree {
    string name;
    float high;
};

bool sapxep(const high_tree &tree1, const high_tree &tree2) {
    return tree1.high <= tree2.high;
}

int main(){
    ifstream inpf("TREE.INP");
    ofstream outf("TREE.OUT");

    int n;
    inpf >> n;

    high_tree tree[n];  // Khai bao mang tree kieu du lieu high_tree

    for (int i = 0; i < n; i++) {
        inpf >> tree[i].name;
    }
    for (int i = 0; i < n; i++) {
        inpf >> tree[i].high;
    }

    sort(tree, tree + n, sapxep);   // Sap xep theo chieu tang dan cua chieu cao cay

    for (int i = 0; i < n; i++) {
        outf << tree[i].high << " ";
    }

    outf << "\nSinh vien trong cay co chieu cao lon nhat la: " << tree[n-1].name;

    inpf.close();
    outf.close();
    return 0;
}