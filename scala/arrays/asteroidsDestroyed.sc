def asteroidsDestroyed(mass: Int, asteroids: Array[Int]): Boolean = {
  var planet = mass.toLong
  for (a <- asteroids.sorted) {
    if (a <= planet) planet += a
    else return false
  }
  true
}