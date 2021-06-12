package main

import (
	"fmt"
)

func sumPair(sum int, arr []int) (int, int) {
	m := make(map[int]bool)
	for _, num := range arr {
		_, ok := m[sum-num]
		if ok == true {
			return num, sum - num
		}
		m[num] = true
		fmt.Println(m)
	}
	return -1, -1
}

func neList() []int {
	list := []int{}
	list = append(list, 10)
	list = append(list, 20)
	list = append(list, 10)
	list = append(list, 30)
	return list
}

func main() {
	a := []int{1, 2, 3, 4, 5, 6}
	fmt.Println(sumPair(10, a))
	fmt.Println(neList())
}
