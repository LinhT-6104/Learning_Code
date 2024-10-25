def MaxLeftVector(a, i, j):
    maxSum = float('-inf')
    sum = 0
    maxLeft = j
    for k in range(j, i-1, -1): 
        sum += a[k]
        if sum > maxSum:
            maxSum = sum
            maxLeft = k  # Lưu chỉ số bắt đầu của mảng con lớn nhất
    return maxSum, maxLeft  # Trả về cả tổng và vị trí bắt đầu

def MaxRightVector(a, i, j):
    maxSum = float('-inf')
    sum = 0
    maxRight = i
    for k in range(i, j+1):
        sum += a[k] 
        if sum > maxSum:
            maxSum = sum
            maxRight = k  # Lưu chỉ số kết thúc của mảng con lớn nhất
    return maxSum, maxRight  # Trả về cả tổng và vị trí kết thúc

def MaxSubVector(a, i, j):
    if i == j:
        return a[i], i, j  # Trường hợp mảng chỉ có một phần tử
    else:
        m = (i + j) // 2
        
        # Tìm mảng con lớn nhất bên trái
        wL, leftStart, leftEnd = MaxSubVector(a, i, m)
        # Tìm mảng con lớn nhất bên phải
        wR, rightStart, rightEnd = MaxSubVector(a, m + 1, j)
        
        # Tìm mảng con giao qua điểm giữa
        leftMaxSum, maxLeft = MaxLeftVector(a, i, m)
        rightMaxSum, maxRight = MaxRightVector(a, m + 1, j)
        wM = leftMaxSum + rightMaxSum
        
        # So sánh để tìm mảng con lớn nhất
        if wL >= wR and wL >= wM:
            return wL, leftStart, leftEnd  # Mảng con lớn nhất bên trái
        elif wR >= wL and wR >= wM:
            return wR, rightStart, rightEnd  # Mảng con lớn nhất bên phải
        else:
            return wM, maxLeft, maxRight  # Mảng con lớn nhất giao điểm giữa

# Test
a = [3, -2, 9, 10, -7, 5, -8, 6, 4]
maxSum, start, end = MaxSubVector(a, 0, len(a) - 1)
print(f"Mảng con lớn nhất có tổng {maxSum}, bắt đầu tại vị trí {start}, kết thúc tại vị trí {end}")
