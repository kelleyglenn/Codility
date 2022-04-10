package task2

class SolutionTest extends org.scalatest.FunSuite {

  test("testSolution") {
    assert(!Solution.solution(Array(
      "X.....>",
      "..v..X.",
      ".>..X..",
      "A......")))
    assert(Solution.solution(Array(
      "...Xv",
      "AX..^",
      ".XX..")))
    assert(!Solution.solution(Array(
      "...",
      ">.A")))
    assert(!Solution.solution(Array(
      "A.v",
      "...")))
  }

}
