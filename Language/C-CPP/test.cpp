#include <stdio.h>
#include <stdlib.h>

#define STR "some string"

int main()
{
    printf("Macro:" __STR__ "");
    return 0;
}