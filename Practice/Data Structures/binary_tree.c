#include <stdio.h>
#include <stdlib.h>

/* Node Structure */
struct node {
    int data;
    struct node* left;
    struct node* right;
};

/* function to allocate newNode */
struct node* newNode(int data) {
    struct node* node = (struct node*)malloc(sizeof(struct node));                  // Allocating memory
    node->data = data;
    node->left = NULL;
    node->right = NULL;
    return node;
}

/* --- tree traversal algorithms --- */

/* preorder traversal */
void printPreOrder(struct node* node) {
    if(!node)
        return;
    printf("%d ", node->data);
    printPreOrder(node->left);
    printPreOrder(node->right);
}

/* preorder traversal */
void printInOrder(struct node* node) {
    if(!node)
        return;
    printPreOrder(node->left);
    printf("%d ", node->data);
    printPreOrder(node->right);
}

/* preorder traversal */
void printPostOrder(struct node* node) {
    if(!node)
        return;
    printPreOrder(node->left);
    printPreOrder(node->right);
    printf("%d ", node->data);
}

int main() {
    struct node* root = newNode(1);
    root->left = newNode(2);
    root->right = newNode(3);
    root->left->left = newNode(4);

    printf("\nPreorder: ");
    printPreOrder(root);
    printf("\nInorder: ");
    printInOrder(root);
    printf("\nPostorder: ");
    printPostOrder(root);
    return 0;
}