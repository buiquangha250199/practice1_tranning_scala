import scala.collection.mutable.ListBuffer
import scala.util.Random

object WordChainGame {
  // read file
  def readDictionaryFile(): String = {
    val source = scala.io.Source.fromFile("src//dictionary.txt")
    val lines = try source.mkString finally source.close()
    lines
  }
  // random character
  def random(START: Int, END: Int): Int = {
    val random_number = new Random()
    START + random_number.nextInt(( END - START) + 1)
  }
  def randomChar: String = {
    val aNumber = 97
    val zNumber = 122
    random( aNumber, zNumber).toChar.toString
  }
  def isUserGoFirst: Int = random(0, 1)

  def userInput: String = {
    println("Please input: ")
    val scanner = new java.util.Scanner(System.in)
    val line = scanner.nextLine().toLowerCase()
    line
  }

  def game() {
    // get all words in file and split to listBuffer
    val wordString = readDictionaryFile().toLowerCase()
    val wordList: List[String] = wordString.split(", ").map(_.trim).toList
    var wordListBuffer = ListBuffer.empty ++= wordList

    // set a map all element not input format: turn -> "[player] [word]" to count turn and amount of words
    val inputtedWord = scala.collection.mutable.Map[Int, String]()
    // init
    var turn = 1
    var charPresent = ""
    val lengthOfWordListAtPresent = wordListBuffer.length

    isUserGoFirst match {
      case 1 =>
        println("User go first:")
        println(randomChar)
        userInput
        
      case 0 =>
        println("Computer go first")
    }
  }

    // random first player: random 1 for player, 2 for computer
//    if(random(0,1) == 1) {
//      val aNumber = 97
//      val zNumber = 122
//
//      //init user go first state
//      alphabetsStart = random(aNumber, zNumber).toChar
//
//      println("USER")
//      println("Please input your word start with => " + alphabetsStart)
//
//    } else {
//      val randomNumber = random(0,wordListBuffer.length-1)
//      val computerWord = wordListBuffer(randomNumber)
//
//      alphabetsStart = computerWord(computerWord.length()-1)
//
//      inputtedWord(turn) = "computer " + computerWord // turn -> "computer hello"
//      println("COMPUTER")
//      println("COMPUTER word: " + computerWord)
//
//      wordListBuffer -= computerWord // listBuffer minus 1
//      println("Next turn: User")
//      print("Input: ")
//      turn += 1
//    }
//
//    val scanner = new java.util.Scanner(System.in)
//    var line = ""
//    line = scanner.nextLine().toLowerCase() //pass all to lower case
//    alphabetsPresent = line(0)
//
//    // if wrong logic game
//    if(alphabetsPresent != alphabetsStart) {
//      println("You lose!")
//      endGame = true;
//    }
//
//    // check after first input
//    var check = line.exists(a => (a.toInt < 97 || a.toInt > 122));
//
//    while(!endGame) {
//
//      while((!wordListBuffer.contains(line) || check) && !endGame) {
//        println("Your word must in dictionary file and true format! Please enter again.")
//        println("length:" + wordListBuffer.length)
//        println(inputtedWord)
//        line = scanner.nextLine()
//
//        // user input word already used => end game
//        if(inputtedWord.exists(_._2 == ("user " + line)) || inputtedWord.exists(_._2 == ("computer " + line) )) {
//          println("You lose!")
//
//          val key = inputtedWord.find(_._2 == ("user " + line)).map(_._1);
//          val result = inputtedWord.filter(x => x._2 == ("user " + line) || x._2 == ("computer " + line) )
//          println("Your word has used by " + result(0).substring(0, result(0).indexOf(" ")) + " at turn " + key)
//          endGame = true
//        }
//
//        // wrong format => continue enter input
//        check = line.exists(a => (a.toInt < 97 || a.toInt > 122))
//
//      }
//
//      inputtedWord(turn) = "user " + line // turn -> "user hello"
//      alphabetsPresent = line(0)
//
//      // next turn to computer
//      turn += 1
//      println("User input: " + line)
//
//      // list minus 1 (line ~ valid input)
//      wordListBuffer -= line
//
//      println(wordListBuffer.length)
//      println(inputtedWord)
//      //win = true
//
//      line = "" // restart loop
//
//      if(!endGame) {
//
//        // Computer turn
//        if(!wordListBuffer.exists(a => (a(0).toString() == alphabetsPresent.toString() ))) {
//          //   println(Alphabets_present.toString())
//          println("You win!")
//          val countWord = inputtedWord.filter(x => x._2 == ("user " + line))
//          println(countWord.size + " word(s) have used in this game")
//          endGame = true
//        } else {
//          val satisfiedWord = wordListBuffer.filter(_(0).toString() == alphabetsPresent.toString())
//          val computerWord = satisfiedWord(0)
//          println("COMPUTER word: " + computerWord)
//          wordListBuffer -= computerWord
//          println(wordListBuffer.length)
//          println(inputtedWord)
//          println("Next turn: User")
//          print("Input: ")
//          turn += 1
//
//        }
//
//      }
//
//    }
//
//
//  } // end loop

  def main(args: Array[String]) {
    game()
  }
}
