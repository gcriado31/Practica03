import de._
object ThreadsCommunicate extends App {
  var result: String = null
  val t = thread {result = "\nTitle\n" + "=" * 5 }
  t.join()
  log(result)
}
