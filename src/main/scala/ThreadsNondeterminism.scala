import de._
object ThreadsNondeterminism extends App {
  val t = thread {log("New thread running.")}
  log("...")
  log("...")
  t.join()
  log("New thread joined.")
}