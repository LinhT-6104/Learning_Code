def merge(arr):
    if len(arr) <= 1:
        return arr
    mid = len(arr)//2
    left, right = merge(arr[:mid]), merge(arr[mid:]) 
    return mer(left, right, arr.copy())  
def mer(left, right, merged):
    leftcur = 0
    rightcur = 0
    while leftcur < len(left) and rightcur < len(right):
        if left[leftcur] <= right[rightcur]:
            merged[leftcur + rightcur] = left[leftcur]
            leftcur += 1
        else:
            merged[leftcur + rightcur] = right[rightcur]
            rightcur += 1
    for leftcur in range(leftcur, len(left)):
        merged[leftcur + rightcur] = left[leftcur]
    for rightcur in range(rightcur, len(right)):
        merged[leftcur + rightcur] = right[rightcur]
    return merged

arr = [3, 41, 52, 26, 38, 57, 9, 49]
kq = merge(arr) 
print(kq)