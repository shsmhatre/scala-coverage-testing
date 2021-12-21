/**
 * ScalaTest is a testing toolkit : it consists of focused, lightweight traits that you can mix together
 * to solve the problem
 * Instead of duplicating code by mixing the same traits together repeatedly, it is recommended to
 * create abstract base classes for your project that mix together the features you use the most
 * Example below
 */
import org.scalatest._
import flatspec._
import matchers._
abstract class ScalaTestBaseClass extends AnyFlatSpec with should.Matchers with OptionValues with Inside
  with Inspectors{

}

//Then you can write unit tests for your project  using the custom base class
class MyFirstTest extends ScalaTestBaseClass {
  //Tests here

}

//In ScalaTest, you define tests inside classes that extend a style class such as AnyFlatSpec
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.tagobjects.Slow
import org.scalatest.Tag
class FirstSpec extends AnyFlatSpec {
  //tests go here
  /**
   * Each test in AnyFlatSpec is composed of a sentence that specifies a bit of required behavior and
   * a block of code that tests it. The sentence needs a subject, such as "Salary calculation",
   * a verb either "should", "must" or "can" and rest of the sentence
   * If you have multiple tests about the same subject, you can use "it" to refer to the previous subject
   * Press Ctrl + Shift + F10 to run current test case
   * To run all testcases in folder, select this folder in the project tool and pres Ctrl + Shift + F10
   */
  var hrManager = new HRManager(1, "Technology")
  "Salary calculation" should "return proper salary if passed percentage as integer > 0 " in {
    assert(hrManager.getSalary(30, 50000) === 65000)

  }

  it should "throw WrongInputException if passed percentage value as 0" in {
    assertThrows[WrongInputException] {
      hrManager.getSalary(0, 5000)
    }
  }
  it should "throw UpperBoundException if passed percentage value is more than 100" in {
    assertThrows[UpperBoundException] {
      hrManager.getSalary(101, 50000)
    }
  }
  //Tagging your tests
  //Tagging tests as ignored - temporarily disabling a test
  ignore should "throw LowerBoundException if passed percentage in negative" in {
    assertThrows[LowerBoundException] {
      hrManager.getSalary(-10, 50000)
    }
  }

  //filtering tests based on tags refer below docs
  //https://www.scalatest.org/user_guide/using_the_runner#filtering
  object ErrorTest extends Tag("scalabasics")
  "Upper Bound Exception" should "throw UpperBoundException if i passed perentage > 100" in {
    assertThrows[UpperBoundException] {
      hrManager.getSalary(101, 50000)
    }
  }
  /*
  "Lower Bound Percentage" should "Throw lower bound exception" taggedAs(Slow) in {
    assertThrows[LowerBoundException] {
      hrManager.getSalary(101, 50000)
    }
  }
  */

}

