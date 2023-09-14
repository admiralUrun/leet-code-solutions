def merge(nums1: Array[Int], m: Int, nums2: Array[Int], n: Int): Unit = {
  val sorted = (nums1.take(m) ++ nums2.take(n)).sorted
  System.arraycopy(sorted, 0, nums1, 0, m + n)
}