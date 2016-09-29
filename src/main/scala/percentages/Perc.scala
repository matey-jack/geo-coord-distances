package percentages

import scala.util.matching.Regex

object Perc {
  def main(args: Array[String]): Unit = {

  }

  def getPercentage(s: String): String = {
    val r: Regex = raw"(\d,\d\d?) ?%".r
    val firstMatch = r.findFirstIn(s)
    firstMatch match {
      case Some(r(p)) => p.replace(',', '.')
      case None => ""
    }
  }

  def getAbsolute(s: String): String = {
    val r: Regex = raw"(\d*[.]?\d+)(,\d+)? ?€".r
    val firstMatch = r.findFirstIn(s)
    firstMatch match {
      case Some(r(value, fraction)) => value.replace(".", "")
      case None => ""
    }
  }
}
