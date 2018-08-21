import org.scalatest.FunSuite

import StringCalculator._

class TestStringCalculator extends FunSuite {

  test("Should return 0 when empty string is passed") {
    assert(0 == add(""))
  }

  test("Should return the input number when only one number is passed") {
    assert(1 == add("1"))
  }

  test("Should sum two numbers when two numbers are passed") {
    assert(5 == add("3,2"))
  }

  test("Should sum any amount of numbers that is passed as input") {
    assert(6 == add("3,2,1"))
  }

  test("Should accept newline as separator") {
    assert(4 == add("3\n1"))
  }

  test("Should allow to define a custom separator") {
    assert(5 == add("//;\n2;3"))
  }

  test("Should not allow negative numbers") {
    assertThrows[Exception](add("-1,2"))
  }

  test("Should show negative numbers in the exception message if more than one is present") {
    try {
      add("-1,-3")
    } catch {
      case ex: Exception => {
        assert(ex.getMessage.contains("-1,-3"))
      }
    }
  }

}
