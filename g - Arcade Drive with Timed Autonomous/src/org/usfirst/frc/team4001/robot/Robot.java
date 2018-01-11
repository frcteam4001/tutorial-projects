package org.usfirst.frc.team4001.robot;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
		double leftStickValue;
		double rightStickValue;
	
	@Override
	public void autonomousInit() {
		timer.reset();
		timer.start();
}
	@Override
	public void autonomousPeriodic() {
		
		if(timer.get()<1) {
			LeftDrive.set(-0.4);
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
			myRobot.drive(0.0, 0.0);
		}
		
	}
	
	@Override
	public void teleopPeriodic() {
		myRobot.arcadeDrive();
	}
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}

