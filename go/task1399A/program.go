package com.github.elvirka.tasks.codeforces.archive.main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
)

func com.github.elvirka.tasks.codeforces.archive.main() {
	var tn int
	in := bufio.NewReader(os.Stdin)
	fmt.Fscan(in, &tn)
	for i := 0; i < tn; i++ {
		var tsSize int
		fmt.Fscan(in, &tsSize)
		var ts []int
		for i := 0; i < tsSize; i++ {
			var item int
			fmt.Fscan(in, &item)
			ts = append(ts, item)
		}
		sort.Ints(ts)
		var yes = true
		for i := 0; i < tsSize-1; i++ {
			var dif =  ts[i+1] - ts[i]
			if dif > 1 {
				yes = false
			}
		}
		if yes {
			fmt.Println("YES")
		} else {
			fmt.Println("NO")
		}
	}
}
