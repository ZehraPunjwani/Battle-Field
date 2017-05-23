//Zehra Punjwani - K1502450 - Computer Science Year 1
//There are three soldiers on a Battlefield each from opposing sides. The Battlefield is 0<=X<=100, 0<=Y<=100. Each soldier travels has its own speed. 
//The goal for each soldier is to wound one other soldier. The Winner is, calculated depending on the time it takes for a soldier to get from its position to 
//the opponents position. At the end the winner soldier takes the position of its opponent after wounding it and the opponent disappears from the board 
//or stays in the same position. The program runs three times and in each case the third soldier remains uneffected. 

//Imports random from util in the java library 
import java.util.Random;
public class Battlefield{
	
	public static void main(String[] args){
		//looping the entire program 3 times. Each time there are a set of different X and Y positions for each soldier,
		//and distance and time is calculated accordingly. . 
		for (int i=1; i<=3; i++){
			System.out.println("\n" + "-------Round " + i + "--------------");
			
			//Create an instance of a random
			Random rnd = new Random();
			
			//initialize the X and Y variable coordinates for each soldier  
			double arbPosX = (rnd.nextDouble())*100;
			double arbPosY = (rnd.nextDouble())*100;
			double spearPosX = (rnd.nextDouble())*100;
			double spearPosY = (rnd.nextDouble())*100;
			double clibPosX = (rnd.nextDouble())*100;
			double clibPosY = (rnd.nextDouble())*100;
			
			//Create Instances of each of the Soldier position coordinates in the range 0-100. 
			Arbalist arbalist = new Arbalist("Arbalist", arbPosX, arbPosY, 12.2);
			Spearman spearman = new Spearman("Spearman", spearPosX, spearPosY, 4.3);
			Clibanarii clibanarii = new Clibanarii("Clibanarii", clibPosX, clibPosY, 5);
			
			//Print the soldier along with its coordinates
			System.out.println("Arbalist: " + arbalist);
			System.out.println("Spearman: " + spearman);
			System.out.println("Clibanarii: " + clibanarii + "\n");
			
			//Calculating distance. √((X2 -X1)^2 + (Y2 - Y1)^2)
			double Dist_AToS = Math.sqrt(Math.pow(arbalist.distanceXPos(spearman), 2) + Math.pow(arbalist.distanceYPos(spearman), 2));
			double Dist_CToA = Math.sqrt(Math.pow(clibanarii.distanceXPos(arbalist), 2) + Math.pow(clibanarii.distanceYPos(arbalist), 2));
			double Dist_SToC = Math.sqrt(Math.pow(spearman.distanceXPos(clibanarii), 2) + Math.pow(spearman.distanceYPos(clibanarii), 2));
			
			//Calculating Time. Time = Distnace / Speed
			double time_AToS = Dist_AToS / arbalist.getSpeed();
			double time_CToA = Dist_CToA / clibanarii.getSpeed();
			double time_SToC = Dist_SToC / spearman.getSpeed();
			
			System.out.println("Time: Arbalist to Spearman: " + time_AToS + "\n" + "Time: Clibanarii to Arbalist: " + time_CToA + "\n" + "Time: Spearman to Clibanarii: " + time_SToC + "\n");
			
			//Calculating Winner. 	Starting by Initializing the variable and declaring it to be Null.	
			String Winner = null;
			//The winner is calculated depending on the time it takes for a soldier to get to another.
			if (time_AToS < time_CToA || time_AToS < time_SToC){
				//If the distance from the Arbalist to the Spearman is more than 10.5, thus outside its arrow range...
				if (Dist_AToS > 10.6){
					System.out.println("Spearman out of Range from Arbalist");
					if (time_SToC < time_CToA){Winner = spearman.getAttack();}
					else if (time_SToC > time_CToA){Winner = clibanarii.getAttack();}
				}	
				//if the distance from the Arbalist to the Spearman is less then or equal to 10.6, thus within it arrow range, then...
				else if(Dist_AToS <= 10.6){
					//if the time from Spreaman to clibanarii is greater than the time from Arbalist to Spearman than the winner is Arbalist
					if (time_SToC > time_AToS ){Winner = arbalist.getAttack();}
					//if the time from Arbalist to Spearman is greater than the time from Clibanarii to Arbalist than the winner is Clibanarii
					else if(time_AToS > time_CToA){Winner = clibanarii.getAttack();}
				}
			}
			System.out.println(Winner);
			
			//Once the winner is determins, we then assume that the battle takes place. After the battle,
			//we then update the position for the relevent soldiers on the battlefield depending on the winner.
			//if the winner is arbalist.....
			if (Winner != arbalist.getAttack()){
				//The Arbalist stays in the same positions as it wounds its opponent by stricking an arrow.
				System.out.println("New Arbalist: " + arbalist);
				//The Spearman disappears...
				System.out.println("New Spearman: (-1.0, -1.0)");
				//The 3rd Soldier remains uneffected...
				System.out.println("New Clibanarii: " + clibanarii + "\n");
			}
			else if(Winner != clibanarii.getAttack()){
				//The Clibanarii disappears...
				System.out.println("New Arbalist: (-1.0, -1.0)");
				//The 3rd Soldier remains uneffected...
				System.out.println("New Spearman: " + spearman);
				//The Clibanarii takes the position of its opponent (Arbalist) after wounding it...
				System.out.println("New Clibanarii: " + "(" + arbPosX + ", " + arbPosY + ")" + "\n");
			}
			else if(Winner != spearman.getAttack()){
				//The 3rd Soldier remains uneffected...
				System.out.println("New Arbalist: " + arbalist);
				//The spearman takes the position of its opponent (Clibanarii) after wounding it...
				System.out.println("New Spearman: " + "(" + clibPosX + ", " + clibPosY + ")");
				//The clianarii though having been attacked still remains it is position.
				System.out.println("New Clibanarii: " + clibanarii + "\n");
			}
		}
	}
}