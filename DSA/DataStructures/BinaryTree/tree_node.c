#include <stdio.h>

/* Node Structure */
struct node{
    int data;
    struct node* left;
    struct node* right;
};

typedef struct node* Node;

/* function to allocate newNode */
Node newNode(int data) {
    Node node = (Node)malloc(sizeof(Node));                  // Allocating memory
    node->data = data;
    node->left = NULL;
    node->right = NULL;
    return node;
}

int height(Node node) {
    int ltree_height, rtree_height;
    if (node==NULL)
        return 0;
    else {
        ltree_height = height(node->left);
        rtree_height = height(node->right);

        return (ltree_height > rtree_height) ? ltree_height+1 : rtree_height+1;
    }
}