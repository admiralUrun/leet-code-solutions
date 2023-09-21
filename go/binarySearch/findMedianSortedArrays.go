package binarySearch

import "math"

func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	if len(nums1) > len(nums2) {
		return findMedianSortedArrays(nums2, nums1)
	}

	m, n := len(nums1), len(nums2)
	left, right := 0, m
	for left <= right {
		partitionA := (left + right) / 2
		partitionB := (m+n+1)/2 - partitionA

		maxLeftA, minRightA, maxLeftB, minRightB := math.Inf(-1), math.Inf(-1), math.Inf(-1), math.Inf(-1)
		if partitionA != 0 {
			maxLeftA = float64(nums1[partitionA-1])
		}
		if partitionA != m {
			minRightA = float64(nums1[partitionA])
		}
		if partitionB != 0 {
			maxLeftB = float64(nums2[partitionB-1])
		}
		if partitionB != n {
			minRightB = float64(nums2[partitionB])
		}

		if maxLeftA <= minRightB && maxLeftB <= minRightA {
			if (m+n)%2 == 0 {
				return (max(maxLeftA, maxLeftB) + min(minRightA, minRightB)) / 2
			} else {
				return max(maxLeftA, maxLeftB)
			}
		} else if maxLeftA > minRightB {
			right = partitionA - 1
		} else {
			left = partitionA + 1
		}
	}
	return -1
}

func max(a float64, b float64) float64 {
	if a > b {
		return a
	} else {
		return b
	}
}

func min(a float64, b float64) float64 {
	if a > b {
		return b
	} else {
		return a
	}
}
