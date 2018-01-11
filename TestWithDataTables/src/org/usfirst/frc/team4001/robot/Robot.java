package org.usfirst.frc.team4001.robot;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
public class Robot extends IterativeRobot {
	Victor LeftDrive = new Victor (0);
	Victor RightDrive = new Victor (1);
	Victor Potato = new Victor (2);
    Joystick driverstick = new Joystick(0);
 	double LeftStickValue;
	double RightStickValue;
	DigitalInput LimitSwitch1 = new DigitalInput(3);
	DigitalInput LimitSwitch2 = new DigitalInput(4);
	NetworkTable ntTable;
	DigitalInput left = new DigitalInput(5);
	DigitalInput right = new DigitalInput(6);
	
	
	@Override
	public void robotInit() {
		NetworkTable.setServerMode();
		NetworkTable.setTeam(4001);
		NetworkTable.initialize();
		
		ntTable = NetworkTable.getTable("DataTable");  //the table that data is posted to
	}
	
	@Override
	public void autonomousInit() {
	}	
	
	@Override
	public void autonomousPeriodic() {
	}
	
	@Override
	public void teleopPeriodic() {
		//Drive train tank	
		LeftStickValue = driverstick.getRawAxis(1);
	    RightStickValue = driverstick.getRawAxis(5);
        LeftDrive.set(-LeftStickValue);
        RightDrive.set(RightStickValue);
        System.out.println("left limitsw: " + LimitSwitch1.get() + ", right Limitsw: " + LimitSwitch2.get());	
        System.out.println("Left:" + left.get() + " Right: " + right.get());
        
        if(LimitSwitch1.get())
   	 	{	 
   		 	Potato.set(0);
   	 	}
        else if(LimitSwitch2.get())
	 	{			 
		 	Potato.set(0);    
		}  
        else if(left.get())
   	 	{			 
      		 Potato.set(-0.15);    
      	 }
        else if (right.get())
   	 	{			 
   		 	Potato.set(0.15);   
   	 	} 	 
        else { 
        	Potato.set(0);
        }
   	 
   	//ntTable.getNumber("key2Int", -900000);
	
	//System.out.println("nt key1: " + ntTable.getString("key1Str", "") );
	//System.out.println("nt key2: " + ntTable.getNumber("key2Int", -900000));
}

	@Override
	public void testPeriodic() 
	{
		LiveWindow.run();
	}
}


