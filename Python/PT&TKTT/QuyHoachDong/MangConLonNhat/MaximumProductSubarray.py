def MaxSub(a: list[int]):
    smax = a[0]  # Tổng của dãy con lớn nhất
    maxendhere = a[0]  # Tổng của dãy con lớn nhất kết thúc tại a[i]
    imax = 0  # Vị trí kết thúc của dãy con lớn nhất

    for i in range(1, len(a)):
        u = maxendhere + a[i]
        v = a[i]
        if u > v:
            maxendhere = u
        else: 
            maxendhere = v

        if maxendhere > smax:
            smax = maxendhere
            imax = i

    print("Vị trí kết thúc:", imax)
    print("Tổng lớn nhất:", smax)

MaxSub([2, -15, 1, 2, 4, -3])
'''
[2, -15, 1, 2, 4, 3]
maxendhere = smax = 2.
imax = 0

i = 1
u = maxendhere + a[1] = 2 - 15  = -13
v = a[1] = -15
maxendhere = -13
smax = 2
imax = 0

i = 2
u = maxendhere + a[2] = -13 + 1 = -12
v = a[2] = 1
maxendhere = 1
smax = 2
imax = 0

i = 3
u = maxendhere + a[3] = 1 + 2 = 3
v = a[3] = 2
maxendhere = 3
smax = 3
imax = 3

i = 4
u = maxendhere + a[4] = 3 + 4 = 7
v = a[4] = 4
maxendhere = 7
smax = 7
imax = 4

i = 5
u = maxendhere + a[5] = 7 - 3 = 4
v = a[5] = -3
maxendhere = 4
smax = 7
imax = 4

'''