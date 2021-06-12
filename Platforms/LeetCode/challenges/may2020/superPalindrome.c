#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int isPalindrome2(long number) {
    long num=number, n=0;
    long sqr, square, s=0;
    square = number * number;
    sqr = square;

    while (1) {
        if (num==0)
            break;
        
        if (num!=0) {
            n = n*10 + num%10;
            num /= 10;
        }
        if (sqr!=0) {
            s = s*10 + sqr%10;
            sqr /= 10;
        }
    }
    if (n!=number)
        return 0;
    while (sqr!=0) {
        s = s*10 + sqr%10;
        sqr /= 10;
    }
    return s==square;
}

int isPalindrome(long number) {
    long num=number, n=0;
    while (num!=0) {
        n = n*10 + num%10;
        num /= 10;
    }
    return n==number;
}
int superpalindromesInRange(char * left, char * right){
    
    int count = 0;
    long sqrt1 = sqrt(atol(left));
    long sqrt2 = sqrt(atol(right));

    for (long i=sqrt1; i<=sqrt2; ++i) {
        if (i>10 && (i%10!=1 && i%10!=2))
            continue;
        // if (isPalindrome(i) && isPalindrome(i*i)) {
        if (isPalindrome2(i)) {
            // printf("\ni, i*i: %ld, %ld", i, i*i);
            count++;
        }
            
    }
    return count;
    return 0;
}

int main() {
    int count = superpalindromesInRange("4", "999999999999999999");
    printf("\nnumber of super-palindromes in range: %d\n", count);
    /*
    "38455498359"
"999999999999999999"*/
    return 0;
}