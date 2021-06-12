#include <stdio.h>

int countingValleys(int n, char* s) {
    int i, level=0, valley_count=0;
    printf("\n>n: %d, path: %s", n, s);
    for (i=0; s[i]!='\0'; ++i) {
        if (s[i] == 'U')
            level++;
        else if (s[i] == 'D')
            level--;
        if (level==0 && s[i]=='U')       // Valley ends with U and level will be 0
            valley_count++;
    }
    printf("\ncount: %d", valley_count);
}
int main() {
    int n, i, level=0, valley_count=0;
    //char path[n];
    scanf("%d", &n);
    //scanf("%s", path);
    printf(">>n: %d", n);
    //printf(">>n: %d, path: %s", n, path);
    //countingValleys(n, path);
    return 0;
}