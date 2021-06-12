#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

struct Stack {
    int size;       // fixed size of the stack
    int top;        // top holds the index of the top item
    int *array;     // This array holds the stack data
};

struct Stack* createStack(int size) {
    struct Stack *stack = (struct Stack*)malloc(sizeof(struct Stack));
    stack->size = size;
    stack->top = -1;
    stack->array = (int*)malloc(size*sizeof(int));
}

int isFull(struct Stack *stack) {
    return stack->top == stack->size-1;
}

int isEmpty(struct Stack *stack) {
    return stack->top == -1;
}

void push(struct Stack *stack, int data) {
    if (isFull(stack))
        return;
    stack->array[++stack->top] = data;
    printf("\n%d pushed to stack", data);
}

int pop(struct Stack *stack) {
    if (isEmpty(stack))
        return INT_MIN;
    return stack->array[stack->top--];
}

int peek(struct Stack *stack) {
    if (isEmpty(stack))
        return INT_MIN;
    return stack->array[stack->top];
}

int main() {
    struct Stack* stack = createStack(100); 

	push(stack, 10); 
	push(stack, 20);
	push(stack, 30);
    printf("\n%d is on stack top", peek(stack));
    printf("\n%d popped from stack", pop(stack));
    printf("\n%d is on stack top", peek(stack));
    push(stack, 100); 
	push(stack, 200);
	push(stack, 300);
    printf("\n%d is on stack top", peek(stack));
	printf("\n%d popped from stack", pop(stack));
    printf("\n%d is on stack top", peek(stack));
    return 0;
}