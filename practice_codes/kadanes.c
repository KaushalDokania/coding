#include <stdio.h>
#include<stdlib.h>

void printArray(int a[], int len)
{
    int i;
    for(i=0; i<len; i++)
        printf("%d, ", a[i]);
    printf("\n");
}
void kadanes(int a[], int len)
{
    int i, sum=0, max_sum=-99999;

    for(i=0; i<len; i++)
    {
        if(a[i]<0 && max_sum<a[i])
            max_sum = a[i];
        else
        {
            sum += a[i];
            if(sum < 0)
                sum = 0;
            if(sum > max_sum)
                max_sum = sum;
        }

    }

    printf("%d\n", max_sum);
}
int main()
{
    int i, t, n, *arr;
    scanf("%d", &t);
    while(t--)
    {
        scanf("%d", &n);
        arr = (int *)malloc(n * sizeof(int));
        for(i=0; i<n; i++)
            scanf("%d", &arr[i]);
        //printArray(arr, n);
        kadanes(arr, n);
        free(arr);
    }
    getchar();
    return 0;
}
