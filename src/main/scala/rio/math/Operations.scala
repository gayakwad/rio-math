package rio.math

object Operations {

  val concat: (Int, Int) => (Int, String) = (a: Int, b: Int) => (a * 10 + b, "")
  val sum: (Int, Int) => (Int, String) = (a: Int, b: Int) => (a + b, " + ")
  val diff: (Int, Int) => (Int, String) = (a: Int, b: Int) => (a - b, " - ")
  val multiply: (Int, Int) => (Int, String) = (a: Int, b: Int) => (a * b, " * ")
  val divide: (Int, Int) => (Int, String) = (a: Int, b: Int) => (a / b, " / ")

  val ops: Array[(Int, Int) => (Int, String)] = Array(concat, sum, diff, multiply, divide)


  // 9,9,9,9
  // 99 + (9 / 9)
  // 9+9

  def printAllCombinations(numbers: Array[Int], str: String, sum: Int): Unit = {

    var x: Map[Int, List[String]] = Map()
    print(numbers, str, sum)
    println(x.size)
    println(x.mkString("\n"))

    def print(numbers: Array[Int], str: String, sum: Int): Unit = {

      if (numbers.length > 0) {
        for (op <- ops) {
          val (head, tail) = (numbers.head, numbers.drop(1))
          val (result, str1) = op(sum, head)
          print(tail, s"$str${str1}${head})", result)
        }
      } else {
        x += (sum -> (x.getOrElse(sum, List()) :+ str))
      }

    }
  }


}
