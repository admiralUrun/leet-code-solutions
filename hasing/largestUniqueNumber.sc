def largestUniqueNumber(nums: Array[Int]): Int = nums
  .groupBy(identity)
  .filter(_._2.length == 1)
  .maxByOption(_._1)
  .map(_._1)
  .getOrElse(-1)