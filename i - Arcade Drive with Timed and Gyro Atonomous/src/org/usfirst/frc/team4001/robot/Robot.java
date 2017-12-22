package org.usfirst.frc.team4001.robot;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
public class Robot extends IterativeRobot {
	RobotDrive myRobot;
	Victor LeftDrive;
	Victor RightDrive;
	Joystick stick;
	Timer timer;
	@Override
	public void robotInit() {
		 LeftDrive = new Victor (0);
		 RightDrive = new Victor (1);
			myRobot = new RobotDrive(LeftDrive, RightDrive);
		LeftDrive.setInverted(true);
		RightDrive.setInverted(true); 
		stick = new Joystick(0);
		timer = new Timer();}
	 double kAngleSetpoint = 0.0;
	 double kP = 0.005; // propotional turning constant	 
	// gyro calibration constant, may need to be adjusted;
	// gyro value of 360 is set to correspond to one full revolution
	 double kVoltsPerDegreePerSecond = 0.0128;
	 int kLeftMotorPort = 0;
	 int kRightMotorPort = 1;
	 int kGyroPort = 0;
	 int kJoystickPort = 0;	 
     AnalogGyro gyro = new AnalogGyro(0);	 
	@Override
	public void autonomousInit() {
		timer.reset();
		timer.start();
}
	@Override
	public void autonomousPeriodic() {		
		if(timer.get()<5) {
			LeftDrive.set(-0.5);
			RightDrive.set(0.5);
			double turningValue = (kAngleSetpoint - gyro.getAngle()) * kP;
			// Invert the direction of the turn if we are going backwards
			turningValue = Math.copySign(turningValue, stick.getY());
			myRobot.drive(stick.getY(), turningValue);			   
		}else{			
			myRobot.drive(0.0, 0.0);
		}		
	}
	
	@Override
	public void teleopPeriodic() {
		myRobot.arcadeDrive(stick);
	}
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}

