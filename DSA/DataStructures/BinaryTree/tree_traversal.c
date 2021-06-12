#include "tree_node.c"

/* --- tree traversal algorithms --- */

/* preorder traversal */
void printPreOrder(Node node) {
    if(!node)
        return;
    printf("%d ", node->data);
    printPreOrder(node->left);
    printPreOrder(node->right);
}

/* preorder traversal */
void printInOrder(Node node) {
    if(!node)
        return;
    printPreOrder(node->left);
    printf("%d ", node->data);
    printPreOrder(node->right);
}

/* preorder traversal */
void printPostOrder(Node node) {
    if(!node)
        return;
    printPreOrder(node->left);
    printPreOrder(node->right);
    printf("%d ", node->data);
}

void printLevel(Node node, int level) {
    if (node == NULL)
        return;
    
    if (level==0)
        printf("%d ", node->data);              // root node
    else {
        printLevel(node->left, level-1);
        printLevel(node->right, level-1);
    }
}

void printLevelOrder(Node root) {
    int h = height(root);
    for (int i=0; i<h; ++i) {
        printLevel(root, i);
    }
}

void print2D(Node root) {
    printf("hi");
    int i, j;
    for (i=0; i<5; ++i) {
        for (j=0; j<5; ++j) {
            printf("*");
        }
    }
}