def kWeakestRows(mat: Array[Array[Int]], k: Int): Array[Int] = mat
  .map(_.sum)
  .zipWithIndex
  .sortBy(_._1)
  .map(_._2)
  .take(k)