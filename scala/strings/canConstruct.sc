def canConstruct(ransomNote: String, magazine: String): Boolean = {
  val hashMap = scala.collection.mutable.HashMap.empty[Char, Int]
  magazine.foreach(c => hashMap.update(c, hashMap.getOrElse(c, 0) + 1))

  ransomNote.forall { c =>
    val exists = hashMap.contains(c)
    if (exists) {
      if (hashMap(c) > 1) hashMap.update(c, hashMap(c) - 1)
      else hashMap.remove(c)
    }

    exists
  }
}