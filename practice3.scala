import scala.collection.immutable.Stream.cons
// 1. Check if given number is prime number.
// 2. Show all prime numbers less than or same as given number.


object Practice3 {

    def checkPrimeNumber(check_number:Int): Boolean = {

        var flag = true; 

        if(check_number == 1 || check_number == 2) flag = true;

        for(i <- 2 to check_number/2) {
            if(check_number % i == 0) flag = false;
        }

        return flag

    }
    
  // Main method 
    def main(args: Array[String]) 
    { 
        val input_number = args(0).toInt

        println("Check Number = " + input_number)
        println("Show: ")
        println("=======")

        if(checkPrimeNumber(input_number)) println(input_number + " is a prime number")
        else println(input_number + " is not a prime number")

        print("Prime Number less then " + input_number + " is: ")

        for( i <- 1 to input_number) {
            if(checkPrimeNumber(i)) print(i + " ")
        }
        
        println("")
        
    } 
}