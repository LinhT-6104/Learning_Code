def MEX_def(n, m):
    MEX = list()
    for i in range(m+1):
        MEX.append(n^i)
    MEX.sort()
    x = 0
    while x in MEX:
        x += 1
    return x
t = int(input())
results = list()
for _ in range(t):
    n, m = map(int, input().split())
    results.append(MEX_def(n, m))
for result in results:
    print(result)