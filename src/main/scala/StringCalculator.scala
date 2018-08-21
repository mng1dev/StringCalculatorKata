object StringCalculator extends App {

  def add(rawnumbers: String): Int = {
    def listOfNumbers: Array[Int] = {

      val customSeparatorPattern = "//(.)\n(.*)".r

      val numbers = rawnumbers match {
        case "" => "0"
        case customSeparatorPattern(delimiter, numbersList) => numbersList.replace(delimiter, ",")
        case _ => rawnumbers
      }
      numbers.split(",|\n") map { _.toInt }
    }

    val negativeNumbers = listOfNumbers filter { _ < 0 }

    try {
      require(negativeNumbers.length == 0)
    } catch {
      case _: IllegalArgumentException => {
        val message = "Negative Numbers not Allowed.".concat(
          if (negativeNumbers.length == 0) ""
          else s" - (${negativeNumbers.mkString(",")})"
        )
        throw new Exception(message)
      }
    }

    listOfNumbers.sum
  }

}
