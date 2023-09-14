def combinationSum(candidates: Array[Int], target: Int): List[List[Int]] = {
  var answer = List.empty[List[Int]]

  def backtracking(curr: List[Int], sum: Int, start: Int): Unit = {
    if (sum == target) answer = curr :: answer
    else {
      for (i <- start until candidates.length) {
        val c = candidates(i)
        if (c + sum <= target) backtracking(c :: curr, sum + c, i)
      }
    }
  }

  backtracking(Nil, 0, 0)
  answer
}