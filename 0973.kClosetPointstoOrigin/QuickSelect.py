def partition(arr, l, r):
    x = arr[r]
    i = l #i = 0 
    for j in range (l, r):
        if arr[j] <= x:
            arr[i], arr[j] = arr[j], arr[i]; 
            i += 1
    
    arr[i], arr[r] = arr[r], arr[i]
    return i 