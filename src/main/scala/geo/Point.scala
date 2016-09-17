package geo

import scala.math.sqrt
import Point._

case class Point(lat : Double, long: Double, name: String, ort: String) {
  val ONE_LATTITUDE_IN_KM = 111
  val ONE_LONGITUDE_AT_52_5_IN_KM = 67.7
  def dist(p: Point) : Double = {
    sqrt(sq((lat - p.lat) * ONE_LATTITUDE_IN_KM) 
      + sq((long - p.long) * ONE_LONGITUDE_AT_52_5_IN_KM)
    )
  }
}

object Point {
  def sq(x : Double) : Double = x*x
  
  val centres = Seq(
    // Point(52.520689, 13.387560, "Weidendammer Brücke", "Mitte"),
    Point(52.5043971, 13.3315912, "Kurfürstendamm 1", "Zoo"),
    Point(52.5111799, 13.3859783, "U Stadtmitte", "Friedrich-/Mohrenstraße"),
    Point(52.5210752, 13.4133312, "Weltzeituhr", "Alexanderplatz")
  )
  val reforms = Seq(
    Point(52.480386, 13.312780, "Heidelberger Platz", "Wilmersdorf"),
    Point(52.477734, 13.535720, "Ende Waldowallee", "Karlshorst"),
    Point(52.461266, 13.487777, "Ende Frauenlobstraße", "Baumschulenweg"),
    Point(52.579690, 13.398266, "Pastor-Niemöller-Platz", "NSH"),
    Point(52.585311, 13.302346, "Fußballfeld", "Borsigwalde"),
    Point(52.436130, 13.345773, "Kirche", "Lankwitz"),
    Point(52.556017, 13.212899, "Maselakepark", "Hakenfelde")
  )
  def main(args : Array[String]): Unit = {
    for (c : Point <- centres) {
      println(f"Distances from ${c.name}, ${c.ort}")
      for (p : Point <- reforms) {
        println(f"${c.dist(p)}%6.2f - ${p.name}, ${p.ort}")
      }
      println()
    }  
  }
  
  """
    |  6.76 - Ring
    | 11.11 - Ende Waldowallee, Karlshorst
    |  9.46 - Ende Frauenlobstraße, Baumschulenweg
    |  6.59 - Pastor-Niemöller-Platz, NSH
    |  9.21 - Fußballfeld, Borsigwalde
    |  9.80 - Kirche, Lankwitz
    | 12.46 - Maselakepark, Hakenfelde
    |""".stripMargin
}
