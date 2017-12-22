package org.usfirst.frc.team4001.robot;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
public class Robot extends IterativeRobot {
	Victor LeftDrive = new Victor (0);
	Victor RightDrive = new Victor (1);
	Victor Armmotor = new Victor (2);
    Joystick driverstick = new Joystick(0);
	double LeftStickValue;
	double RightStickValue;
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
		 if(driverstick.getRawButton(4))
		 {			 Armmotor.set(0.8);    }
		 else if (driverstick.getRawButton(1))
		 {			 Armmotor.set(-0.8);   }
		  else { Armmotor.set(0);}		 	  
	}
    @Override
	public void testPeriodic() {
    LiveWindow.run();
	}
}

