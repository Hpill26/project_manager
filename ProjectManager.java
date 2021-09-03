import java.util.*;

/**
  Manages all other classes in this project, essentially reads in user input and decides
  what method to use. Fine tunes the output and prints. 
  
 @author HarishKarthik Kumaran Pillai 
 */
 
public class ProjectManager
{
   Scanner stdin = new Scanner(System.in);
   Team cs213 = new Team();
   String nameInput,dateInput;
   Date inputDate;
   TeamMember inputMember;
   
   /**
    * Finds out what operation the User want's to use and calls the appropriate method.
    * 
    */
   public void run()
   {
      System.out.println("Let's start a new team!");
      
     
      boolean done = false;
      while ( !done )
      {
    	
         String command = stdin.next();
         char switchArg = command.charAt(0);
//         nameInput = stdin.next();
//         dateInput = stdin.next();
//                  
//         inputDate = new Date(dateInput);
//         inputMember = new TeamMember(nameInput,inputDate);
         
                
         switch (switchArg)  
         {   
            case 'A': 
            	nameInput = stdin.next();
                dateInput = stdin.next();
                         
                inputDate = new Date(dateInput);
                inputMember = new TeamMember(nameInput,inputDate);
            	add();
		      break; 
            case 'R': 
            	nameInput = stdin.next();
                dateInput = stdin.next();
                         
                inputDate = new Date(dateInput);
                inputMember = new TeamMember(nameInput,inputDate);
            	remove();
            	break;
            case 'P' : 
            	print();
            	break;
            case 'Q' : 
            	print();
            	System.out.println("The team is ready to go!");
            	System.exit(0);
            	break;
            default:
            	System.out.println("Command '" + switchArg + "' not supported!" );
            	stdin.nextLine();
            	break;
            	//deal with bad command here 
         }  
      }
      
      //write java code before you terminate the program
   } //run()
   
   //Initializing the input as a team member 
   

   /**
    * Adds the team member input by the user to the team object after checking if 
    * person is already a member. If they are already a member of the team, add will
    * not perform this funciton. 
    */
   private void add()
   {
      	//must check if the date is valid
	//must call the contains() method to check if a given 
	//team member is in the team already
	   
	   boolean dateIsValid = inputDate.isValid();
	   boolean isInTeam;
	   if(dateIsValid)
	   {
		   isInTeam = cs213.contains(inputMember);
		   
		   if(isInTeam)
		   {
			   System.out.println(inputMember.toString() + " is already in the team.");
		   }
		   else
		   {
			   cs213.add(inputMember);
			   System.out.println(inputMember.toString() + " has joined the team.");
		   }
	   }
	   else
	   {
		   System.out.println(inputDate.toString() + " is not a valid date!");
	   }
   }
   
   /**
    * Removes user specified person from the team. Also makes sure that person is 
    * an existing member of the team before removal. 
    */
   private void remove()
   {
      //must check if the date is valid
	   
	   boolean dateIsValid = inputDate.isValid();
	   boolean removeWasSuccessful;
	   if(dateIsValid)
	   {
		   removeWasSuccessful = cs213.remove(inputMember);
		   if(removeWasSuccessful)
		   {
			   System.out.println(inputMember.toString()+ " has left the team.");
			   
		   }
		   else
		   {
			   System.out.println(inputMember.toString() + " is not a team member.");
		   }
	   }
   }
   
   /**
    * Prints all members in the Team object. Prints out "We have 0 team members!"
    * when Team list is empty. 
    */
   private void print()
   {
      //must check if the team has 0 members. 
	   boolean teamIsEmpty = cs213.isEmpty();
	   
	   if(teamIsEmpty)
	   {
		   System.out.println("We have 0 team members!");
	   }
	   else
	   {
		   System.out.println("We have the following team members: ");
		   cs213.print();
		   System.out.println("-- end of the list --");
	   }
   }  
   
   
   //testbed main
   
  /* public static void main (String []args)
   {
	   ProjectManager test = new ProjectManager();
	   test.run();
   }
   */
} //ProjectManager


