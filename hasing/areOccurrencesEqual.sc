def areOccurrencesEqual(s: String): Boolean = s
  .groupBy(identity)
  .map(_._2.length)
  .toSet
  .size == 1