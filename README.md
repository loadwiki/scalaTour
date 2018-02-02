# ScalaTour
A few months ago, I used clojure to do some consistent test for our NoSQL [elasticell](https://github.com/deepfabric/elasticell).
I see very powerful strength of the functional praradigm for dataflow process, while so many parenthesises makes me crazy. There is so may syntax sugar that both if-else and for-loops are functions. Now I find scala, a perfect mixture language with object oriented, imperative and functional enabled.

# Scala Advantage

You can easily write any algorithm which is essencially recursive in a functional way. Moreover, recursive function with tail recursion will be executed efficiently in scala.

Maybe you are famaliar with c/c++ or java. It is not so convenient to lack traditional for loops statement at first. However, you can also use if-branch or match-case statement in scala. 

At last when you are uesd to write pure recursive code with no for-loop styles in C++ or java, you will find that it is more important to express the algorithm rather than some space or computational rate. At the end, you will never worry about that the "i" index boudary in for-loops may overflow, because all the boundary will be expressed in an if-else statement using recursive style.

+ Pure funtional with no side-effect.
+ No for-loops just tail recursion.
