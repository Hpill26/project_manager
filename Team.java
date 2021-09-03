/**
  Creates the Team container. Has ability to add and remove members from the team as well as
  view all members in the team via the print function. 
 @author  Brian Moran 
 */
public class Team 
{
   private final int NOT_FOUND = -1;
   private final int GROW_SIZE = 4; //initial and grow size
   private TeamMember [] team;
   private int numMembers;
   
   /**
    * Constructs the team object, by creating a grow able array. 
    */
   public Team()
   {
      //this is the default constructor
	   this.team = new TeamMember[GROW_SIZE];
	   this.numMembers = 0;
   }
   
   /**
    * Finds the index of team member we want to find within the Team object.
    * @param m is the team member
    * @return index of team member inside array, -1 otherwise
    */
   private int find(TeamMember m)
   {
       for(int i = 0; i < numMembers; i++) {
    	   if(m.equals(team[i])) {
    		   return i;
    	   } 
       }
       return NOT_FOUND;
   }
   /**
    * Increases the size of the TeamMember array, allowing the team object to be 
    * a grow able container class. 
    */
   private void grow()
   {
       TeamMember[] temp = new TeamMember[team.length + GROW_SIZE];
       for (int i = 0; i < team.length; i++)
       {
    	      temp[i] = this.team[i];
       }
       this.team = temp;
   }
   /**
    * Checks to see if the Team is empty
    * @return true if Team is empty, false otherwise
    */
   public boolean isEmpty()
   {
       if(numMembers == 0) 
       {
    	   return true;
       } else {
    	   return false;
       }
   }
   
   /**
    * Adds the specified TeamMember to the Team
    * @param m TeamMember to be added
    */
   public void add(TeamMember m)
   {     
	   //check if array is full
	   if(numMembers == team.length) 
	   {
		   this.grow();
	   }		   
	   numMembers ++;
	   //adds to the end of list		   
	   int i = 0;
	   while(team[i] != null) {
		   i++;
	   }
	   team[i] = m;	   
   }
   
   /**
    * Removes the specified TeamMember from the team. 
    * @param m TeamMember to be removed
    * @return true if successfully removed, false otherwise
    */
   //Errors MAY exist
   //could be coming from .equals() in find()
   public boolean remove(TeamMember m)
   {
	   int i = find(m);    
       if(i > NOT_FOUND) 
       {
    	   numMembers --;
    	   if(team[i].equals(team[team.length-1])) { //to be removed is last item in array
    		   team[i] = null;
    		   return true;
    	   } else {
    		   int k;
			   for(k = 0; k < team.length-1; k++) //finds last item of array
			   {
				   if(team[k] == null) {
					   break;
				   }
			   }
    		   team[i] = team[k-1]; //sets removal to last item in array
	    	   team[k-1] = null;  
	    	   return true;
    	   }
       } else {
    	   return false;
       }
   } 
   /**
    * Checks to see if Team has a TeamMember
    * @param m TeamMember to be searched
    * @return true if found, false other wise
    */
   public boolean contains(TeamMember m)
   {
       if(find(m) > NOT_FOUND)
       {
    	   return true;
       } else {
    	   return false;
       }
   } 
   /**
    * Prints out all the TeamMember contained within team.
    */
   public void print()
   {
       //4eset up a for loop and call the toString() method
	   for(int i = 0; i < numMembers; i ++)
	   {
		   System.out.println(team[i].toString());
	   }
	   
   } 
   
   //Error testing
   /*
   public static void main(String [] args)
   {
	   Date testA = new Date("12/4/1998");
	   Date testB = new Date("03/09/2000");
	   Date testC = new Date("12/4/1988");
	   Date testD = new Date("2/29/2024");
	   Date testE = new Date("1/28/2020");
	   Date testF = new Date("03/09/2000");
	   Date testG = new Date("12/11/2020");
	   Date testH = new Date("01/07/2004");
	   Date testI = new Date("06/09/1997");
	   
	   TeamMember a = new TeamMember("Bill" , testA);
	   TeamMember b = new TeamMember("adam" , testB);
	   TeamMember c = new TeamMember("Bill" , testC);
	   TeamMember d = new TeamMember("Suzie" , testD);
	   TeamMember e = new TeamMember("Tom" , testE);
	   TeamMember f = new TeamMember("Dan" , testF);
	   TeamMember g = new TeamMember("Mike" , testG);
	   TeamMember h = new TeamMember("Amber" , testH);
	   TeamMember i = new TeamMember("Brooke" , testI);
	   
	   Team test = new Team();
	   test.add(a);
	   test.add(b);
	   test.add(c);
	   test.add(d);
	   test.add(e);
	   test.add(f);
	   test.add(g);
	   test.add(h);
	   test.add(i);
	 
	   //find works
	   int p = test.find(e);
	   System.out.println("4? - " + p);
	   
	   //Remove
	   
	   if(test.remove(h)) 
	   {
		   System.out.println("mike shldnt be there");
	   }
	   
	   //Contains Works
	   /*
	   if(test.contains(b))
	   {
		   System.out.println("Contain WORKS");
	   }
	   
	   //Print Works
	   test.print();
	   }
    */
}
