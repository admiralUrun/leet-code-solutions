def lengthOfLongestSubstring(s: String): Int = {
  var left, max = 0
  val set = scala.collection.mutable.Set.empty[Char]

  for (r <- s.indices) {
    while (set.contains(s(r))) {
      set.remove(s(left))
      left += 1
    }
    max = math.max(max, r - left + 1)
    set.add(s(r))
  }

  max
}