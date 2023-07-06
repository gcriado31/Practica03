//from Professional Scala, p.184
object Volatile extends App {
  class CustomThread extends Thread {
     @volatile var flag = true // Se pone @volatile para que el thread pueda ver el cambio de la variable

    override def run(): Unit = {
      while (flag) {}
      println("Thread terminated")
    }
  }

  val thread = new CustomThread
  thread.start()
  Thread.sleep(2000)
  thread.flag = false
  println("App terminated")
}
