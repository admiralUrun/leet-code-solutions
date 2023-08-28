def permute(nums: Array[Int]): List[List[Int]] = {
  var answer = List.empty[List[Int]]
  def backTrack(curr: List[Int]): Unit = {
    if (curr.length == nums.length) answer = curr :: answer
    else {
      for (n <- nums) {
        if (!curr.contains(n)) backTrack(n :: curr)
      }
    }
  }

  backTrack(Nil)
  answer
  // nums.toList.permutations.toList
}