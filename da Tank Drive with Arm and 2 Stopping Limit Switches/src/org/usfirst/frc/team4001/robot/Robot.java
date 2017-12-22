package org.usfirst.frc.team4001.robot;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
public class Robot extends IterativeRobot {
	Victor LeftDrive = new Victor (0);
	Victor RightDrive = new Victor (1);
	Victor Potato = new Victor (2);
            Joystick driverstick = new Joystick(0);
 	double LeftStickValue;
	double RightStickValue;
	DigitalInput LimitSwitch1 = new DigitalInput(2);
	DigitalInput LimitSwitch2 = new DigitalInput(3);
	@Override
	public void robotInit() {
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
        System.out.println("up limitsw: " + LimitSwitch1.get() + ", bottom Limitsw: " + LimitSwitch2.get());
           
   	 if(LimitSwitch1.get()&driverstick.getRawButton(1))
	 {	 Potato.set(0);}
	 else if (LimitSwitch2.get()&driverstick.getRawButton(2))
	 {			 Potato.set(0);    }
	 else if(driverstick.getRawButton(2))
		{			 Potato.set(-0.2);    }
	 else if(driverstick.getRawButton(1))
		{			 Potato.set(0.2);    }
		else { Potato.set(0);}   	  
}

	@Override
	public void testPeriodic() {
	LiveWindow.run();
	}
}

