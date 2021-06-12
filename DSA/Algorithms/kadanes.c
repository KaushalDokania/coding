// KADANE's ALgorightm: Given an array arr of N integers. Find the maximum sum in a contiguous sub-array.

#include <stdio.h>
#include <limits.h>

int subArrayMaxSum(int *arr, int len) {
    int i, sum=0, maxSum=INT_MIN;
    for (i=0; i<len; ++i) {
        sum += arr[i];
        if (sum > maxSum) {
            maxSum = sum;
        }
        if (sum < 0) {
            sum = 0;
        }
    }
    return maxSum;
}

int main() {
    int arr[] = {-5, -4, -30, -20, -2};
    printf("Max sum in subarray: %d", subArrayMaxSum(arr, sizeof(arr)/sizeof(arr[0])));
    return 0;
}