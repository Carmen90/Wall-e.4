package tp.pr4.items;

import tp.pr4.NavigationModule;
import tp.pr4.RobotEngine;

/**
 * @author Carmen Acosta Morales y Nerea Ramirez Lamela 
 * An item that represents fuel. 
 * This item can be used at least once and it provides power energy to the robot.
 *  When the item is used the configured number of times, then it must be removed from the robot inventory
 *
 */
public class Fuel extends Item {
	private int power;
	private int times;
	
	
	/**
	 * Fuel constructor
	 * @param id identification of the fuel
	 * @param description of the fuel
	 * @param power that gives this fuel
	 * @param times you can use this fuel
	 */
	public Fuel(String id, String description, int power, int times){
		super ( id, description);
		this.power = power;
		this.times = times;
	}
	/**
	 * Fuel can be used as many times as it was configured
	 * return: true it the item still can be used
	 */
	public boolean canBeUsed (){
		return this.times > 0;
	}

	/**
	 * Try to use the item with a robot in a given place. It returns whether the action was completed. 
	 * Subclasses must override this method
	 * return:true if the action was completed. Otherwise, it returns false
	 */
	public boolean use(RobotEngine r, NavigationModule nav) {
		boolean seUsa=false;
		if ( this.canBeUsed()){
			seUsa=true;
			r.addFuel(this.power) ;
			this.times--;
		}
		return seUsa;	
	}
	
	/**
	 * Generates a String with the Fuel idenfication and description
	 */
	public java.lang.String toString(){
		return this.id + ": "+ this.description + " // " + "power = "+
				this.power + ", times = " + this.times; 
	}

	/**
	 * Return the times you can use that fuel
	 */
	public int getTimes() {
		return times;
	}

	/**
	 * Modify the times you can use a fuel
	 * 
	 */
	public void setTimes(int times) {
		this.times = times;
	}

}
