/**
 
 @author Brian Moran
 */
public class TeamMember 
{
   private String name;
   private Date   startDate;
   
   /**
    * Create the TeamMember object using the name and the date. 
    * @param nm is the name of the Team Member
    * @param date is the date when the Team Member joined the company
    */
   public TeamMember(String nm, Date date)
   {
       name = nm;
       startDate = date;
   }
   /**
    * Gets the start date
    * @return startdate
    */
   public Date getStartDate()
   {
      return startDate;
   }
   
   public boolean equals(Object obj)
   {
	   if((TeamMember)obj == this) 
	   {
		   return true;
	   } 
	   if(!(obj instanceof TeamMember))
	   {
		   return false;
	   }
	   TeamMember temp = (TeamMember) obj;
	   
	   if(temp.name.equals(this.name) && temp.startDate.equals(this.startDate))
	   {
		   return true;
	   } else {
		   return false;
	   }
   }  
   
   public String toString()
   {
       return name + " " + startDate.toString();
   }

   
   public void TestbedTeamMember()
   {
      //testbed main; you must include test cases that exercise 
      //the constructor and all methods in this class.
	   Date testA = new Date("12/4/1998");
	   Date testB = new Date("03/09/2000");
	   Date testC = new Date("12/04/1998");
	   Date testD = new Date("2/29/2024");
	   
	   TeamMember a = new TeamMember("Bill" , testA);
	   TeamMember b = new TeamMember("adam" , testB);
	   TeamMember c = new TeamMember("Bill" , testC);
	   TeamMember d = new TeamMember("Suzie" , testD);
	   
	   //EQUALS DOES NOT WORK
	   if(a.equals(c))
	   {
		   System.out.println("WORKS!");
	   }
	   System.out.println(b.toString());
	   
	   Date test = d.getStartDate();
	   
	   System.out.println(test.toString());
   }

}
