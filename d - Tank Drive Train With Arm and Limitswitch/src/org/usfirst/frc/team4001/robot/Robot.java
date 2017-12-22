package org.usfirst.frc.team4001.robot;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class Robot extends IterativeRobot {
	Victor LeftDrive = new Victor (0);
	Victor RightDrive = new Victor (1);
	Victor Armmotor = new Victor (2);
    Joystick driverstick = new Joystick(0);
	double LeftStickValue;
	double RightStickValue;
	DigitalInput LimitSwitch1 = new DigitalInput(2);
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
	    LeftStickValue = driverstick.getRawAxis(0);
	    RightStickValue = driverstick.getRawAxis(1);
        LeftDrive.set(-LeftStickValue);
		RightDrive.set(RightStickValue);
		System.out.println(LimitSwitch1.get());
// Arm motor with limit switch
		 System.out.println("Start limitsw: " + LimitSwitch1.get());
		 if(LimitSwitch1.get())
		 {	 Armmotor.set(0.8);            }
		 else if (driverstick.getRawButton(1))
		 {			 Armmotor.set(0.8);    }
		 else if (driverstick.getRawButton(2))
		 {			 Armmotor.set(-0.8);   }
		  else { Armmotor.set(0);}		 	  
	}
    @Override
	public void testPeriodic() {
    LiveWindow.run();
	}
}

