#include <stdio.h>
#include <string.h>

int main() {
    int l, i, j, count=0, maxCount=0;
    char str[51];
    scanf("%s", str);
    scanf("%d", &l);    

    for (i=0; i<str[i]; ++i) {
        if (str[i] == '1')
            count++;
        if (i!=0 && i%l == 0) {     // current split done
            maxCount = (count>maxCount) ? count : maxCount;
            count = 0;
        }
        
    }
    maxCount = (count>maxCount) ? count : maxCount;
    printf("%d", maxCount);
    return 0;
}