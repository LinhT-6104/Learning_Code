def Matrix_chain_multiplication(n, p[]):
    int m[n][n] = {0}
    int s[n][n] = {0}
    int j, min, q
    for d in range(1, n-1):
        for i in range(1, n-d):
            j = i + d
            