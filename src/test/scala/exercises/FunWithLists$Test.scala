package exercises

import org.scalatest.{Matchers, FunSuite}

class FunWithLists$Test extends FunSuite with Matchers{

  val games = List(Game("Activision", 30), Game("Zenga", 60), Game("Zenga", 10), Game("EA",60), Game("EA",110))

  test("should return list of labels"){
    val expected = List("Activision", "Zenga", "Zenga", "EA", "EA")
    FunWithLists labels games should equal (expected)
  }

  /* 1 BONUS POINT : complete this using recursion */
  test("should return the total ratings of all games"){
    FunWithLists totalRatingsOf games should equal (270)
  }

  /* 1 BONUS POINT : complete this using only higher order functions */
  test("should return the average rating of games belonging to Zenga"){
    FunWithLists averageRatingsOf ("Zenga", games) should equal (35)
  }


  test("should return the total ratings of EA games"){
    FunWithLists totalRatingsOfLabel ("EA", games) should equal (170)
  }

  test("should increase all games rating by 10"){
    val expected = List(Game("Activision", 40), Game("Zenga", 70), Game("Zenga", 20), Game("EA",70), Game("EA",120))
    FunWithLists increaseRatingBy (10, games) should equal (expected)
  }

  test("should decrease all Zenga games rating by 10"){
    val expected = List(Game("Activision", 30), Game("Zenga", 50), Game("Zenga", 0), Game("EA",60), Game("EA",110))
    FunWithLists decreaseRatingBy (10, "Zenga", games) should equal (expected)
  }

  test("should create function to find Activision games"){
    val findByActivision = FunWithLists createFunctionToFindGamesByLabel("Activision")
    findByActivision (games) should equal (List(Game("Activision", 30)))
  }



  /* 2 BONUS POINTS : uncomment test and make it pass
  test("find first game with rating of 60 using curried function"){
    val firstGameWithRating60in = firstGameWithRating(60)
    firstGameWithRating60in (games) should be (Game("Zenga", 60))
    val otherGames =(List(Game("Zenga", 30), Game("Activision",20), Game("EA",60)))
    firstGameWithRating60in (otherGames) should be (Game("EA", 60))
  }
  */

}


