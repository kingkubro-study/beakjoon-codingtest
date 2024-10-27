arr = list(input())
s = []
result = 0
temp = 1

for i in range(len(arr)):
    if arr[i] == '(':
        s.append('(')
        temp *= 2 
    elif arr[i] == '[':
        s.append('[')
        temp *= 3 
    elif arr[i] == ')':
        if not s or s[-1] != '(':
            result = 0
            break
        if arr[i-1] == '(':
            result += temp 
        s.pop()
        temp //= 2 
    elif arr[i] == ']':
        if not s or s[-1] != '[':
            result = 0
            break
        if arr[i-1] == '[':
            result += temp  
        s.pop()
        temp //= 3  

if s:
    result = 0

print(result)


            


    