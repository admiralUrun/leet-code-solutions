def combine(n: Int, k: Int): List[List[Int]] = {
  var answer = List.empty[List[Int]]

  def backTrack(curr: List[Int], i: Int): Unit = {
    if (curr.length == k) answer = curr :: answer
    else {
      for (j <- i until n + 1) {
        backTrack(j :: curr, j + 1)
      }
    }
  }

  backTrack(Nil, 1)
  answer

}