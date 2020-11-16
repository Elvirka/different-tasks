package main

import (
	"fmt"
)

func printCount(c chan int)  {
	num := 0
	for num >= 0 {
		num := <- c
		fmt.Print(num, " ")
	}
}

func main() {
	c := make(chan int)
	a := []int {1, 2, 5, 8, -4, 13, 21, -6}
	go printCount(c)
	for _, v := range a{
		c <- v
	}
	//time.Sleep(time.Millisecond * 1)
	fmt.Println("End of main")
}
