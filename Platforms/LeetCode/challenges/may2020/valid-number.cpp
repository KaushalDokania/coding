#include <bits/stdc++.h>

bool isInteger(char **s1) {
    char *s = *s1;
    bool digit=false;

    if (*s=='+' || *s=='-')
        s++;
    for (char *c=s; *c!='\0'; c++) {
        if (*c=='e' || *c=='E') {
            *s1 = c;
            return false;
        }
        else if (*c < '0' || *c > '9')
            return false;
        else
            digit = true;
    }
    return digit;
}

bool isDecimal(char **s1) {
    char *s = *s1;
    bool decimal = false, digit=false;      // booleans to check if decimal character and at least one digit is present
    if (*s=='+' || *s=='-')
        s++;
    for (char *c=s; *c!='\0'; c++) {
        if (decimal && *c=='.')
            return false;
        else if (!decimal && *c=='.')
            decimal = true;
        else if (*c=='e' || *c=='E') {
            *s1 = c;
            return false;
        }
        else if (*c < '0' || *c > '9')
            return false;
        else
            digit = true;
    }
    return decimal&digit ? true : false;
}

bool isExponentPart(char *s) {
    bool exp = false, digit = false;
    if (*s=='e' || *s=='E') {
        s++;
        exp = true;
    }
    if (*s && isInteger(&s) && exp)
        return true;
    return false;
}

bool isNumber(char * s) {
    char *s1 = s;
    bool isNumber = false;
    // printf("\nbefore isInteger: s1: %s", s1);
    if (isInteger(&s1) || isDecimal(&s1)) {
        return true;
    }
    else {   // not integer nor decimal
        // printf("\nbefore isInteger: s1: %s", s1);
        // not integer or decimal, possibly due to 'e' or 'E', confirm that
        int len=0;
        for (char *c=s; *c!=*s1; c++) {
            len++;
        }
        char *prefix = (char*)malloc((len+1)*sizeof(char));
        strncpy(prefix, s, len);

        if (isInteger(&prefix) || isDecimal(&prefix)
                && isExponentPart(s1))
            isNumber = true;
        else
            isNumber = false;
        free(prefix);
        return isNumber;
    }
    // does not contain exponent part
    return false;
}

int main() {
    int res;
    char number[] = "2e0";
    res = isNumber(number);
    // res = isDecimal(number);
    // res = isExponentPart(number);
    res ? printf("\nValid Number\n") : printf("\nInvalid number\n");
    return 0;
}