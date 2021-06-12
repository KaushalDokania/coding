#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int t;
    struct RecentCounter* next;
} RecentCounter;

void printStack(RecentCounter** root) {
  RecentCounter* p = NULL;
  printf("Stack: [ ");
  for (p=*root; p; p=p->next) {
      printf("%d->", p->t);
  }
  printf(" ]\n");
}

RecentCounter* recentCounterCreate() {
    RecentCounter* rc = (RecentCounter*)malloc(sizeof(RecentCounter*));
    rc->t = 0;
    rc->next = NULL;
    return rc;
}

int recentCounterPing(RecentCounter* obj, int t) {
  RecentCounter* req = (RecentCounter*)malloc(sizeof(RecentCounter*));
  req->t = t;
  req->next = obj;
  obj = req;
  printStack(&obj);
  return -1;
}

void recentCounterFree(RecentCounter* obj) {
    free(obj);
}

int main() {
    RecentCounter* obj = recentCounterCreate();
    int param_1 = recentCounterPing(obj, 1);
    int param_2 = recentCounterPing(obj, 100);
    int param_3 = recentCounterPing(obj, 3001);
    int param_4 = recentCounterPing(obj, 3002);
 
    recentCounterFree(obj);
    return 0;
}