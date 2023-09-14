def heightChecker(heights: Array[Int]): Int = {
  heights.zip(heights.sorted).count { case (a, e) => a != e }
}