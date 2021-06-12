#include <bits/stdc++.h> 
using namespace std; 
  
typedef long long int ll; 
  
int gcd(ll a, ll b) 
{ 
    if (b == 0) 
        return a; 
    return gcd(b, a % b); 
} 
  
ll findlcm(int arr[], int n, int m1, int m2) 
{  
    ll ans = 1; 
  
    for (int i = 0; i < n; i++)
	{
		if (i == m1 || i == m2)
			continue;
		    ans = (((arr[i] * ans)) / (gcd(arr[i], ans))); 
	 } 
 
  
    return ans; 
} 
  

int main() 
{ 
    int a[] = { 2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31}; 
    int n = sizeof(a) / sizeof(a[0]); 
    //printf("%lld", findlcm(arr, n));
    
    for(int i=0,j=i+1; j < n;  ++i, ++j)
    {
    	ll ans = findlcm(a, n,i,j);
    	
    	if((ans % a[i] != 0)  && (ans % a[j] != 0))
    	{
    		cout << "first: " << a[i] << "\nsecond: " << a[j] << endl;
		}
	}
    
    return 0; 
} 
