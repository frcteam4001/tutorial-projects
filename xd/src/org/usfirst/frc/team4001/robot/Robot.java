package org.usfirst.frc.team4001.robot;
import edu.wpi.first.wpilibj.AnalogInput;
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
	AnalogInput boi = new AnalogInput(0);
    int top = 4000;
    int bottom = 1000;
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
	boi.getAverageVoltage();
	System.out.println(boi.getValue());
//Arm motor with limit switch
	//if(LimitSwitch1.get())
	// {			Potato.set(0);}
	 //else if (driverstick.getRawButton(2))
	 //{			 Potato.set(-0.8);   }
	 //else if(driverstick.getRawButton(1))
	 //{			 Potato.set(0.8);    }
	  //else { Potato.set(0);}
	//}
	if ((boi.getValue() < top)&&(driverstick.getRawButton(1))) {
		Potato.set(0.2);
	}else if ((Potato.get() > 0) && (boi.getValue() > top)){
		Potato.set(0.0);
	}else if ((boi.getValue() > bottom)&&(driverstick.getRawButton(4))) {
		Potato.set(-0.2);
	}else if ((Potato.get() < 0)&&(boi.getValue() < bottom)) {
		Potato.set(0.0); }
	}
	@Override
	public void testPeriodic() {
	LiveWindow.run();
	}
}


