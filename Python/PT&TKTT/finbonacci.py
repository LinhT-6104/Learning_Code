def FibRec(n):
    if n < 2:
        return 1
    else:
        return FibRec(n-1) + FibRec(n-2)

print(FibRec(5))