// Print numbers from 1 to n.
// For each number, show "Fizz" instead if it can be divided by three, show "Buzz" instead if it can be divided by five.
// Show "FizzBuzz" instead if it can be divided by three AND five.

object ShowFizzBuzz {
  // Main method 
    def FizzBuzz(num: Int) {

        for(i <- 1 to num) {
            if(i % 3 == 0 && i % 5 != 0) 
                println("Fizz")
            else if (i % 3 != 0 && i % 5 == 0)
                println("Buzz")
            else if (i % 3 == 0 && i % 5 == 0)
                println("FizzBuzz")
            else 
                println(i)
        } 
    }

    def main(args: Array[String]) 
    { 
        var n = args(0).toInt

        println("n = " + n)
        println("Show: ")
        println("=======")
          
        FizzBuzz(n)
        
    } 
}