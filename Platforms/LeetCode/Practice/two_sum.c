#include<stdio.h>
#include<stdlib.h>

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
/* int* twoSum(int* nums, int numsSize, int target, int* returnSize){
    nums = (int *)malloc(sizeof(int*) * numsSize);
    int b, hash_map[INT_MAX] = {0};

    for(int i=0; i<numsSize; ++i) {
        b = target = nums[i];
        if (hash_map[b] != 0)
            return 
    }
} */

int twoSum(int* nums, int numsSize, int target) {
    printf("inside twoSum()");
    int b, hash_map[10000] = {0};

    printf("calling for loop");
    for(int i=0; i<numsSize; ++i) {
        b = target - nums[i];
        if (hash_map[b] == 1)
            return nums[i];

        hash_map[nums[i]] = (hash_map[nums[i]] == 0) ? 1 : 0;
    }
    return -1;
}

int main() {
    int input, nums[] = {2, 7, 11, 15, 3, 8, 9};
    int len = sizeof(nums)/sizeof(nums[0]);
    printf("Enter number: ");
    fflush(stdout);
    fflush(stdin);
    scanf("%d", &input);
    printf("Array: ");
    for (int i=0; i<len; ++i) {
        printf("%d, ", nums[i]);
    }
    fflush(stdout);
    // twoSum(nums, len, input);
    printf("two sum for %d is %d", input, twoSum(nums, len, input));
    return 0;
}