# https://projecteuler.net/problem=155



#!/bin/python

import sys

lst = [1,3,7,15,35,77,179,429,1039,2525,6235,15463,
 38513,96231,241519,607339,1529533,3857447,9743247,
 24634043,62335495,157885967,400211085,1015080877,
 2576308943]

n = int(raw_input().strip())



def D(n):
    if n == 1:
        return 1;
    else:
        return 2**(n-1)+D(n-1);
    
print lst[n-1]
