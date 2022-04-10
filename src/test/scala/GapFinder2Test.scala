import scala.util.Random

class GapFinder2Test extends org.scalatest.FunSuite {

  test("testSolution") {
    assert(GapFinder2.solution(Array(1, 2, 3)) == 4)
    assert(GapFinder2.solution(Array(1, 3, 6, 4, 1, 2)) == 5)
  }
  test("performance") {
    val funcsToTest = List(
      GapFinder2.solution(_))
    val numberOfValues = 1000000
    val maxValue = 1000000
    val NANOS_PER_SEC = 1000000000
    val randomInts = Array.fill(numberOfValues) {
      Random.nextInt(maxValue) + 1
    }

    funcsToTest.foreach(f => {
      val start = System.nanoTime()
      assert(f(randomInts) < numberOfValues + 1)
      val stop = System.nanoTime()
      println("time: " + (stop - start) + " ns,  heap: " + Runtime.getRuntime.totalMemory() + " bytes")
      assert(stop - start < NANOS_PER_SEC)
    })

  }

}
