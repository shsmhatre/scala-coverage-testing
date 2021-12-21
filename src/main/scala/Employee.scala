trait Employee extends Person{
  var empId:Int
  var department:String
  override def getPersondetails(name:String, city:String) :String = {
    name+" "+city
  }
  override def getPersondetails(name:String, city:String, mobile:String) :String = {
    name+" "+city+" "+mobile
  }
  def getEmployeeDetails():String
}

