def search(nums: Array[Int], target: Int): Int = {
  var left = 0
  var mid = nums.length / 2
  var right = nums.length - 1

  while (left <= right) {
    if (nums(mid) < target) left = mid + 1
    else if (nums(mid) > target) right = mid - 1
    else return mid

    mid = left + (right - left) / 2
  }

  -1
}