package basicAlgorithm

object heapSort {
    def Sort(x: Array[Int],head:Int,tail:Int) = {
    def swap(i:Int,j:Int) = {
      var tmp = 0
      tmp = x(i)
      x(i) = x(j)
      x(j) = tmp
    }
    def min2(i:Int,j: Int) = {
      if(x(i)>x(j)) swap(i,j)
    }
    def min3(i:Int,j: Int,k: Int):Int = {
      if(x(j)<x(k)){
        if(x(j)<x(i)) {
          swap(i,j)
          2
        } 
        else  1
          
      }
      else {
        if(x(k)<x(i)) {
          swap(i,k)
          3
        }
        else 1
      }
    }
    
    def makeHeap(i:Int,j: Int): Unit = {
      val k = i+(j-i)/2+(j-i)%2-1
      if(i >= j) ()
      else {
        if( (j-i)%2 == 0 ){
          min3(i,j-1,j)
          makeHeap(i,j-2)
        }
        else {
          min2(i,j)
          makeHeap(i,j-1)
        } 
      }
    }
    
    def adjust(i:Int,j:Int): Unit = {
      if(j-i>=2) {
        min3(i,i+1,i+2) match {
          case 1 => ()
          case 2 => adjust(i+1,j)
          case 3 => adjust(i+2,j)
        }
      }
      else if(j-i==1){
        if(x(i)>x(j)) swap(i,j)
      }
      else ()
    }
  
    def recSort(i:Int,j:Int):Unit = {
      if(i<j){
        swap(i,j)
        swap(i,j-1)
        adjust(i,j-1)
        recSort(i,j-1)
      }
    }
    
    makeHeap(head,tail)
    recSort(head,tail)
  }
  
  def main(args: Array[String]) {
    val a = {
        for(arg <- args) yield arg.toInt
    }
    
    Sort(a,0,args.length-1)
    println("heapSort!")
    a.map(i=>println(i))
    
  }
}