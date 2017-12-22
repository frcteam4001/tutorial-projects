package org.usfirst.frc.team4001.robot;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
public class Robot extends IterativeRobot {
	Victor LeftDrive = new Victor (0);
	Victor RightDrive = new Victor (1);	
	Solenoid Solenoidin;
	Solenoid Solenoidout;
    Joystick driverstick = new Joystick(0);
	double LeftStickValue;
	double RightStickValue;
	
	@Override
	public void robotInit() {
		Solenoidin = new Solenoid(0,0);
		Solenoidout = new Solenoid(0,1);
	
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
	 if (driverstick.getRawButton(4))
	 {Solenoidin.set(true);
	  Solenoidout.set(false); }		  
     if (driverstick.getRawButton(1)) 
     {Solenoidout.set(true);
      Solenoidin.set(false);
    }
	}
    @Override
	public void testPeriodic() {
      LiveWindow.run();
	}
}