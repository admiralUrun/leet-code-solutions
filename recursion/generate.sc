def generate(numRows: Int): List[List[Int]] = {
  def getNewRow(goThought: List[Int], acc: List[Int], prev: Int): List[Int] = goThought match {
    case n :: ns => getNewRow(ns, n + prev :: acc, n)
    case Nil => acc
  }

  var result: List[List[Int]] = Nil

  if (numRows >= 1) result = List(1) :: result

  for (_ <- 1 until numRows) {

    result = (result.head.head :: getNewRow(result.head, Nil, 0)) :: result
  }


  result.reverse
}