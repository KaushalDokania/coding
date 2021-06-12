package main

import (
	"fmt"
)

type Tree struct {
	root *Node
}
type Node struct {
	left  *Node
	right *Node
	data  int
}

func (n *Node) insert(data int) {
	if n == nil {
		return
	} else if data <= n.data {
		if n.left == nil {
			n.left = &Node{data: data, left: nil, right: nil}
		} else {
			n.left.insert(data)
		}
	} else {
		if n.right == nil {
			n.right = &Node{data: data, left: nil, right: nil}
		} else {
			n.right.insert(data)
		}
	}
}

func (t *Tree) insert(data int) *Tree {
	if t.root == nil {
		t.root = &Node{data: data, left: nil, right: nil}
	} else {
		t.root.insert(data)
	}
	return t
}

func print(node *Node, ns int) {
	if node == nil {
		return
	}

	for i := 0; i < ns; i++ {
		fmt.Print(" ")
	}
	fmt.Printf("%v\n", node.data)
	print(node.left, ns+2)
	print(node.right, ns+2)
}

func printPreOrder(n *Node) {
	if n == nil {
		return
	} else {
		fmt.Printf("%d ", n.data)
		printPreOrder(n.left)
		printPreOrder(n.right)
	}
}

func printInOrder(n *Node) {
	if n == nil {
		return
	} else {
		printInOrder(n.left)
		fmt.Printf("%d ", n.data)
		printInOrder(n.right)
	}
}

func printPostOrder(n *Node) {
	if n == nil {
		return
	} else {
		printPostOrder(n.left)
		printPostOrder(n.right)
		fmt.Printf("%d ", n.data)
	}
}

func printGivenLevel(n *Node, level int) {
	if n == nil {
		return
	}
	if level == 1 {
		fmt.Printf("%d", n.data)
	} else if level > 1 {
		printGivenLevel(n.left, level-1)
		printGivenLevel(n.right, level-1)
	}
}

func newNode(data int) *Node {
	return &Node{data: data, left: nil, right: nil}
}

func main() {

	// tree := &Tree{}
	root := &Node{}
	root.data = 1
	root.left = newNode(2)
	root.right = newNode(3)
	root.left.left = newNode(4)
	root.left.right = newNode(5)
	root.right.left = newNode(6)
	root.right.right = newNode(7)

	for i := 0; i <= 4; i++ {
		printGivenLevel(root, i)
		fmt.Println()
	}

	fmt.Print("\nPreorder: ")
	printPreOrder(root)

	fmt.Print("\nInorder: ")
	printInOrder(root)

	fmt.Print("\nPostorder: ")
	printPostOrder(root)
}
