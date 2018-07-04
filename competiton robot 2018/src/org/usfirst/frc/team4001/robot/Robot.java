package org.usfirst.frc.team4001.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PWMSpeedController;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends IterativeRobot {
	RobotDrive myDrive;
	Joystick driveStick;
	Solenoid Solenoidin;
	Solenoid Solenoidout;
	Solenoid Solenoidup;
	Solenoid Solenoiddown; 

	@Override
	public void robotInit() {
		myDrive = new RobotDrive(0,1);
    	driveStick = new Joystick(0);
    	Victor frontelevatorMotor = new Victor (3);
    	DigitalInput FEBottomLS = new DigitalInput(4);
    	DigitalInput FETopLS = new DigitalInput(5);
    	Victor backelevatorMotor = new Victor (4);
    	DigitalInput BEBottomLS = new DigitalInput(6);
    	DigitalInput BETopLS = new DigitalInput(7);
    	Victor intakeMotor = new Victor (3);
    	DigitalInput intakeLS = new DigitalInput(4);
    	Solenoidin = new Solenoid(0,0);
		Solenoidout = new Solenoid(0,1);
		Solenoidup = new Solenoid(0,2);
		Solenoiddown = new Solenoid(0,3);
	}

	
	@Override
	public void autonomousInit() {
		
	}


	@Override
	public void autonomousPeriodic() {
		
	}

	
	@Override
	public void teleopPeriodic() {
		
		
		//  DRIVETRAIN
		
		Object driverStick;
		while (isOperatorControl() && isEnabled()) {
    	myDrive.arcadeDrive(driveStick);
    	Timer.delay(0.01);
        Object driverstick;
       
       
			//FRONT ELEVATOR   driver stick up and down buttons/ top and bottom limit switches
       
    PWMSpeedController frontelevatorMotor; 
    if(LimitSwitch1.get( )& driverStick.getRawButton(1))  	 
	frontelevatorMotor.set(0);}
  	else if (LimitSwitch2.get()&driverStick.getRawButton(2))
  	{ PWMSpeedController frontelevatorMotor;
	frontelevatorMotor.set(0);    }
  	else if(driverStick.getRawButton(2))
  	{frontelevatorMotor.set(-0.2);    }
  	else if(driverStick.getRawButton(1))
  	{frontelevatorMotor.set(0.2);    }
  	 else {frontelevatorMotor.set(0);}   	  
    		 
    		 
    		 // BACK ELEVATOR     driver stick up and down buttons/ top and bottom limit switches
    		 
     PWMSpeedController backelevatorMotor;
	 if(LimitSwitch1.get()&((Object) driverStick).getRawButton(1))
  	 {	 backelevatorMotor.set(0);}
  	 else if (LimitSwitch2.get()&driverStick.getRawButton(2))
  	 {	 backelevatorMotor.set(0);    }
  	 else if(((Object) driverStick).getRawButton(2))
  		{backelevatorMotor.set(-0.2);    }
  	 else if(driverStick.getRawButton(1))
  		{backelevatorMotor.set(0.2);    }
  	 else { backelevatorMotor.set(0);}   	  
				
				
				// INTAKE MOTOR WITH driver stick in and out buttons/part in limit switches 
				
     if(LimitSwitch1.get()&driverstick.getRawButton(1))
  	 {	 intakeMotor.set(0);}
  	 else if (LimitSwitch2.get()&driverstick.getRawButton(2))
  	 {intakeMotor.set(0);    }
  	 else if(driverstick.getRawButton(2))
  		{intakeMotor.set(-0.2);    }
  	 else if(driverstick.getRawButton(1))
  		{ intakeMotor.set(0.2);    }
  	 else { intakeMotor.set(0);}   	  
       
        //intake open and close solenoid valve
       
  	 if (driverstick.getRawButton(4))
  	 {Solenoidin.set(true);
  	  Solenoidout.set(false); }		  
      if (driverstick.getRawButton(1)) 
      {Solenoidout.set(true);
      Solenoidin.set(false);
      
      
         // Raise intake up and down solenoid valve with driver stick buttons up and down
      
 	 if (driverStick.getRawButton(6))
 	 {Solenoidin.set(true);
 	 Solenoidout.set(false); }	
 	 
 	 
    	  // intake solenoid valve with driver stick button to open
 	 
     if (driverStick.getRawButton(1)) 
     {Solenoidout.set(true);
     Solenoidin.set(false);
        
        
        
	}}
	}
	

	@Override
	public void testPeriodic() {
	}
}
