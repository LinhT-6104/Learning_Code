'''
    s(n) = n/2 * (u1 + un)
    s(n) = n/2 * (2*u1 + (n-1) * d)
    u1 = s/n - (n-1) * d/2
'''
def check(s, n, d):
    result = int(s/n - (n-1) * d/2)
    if s == (n/2) * (2 * result + (n-1) * d) and result >= 0:
        return int(result)
    else:
        return -1
T = int(input())
results = list()
for _ in range(T):
    A = input()
    S, N, D = map(int, A.split())
    results.append( check(S, N, D) )
for result in results:
    print(result)