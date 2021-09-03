
/**
 *  Builds the Date object and specifies the format in which a date should be entered. 
 @author Brian Moran 
 */
public class Date 
{
   private int  day;
   private int  month;
   private int  year;
   
   /**
    * Parses the string input into a date object. 
    * @param d - String that will be parsed into a date. 
    */
   public Date(String d)
   {
      //use StringTokenizer to parse the String and create a Date object    
	  
	  String[] specs = d.split("/", 0);
	  month = Integer.parseInt(specs[0]);
	  day = Integer.parseInt(specs[1]);
	  year = Integer.parseInt(specs[2]);
   }
   /**
    * Constructs the date object from the results of the parsed string. Sets the day, 
    * month, and year appropriately. 
    * @param d - Date that was parsed from the string. 
    */
   public Date(Date d)
   {
	   //this is a constructor
      day = d.day;
      month = d.month;
      year = d.year;
   }      
   /**
    * Check to see if the date entered is actual date. Also accounts for leap years. 
    * @return true if date is valid, false otherwise
    */
   public boolean isValid()
   {
	   //Month is Not 1-12
       if(!(Month.JAN <= month  && month <= Month.DEC)) 
       {
    	   return false;
       }
       
       
       if(month == Month.APR || month == Month.JUN || month == Month.SEP || month == Month.NOV) // 30 day months
       {
    	   if(!(0 < day && day <= Month.DAYS_EVEN))
    	   {
    		   return false;
    	   }
       }
       else if(month == Month.FEB) 
       {
    	   if(day == (Month.DAYS_FEB + 1)) //check if its a leap year
    	   {
    		   /*
    		    * Given Formula for leap Year
    		    */
    		   if((year % Month.QUADRENNIAL) == 0) {
    			   if((year % Month.CENTENNIAL) == 0){
    				   {
    					   if((year % Month.QUATERCENTENNIAL) == 0)
    					   {
    						   //Do nothing
    					   } else {
    						   return false;
    					   }
    				   }
    			   } else {
    				   //Do nothing
    			   }
    		   } else {
    			   return false;
    		   }
    		   //END of given Formula
    		   
    	   }
    	   else if(!(0 < day && day <= Month.DAYS_FEB)) 
    	   {
    		   return false;
    	   }
       } else { //the month is 31 days long
    	   if(!(0 < day && day <= Month.DAYS_ODD))
    	   {
    		   return false;
    	   }
       }
       
       return true;
   }
   
   @Override
   public String toString()
   {
       //use the format "month/day/year"
	   return Integer.toString(month) +"/"+ Integer.toString(day) +"/"+ Integer.toString(year);
   }
   
   
   @Override
   public boolean equals(Object obj)
   {
	   	if((Date)obj == this)
	   	{
	   		return true;
	   	}
	   	if(!(obj instanceof Date))
	   	{
	   		return false;
	   	}
	   	Date temp = (Date) obj;
	   	
	   	if(temp.day == this.day && temp.month == this.month && temp.year == this.year) {
	   		return true;
	   	} else {
	   		return false;
	   	}
   }  
   
   //For error Testing Only
   //Tested everything besides equals
   
  	public void TestbedDate()
   {
	   String a = "02/29/2024";
	   String c = "1/30/1988";
	   String e = "1/30/1988";
	   
	   Date test1 = new Date(a);
	   Date test3 = new Date(c);
	   Date test5 = new Date(e);
	   
	   System.out.println("result:" + a);
	   
	   if(test1.isValid()) {
		   System.out.println("VALID");
		   System.out.println(test1.toString());
	   } else {
		   System.out.println("NOTVALID");
	   }
	   
	   if(test3.equals(test5)) {
		   System.out.println("WORKS!");
	   }
	   
   }
   
}


