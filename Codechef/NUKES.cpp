/*  Problem URL: https://www.codechef.com/problems/NUKES
    @Author :   Kaushal Dokania

    Sample Input & Output:
        Input:
            3 1 3
        Output:
            1 1 0
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

long particles, chamber_size, n, *arr, *size_arr;

void printArray()
{
    printf("\n[");
    for(int i=0; i<n; ++i)
    {
        printf("%ld, ", arr[i]);
    }
    printf("]");
}

int main()
{
    long i, size=1, limit=0, p;
    scanf("%ld %ld %ld", &particles, &chamber_size, &n);

    arr = (long*)malloc(n * sizeof(long));
    size_arr = (long*)malloc(n * sizeof(long));
    memset(arr, 0 , n*sizeof(arr));
    memset(size_arr, 0 , n*sizeof(size_arr));

    for(i=0; i<n; ++i)
    {
        limit += size*chamber_size;
        printf("\ni=%d, limit=%ld, part=%ld", i, limit, particles);
        if(particles <= limit)
        {

            p = particles/size;
            arr[i] = p;
            particles -= p*size;

            printf("\np=%ld, part=%ld", p, particles);
            printArray();
            if(particles==0)
                break;
            i = 0;
            size=1;
            limit = 0;
        }
        else
            size = limit + 1;
    }

    printArray();
    printf("Hello world");
    return 0;
}
