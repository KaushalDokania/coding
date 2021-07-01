// KADANE's ALgorightm: Given an array arr of N integers. Find the contiguous sub-array with maximum sum.

#include <stdio.h>
#include <limits.h>

int findZeroes(int *arr, int n, int m) {
    int i, j, count=0, maxCount=0, toFlip=m;

    for (i=0; i<n; ++i) {
        if (arr[i]==0) {
            if (toFlip) {
                toFlip--;
            }
            else {
                toFlip++;
                count = 0;
            }
        }            
        count++;
        maxCount = (count>maxCount) ? count : maxCount;
    }
    return maxCount;
}

int main() {
    int arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1};
    int len = sizeof(arr)/sizeof(arr[0]);
    printf("\n=> Max sum in subarray: %d\n", findZeroes(arr, len, 2));
    return 0;
}