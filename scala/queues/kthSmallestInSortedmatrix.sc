def topKFrequent(nums: Array[Int], k: Int): Array[Int] = nums
  .groupBy(identity)
  .toArray
  .sortBy(_._2.length)(Ordering.Int.reverse)
  .map(_._1)
  .take(k)
