def power(a, n):
    if n == 0:  # Điều kiện dừng
        return 1
    elif n % 2 == 0:  # Nếu n là số chẵn
        half = power(a, n // 2)
        return half * half
    else:  # Nếu n là số lẻ
        return a * power(a, n - 1)
a = 20
n = 10
result = power(a, n)
print(f'{a}^{n} = {result}')
    