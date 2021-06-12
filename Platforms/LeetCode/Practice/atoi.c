#include<stdio.h>
#include <limits.h>

int myAtoi(char * s) {
    long num = 0, n;
    int sign = 1, signFound = 0, counting=0;
    for (char *c=s; *c; ++c) {
        if(!counting && !signFound && *c == ' ')
            continue;
        if (!counting && !signFound && ((*c == '+') || (*c == '-'))) {
            signFound = 1;
            sign = (*c == '-') ? -1 : 1;
        }
        else if (*c>='0' && *c<='9') {
            counting = 1;
            num = num*10 + *c-(int)'0';
        }
        else 
            break;
        
        n = sign*num;
        if (n > INT_MAX)
            return INT_MAX;
        else if(n < INT_MIN)
            return INT_MIN;
    }
    
    return num*sign;
}

int main() {
    printf("Atoi:%d", myAtoi("00000-42a1234"));
    return 0;
}