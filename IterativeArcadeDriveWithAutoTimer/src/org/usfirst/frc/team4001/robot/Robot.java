/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4001.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	private static final String kDefaultAuto = "Default";
	private static final String kCustomAuto = "My Auto";
	private static final String gameData = DriverStation.getInstance().getGameSpecificMessage();//message from FRC 
	private String m_autoSelected;
	private SendableChooser<String> m_chooser = new SendableChooser<>();
	private Victor leftMotor;
	private Victor rightMotor;
	private DifferentialDrive drive;
	private Joystick joystick;
	private Timer timer;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		leftMotor = new Victor(0);
		rightMotor = new Victor(1);
		drive = new DifferentialDrive(leftMotor, rightMotor);
		joystick = new Joystick(0);
		timer = new Timer();
		m_chooser.addDefault("Default Auto", kDefaultAuto);
		m_chooser.addObject("My Auto", kCustomAuto);
		SmartDashboard.putData("Auto choices", m_chooser);

	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional comparisons to
	 * the switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() {
		m_autoSelected = m_chooser.getSelected();
		timer.reset();
		timer.start();
		// autoSelected = SmartDashboard.getString("Auto Selector",
		// defaultAuto);
		System.out.println("Auto selected: " + m_autoSelected);
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		switch (m_autoSelected) {
		
			case kCustomAuto:
				if(timer.get() < 10) {
					//drives forward, no turning
					drive.arcadeDrive(0.5, 0);
				}
				else if(timer.get() > 10 && timer.get() < 11) {
					drive.arcadeDrive(0, 0.25);
				}
				else {
					drive.arcadeDrive(0, 0);
				}
				break;
			case kDefaultAuto:
			default:
				if(timer.get() < 10) {
					//drives forward, no turning
					drive.arcadeDrive(0.5, 0);
				}
				else if(timer.get() > 10 && timer.get() < 11) {
					drive.arcadeDrive(0, 0.25);
				}
				else {
					drive.arcadeDrive(0, 0);
				}
				break;
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		double move = joystick.getRawAxis(1);
		double turn = joystick.getRawAxis(4);
		drive.arcadeDrive(move, turn);
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
