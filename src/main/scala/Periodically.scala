object Periodically extends App{
  def periodically (duriation: Long, f: => Unit) : Unit ={
    val worker= new Thread {
      override def run(): Unit = {
        while (true) {
          f
          Thread.sleep(duriation)
        }
      }
    }
    worker.setName("Worker")
    worker.start()
  }

  periodically (1000,{println("ha pasado 1 segundo")})

}
