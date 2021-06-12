#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "tree_traversal.c"

/* Creates a new tree in level-order from an integer array
    and returns the pointer to root */
Node createTreeFromArray(int *arr, int len, int i) {
    if (i >= len || arr[i]<0)
        return NULL;
    Node root = newNode(arr[i]);
    root->left = createTreeFromArray(arr, len, 2*i+1);
    root->right = createTreeFromArray(arr, len, 2*i+2);
    return root;
}

int main() {
    setbuf(stdout, NULL);
    int inputArr[] = {1, 2, 5, 3, 4, -1, 6};
    int height = sizeof(inputArr)/sizeof(inputArr[0]);
    Node root = createTreeFromArray(inputArr, height, 0);

    printLevelOrder(root);
    return 0;
}