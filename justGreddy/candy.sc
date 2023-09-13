def candy(ratings: Array[Int]): Int = {
  val candies = Array.fill(ratings.length)(1)

  for (i <- ratings.indices) {
    if (i > 0 && ratings(i) > ratings(i - 1)) {
      candies(i) = candies(i) + candies(i - 1)
    }
  }

  for (i <- ratings.length - 2 to 0 by -1) {
    if (ratings(i) > ratings(i + 1)) {
      candies(i) = candies(i) max candies(i + 1) + 1
    }
  }

  candies.sum
}