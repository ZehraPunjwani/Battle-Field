//Arbalist class extends from the soldier class which illaminates the need for duplication of code.
//Inheritance allows one class to inherit the properties of another class
public class Arbalist extends Soldier{
	//The constructor has the same number of parameters as in the main soldier class
	public Arbalist(String name, double xPos, double yPos, double speed)
	{
		//Super() is used to call the parent class with arguments. In this case the arguments are
		//name, xPos, yPos, and speed.
		super(name, xPos, yPos, speed);
	}
	
	//getAttack method - obtains the name of the soldier using the getMethod created the soldier class,
	//then prints the text along with the soldier speed
	public String getAttack()
	{
		return "WINNER " + getName() + ": Targets Spearman using his arrorw at " + speed + "  units of space per unit of time.";
	}
}