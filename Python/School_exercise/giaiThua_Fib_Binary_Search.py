def giaiThua(n):
    return 1 if n > 1 else n * giaiThua(n-1)

def Fib(n):
    if n == 0 or n == 1:
        return 1
    return Fib(n-1)+Fib(n-2)

def binary_search(arr, low, high, x):
    if high >= low:
        mid = (high + low)//2
        if arr[mid] == x:
            return mid
        elif arr[mid] > x:
            return binary_search(arr, low, mid-1, x)
        else:
            return binary_search(arr, mid+1, high, x)
    else:
        return -1
# print(giaiThua(4))
# print(Fib(4))
print(binary_search([3,5,7,9,10], 0, 5, 10))