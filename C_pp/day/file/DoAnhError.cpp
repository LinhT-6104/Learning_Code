#include <iostream>
#include <fstream>

using namespace std;
void output(int m, int n, int a[][100])
{
	for (int i = 0; i < m; i++)
	{
		for (int j = 0; j < n; j++)
		{
			cout << a[i][j] << "";
		}
		cout << endl;
	}
}
void toinhat(int m, int n, int a[][100])
{
	int min = a[0][0];
	for (int i = 0; i < m; i++)
	{
		for (int j = 0; j < n; j++)
		{
			if (a[i][j] < min)
			{
				min = a[i][j];
			}
		}
	}
	cout << "mang toi nhat la: " << min << endl;
}
int main()
{
	ifstream finp;
	finp.open("anh.txt");
	if (finp.fail())
	{
		cout << " mo file khong thanh cong" << endl;
		return 1;
	}
	else
	{
		cout << "mo file thanh cong." << endl;
	}
	int n, m;
	finp >> m >> n;
	int a[100][100];
	// doc mang
	for (int i = 0; i < m; i++)
	{
		for (int j = 0; j < n; j++)
		{
			finp >> a[i][j];
		}
	}
	output(m, n, a);
	// toi nhat
	toinhat(m, n, a);
	finp.close();
	return 0;
}