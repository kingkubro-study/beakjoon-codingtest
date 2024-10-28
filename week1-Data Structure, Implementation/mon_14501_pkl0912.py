n = int(input())
TP = [(0, 0)]  # 초기값 추가
dp = [0] * (n + 1)  # n+1 크기로 dp 초기화

for _ in range(n):
    t, p = map(int, input().split())
    TP.append((t, p))

for i in range(1, n+1):
    dp[i] = max(dp[i-1], dp[i])
    if i+TP[i][0]-1 <=n:
        dp[i+TP[i][0]-1] = max(dp[i+TP[i][0]-1], dp[i-1]+TP[i][1])

print(max(dp))  


    