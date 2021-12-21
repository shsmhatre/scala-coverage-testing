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

class StateCensusAnalyserTest extends AnyFlatSpec {

  var stateCensusAnalyser = new StateCensusAnalyser

  "verify number of records in csv file" should "match number of records with csv file" in {
      assert(stateCensusAnalyser.getNumberRecords() === 29)
   }
}


