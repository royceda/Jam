# https://projecteuler.net/problem=3
# The prime factors of 13195 are 5, 7, 13 and 29.
# What is the largest prime factor of the number 600851475143 ?


#!/bin/python
import sys


t = int(raw_input().strip())
for a0 in xrange(t):
    n = long(raw_input().strip())
    i = 2
    largest_prime = 2
    while i*i <= n:
        while n % i == 0:
            largest_prime = i
            n //= i    #floor division
        i += 1
    if n>largest_prime:
        largest_prime = n;
    print(largest_prime)
