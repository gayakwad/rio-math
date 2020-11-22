package rio.math

class ArrangementTest extends org.scalatest.funsuite.AnyFunSuite {

  test("How many combinations are there for 9999") {
    val concat: (Int, Int) => (Int, String) = (a: Int, b: Int) => (a * 10 + b, "")
    val sum: (Int, Int) => (Int, String) = (a: Int, b: Int) => (a + b, " + ")
    val diff: (Int, Int) => (Int, String) = (a: Int, b: Int) => (a - b, " - ")
    val multiply: (Int, Int) => (Int, String) = (a: Int, b: Int) => (a * b, " * ")
    val divide: (Int, Int) => (Int, String) = (a: Int, b: Int) => (a / b, " / ")

    val numbers: Array[Int] = Array(9, 9, 9)
    val ops: Array[(Int, Int) => (Int, String)] = Array(concat, sum, diff, multiply, divide)

    var x: Map[Int, String] = Map()
    print(numbers, "(9", 9)

    println(x.mkString("\n"))

    def print(numbers: Array[Int], str: String, sum: Int): Unit = {

      if (numbers.length > 0) {
        for (op <- ops) {
          val split = numbers.splitAt(1)
          val tuple = op(sum, split._1(0))
          print(split._2, s"$str${tuple._2}${split._1(0)})", tuple._1)
        }
      } else {
        x += (sum -> str)
        println(s"$str : $sum")
      }

    }

  }

  test("How many combinations are there for 9999 Improved ") {
    val concat: (Int, Int) => (Int, String) = (a: Int, b: Int) => (a * 10 + b, "")
    val sum: (Int, Int) => (Int, String) = (a: Int, b: Int) => (a + b, " + ")
    val diff: (Int, Int) => (Int, String) = (a: Int, b: Int) => (a - b, " - ")
    val multiply: (Int, Int) => (Int, String) = (a: Int, b: Int) => (a * b, " * ")
    val divide: (Int, Int) => (Int, String) = (a: Int, b: Int) => (a / b, " / ")

    val ops: Array[(Int, Int) => (Int, String)] = Array(concat, sum, diff, multiply, divide)

    val numbers: Array[Int] = Array(9, 9, 9)
    var x: Map[Int, String] = Map()
    print(numbers, "(9", 9)

    println(x.mkString("\n"))

    def print(numbers: Array[Int], str: String, sum: Int): Unit = {

      if (numbers.length > 0) {
        for (op <- ops) {
          val split = numbers.splitAt(1)
          val tuple = op(sum, split._1(0))
          print(split._2, s"$str${tuple._2}${split._1(0)})", tuple._1)
        }
      } else {
        x += (sum -> str)
        println(s"$str : $sum")
      }

    }

  }

}
