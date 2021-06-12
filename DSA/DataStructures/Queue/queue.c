#include <stdio.h>
#include <limits.h>
#include <malloc.h>

struct Queue {
    int front, rear, size;
    unsigned maxSize;
    int *array;
};

struct Queue* createQueue(unsigned size) {
    struct Queue *queue = (struct Queue*)malloc(sizeof(struct Queue));
    queue->array = (int *)malloc(size * sizeof(int));
    queue->front = queue->size = 0;
    queue->rear = size - 1;
    queue->maxSize = size;
    return queue;
}

int isEmpty(struct Queue *queue) {
    return (queue->size == 0);
}

int isFull(struct Queue *queue) {
    return (queue->size == queue->maxSize);
}

void enqueue(struct Queue *queue, int item) {
    if (isFull(queue)) {
        return;
    }
    queue->rear = (queue->rear + 1) % queue->maxSize;
    queue->array[queue->rear] = item;
    queue->size++;

}

int dequeue(struct Queue *queue) {
    if (isEmpty(queue)) {
        return INT_MIN;
    }
    int item = queue->array[queue->front];
    queue->front = (queue->front + 1) % queue->maxSize;
    queue->size--;
    return item;
}

int front(struct Queue *queue) {
    if (isEmpty(queue)) {
        return INT_MIN;
    }
    return queue->array[queue->front];
}

int rear(struct Queue *queue) {
    if (isEmpty(queue)) {
        return INT_MIN;
    }
    return queue->array[queue->rear];
}

int main() {
    struct Queue* queue = createQueue(1000);
 
    enqueue(queue, 10);
    printf("Front:%d, Rear:%d\n", front(queue), rear(queue));
    
    enqueue(queue, 20);
    printf("Front:%d, Rear:%d\n", front(queue), rear(queue));
    
    enqueue(queue, 30);
    printf("Front:%d, Rear:%d\n", front(queue), rear(queue));
    
    enqueue(queue, 40);
    printf("Front:%d, Rear:%d\n", front(queue), rear(queue));
 
    printf("%d dequeued from queue\n\n",dequeue(queue));
    printf("Front:%d, Rear:%d\n", front(queue), rear(queue));

    enqueue(queue, 50);
    printf("Front:%d, Rear:%d\n", front(queue), rear(queue));

    return 0;
}