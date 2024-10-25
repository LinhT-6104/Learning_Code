def print_selected_items(items: list[list[int]], selected_items: list[int]):
    print("Vật phẩm đã chọn:")
    for i in range(1, len(selected_items)):
        print(f"Vật phẩm {i}: Khối lượng = {items[i][0]}, Giá trị = {items[i][1]}")

def knapsack(n: int, L: int, S: list[list[int]], selected_items: list[int]) -> int:
    # Điều kiện dừng: nếu không còn vật phẩm hoặc balo không còn sức chứa
    if n == 0 or L == 0:
        return 0
    
    w, v = S[n - 1]  # Lấy khối lượng và giá trị của vật phẩm hiện tại

    # Nếu vật phẩm hiện tại có khối lượng lớn hơn dung lượng balo, không thể chọn nó
    if w > L:
        return knapsack(n - 1, L, S, selected_items)

    # Nếu có thể chọn, ta có hai lựa chọn:
    exclude_item = knapsack(n - 1, L, S, selected_items)          # 1. Không chọn vật phẩm hiện tại
    include_item = v + knapsack(n - 1, L - w, S, selected_items)  # 2. Chọn vật phẩm hiện tại

    # Nếu chọn vật phẩm hiện tại, thêm nó vào danh sách vật phẩm đã chọn
    if include_item > exclude_item:
        selected_items.append(n - 1)  # Lưu chỉ số của vật phẩm đã chọn
        return include_item
    else:
        return exclude_item

# Ví dụ
n = 4  # Số vật phẩm
L = 5  # Dung lượng của balo
S = [[2, 3], [3, 4], [4, 5], [5, 6]]  # Mỗi vật phẩm có [khối lượng, giá trị]
selected_items = []  # Danh sách lưu các vật phẩm đã chọn

# Tính tổng giá trị lớn nhất
max_value = knapsack(n, L, S, selected_items)
print(f"Tổng giá trị tối đa: {max_value}")

# In ra các vật phẩm đã chọn
print_selected_items(S, selected_items)
