def sortArray(nums: Array[Int]): Array[Int] = {

  def heapyfy(size: Int, i: Int): Unit = {
    val left = 2 * i + 1
    val right = 2 * i + 2
    var largest = i

    if (left < size && nums(left) > nums(largest)) largest = left
    if (right < size && nums(right) > nums(largest)) largest = right
    if (largest != i) {
      val swap = nums(i)
      nums(i) = nums(largest)
      nums(largest) = swap
      heapyfy(size, largest)
    }
  }

  for (i <- nums.length / 2 - 1 to 0 by -1) {
    heapyfy(nums.length, i)
  }

  for (i <- nums.indices.reverse) {
    val swap = nums(i)
    nums(i) = nums(0)
    nums(0) = swap
    heapyfy(i, 0)
  }


  nums
}