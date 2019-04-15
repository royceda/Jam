import math
import string 
import numpy as np

def gen_primes(max_n):
    numbers = range(3, max_n+1, 2)
    half = (max_n)//2
    initial = 4

    for step in xrange(3, max_n+1, 2):
        for i in xrange(initial, half, step):
            numbers[i-1] = 0
        initial += 2*(step+1)

        if initial > half:
            return [2] + filter(None, numbers)

def crypto(N, l):
    primes = gen_primes(N)
    ll = list(l)#.copy()
    r = []
    for i in primes:
        for j in primes:
            for p in l:
                if i*j == p:
                    r.append(i)
                    r.append(j)
                    l.remove(p)

    r = np.array(r)   
    r = np.unique(r) 
    r = np.sort(r, kind='quicksort' )

    alphabet = list(string.ascii_uppercase)

    #O(26)
    k = {}
    #k = { r[i] : i  for i in alphabet}
    k = dict(zip(r,alphabet))
    #for i in range(len(alphabet)):
    #    k[r[i]] = alphabet[i]

    #following 
    path = []
    keep = []
    for p in ll:
        wit = True;
        for i in r:
            for j in r:
                if i * j == p and wit == True:
                    wit = False
                    ind = len(path)
                    path.append([k[i],k[j]])
                    if ind > 0:
                        node = path[ind -1]
                        next_node = [k[i],k[j]]
                        for  j in node:
                            if (j not in next_node):
                                keep.append(j)
                    break
    
    keep.append(path[len(path)-1][0])
    keep.append(path[len(path)-1][1])

    return ''.join(keep)


T = 1
N = 10000
L = 25
l = [3292937,175597,18779,50429,375469,1651121,2102,3722,2376497,611683,489059,2328901,3150061,829981,421301,76409,38477,291931,730241,959821,1664197,3057407,4267589,4729181,5335543]

print(crypto(N, l))


#CJQUIZKNOWBEVYOFDPFLUXALGORITHMS

#SUBDERMATOGLYPHICFJKNQVWXZ
#SUBDERMATOGLYPHICFJKNQVWXZ
