def knapsack(n: int, L: int, S: list[list[int]]) -> list[list[int]]:
    # Tạo bảng động với kích thước (n+1) x (L+1) để lưu giá trị tối đa đạt được
    dp = [[0] * (L + 1) for _ in range(n + 1)]

    # In tiêu đề của bảng với khoảng cách và các đường phân cách
    print(f"{' ':>6} {'k':^5} |", end='')
    for i in range(0, L + 1):
        print(f"{i:^5}", end=' ')
    print("\n" + "-" * (8 + 6 * (L + 1)))

    print(f"{'S':>6}       |", end='')
    for i in range(0, L + 1):
        print(f"{dp[0][i]:^5}", end=' ')
    print()

    # Duyệt qua các vật phẩm
    for i in range(1, n + 1):
        w, v = S[i - 1]  # Khối lượng và giá trị của vật phẩm thứ i

        # In dòng của từng vật phẩm
        print(f"{i:^6}       |", end='')
        for k in range(0, L + 1):
            if w <= k:  # Nếu có thể cho vật phẩm vào balo
                dp[i][k] = max(dp[i - 1][k], v + dp[i - 1][k - w])
            else:
                dp[i][k] = dp[i - 1][k]

            # In giá trị hiện tại của dp[i][k]
            print(f"{dp[i][k]:^5}", end=' ')
        print()

    return dp

# Ví dụ
n = 4  # Số vật phẩm
L = 5  # Dung lượng của balo
S = [[2, 6], [2, 3], [3, 1], [4, 5]]  # Mỗi vật phẩm có [khối lượng, giá trị]

# Tạo bảng dp và in ra kết quả
dp = knapsack(n, L, S)
