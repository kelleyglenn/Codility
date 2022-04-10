package task1

// you can write to stdout for debugging purposes, e.g.
// println("this is a debug message")

object Solution {
  def solution(s: String): Int = {
    if (s.length == 1) 4 else {
      val digitSum = s.map(_.asDigit).sum

      def mod0to4 = Set('0', '3', '6', '9')

      def mod1to4 = Set('1', '4', '7')

      def mod2to4 = Set('2', '5', '8')

      val modSet = digitSum % 3 match {
        case 0 => mod0to4
        case 1 => mod1to4
        case 2 => mod2to4
      }
      val prelim = s.map(d => if (modSet.contains(d)) 4 else 3).sum
      if (digitSum % 3 == 0) prelim - s.length + 1
      else prelim
    }
  }
}

