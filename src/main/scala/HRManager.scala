class HRManager(var inputEmpId:Int, var inputDepartment:String) extends Employee with Technology  {
  override var empId = this.inputEmpId
  override var department: String = this.inputDepartment
  override def getEmployeeDetails() :String = {
    empId + " "+department
  }
  def getSalary(percentageIncrement : Int, currentSalary: Double) = {
    if (percentageIncrement == 0 ) throw WrongInputException("Wrong input please pass percentage" +
      " greater than 0")
    if (percentageIncrement > 100 ) throw UpperBoundException("Percentage can not be more than 100")
    var newSalary = currentSalary + currentSalary*percentageIncrement/100
    newSalary
  }
  val multiplyByThree : PartialFunction[Double, Double] = {
    case x if (x %3) ==0 => x*3
  }

}
