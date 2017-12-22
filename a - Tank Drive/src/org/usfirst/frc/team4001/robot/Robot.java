package org.usfirst.frc.team4001.robot;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import edu.wpi.first.wpilibj.networktables.*;


public class Robot extends IterativeRobot {
	Victor LeftDrive = new Victor (0);
	Victor RightDrive = new Victor (1);	
    Joystick driverstick = new Joystick(0);
    
	double LeftStickValue;
	double RightStickValue;
	
	NetworkTable ntTable;
	
	@Override
	public void robotInit() {
		
		//Initialize Network table connection
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
		
		LeftStickValue = driverstick.getRawAxis(1);
		RightStickValue = driverstick.getRawAxis(5);
		LeftDrive.set(-LeftStickValue);
		RightDrive.set(RightStickValue);	
		
		// The second parameter is a default value that must be supplied in case no value is given
		
		ntTable.getNumber("key2Int", -900000);
		
		System.out.println("nt key1: " + ntTable.getString("key1Str", "") );
		System.out.println("nt key2: " + ntTable.getNumber("key2Int", -900000));
		
	}
		
    @Override
	public void testPeriodic() {
    	LiveWindow.run();
	}
}