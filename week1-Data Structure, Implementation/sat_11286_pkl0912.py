import heapq
import sys
input = sys.stdin.readline
nums = []
n = int(input())
for _ in range(n):
    x = int(input())
    if x != 0:
        heapq.heappush(nums, (abs(x), x))
    else:
        if nums:
            print(heapq.heappop(nums)[1])
        else:
            print(0)
        


        
        