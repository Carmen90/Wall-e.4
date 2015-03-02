package tp.pr4.testprofesor;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import tp.pr4.cityLoader.testprofesor.CityLoaderTest;
import tp.pr4.instructions.testprofesor.*;
import tp.pr4.items.testprofesor.*;


@RunWith(Suite.class) 

@Suite.SuiteClasses( { 
						ItemTest.class,
						ItemContainerTest.class,
						PlaceTest.class,
						StreetTest.class,
						CityTest.class,		
						NavigationModuleTest.class,
						RobotEngineTest.class,
						CodeCardTest.class,
						FuelTest.class,
						GarbageTest.class,
						DropInstructionTest.class,
						HelpInstructionTest.class,
						MoveInstructionTest.class,
						OperateInstructionTest.class,
						PickInstructionTest.class,
						QuitInstructionTest.class,
						RadarInstructionTest.class,
						ScanInstructionTest.class,
						TurnInstructionTest.class,
						CityLoaderTest.class
					} ) 


public class AllTests {
    // Add new classes to the SuiteClasses array
}
