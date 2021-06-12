#include <stdio.h>
#include <math.h>

void printBinary(unsigned n) 
{ 
    unsigned i; 
    for (i = 1 << 31; i > 0; i = i >> 1) 
        printf("%d ", (n & i)?1:0); 
}

int bitwiseComplement(int N){
    // int mask_bits;
    if (N==0)
        return 1;
    // mask_bits = log2(N)+1;
    // printf("\nmaskbits: %d\n", mask_bits);
    // printBinary((unsigned)-1>>32-mask_bits);
    // return ~N & (unsigned)-1>>(int)(32-log2(N)+1);
    printf("ex=%d\n", (31-(unsigned)log2(N)));
    return ~N & (unsigned)(pow(2, (unsigned)log2(N)+1) - 1);
}

int main() {
    int number=4, comp;
    printf("\n");
    printBinary(number);

    comp = bitwiseComplement(number);
    printf("\n%d\n", comp);
    printBinary(comp);
    return 0;
}