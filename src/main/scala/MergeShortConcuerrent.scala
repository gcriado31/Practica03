import de._

object MergeShortConcuerrent extends App {
  def msort(xs: List[Int]): List[Int] = {
    def merge(xs: List[Int], ys: List[Int]): List[Int] = {
      (xs, ys) match {
        case (Nil, _) => ys
        case (_, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (x < y) x :: merge(xs1, ys) else y :: merge(xs, ys1)
      }
    }

    log(s"comienzo el sort de la lista $xs")
    val n = xs.length / 2
    if (n == 0) xs
    else {
      var res1: List[Int] = Nil
      var res2: List[Int] = Nil
      val (ys, zs) = xs splitAt n
      val t1 = new Thread {
        override def run() = {
          res1 = msort(ys)
        }
      }
      val t2 = new Thread {
        override def run() = {
          res2 = msort(zs)
        }
      }
      t1.start()
      t2.start()
      t1.join()
      t2.join
      merge(res1, res2)
    }
  }

  val res=msort(List(5, -7, 3, 1, 14, 9, 6, -8))
  println("fin")
  println(res)

}
