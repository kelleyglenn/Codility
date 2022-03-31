import scala.collection.mutable.ArrayBuffer

object GapFinder {
  def firstMissingIntSlow(ints: List[Int]): Int = {
    Range.inclusive(1, 100000).diff(ints).min
  }

  def firstMissingIntSlowWithSort(ints: List[Int]): Int = {
    Range.inclusive(1, 100000).diff(ints.sorted).min
  }

  def firstMissingIntSlowWithDistinct(ints: List[Int]): Int = {
    Range.inclusive(1, 100000).diff(ints.distinct).min
  }

  def firstMissingIntSlowWithSortDistinct(ints: List[Int]): Int = {
    Range.inclusive(1, 100000).diff(ints.sorted.distinct).min
  }

  def findMissingIntFastWithArrayBuffer(ints: List[Int]): Int = {
    val found = ArrayBuffer.fill(100000)(false)
    ints.foreach(i => if (found.indices.contains(i - 1)) {
      found(i - 1) = true
    })
    found.zipWithIndex.find(!_._1).get._2 + 1
  }

  def findMissingIntFastWithArray(ints: List[Int]): Int = {
    val found = Array.fill(100000)(false)
    ints.foreach(i => if (found.indices.contains(i - 1)) {
      found(i - 1) = true
    })
    found.zipWithIndex.find(!_._1).get._2 + 1
  }
}
