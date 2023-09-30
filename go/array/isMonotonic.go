package array

func isMonotonic(nums []int) bool {
	if len(nums) == 1 {
		return true
	}
	direction := 0
	prev := nums[0]

	for i := 1; i < len(nums); i++ {
		if prev > nums[i] {
			if direction == 0 {
				direction = -1
			} else if direction == 1 {
				return false
			}
		} else if prev < nums[i] {
			if direction == 0 {
				direction = 1
			} else if direction == -1 {
				return false
			}
		}

		prev = nums[i]
	}

	return true
}
