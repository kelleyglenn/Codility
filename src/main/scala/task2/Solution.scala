package task2

object Solution {
  def solution(b: Array[String]): Boolean = {
    val assassin = 'A'
    val obstacle = 'X'
    val board = b.map(_.toCharArray)
    assert(board.map(_.length).distinct.length == 1)
    val startRow = board.zipWithIndex.find(_._1.contains(assassin)).get._2
    val startCol = board(startRow).indexOf(assassin)
    val rowsWithLeftGuards = board.filter(_.contains('<'))
    val rowsWithRightGuards = board.filter(_.contains('>'))
    rowsWithLeftGuards.foreach { r =>
      val guardPos: Seq[Int] = r.indices.filter(i => r(i) == '<')
      guardPos.foreach { pos =>
        var i = pos
        while (i >= 0 && r(i) != obstacle) {
          r(i) = '<'
          i -= 1
        }
      }
    }
    rowsWithRightGuards.foreach { r =>
      val guardPos: Seq[Int] = r.indices.filter(i => r(i) == '>')
      guardPos.foreach { pos =>
        var i = pos
        while (i < r.length && r(i) != obstacle) {
          r(i) = '>'
          i += 1
        }
      }
    }
    val colIndicesWithUpGuards = board.filter(_.contains('^')).flatMap(r => r.indices.filter(i => r(i) == '^'))
    colIndicesWithUpGuards.foreach { col =>
      val guardRowIndices: Seq[Int] = board.zipWithIndex.filter(r => r._1(col) == '^').map(_._2)
      guardRowIndices.foreach { row =>
        var i = row
        while (i >= 0 && board(i)(col) != obstacle) {
          board(i)(col) = '^'
          i -= 1
        }
      }
    }
    val colIndicesWithDownGuards = board.filter(_.contains('v')).flatMap(r => r.indices.filter(i => r(i) == 'v'))
    colIndicesWithDownGuards.foreach { col =>
      val guardRowIndices: Seq[Int] = board.zipWithIndex.filter(r => r._1(col) == 'v').map(_._2)
      guardRowIndices.foreach { row =>
        var i = row
        while (i < board.length && board(i)(col) != obstacle) {
          board(i)(col) = 'v'
          i += 1
        }
      }
    }
    if (board(startRow)(startCol) != assassin) false else {
      var visited: Set[(Int, Int)] = Set((startRow, startCol))
      var unVisitedReachableNeighbors =
        Set((startRow - 1, startCol), (startRow + 1, startCol), (startRow, startCol - 1), (startRow, startCol + 1)).
          filter { case (r, c) => board.indices.contains(r) && board(r).indices.contains(c) && board(r)(c) == '.' }.diff(visited)
      while (unVisitedReachableNeighbors.nonEmpty && !unVisitedReachableNeighbors.contains((board.length - 1, board(0).length - 1))) {
        val (r, c) = unVisitedReachableNeighbors.head
        visited = visited ++ Set((r, c))
        unVisitedReachableNeighbors =
          Set((r - 1, c), (r + 1, c), (r, c - 1), (r, c + 1)).
            filter { case (r, c) => board.indices.contains(r) && board(r).indices.contains(c) && board(r)(c) == '.' }.diff(visited)
      }
      if (unVisitedReachableNeighbors.contains((board.length - 1, board(0).length - 1))) true
      else false
    }
  }
}
