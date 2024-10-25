#include <iostream>
#include <fstream>

using namespace std;
void kiemTra(int A[], ifstream &finp, ofstream &fout)
{
    string s;
    while (!finp.eof())
    {
        finp >> s;
        for (int i = 0; i < s.length(); i++)
        {
            if (s[i] >= 'a' && s[i] <= 'z')
            {
                A[1] += 1;
            }
        }
        for (int i = 0; i < s.length(); i++)
        {
            if (s[i] >= 'A' && s[i] <= 'Z')
            {
                A[2] += 1;
            }
        }
        for (int i = 0; i < s.length(); i++)
        {
            if (s[i] >= '0' && s[i] <= '9')
            {
                A[3] += 1;
            }
        }
    }
    for (int i = 0; i < 3; i++)
    {
        fout << A[i] << endl;
    }
}

int main()
{
    // goi file
    ifstream finp("kitu.inp");
    ofstream fout("kitu.out");
    // kiemtra file
    if (finp.fail())
    {
        cout << "Mo file kitu.inp khong thanh cong";
        return 1;
    }
    else
    {
        cout << "Mo file kitu.inp thanh cong";
    }
    if (fout.fail())
    {
        cout << "Mo file kitu.out khong thanh cong";
        return 1;
    }
    else
    {
        cout << "Mo file kitu.out thanh cong";
    }
    // tao mang
    int A[3] = {0, 0, 0};
    kiemTra(A, finp, fout);

    return 0;
}