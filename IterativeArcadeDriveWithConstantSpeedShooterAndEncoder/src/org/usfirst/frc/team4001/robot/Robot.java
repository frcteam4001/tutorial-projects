/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4001.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	private static final String kDefaultAuto = "Default";
	private static final String kCustomAuto = "My Auto";
	private String m_autoSelected;
	private SendableChooser<String> m_chooser = new SendableChooser<>();
	private Victor leftMotor;
	private Victor rightMotor;
	private Victor shooterMotor;
	private DifferentialDrive drive;
	private Encoder shooterEnc;
	private Joystick joystick;
	private double move;
	private double turn;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		leftMotor = new Victor(0);
		rightMotor = new Victor(1);
		shooterMotor = new Victor(2);
		drive = new DifferentialDrive(leftMotor, rightMotor);
		shooterEnc = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
		joystick = new Joystick(0);
		shooterEnc.reset();
		/*
		m_chooser.addDefault("Default Auto", kDefaultAuto);
		m_chooser.addObject("My Auto", kCustomAuto);
		SmartDashboard.putData("Auto choices", m_chooser);
		*/
	}

	@Override
	public void autonomousInit() {
		/*
		m_autoSelected = m_chooser.getSelected();
		// autoSelected = SmartDashboard.getString("Auto Selector",
		// defaultAuto);
		System.out.println("Auto selected: " + m_autoSelected);
		*/
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		/*
		switch (m_autoSelected) {
			case kCustomAuto:
				// Put custom auto code here
				break;
			case kDefaultAuto:
			default:
				// Put default auto code here
				break;
		}
		*/
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		move = joystick.getRawAxis(1);
		turn = joystick.getRawAxis(4);
		drive.arcadeDrive(move, turn); 
		if(joystick.getRawButton(3) && shooterEnc.getRate() > 6000) {
			shooterMotor.set(0.5);
		}
		else if(joystick.getRawButton(3) && shooterEnc.getRaw() < 6000) {
			shooterMotor.set(0.7);
		}
		else {
			shooterMotor.set(0);
		}
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
