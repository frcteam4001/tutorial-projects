package org.usfirst.frc.team4001.robot;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
public class Robot extends IterativeRobot {
	Victor LeftDrive = new Victor (0);
	Victor RightDrive = new Victor (1);	
    Joystick driverstick = new Joystick(0);
	double LeftStickValue;
	double RightStickValue;
	Timer timer;
	@Override
	public void robotInit() {
		timer = new Timer();
	}
	@Override
	public void autonomousInit() {
		timer.reset();
		timer.start();
	}
	@Override
	public void autonomousPeriodic() {
		if(timer.get()<1) {
			LeftDrive.set(-0.5);
			RightDrive.set(0.5);
			
		}else if (1 < timer.get() && timer.get() < 2.0) {
		    LeftDrive.set(-0.5);
		}else if (2 < timer.get() && timer.get() < 3.0) {
		    RightDrive.set(0.5);
		}else if (3 < timer.get() && timer.get() <4.0) {
		    LeftDrive.set(-0.5);
		}else if (4 < timer.get() && timer.get() < 5.0) {
		    RightDrive.set(0.5);
		}else if (5 < timer.get() && timer.get() < 6) {
		    LeftDrive.set(-0.5);
		}else if (6 < timer.get() && timer.get() < 7) {
		    RightDrive.set(0.5);    
		}else{			
			LeftDrive.set(0.0);
			RightDrive.set(0.0);}
	}	
		@Override
	public void teleopPeriodic() {
//Drive train tank	
        LeftStickValue = driverstick.getRawAxis(1);
	    RightStickValue = driverstick.getRawAxis(5);
        LeftDrive.set(-LeftStickValue);
		RightDrive.set(RightStickValue);	  
	}
    @Override
	public void testPeriodic() {
    LiveWindow.run();
	}
}
  