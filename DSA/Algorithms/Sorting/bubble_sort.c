#include <stdio.h>

void bubbleSort(int *arr, int length) {
    int i, j, temp;
    for(i=0;i<length;i++) {
        for(j=0; j<length-i; j++) {
            if(arr[j]>arr[j+1]) { //swap
                temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }
}

void printArray(int *arr, int length) {
    printf("[");
    for (int i=0; i<length; i++) {
        printf("%d, ", arr[i]);
    }
    printf("\b\b]\n");
}

int main() {
    int arrSize, arr[] = {20, 10, 50, 90, 40, 60, 70, 80, 30};
    arrSize = sizeof(arr)/sizeof(arr[0]);
    printArray(arr, arrSize);
    
    bubbleSort(arr, arrSize);
    printArray(arr, arrSize);
    return 0;
}