n = list(map(int, input().split()))[0]
flag = False
for i in range(1, n + 1):
    if (i % 2 == 0 and (n - i) % 2 == 0 and (n - i) != 0):
        flag = True
        break
print("YES" if flag else "NO")
