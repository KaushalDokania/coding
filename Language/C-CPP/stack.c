#include <stdio.h>
#include <stdlib.h>

struct Stack {
    int data;
    struct Stack* next;
};

// typedef struct Stack* Stack;



int main() {
    //MinStack *stk = minStackCreate();MinStack **obj = &stk;
    //MinStk **obj = minStackCreate();
    struct Stack* root = (struct Stack*)malloc(sizeof(struct Stack*));
    printf("Created stack, ");printStack(root);printf("\n");

    minStackPush(root, 101);
    printf("pushed, ");printStack(root);printf("\n");

    // minStackPush(root, 4);
    // printf("pushed, ");printStack(root);printf("\n");

    // minStackPush(root, 13);
    // printf("pushed, ");printStack(root);printf("\n");

    // minStackPop(root);
    // printf("popped, ");printStack(root);printf("\n");

    // printf("top: %d", minStackTop(root));
}