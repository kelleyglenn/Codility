object GapFinder2 {
  def solution(a: Array[Int]): Int = {
    val found = Array.fill(100000)(false)
    for (i <- a.indices) if (found.indices.contains(a(i) - 1)) found(a(i) - 1) = true
    found.zipWithIndex.find(! _._1).get._2 + 1
  }
}
