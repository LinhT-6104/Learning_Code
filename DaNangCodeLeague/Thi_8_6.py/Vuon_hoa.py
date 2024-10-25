def find_max(n, vuonHoa):
    size_list = []
    for i in range(n):
        total_length = 0
        s_list = vuonHoa[i].split('.')
        for s in s_list:
            if s: 
                total_length += len(s) ** len(s)
        size_list.append(total_length)
    return max(size_list)

n = int(input())
vuonHoa_row = [input() for _ in range(n)]

vuonHoa_col = [''.join(row[i] for row in vuonHoa_row) for i in range(n)]

max_row = find_max(n, vuonHoa_row)
max_col = find_max(n, vuonHoa_col)

print(max_row, max_col)
