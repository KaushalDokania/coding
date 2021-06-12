#include <stdio.h>

int removeElement(int* nums, int numsSize, int val) {
    int i, j;
    for (i=0, j=0; i<numsSize; ++i) {
        if (nums[i] != val)
            nums[j++] = nums[i];
    }
    return j;
}

void printArray(int *arr, int size) {
    printf("\n");
    for (int i=0;i<size; ++i)
        printf("%d, ", arr[i]);
}
int main() {
    int nums[] = {3,2,2,3};
    int size = sizeof(nums)/sizeof(nums[0]);
    int newSize = removeElement(nums, size, 5);
    printf("\nnew size: %d", newSize);
    printArray(nums, newSize);
    return 0;
}