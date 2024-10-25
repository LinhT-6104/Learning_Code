def knapsack(n: int, L: int, S: list[list[int]]) -> tuple[int, list[int]]:
    # Tạo bảng động với kích thước (n+1) x (L+1) để lưu giá trị tối đa đạt được
    dp = [[0] * (L + 1) for _ in range(n + 1)]

    # Duyệt qua các vật phẩm
    for i in range(1, n + 1):
        w, v = S[i - 1]  # Khối lượng và giá trị của vật phẩm thứ i

        # Duyệt qua các mức dung lượng balo từ nhỏ đến lớn
        for k in range(1, L + 1):
            if w <= k:  # Nếu vật phẩm có thể cho vào balo
                dp[i][k] = max(dp[i - 1][k], v + dp[i - 1][k - w])
            else:
                dp[i][k] = dp[i - 1][k]

    # Truy vết lại các vật phẩm đã chọn từ bảng dp  
    selected_items = []
    k = L

    # Truy vết từ n về 0 để tìm các vật phẩm đã chọn
    for i in range(1, n+1):
        if dp[i][k] != dp[i - 1][k]:  # Nếu giá trị thay đổi, vật phẩm đã được chọn
            selected_items.append(i - 1)  # Lưu chỉ số vật phẩm đã chọn
            k -= S[i - 1][0]  # Giảm dung lượng của balo

    return dp[n][L], selected_items

def print_selected_items(items: list[list[int]], selected_items: list[int]):
    print("Vật phẩm đã chọn:")
    for index in selected_items:
        print(f"Vật phẩm {index + 1}: Khối lượng = {items[index][0]}, Giá trị = {items[index][1]}")

# Ví dụ
n = 4  # Số vật phẩm
L = 5  # Dung lượng của balo
S = [[2, 6], [2, 3], [3, 1], [4, 5]]  # Mỗi vật phẩm có [khối lượng, giá trị]

# Tính tổng giá trị lớn nhất và nhận danh sách vật phẩm đã chọn
max_value, selected_items = knapsack(n, L, S)

print(f"Tổng giá trị tối đa: {max_value}")
print_selected_items(S, selected_items)
