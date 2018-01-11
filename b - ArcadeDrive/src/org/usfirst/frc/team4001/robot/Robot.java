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
	double leftStickValue;
	double rightStickValue;
		@Override
	public void robotInit() {
		LeftDrive = new Victor (0);
		RightDrive = new Victor (1);
		myRobot = new RobotDrive(LeftDrive, RightDrive);
		LeftDrive.setInverted(true);
		RightDrive.setInverted(true);
		stick = new Joystick(0);
		}
	@Override
	public void autonomousInit() {
	}
	@Override
	public void autonomousPeriodic() {		
	}	
	@Override
	public void teleopPeriodic() {
		leftStickValue = stick.getRawAxis(1);
		rightStickValue = stick.getRawAxis(4);
		myRobot.arcadeDrive(leftStickValue, rightStickValue);
	}
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}

