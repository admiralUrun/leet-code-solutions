def subsets(nums: Array[Int]): List[List[Int]] = {
  var answer = List.empty[List[Int]]

  def backTrack(curr: List[Int], i: Int): Unit = {
    answer = curr :: answer
    for (j <- i until nums.length) {
      if (!curr.contains(nums(j))) {
        backTrack(nums(j) :: curr, j)
      }
    }
  }

  backTrack(Nil, 0)
  answer
}