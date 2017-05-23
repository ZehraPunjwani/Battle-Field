public class Soldier {
	//A Seperate String fields to hold the name of the soldier, its speed which is a double date type,
	//The XPosition  and YPosition of the soldiers also the double date type
	// Fields must be private.
	private String name;
	protected double speed;
	private double xPos;
	private double yPos;
	
	//Consructor, parameters are essential. 
	//parameters include the soldier name, the XPosition, YPosition and Speed. 
	//Each have their own data types
	public Soldier(String name, double xPos, double yPos, double speed) {
		this.name = name;
		this.speed = speed;
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	//Allows the XPos to be accessed from outside the Soldier class
	public double getX(){
		return xPos;
	}
	
	//Allows the YPos to be accessed from outside the Soldier class
	public double getY(){
		return yPos;
	}
	//Refering to a class type within a class. Compares a Soldiers XPosition
	//the opponents XPosition
	public double distanceXPos(Soldier opponent){
		return this.xPos - opponent.xPos;
	}
	//Refering to a class type within a class. Compares a Soldiers YPosition
	//the opponents YPosition
	public double distanceYPos(Soldier opponent){
		return this.yPos - opponent.yPos;
	}
	//Print a soldier's name every time getName method is called.
	//enables us to access the Soldier name from outside the Soldier class
	public String getName() {
		return name;
	}
	//Print a soldier's speed every time getSpeed method is called.
	//enables us to access the Soldier speed from outside the Soldier class
	public double getSpeed(){
		return speed;
	}
	//Print a Soldier's XPosition and YPosition every time a Soldier object is printed
	public String toString(){
		return "("+xPos+", "+yPos+")";
	}
}