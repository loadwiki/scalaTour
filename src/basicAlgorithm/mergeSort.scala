package basicAlgorithm

object mergeSort {
  // recursive mode
  def recSort(x:Array[Int],buf:Array[Int],i:Int,j:Int):Unit = {  
    def merge2Array(s1:Int,l1:Int,s2:Int,l2:Int) = {
      var i = s1
      var j = s2
      for(xi<- s1 to s1+l1+l2-1 ) {
         if(i>s1+l1-1) {
          buf(xi) = x(j)
          j += 1
        }
        else if(j>s2+l2-1) {
          buf(xi) = x(i)
          i += 1
        }
        else if(x(i)<=x(j) && i <= s1+l1-1) {
          buf(xi) = x(i)
          i += 1
        }
        else if( x(i)>x(j) && j <= s2+l2-1) {
          buf(xi) = x(j)
          j += 1
        }
      }
      
      for(xi<- s1 to s1+l1+l2-1)
        x(xi) = buf(xi)
    }
    val mid = i+(j-i)/2
    if(mid>i) recSort(x,buf,i,mid)
    if(mid+1<j) recSort(x,buf,mid+1,j)
    merge2Array(i,mid-i+1,mid+1,j-mid)
  }
  // tail recursion
  def sort(x:Array[Int],buf:Array[Int],i:Int,j:Int,interval:Int):Unit = {
    def merge2Array(s1:Int,l1:Int,s2:Int,l2:Int) = {
      var i = s1
      var j = s2
      if(s1 == s2) ()
      for(xi<- s1 to s1+l1+l2-1 ) {
        if(i>s1+l1-1) {
          buf(xi) = x(j)
          j += 1
        }
        else if(j>s2+l2-1) {
          buf(xi) = x(i)
          i += 1
        }        
        else if(x(i)<=x(j) && i <= s1+l1-1) {
          buf(xi) = x(i)
          i += 1
        }
        else if( x(i)>x(j) && j <= s2+l2-1) {
          buf(xi) = x(j)
          j += 1
        }
      }
      
      for(xi<- s1 to s1+l1+l2-1)
        x(xi) = buf(xi)
    }
   if(interval == j-i+1) ()
   else if(interval > j-i+1) {
     merge2Array(0,interval/2,interval/2,j-i+1-interval/2)
   }
   else {
     for(i <- 0 to (j-i+1)/interval-1){
       merge2Array(i*interval,interval/2,i*interval+interval/2,interval/2)
     }
     val remaind = (j-i+1)%interval
     val remaindSub = (j-i+1)%(interval/2)
     if(remaind>interval/2){
       merge2Array(j-remaind+1,interval/2,j-remaindSub+1,remaindSub)
     }
     sort(x,buf,i,j,interval*2)
   }
  }
  
  def main(args: Array[String]) = {
    val a = args.map(s=>s.toInt)
    val buf = Array.range(0,a.length)
    println("recursive mergeSort: ")
    recSort(a,buf,0,a.length-1)
    for(i <- a )
      println(i)
      
    val b = args.map(s=>s.toInt)
    println("tailRecursive mergeSort: ")
    sort(b,buf,0,b.length-1,2)
    
    for(i <- b )
      println(i)
  }
}