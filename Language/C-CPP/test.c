#include <stdio.h>
#include <stdlib.h>


void print2D() {
    int i, j, k=0;
    int a[] = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160};
    int len = sizeof(a)/sizeof(a[0]);
    for (i=0; i<5; ++i) {
        for (j=i; j<5; ++j) {
            printf("*****");
        }
        for (j=0; j<2*i-1; ++j) {
            if (k<len)
                printf("%-4d ", a[k++]);
        }
        printf("\n");
    }
}

int main()
{
    print2D();
    return 0;
}