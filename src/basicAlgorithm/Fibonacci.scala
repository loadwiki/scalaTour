package basicAlgorithm

object Fibonacci {
  def fb(n:Int): Int = {
    var a = 0
    var b = 1
    var c = 1
  
    def recFb(i:Int):Unit = {
      	if(i == 3){
      		a = b + c
      	}
      	else if(i>3){
      	  a = b + c
      	  
      	  c = b
      	  b = a
      	  recFb(i-1)
      	}
    }
    recFb(n)
    a
  }
  def main(args: Array[String]) = {
    val input = args(0).toInt
    println("fibonacci: ")
    println(fb(input))
  }  
}