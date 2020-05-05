/* Enter two strings(# means a backspace) and compare if the two strings are equal
    Possible cases:
    abc#d    abc##d    a#b#    ##abc
*/

#include <stdio.h>
#include <iostream>
#include <string.h>

char* getFinalString(char *str) {
    char *rp, *wp;                      // read_ptr and write_ptr
    if (str) {
        wp = str-1;
        rp = str;
        while(*rp) {
            if (*rp == '#') {   
                *wp = '\0';
                if(wp >= str)             // if current string is empty then write_ptr should not move back further
                    --wp;
                *rp = '\0';
            }
            else {
                ++wp;                   // move the write_ptr
                *wp = *rp;
                if(wp!=rp)
                    *rp = 0;
            }
            ++rp;                       // read_ptr should always move
            
        }
    }
    return str;
}

bool backspaceCompare(char * S, char * T){
    getFinalString(S);
    getFinalString(T);
    
    printf("str1: ");puts(S);
    printf("str2: ");puts(T);

    if(strcmp(S,T)==0)
        return true;
}

int main() {
    char *str1, *str2;
    str1 = (char*)malloc(sizeof(char)*10);
    str2 = (char*)malloc(sizeof(char)*10);
    printf("Enter 1st string: ");scanf("%s", str1);
    printf("Enter 2nd string: ");scanf("%s", str2);

    if(backspaceCompare(str1, str2))
        printf("Strings are EQUAL");
    else
        printf("Strings are NOT EQUAL");
    
    return 0;
}