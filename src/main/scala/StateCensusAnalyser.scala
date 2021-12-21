import scala.io.Source
class StateCensusAnalyser {
  def getNumberRecords() = {
      var source = Source.fromFile("/home/hp/Downloads/StateCensusData.csv")
      var csvStates : List[CsvStates] = List()
      var header = source.getLines().take(1).next
      for(line <- source.getLines) {
          var columns = line.split(",").map(_.trim).toList
          println(columns)
          var name:String = ""
          var population:Int = 0
          var areaInSqKm :Int = 0
          var densityPerKm :Int = 0
          if (columns(0) != null ) {
            name = columns(0)
          }
          if (columns(1) != null) {
            population = columns(1).toInt
          }
          try {

            if (columns(2) != null) {
              areaInSqKm = columns(2).toInt
            }
          } catch {
            case e:Exception => {

            }
          }
        try {
          if (columns(3) != null) {
            densityPerKm = columns(3).toInt
          }
        } catch {
          case e:Exception => {

          }
        }
          csvStates = csvStates:+ new CsvStates(name, population, areaInSqKm, densityPerKm)
      }
      csvStates.size
  }

}
