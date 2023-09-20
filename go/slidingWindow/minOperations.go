package slidingWindow

func minOperations(nums []int, x int) int {
	left, count, total, curr := 0, -1, 0, 0

	for _, n := range nums {
		total += n
	}

	for right, n := range nums {
		curr += n

		for curr > total-x && left <= right {
			curr -= nums[left]
			left++
		}

		if curr == total-x {
			count = max(count, right-left+1)
		}
	}

	if count != -1 {
		return len(nums) - count
	}
	return count
}

func max(a int, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}
