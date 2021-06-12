/*
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

6
-2 1 -3 4 -1 2 1 -5 4
*/

#include <stdio.h>
#include <stdlib.h>

void getArrayInput(int *a, int n) {
    int i;
    for (i=0; i<n; ++i)
        scanf("%d", &a[i]);
}

void printArray(int *a, int n) {
    int i;
    printf("\n[");
    for (i=0; i<n; ++i) {
        printf("%d, ", a[i]);
    }
    printf("]\n");
}

int maxSubArray(int* a, int n){
    int i;
    int  maxSum = INT_MIN, tempSum = 0;
    for(i=0; i<n; ++i) {
        printf("\n\na[%d]:%d, temp:%d, max:%d", i, a[i], tempSum, maxSum);
        if (tempSum >= 0) {
            tempSum += a[i];
        }
        else {
            if (a[i] >= 0 || a[i] >= tempSum)
                tempSum = a[i];
        }
        if (tempSum > maxSum)
            maxSum = tempSum;
        if (tempSum < 0)
            tempSum = 0;
        printf("\na[%d]:%d, temp:%d, max:%d", i, a[i], tempSum, maxSum);
    }

    return maxSum;
}

int maxProfit(int* a, int n) {
    int i, max_profit=0;
    for (i=0; i<n-1; ++i) {
        if (a[i+1] > a[i])
            max_profit += a[i+1] - a[i];
    }
    return max_profit;
}

void moveZeroes(int* a, int n){
    int i, j, k=n-1;
    for (i=0,j=0; j<n; ++j) {
        printf("\ni=%d, j=%d, k=%d", i, j, k);
        printArray(a, n);
        if (a[j] == 0) {
            a[k--] = 0;
            continue;
        }
        a[i++] = a[j];
    }
    // while (i<n) {
    //     a[i++] = 0;
    // }
}

int main() {
    int n, i;
    scanf("%d", &n);
    int *a = (int*)malloc(sizeof(int)*n);
    getArrayInput(a, n);
    //int n = sizeof(a)/sizeof(a[0]);
    // printf("Max sum: %d", maxSubArray(a,n));
    // printf("Max Profit: %d", maxProfit(a,n));
    moveZeroes(a,n);
    printArray(a, n);
    return 0;
}