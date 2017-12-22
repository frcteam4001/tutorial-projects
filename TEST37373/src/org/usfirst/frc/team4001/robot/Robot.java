package org.usfirst.frc.team4001.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	Victor leftDrive = new Victor (0);
	Victor rightDrive = new Victor (1);
	Victor armMotor = new Victor (2);
	Joystick driverStick = new Joystick (0);
	DigitalInput limitSwitch = new DigitalInput (0);
	AnalogInput potent = new AnalogInput (0);
	Timer coolerTimer = new Timer ();
	
	@Override
	public void robotInit() {

	}


	@Override
	public void autonomousInit() {
		coolerTimer.reset();
		coolerTimer.start();
	}


	@Override
	public void autonomousPeriodic() {
		if (coolerTimer.get() < 15) {
			leftDrive.set(0.8*-1);
			rightDrive.set(0.3);
		} else { 
			leftDrive.set(0);
			rightDrive.set(0);
		}	
	}

	@Override
	public void teleopPeriodic() {
	double leftStick = driverStick.getRawAxis(1);
	double rightStick = driverStick.getRawAxis(5);
	
	leftDrive.set(leftStick);
	rightDrive.set(rightStick);
	
	System.out.println("Limit Switch Value: " + limitSwitch.get());
	System.out.println("Analog Input Value: " + potent.getAverageValue());
	System.out.println("Arm Motor Value: " + armMotor.get());
	
	
	
	}

	@Override
	public void testPeriodic() {
	}
}

