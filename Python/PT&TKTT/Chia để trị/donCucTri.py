def findMonopole(a, low, high):
    mid = (low + high) // 2
    if a[mid-1] < a[mid] and a[mid+1] < a[mid]:     
        return a[mid], mid                          # Điểm m
    elif a[mid-1] < a[mid] and a[mid+1] > a[mid]:
        return findMonopole(a, mid+1, high)         # Bên trái
    elif a[mid-1] > a[mid] and a[mid+1] < a[mid]:
        return findMonopole(a, low, mid-1)          # Bên phải
a = [10,11,12,20,21,18,17,4,3,2,1]
b, c = findMonopole(a, 0, len(a))

print(f'Phần tử lớn nhất trong mảng đơn cực trị là {b} có index {c}')


a = [10,11,12,20,21,18,17,4,3,2,1]