import scala.util.Random

class GapFinderTest extends org.scalatest.FunSuite {
  val funcsToTest = List(
    GapFinder.firstMissingIntSlow(_),
    GapFinder.firstMissingIntSlowWithSort(_),
    GapFinder.firstMissingIntSlowWithDistinct(_),
    GapFinder.firstMissingIntSlowWithSortDistinct(_),
    GapFinder.findMissingIntFastWithArrayBuffer(_),
    GapFinder.findMissingIntFastWithArray(_))
  test("simple tests") {
    funcsToTest.foreach(f => {
      assert(f(List()) === 1)
      assert(f(List(2)) === 1)
      assert(f(List(1)) === 2)
      assert(f(List(1, 2)) === 3)
      assert(f(List(1, 3)) === 2)
    })
  }
  test("negative values") {
    funcsToTest.foreach(f => {
      assert(f(List(-10000, -5, 0, 25)) === 1)
    })
  }
  test("unsorted values") {
    funcsToTest.foreach(f => {
      assert(f(List(7, 3, 9, 1, 2, 4, 6, 8)) === 5)
    })
  }
  test("duplicate values") {
    funcsToTest.foreach(f => {
      assert(f(List(7, 3, 9, 1, 2, 4, 6, 8, 9, 1, 4, 7, 2)) === 5)
    })
  }
  test("performance") {
    val numberOfValues = 1000000
    val maxValue = 1000000
    val NANOS_PER_SEC = 1000000000
    val randomInts = List.fill(numberOfValues) {
      Random.nextInt(maxValue) + 1
    }

    funcsToTest.foreach(f => {
      val start = System.nanoTime()
      assert(f(randomInts) < numberOfValues + 1)
      val stop = System.nanoTime()
      println("time: " + (stop - start))
      assert(stop - start < NANOS_PER_SEC)
    })

  }
}
