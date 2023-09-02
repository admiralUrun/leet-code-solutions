def combinationSum3(k: Int, n: Int): List[List[Int]] = {
  var buffer: List[List[Int]] = Nil

  def backTrack(i: Int, acc: List[Int], sum: Int): Unit = {
    if (acc.length == k && sum == n) buffer = acc :: buffer
    else if (acc.length < k) {
      for (j <- i to 9) {
        backTrack(j + 1, j :: acc, sum + j)
      }
    }
  }

  backTrack(1, Nil, 0)
  buffer
}