# https://projecteuler.net/problem=20
# n! means n × (n − 1) × ... × 3 × 2 × 1

# For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
# and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

# Find the sum of the digits in the number 100!


import sys


def facto(n):
    if n == 1 or n == 2:
        return n
    elif n == 0:
        return 1
    else:
        return n*facto(n-1)


t = int(raw_input().strip())
for a0 in xrange(t):
    n = int(raw_input().strip())
    string = str(facto(n))    
    l = [int(i) for i in string]
    print sum(l)
