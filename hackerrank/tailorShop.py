# https://www.hackerrank.com/contests/w27/challenges/tailor-shop


#!/bin/python

import sys


n,p = raw_input().strip().split(' ')
n,p = [int(n),int(p)]
#a = map(int,raw_input().strip().split(' '))
a = [int(x) for x in raw_input().strip().split(' ')]

# your code goes here

a.sort(); # O(nlog(n))
maxi = 0;
s = 0;

for i in range(0, n):
    k = int(a[i])/p #number we can
    
    if int(a[i]) - k*p > 0:#if there is rest
        k+=1;
     
    if k <= maxi:
        k = maxi+1
        
    maxi = k; # anyway there is a new maxi
    s += k;
    
    
print s 
