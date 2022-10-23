#include <bits/stdc++.h>
using namespace std;
int check[100], col_series[100];
int c = 0;
void print(int n)
{
    c++;
    for (int i = 0; i < n; i++)
        cout << i + 1 << " " << col_series[i] + 1 << "   ";
    cout << endl
         << endl;
}
void nQueen(int row, int col, int n)
{
    for (int j = 0; j < n; j++)
    {
        if (check[j] != 1)
        {
            int r = row, d = 0;
            bool cont = false;
            while (r)
            {
                r--;
                d++;
                if (col_series[r] == j - d || col_series[r] == j + d)
                {
                    cont = true;
                    break;
                }
            }
            if (cont == true)
                continue;
        }
        else
            continue;
        col_series[row] = j;
        if (row == n - 1)
            print(n);
        else
        {
            check[j] = 1;
            nQueen(row + 1, j, n);
            check[j] = 0;
        }
    }
}
int main()
{
    int n;
    cout << "No. of queens: ";
    cin >> n;
    nQueen(0, -2, n);

    cout << c;

    return 0;
}