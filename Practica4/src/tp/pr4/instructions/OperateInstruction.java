package tp.pr4.instructions;

import tp.pr4.NavigationModule;
import tp.pr4.RobotEngine;
import tp.pr4.instructions.exceptions.InstructionExecutionException;
import tp.pr4.instructions.exceptions.WrongInstructionFormatException;
import tp.pr4.items.Item;
import tp.pr4.items.ItemContainer;;
/**
 * @author Carmen Acosta Morales y Nerea Ramirez Lamela 
 * The Instruction for using an item.
 * This Instruction works if the user writes OPERATE id or OPERAR id
 *
 */
public class OperateInstruction implements Instruction{
	private ItemContainer container;
	private RobotEngine robot;
	private NavigationModule navega;
	private String id;
	
	/**
	 * Constructor without parameters 
	 */
	public OperateInstruction (){
		this.container = new ItemContainer ();
		this.id = " ";
		this.navega = new NavigationModule ();
		this.robot = new RobotEngine ();
	}
	
	/**
	 * Set the execution context. The method receives the entire engine (engine, navigation and the robot container)
	 *  even though the actual implementation of execute() may not require it.
	 * @param engine
	 * @param navigation
	 * @param robotContainer
	 */
	public void configureContext(RobotEngine engine,
			NavigationModule navigation, ItemContainer robotContainer) {
		// TODO Auto-generated method stub
		this.container = robotContainer;
		this.robot = engine;
		this.navega = navigation;
	}


	/**
	 * Executes the Instruction It must be implemented in every non abstract subclass.
	 * @throws InstructionExecutionException
	 */
	public void execute() 
			throws InstructionExecutionException {
		// TODO Auto-generated method stub
		Item it = null;
		//System.out.println("---Orden: operate " + id + "---");
		
		if ( this.container.containsItem(this.id) ){
			it = this.container.getItem(this.id);
				if(!it.use(robot, this.navega)){
					throw new InstructionExecutionException ();
				}
				//System.out.println("   * My power is " + robot.getPower());
				//System.out.println("   * My recycled material is: " + robot.getRecycledMaterial());
				if(it.getTimes() == 0){
				//	System.out.println("WALL·E says: What a pity! I have no more " + it.getId().toLowerCase() + " in my inventory" );
				}
				if (it.getTimes()== 0 ){
					this.container.removeItem(it);
				}			
		}
		else{
			throw new InstructionExecutionException ();
		}
		
	}
	/** Returns a description of the Instruction syntax. 
	 * The string does not end with the line separator.
	 *  It is up to the caller adding it before printing.
	 * @return a string with the correct instruction.
	 */
	public String getHelp() {
		// TODO Auto-generated method stub
		return "OPERATE|OPERAR <ID>";
	}
	/**
	* Parses the String returning an instance of OperateInstruction or throwing a WrongInstructionFormatException()
	* @param cad - text String to parse.
	* @returns Instruction Reference to an instance of OperateInstruction.
	*throws WrongInstructionFormatException
	*/
	public Instruction parse(String cad) 
			throws WrongInstructionFormatException {
		// TODO Auto-generated method stub

		String [] cadena = cad.split(" ");/*Divide la cadena en espacios
		y guarda cada fragmento en cada posiciï¿½n del array*/
		
		if ( cadena.length != 2){
			throw new  WrongInstructionFormatException();
		}
		else if ( !cadena[0].equalsIgnoreCase("OPERATE") && !cadena[0].equalsIgnoreCase("OPERAR")){
			throw new  WrongInstructionFormatException();
		}
		else
		{
			this.id = cadena[1];
			return this;
		}
	}

	/**
	 * Executes the Instruction It must be implemented in every non abstract subclass.
	 * @throws InstructionExecutionException
	 * Just for swing
	 */
	@Override
	public void executeVista() throws InstructionExecutionException {
		// TODO Auto-generated method stub
		Item it = null;
		
		if ( this.container.containsItem(this.id) ){
			it = this.container.getItem(this.id);
				if(!it.use(robot, this.navega)){
					throw new InstructionExecutionException ();
				}
				if (it.getTimes()== 0 ){
					this.container.removeItem(it);
				}			
		}
		else{
			throw new InstructionExecutionException ();
		}
	}

}