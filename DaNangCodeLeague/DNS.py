n, m = map(int, input().split())
cache_DNS = dict()
check = True

for _ in range(n):
    s_list = list(input().split())

    if len(s_list) == 3:
        type, domain, ip = s_list
    else:
        type, domain = s_list

    if type == "1": 
        if len(cache_DNS) >= m:
            oldest_domain = next(iter(cache_DNS))
            del cache_DNS[oldest_domain]

        if domain in cache_DNS and cache_DNS[domain] != ip:
            check = False
        else:
            cache_DNS[domain] = ip

    elif type == "2":
        if domain not in cache_DNS:
            check = False
if check == True:
    print("Everything looks ok!")
else:   
    print("Warning: Possible DNS Poisoning detected!")