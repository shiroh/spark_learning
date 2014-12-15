package playground.spark

import scala.io.Source

object CSVParser {
  def main(args: Array[String]) {
    var src = Source.fromFile("newFile");
    var lines = src.getLines
    var map1 = lines.map(
      (x) => {
        var line = x.split(",");
        (line(0), line(1))
      })
    var map2 = map1.map((x) => {
      var tmp = x._1.split("/")
      "\"" + tmp(0)+tmp(1) + "\"" + ":" + "\"" + x._2 + "\","
    })
    for (l <- map2) println(l)
  }
}