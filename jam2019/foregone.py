import numpy as np 
from random import randint


def foregone(n):
    a = randint(1, n)
    b = n - a 
    if '4' in str(a) or '4' in str(b):
        return foregone(n)         
    else:
        return a, b


t = int(input())
for i in range(1, t+1):
    n = int(input())
    print("Case #{}: {}".format(i, foregone(n)))
    print(n)




#t = int(input()) # read a line with a single integer
#print(t)
#for i in range(1, t + 1):
#  n, m = [int(s) for s in input().split(" ")] # read a list of integers, 2 in this case
#  print("Case #{}: {} {}".format(i, n + m, n * m))


