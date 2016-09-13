package geo

import scala.math.sqrt
import Point._

case class Point(lat : Double, long: Double, name: String, ort: String) {
  def dist(p: Point) : Double = sqrt(sq(lat-p.lat) + sq(long-p.long))
}

object Point {
  def sq(x : Double) : Double = x*x
  
  val middle = Point(52.520689, 13.387560, "Weidendammer Brücke", "Mitte")
  val ring = Point(52.480386, 13.312780, "Heidelberger Platz", "Wilmersdorf")
  val reforms = Seq(
    Point(52.477734, 13.535720, "Ende Waldowallee", "Karlshorst"),
    Point(52.461266, 13.487777, "Ende Frauenlobstraße", "Baumschulenweg"),
    Point(52.579690, 13.398266, "Pastor-Niemöller-Platz", "NSH"),
    Point(52.585311, 13.302346, "Fußballfeld", "Borsigwalde"),
    Point(52.436130, 13.345773, "Kirche", "Lankwitz"),
    Point(52.556017, 13.212899, "Maselakepark", "Hakenfelde")
  )
  def main(args : Array[String]): Unit = {
    println("Ring: " + middle.dist(ring).toString)
    for (p : Point <- reforms) {
      println(p.name + ", " + p.ort + ": " + middle.dist(p).toString)
    }
  }
  
  """
    |Ring: 0.08494928021472359
    |Ende Waldowallee, Karlshorst: 0.15426119935032148
    |Ende Frauenlobstraße, Baumschulenweg: 0.11650982798888351
    |Pastor-Niemöller-Platz, NSH: 0.059964459782443004
    |Fußballfeld, Borsigwalde: 0.10694591474198578
    |Kirche, Lankwitz: 0.09432061201031235
    |Maselakepark, Hakenfelde: 0.17819801487390405
  """.stripMargin

  "payload.realEstateTypeSpecificData.serviceCharge"
  
  """
    |payload.realEstateTypeSpecificData.rentSubsidy	35348	10.501735	null: 25498 double: 1167 integer: 8683
    |payload.realEstateTypeSpecificData.rentalIncome	165474	49.161594	null: 161410 double: 996 integer: 3068
    |payload.realEstateTypeSpecificData.rentalIncomeActual	3988	1.1848172	null: 1691 double: 386 integer: 1911
    |payload.realEstateTypeSpecificData.rentalIncomeTarget	3988	1.1848172	null: 2105 double: 174 integer: 1709
    |
  """.stripMargin
}