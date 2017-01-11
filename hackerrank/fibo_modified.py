# https://www.hackerrank.com/challenges/fibonacci-modified/

import fileinput

lines = []
for line in fileinput.input():
    lines.append(line)
    pass

tmp = lines[0].split(" ")

t = []
t.append(int(tmp[0]))
t.append(int(tmp[1]))
n = int(tmp[2])

def fibo(a,b,n):
    if n == 1:
        return a;
    elif n == 2:
        return b;
    else:
        return fibo(b, a+b**2, n-1)
    
print fibo(t[0], t[1], n)
