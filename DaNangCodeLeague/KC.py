def calculate_distance(A, X, B, Y, K):
    position1 = A + X * K
    position2 = B + Y * K
    return abs(position1 - position2)

T = int(input())
results = list()
for _ in range(T):
    s = input()
    a, x, b, y, k = map(int, s.split())
    results.append(calculate_distance(a,x,b,y,k))
for result in results:
    print(result)