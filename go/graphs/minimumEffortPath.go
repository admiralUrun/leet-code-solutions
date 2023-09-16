package graphs

func minimumEffortPath(heights [][]int) int {
	directions := [4][2]int{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}
	n, m := len(heights), len(heights[0])

	check := func(maxEffort int) bool {
		seen := make(map[int]bool)
		stack := [][]int{{0, 0}}

		for len(stack) != 0 {
			lastIndex := len(stack) - 1
			row, col := stack[lastIndex][0], stack[lastIndex][1]
			stack = stack[:lastIndex]

			if row == n-1 && col == m-1 {
				return true
			}

			for _, dir := range directions {
				nextRow, nextCol := row+dir[0], col+dir[1]
				id := createUniqueID(nextRow, nextCol)
				if nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m && !seen[id] {
					if abs(heights[row][col]-heights[nextRow][nextCol]) <= maxEffort {
						seen[id] = true
						stack = append(stack, []int{nextRow, nextCol})
					}
				}
			}

		}

		return false
	}

	left, right := 0, 0

	for _, row := range heights {
		for _, col := range row {
			right = max(col, right)
		}
	}

	for left <= right {
		mid := left + (right-left)/2
		if check(mid) {
			right = mid - 1
		} else {
			left = mid + 1
		}
	}

	return left
}

func max(a, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}

func abs(x int) int {
	if x < 0 {
		return -x
	}
	return x
}

func createUniqueID(num1, num2 int) int {
	return (num1 << 16) | num2
}