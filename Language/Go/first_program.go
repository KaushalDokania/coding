package main

import (
	"fmt"
	"strings"
)

func main() {
	userFDN := "cn=kdokania,o=novell"
	res1 := strings.Split(userFDN, ",")
	res2 := strings.Split(res1[0], "=")
	fmt.Print(res2[0])
	fmt.Print(res2[1])
}
