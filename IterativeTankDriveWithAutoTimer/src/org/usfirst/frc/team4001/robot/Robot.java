/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4001.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	private static final String kDefaultAuto = "Default";
	private static final String kCustomAuto = "My Auto";
	private String m_autoSelected;
	private SendableChooser<String> m_chooser = new SendableChooser<>();
	private Victor leftMotor;
	private Victor rightMotor;
	private Joystick joystick;
	private Timer timer;
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		timer = new Timer();
		leftMotor = new Victor(0);
		rightMotor = new Victor(1);
		joystick = new Joystick(0);
		m_chooser.addDefault("Default Auto", kDefaultAuto);
		m_chooser.addObject("My Auto", kCustomAuto);
		SmartDashboard.putData("Auto choices", m_chooser);
	}

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
					leftMotor.set(0.5);
					rightMotor.set(0.5);
				}
				else {
					leftMotor.set(0);
					rightMotor.set(0);
				}
				break;
			case kDefaultAuto:
			default:
				if(timer.get() < 15) {
					leftMotor.set(0.5);
					rightMotor.set(0.5);
				}
				else {
					leftMotor.set(0);
					rightMotor.set(0);
				}
				break;
		}
		
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		double leftDrive = joystick.getRawAxis(1);
		double rightDrive = joystick.getRawAxis(5);
		leftMotor.set(leftDrive);
		rightMotor.set(rightDrive);
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
