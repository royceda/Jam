/* https://projecteuler.net/problem=10
* The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
* Find the sum of all the primes below two million.
*/

#include <map>
#include <set>
#include <list>
#include <cmath>
#include <ctime>
#include <deque>
#include <queue>
#include <stack>
#include <string>
#include <bitset>
#include <cstdio>
#include <limits>
#include <vector>
#include <climits>
#include <cstring>
#include <cstdlib>
#include <fstream>
#include <numeric>
#include <sstream>
#include <iostream>
#include <algorithm>
#include <unordered_map>


using namespace std;
const int N=1000000;
bool mark[N+1000];


int main(){
    
     vector<int> primes;
     vector<long long> sum;
    
    
     for(int i=2;i<=N/2;++i)
      if(mark[i]==false){
       int b=i+i;
       while(b<=N)
       {
        mark[b]=true;
        b+=i;
       }
      }
    
     primes.push_back(2);
     sum.push_back(2);
    
     for(int i=3;i<=N;++i)
      if(mark[i]==false){
       primes.push_back(i);
       sum.push_back( sum[sum.size()-1]+i);
      }
    
    
     int t;
     cin>>t;
     primes.push_back(10000000);
    
     for(int k=1;k<=t;++k){
      int n;
      cin >> n;
      int i;
         
      for(i=0;primes[i]<=n;++i);
      cout<<sum[i-1]<<endl;
     }
    }
