import de._

object ThreadsUnprotectedUid extends App {

  var uidCount = 0L
  def getUniqueId() = this.synchronized  {
    /* Se le añade this.synchronized para asegurar que el siguiente bloque
    de código solo se puede ejecutar si no hay otro thread ejecutando simultaneamente
    este bloque de código sincronizado y ningún otro bloque sincronizado que use el mismo objeto this. */
    val freshUid = uidCount + 1
    uidCount = freshUid
    freshUid
  }

  def printUniqueIds(n: Int): Unit = {
    val uids = for (i <- 0 until n) yield getUniqueId()
    log(s"Generated uids: $uids")
  }

  val t = thread {
    printUniqueIds(5)
  }
  printUniqueIds(5)
  t.join()

}
