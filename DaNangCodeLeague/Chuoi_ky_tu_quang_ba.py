def check(S):
    i = 0
    while i < len(S):
        if S[i:i+3] == "FDD":
            i += 3
        elif S[i:i+2] == "FD":
            i += 2
        elif S[i] == "F":
            i += 1
        else:
            return "No"
    return "Yes"
    

t = int(input())
results = list()
for _ in range(t):
    results.append(check(input()))
for result in results:
    print(result)