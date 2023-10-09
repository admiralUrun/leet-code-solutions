package binarySearch

func searchRange(nums []int, target int) []int {
	ans := []int{-1, -1}
	left, right := 0, len(nums)-1

	result := -1
	for left <= right {
		mid := left + (right-left)/2
		if nums[mid] == target {
			result = mid
			right = mid - 1
		} else if nums[mid] < target {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}

	ans[0] = result
	left, right = 0, len(nums)-1

	for left <= right {
		mid := left + (right-left)/2
		if nums[mid] == target {
			result = mid
			left = mid + 1
		} else if nums[mid] < target {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}
	ans[1] = result

	return ans
}
