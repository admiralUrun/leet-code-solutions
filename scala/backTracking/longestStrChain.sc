def longestStrChain(words: Array[String]): Int = {
  def checkTwoWords(wordA: String, wordB: String): Boolean = {
    if (wordA.length + 1 != wordB.length) false
    else {
      var i = 0
      var j = 0
      var diffCount = 0

      while (i < wordA.length && j < wordB.length) {
        if (wordA(i) == wordB(j)) {
          i += 1
          j += 1
        } else if (diffCount > 1) return false
        else {
          diffCount += 1
          j += 1
        }
      }

      diffCount == 1 || (diffCount == 0 && wordA.length < wordB.length)
    }
  }

  val cache = scala.collection.mutable.HashMap.empty[Int, Int]
  def longestStrChain(i: Int): Int = {
    if (cache.contains(i)) cache(i)
    else {
      var ans = 0
      for (j <- words.indices if j != i) {
        if (checkTwoWords(words(i), words(j))) ans = ans max (longestStrChain(j) + 1)
      }

      cache(i) = ans
      cache(i)
    }
  }

  var longest = 0
  for (i <- words.indices) {
    longest = longest max longestStrChain(i)
  }

  longest
}
