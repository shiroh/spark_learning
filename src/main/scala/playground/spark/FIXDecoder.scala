package playground.spark

class FIXDecoder {

}
object FIXDecoder {

  val SOH = 0x01.toChar

  def main(args: Array[String]) {
    val pairs = decode("8=FIX.4.49=16535=W49=LMXBDM56=FIXtest134=352=20120924-14:05:45.096262=EURUSD48=400122=8268=2269=0270=91.94271=100272=20120924273=14:05:39.636269=1270=91.98271=10010=071");
    println(pairs)
  }

  def decode(str: String) = {
    try {
      var fields = str.split(SOH)
      val pairArray = for (field <- fields) yield {
        val pair = field.split("=")
        Some((pair(0), pair(1)))
      }
    } catch {
      case _ => None
    }

  }

}