#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "tree_traversal.c"

#define CLEAR_SCREEN 1

void printOptions() {
    if (CLEAR_SCREEN)
        system("clear");
    printf("\n-------------- Welcome to binary tree program -------------------\n");
    printf("\n\nOptions");
    printf("\n\t1. Show Options");
    printf("\n\t2. Create Levelorder");
    printf("\n\t3. Print Preorder");
    printf("\n\t4. Print Inorder");
    printf("\n\t5. Print Postorder");
    printf("\n\t6. Print 2D");
    printf("\n\t0. Exit");
}

Node treeInput() {
    Node root               = newNode(1); 
    root->left              = newNode(2); 
    root->right             = newNode(3); 
    root->left->left        = newNode(4); 
    root->left->right       = newNode(5);
    root->right->left       = newNode(6); 
    root->right->right      = newNode(7);
    root->left->left->left  = newNode(8); 
    root->left->left->right = newNode(9);
    return root;
}

// Function to insert nodes in level order 
Node insertLevelOrder(int arr[], Node root, 
                       int i, int n) 
{ 
    if (i < n)      // Base case for recursion 
    { 
        Node temp = newNode(arr[i]); 
        root = temp; 
        root->left = insertLevelOrder(arr, 
                   root->left, 2 * i + 1, n); 
        root->right = insertLevelOrder(arr, 
                  root->right, 2 * i + 2, n); 
    } 
    return root; 
} 

Node createLevelOrder() {
    int i, num, x;
    // TODO make the array length dynamic so it can be readjusted and avoid memory leak
    printf("Enter number of Nodes: ");
    fflush(stdout);
    fflush(stdin);
    scanf("%d", &num);
    int arr[num];

    for (i=0; i<num; ++i) {
        printf("Enter number: ");
        scanf("%d", &x);
        arr[i] = x;
    }
    Node root = insertLevelOrder(arr, root, 0, num); 
    return root;
}

void runtIterativeProgram() {
    int option, fl=1;
    printOptions();
    Node root = NULL;
    do {
        printf("\n\nEnter your choice: ");
        fflush(stdout);
        scanf("%d", &option);
        switch (option) {
            case 0:     printf("Exited");fl = 0; break;
            case 1:     printOptions();break;
            case 2:     root = createLevelOrder();break;
            case 3:     printf("Preorder Traversal: ");printPreOrder(root); break;
            case 4:     printf("Inorder Traversal: ");printInOrder(root); break;
            case 5:     printf("Postorder Traversal: ");printPostOrder(root); break;
            case 6:     printf("2D: ");print2D(root); break;
            default:    printf("Invalid input");break;
        }
        if (fl) {           // not to wait to flush in case of exit
            fflush(stdout);
            fflush(stdin);
        }
    } while(fl);

}

int main() {
    setbuf(stdout, NULL);
    
    // int arr[] = { 1, 2, 3, 4, 5, 6, 6, 6, 6 }; 
    // int n = sizeof(arr)/sizeof(arr[0]);

    runtIterativeProgram();

    return 0;
}