#http://quiz.geeksforgeeks.org/puzzle-100-people-in-a-circle-with-gun-puzzle/

#100 people standing in a circle in an order 1 to 100.
#No. 1 has a sword. He kills the next person (i.e. No. 2) and gives the sword to the next (i.e. No. 3).
#All people do the same until only 1 survives. Which number survives at the last?
#There are 100 people starting from 1 to 100.
 
#Solution:  73rd person will survive at last


liste = []
for i in range(1,101):
    liste.append(i);



def algo(liste, start=0):
    print "round"
    if len(liste) <= 1:
        return liste[0];
    else:
        tmp = [];
        for i in range(start, len(liste), 2):
            tmp.append(liste[i]);
            #print liste[i]
        if tmp[len(tmp)-1] == liste[len(liste)-1]:
            st = 1;
        else:
            st = 0;
        print tmp
        return algo(tmp, st)


print algo(liste) 
    
