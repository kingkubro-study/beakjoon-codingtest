from collections import deque

n, m = map(int, input().split())
arr = list(map(int, input().split()))
q = deque(range(1, n + 1))  

cnt = 0
for a in arr:
    pos = q.index(a)  

    cnt1 = pos
    cnt2 = len(q) - pos

    if cnt1 <= cnt2:
        q.rotate(-cnt1) 
        cnt += cnt1
    else:
        q.rotate(cnt2)  
        cnt += cnt2

    q.popleft() 

print(cnt)

            
            