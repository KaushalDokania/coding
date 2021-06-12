#include <stdio.h>
#include <stdlib.h>

struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

/* function to allocate newNode */
struct TreeNode* newNode(int val) {
    struct TreeNode *node = (struct TreeNode*)malloc(sizeof(struct TreeNode));                  // Allocating memory
    node->val = val;
    node->left = NULL;
    node->right = NULL;
    return node;
}

int height(struct TreeNode *node) {
    int ltree_height, rtree_height;
    if (node==NULL)
        return 0;
    else {
        ltree_height = height(node->left);
        rtree_height = height(node->right);

        return (ltree_height > rtree_height) ? ltree_height+1 : rtree_height+1;
    }
}

void printLevel(struct TreeNode *node, int level) {
    if (node == NULL)
        return;
    
    if (level==0)
        printf("%d ", node->val);              // root node
    else {
        printLevel(node->left, level-1);
        printLevel(node->right, level-1);
    }
}

void printLevelOrder(struct TreeNode *root) {
    int h = height(root);
    for (int i=0; i<h; ++i) {
        printLevel(root, i);
    }
}

void markNode(struct TreeNode *node) {
    if (node)
        node->val = 1;
}

int putCamera(struct TreeNode *node) {
    if (node && node->val!=2) {
        node->val = 2;
        return 1;           // cammera was put
    }
    return 0;               // camera was not put
}


/* preorder traversal */
int treversePostOrder(struct TreeNode *node, struct TreeNode *parent) {
    int count = 0;
    if(!node)
        return 0;
    count += treversePostOrder(node->left, node);
    count += treversePostOrder(node->right, node);
    if ((node->left && node->left->val==0)
            || (node->right && node->right->val==0)) {
        // need to mark the child node, by marking current node
        if (putCamera(node))            // new camera
            count++;
        markNode(parent);
        markNode(node->left);
        markNode(node->right);
    }
    return count;
}

int minCameraCover(struct TreeNode* root){
    int cameras = treversePostOrder(root, NULL);
    if (root->val == 0) {
        // put camera on root
        cameras++;
    }
    return cameras;
}

int main() {
    setbuf(stdout, NULL);
    // int inputArr[] = {0,0,-1,0,-1,0,-1,-1,0};
    // // int inputArr[] = {1, 2, 5, 3, 4, -1, 6};
    // int height = sizeof(inputArr)/sizeof(inputArr[0]);
    // struct TreeNode *root = createTreeFromArray(inputArr, height, 0);

    struct TreeNode *l, *r, *root = newNode(0);
    
    root->left = newNode(0);
    root->left->right = newNode(0);

    root->left->right->left = newNode(0);
    root->left->right->right = newNode(0);

    root->left->right->left->right = newNode(0);
    root->left->right->right->right = newNode(0);

    root->left->right->left->right->left = newNode(0);

    root->left->right->left->right->left->left = newNode(0);
    root->left->right->left->right->left->right = newNode(0);

    printLevelOrder(root);

    printf("\n");
    printf("\nminimum Cameras: %d\n", minCameraCover(root));
    return 0;
}