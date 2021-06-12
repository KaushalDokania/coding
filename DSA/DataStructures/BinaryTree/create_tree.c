#include "tree_traversal.c"

/* Creates a new tree in level-order from an integer array
    and returns the pointer to root */
Node createTreeFromArray(int *arr, int len, int i) {
    if (i >= len)
        return NULL;
    Node root = newNode(arr[i]);
    root->left = createTreeFromArray(arr, len, 2*i+1);
    root->right = createTreeFromArray(arr, len, 2*i+2);
    return root;
}