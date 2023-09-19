package binarySearch

func findDuplicate(nums []int) int {
	low := 1
	high := len(nums)
	duplicate := -1
	for low <= high {
		cur := (low + high) / 2
		count := 0
		for _, n := range nums {
			if n <= cur {
				count++
			}
		}
		if count > cur {
			duplicate = cur
			high = cur - 1
		} else {
			low = cur + 1
		}
	}
	return duplicate
}
