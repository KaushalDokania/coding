#include <stdio.h>
#include <stdlib.h>

#define CLEAR_SCREEN 1

void printOptions() {
    if (CLEAR_SCREEN)
        system("clear");
    printf("\n-------------- Welcome to Single Linked List program -------------------\n");
    printf("\n\nOptions");
    printf("\n\t1. Show Options");
    printf("\n\t2. Print SLL");
    printf("\n\t3. Push data");
    printf("\n\t4. Delete data");
    printf("\n\t5. Reverse SLL");
    printf("\n\t0. Exit");
}

struct Node {
    int data;
    struct Node* next;
};

struct Node *head = NULL;

struct Node* newNode(int data) {
    struct Node* node = (struct Node*)malloc(sizeof(struct Node));
    node->data = data;
    node->next = NULL;
    return node;
}

void push(struct Node** head_ref, int data) {
    struct Node *node = newNode(data);
    node->next = *head_ref;
    *head_ref = node;
}

void insertData(struct Node* head, int data, int position) {    // index = position-1
    struct Node* p, *node;
    int pos=1;
    for (p=head; p->next != NULL && pos++<position-1; p=p->next){}
    node = newNode(data);
    node->next = p->next;
    p->next = node;
}

void delete(struct Node* head, int data) {
    struct Node *p, *node;
    for (p=head; p->next!=NULL && p->next->data!=data; p=p->next) {}
    node = p->next;         // node to be deleted
    p->next = p->next->next;
    free(node);
}

void deleteDataAtPosition(struct Node* head, int position) {
    struct Node *p, *node;
    int pos;
    for (p=head, pos=1; p->next!=NULL && pos++<position-1; p=p->next) {}
    node = p->next;
    p->next = p->next->next;
    free(node);

}

void reverseSLL(struct Node** head_ref) {
    struct Node *p, *prev=NULL, *next=NULL;
    for (p=*head_ref; p!=NULL; p=next) {
        next = p->next;
        p->next = prev;
        prev = p;
    }
    *head_ref = prev;
}

void printLL(struct Node* head) {
    struct Node* p;
    printf("\nSLL: [");
    for (p=head; p!=NULL; p=p->next) {
        printf("%d, ", p->data);
    }
    printf("]");
}

void runtIterativeProgram() {
    int data, position;
    int option, fl=1;
    printOptions();

    do {
        printLL(head);
        printf("\n\nEnter your choice: ");
        fflush(stdout);
        scanf("%d", &option);
        switch (option) {
            case 0:     printf("Exited");fl = 0; break;
            case 1:     printOptions();break;
            case 2:     printLL(head);break;
            case 3:     printf("Enter data: ");
                        fflush(stdout);
                        fflush(stdin);
                        scanf("%d", &data);
                        push(&head, data);break;
            case 4:     printf("Enter data: ");
                        fflush(stdout);
                        fflush(stdin);
                        scanf("%d", &data);
                        delete(head, data);break;
            case 5:     reverseSLL(&head);
            default:    printf("--> Invalid input");break;
        }
        if (fl) {           // not to wait to flush in case of exit
            fflush(stdout);
            fflush(stdin);
        }
    } while(fl);

}

int main() {
    runtIterativeProgram();
    // printLL(head);
    // push(&head, 10);
    // push(&head, 20);
    // push(&head, 30);
    // push(&head, 40);
    // push(&head, 50);
    // printLL(head);
    // reverseSLL(&head);
    // printLL(head);

    return 0;
}