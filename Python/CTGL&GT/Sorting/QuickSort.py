def partitionSeq(theSeq, first, last):   # Thủ tục phân đoạn
    print("phan doan")
    pivot = theSeq[first]
    left = first + 1
    right = last
    while left <= right:
        while left <= right and theSeq[left] <= pivot:
            left += 1
        while left <= right and theSeq[right] >= pivot:
            right -= 1
        if left < right:
            tmp = theSeq[left]
            theSeq[left] = theSeq[right]
            theSeq[right] = tmp
    if right != first:
        theSeq[first] = theSeq[right]
        theSeq[right] = pivot
    return right

def quicksort(theSeq):
    n = len(theSeq)
    recQuickSort(theSeq, 0, n-1)

def recQuickSort(theSeq, first, last):
    if first >= last:
        return
    else:
        # pivot = theSeq[first]
        pos = partitionSeq(theSeq, first, last)
        recQuickSort(theSeq,first,pos-1)
        recQuickSort(theSeq,pos + 1, last)

# check = [1, 2, 6, 8, 4, 9, 2, 10]
check = [4, 15, 3, 2, 12]
print(check)
quicksort(check)
print(check)


# Cách 2:
def quicksort(arr, left, right):
    if left < right:
        partition_pos = partition(arr, left, right)
        quicksort(arr, left, partition_pos  - 1)
        quicksort(arr, partition_pos + 1, right)

def partition(arr, left, right):
    i = left
    j = right - 1
    pivot = arr[right]    
    while i < j:
        while i < right and arr[i] < pivot:
            i += 1
        while j > left and arr[j] > pivot:
            j -= 1
        if i < j:
            arr[i], arr[j] = arr[j], arr[i]
    if arr[i] > pivot:
        arr[i], arr[right] = arr[right], arr[i]
    return i
arr = [4, 15, 3, 2, 12]
print(quicksort(arr, 0, len(arr) - 1))


'''
[2, 5, 6, 1, 4, 3]
arr[p] = 3
i = 0
j = 4

[2, 5, 6, 1, 4, 3]
i = 1
j = 3

[2, 1, 6, 5, 4, 3]
i = 1
j = 3

[2, 1, 6, 5, 4, 3]
i = 2
j = 1

[2, 1, 3, 5, 4, 6]


'''