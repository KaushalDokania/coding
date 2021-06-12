#include <stdio.h>
#include <stdlib.h>

struct Stack {
    int data;
    struct Stack* next;
};

#define CLEAR_SCREEN 1

void printOptions() {
    if (CLEAR_SCREEN)
        system("clear");
    printf("\n-------------- Welcome to Stack program -------------------\n");
    printf("\n\nOptions");
    printf("\n\t1. Show Options");
    printf("\n\t2. Print Stack");
    printf("\n\t3. Push");
    printf("\n\t4. Pop");
    printf("\n\t5. Peek");
    printf("\n\t6. Print 2D");
    printf("\n\t0. Exit");
}

// typedef struct Stack* Stack;

// void printStack(struct Stack* root) {
//   struct Stack* p = NULL;
//   printf("Stack: [ ");
//   for (p=root; p; p=p->next) {
//       printf("%d->", p->data);
//   }
//   printf("]\n");
// }

void printStack(struct Stack** root) {
  struct Stack* p = NULL;
  printf("Stack: [ ");
  for (p=*root; p; p=p->next) {
      printf("%d->", p->data);
  }
  printf(" ]\n");
}

int isEmpty(struct Stack* root) {
    // return !root;
    return (root==NULL) ? 1 : 0;
}

struct Stack* newNode(int data) {
    struct Stack* node = (struct Stack*)malloc(sizeof(struct Stack));
    node->data = data;
    node->next = NULL;
    return node;
}

void push(struct Stack** root, int data) {
    struct Stack* node = newNode(data);
    node->next = *root;
    *root = node;
    // printStack(root);
}

int pop(struct Stack** root) {
    if (isEmpty(*root))
        return INT_MIN;    
    int popped = (*root)->data;
    *root = (*root)->next;
    return popped;
}

int peek(struct Stack* root) {
    if (isEmpty(root))
        return INT_MIN;
    return root->data;
}

void runtIterativeProgram() {
    setbuf(stdout, NULL);
    int option, fl=1, data;
    printOptions();
    struct Stack* root = NULL;
    do {
        printf("\n\nEnter your choice: ");
        fflush(stdout);
        scanf("%d", &option);
        switch (option) {
            case 0:     printf("Exited");fl = 0; break;
            case 1:     printOptions();break;
            case 2:     printStack(&root);break;
            case 3:     printf("Enter data: ");scanf("%d", &data);
                        push(&root, data);break;
            case 4:     printf("%d popped from stack\n", pop(&root));break;
            case 5:     printf("%d is at the top of stack\n", peek(root));break;
            // case 6:     printf("2D: ");print2D(root);
                        break;
            default:    printf("Invalid input");break;
        }
        if (fl) {           // not to wait to flush in case of exit
            fflush(stdout);
            fflush(stdin);
        }
    } while(fl);

}

int main() {
    struct Stack* root = NULL;
    runtIterativeProgram();
    /* push(&root, 10);
    push(&root, 20);
    push(&root, 30);
    push(&root, 40);
    printf("data: %d\n", peek(root));
    printf("%d popped from stack\n", pop(&root));
    push(&root, 50);
    push(&root, 60);
    printf("\n");
    printStack(&root); */
}