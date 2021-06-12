// Subarray With Given SUM: https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1#
/* Your Task:
    You don't need to read input or print anything. The task is to complete the function subarraySum()
    which takes arr, N and S as input parameters and returns a list containing the starting and ending
    positions of the first such occurring subarray from the left where sum equals to S. The two indexes
    in the list should be according to 1-based indexing. If no such subarray is found, return -1. 
*/

#include <iostream>
#include <vector>

using namespace std;

vector<int> subarraySum(int arr[], int n, int s) {
    vector<int> subArr;
    int i, j, k, sum=arr[0], fl=0;
    
    for (i=1, j=0; i<=n && j<=i;) {
        if (sum == s) {  // sum found
            fl = 1;
            break;
        }
        else if (sum > s) {
            sum -= arr[j];
            ++j;
        }
        else {
            sum += arr[i++];
        }
    }
    if (fl) {
        subArr.push_back(j+1);
        subArr.push_back(i);
    }
    else
        subArr.push_back(-1);
    return subArr;
}

int main() {
    int arr[] = {135,101,170,125,79,159,163,65,106,146,82,28,162,92,196,143,28,37,192,5,103,154,93,183,22,117,119,96,48,127,172,139,70,113,68,100,36,95,104,12,123,134}, s = 468;
    int len = sizeof(arr)/sizeof(arr[0]);

    vector<int> res = subarraySum(arr, len, s);
    for (auto i=res.begin(); i!=res.end(); ++i)
        cout << *i << " ";
    return 0;
}