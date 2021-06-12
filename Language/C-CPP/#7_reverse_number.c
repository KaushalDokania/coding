#include <stdio.h>
#include <math.h>
#include <limits.h>

int reverse(int x) {
    int reverse=0, d;
    while (x!=0) {
        d = x % 10;
        if (reverse > INT_MAX/10 || (reverse == INT_MAX / 10 && d > 7)) return 0;
            if (reverse < INT_MIN/10 || (reverse == INT_MIN / 10 && d < -8)) return 0;
        reverse = reverse*10 + d;
        x = x/10;
    }
    return reverse;
}

int main() {
    int n=-214748348;
    printf("Reverse of %d, is %d", n, reverse(n));
}