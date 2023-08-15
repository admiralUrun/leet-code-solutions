def minMutation(startGene: String, endGene: String, bank: Array[String]): Int = {
  def mutations(gene: String): Seq[String] = {
    val result = scala.collection.mutable.Buffer.empty[String]
    val mutation = Seq('A', 'C', 'G', 'T')
    for (i <- gene.indices) {
      for (m <- mutation if m != gene(i)) {
        val x = gene.substring(0, i) + m + gene.substring(i + 1)
        if (bank.contains(x)) result.addOne(x)
      }
    }
    result.toSeq
  }

  val queue = scala.collection.mutable.Queue((startGene, 0))
  val seen = scala.collection.mutable.HashSet(startGene)

  while (queue.nonEmpty) {
    val (gene, step) = queue.dequeue()

    if (gene == endGene) return step

    for (m <- mutations(gene)) {
      if (!seen.contains(m)) {
        seen.addOne(m)
        queue.addOne((m, step + 1))
      }
    }
  }

  -1
}