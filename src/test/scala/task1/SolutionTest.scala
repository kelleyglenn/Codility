package task1

import scala.util.Random

class SolutionTest extends org.scalatest.FunSuite {

  test("testSolution") {
    assert(Solution.solution("1") == 4)
    assert(Solution.solution("9") == 4)
    assert(Solution.solution("23") == 7)
    assert(Solution.solution("0081") == 11)
    assert(Solution.solution("022") == 9)
  }
  test("performance"){
    val randomDigits = Array.fill(100000) {
      (Random.nextInt(10)+'0').toChar
    }

  }

}
