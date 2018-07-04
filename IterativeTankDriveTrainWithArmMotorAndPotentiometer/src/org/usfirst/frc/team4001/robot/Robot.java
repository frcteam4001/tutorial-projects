/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4001.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	/*
	private static final String kDefaultAuto = "Default";
	private static final String kCustomAuto = "My Auto";
	private String m_autoSelected;
	private SendableChooser<String> m_chooser = new SendableChooser<>();
	*/
	
	public Victor leftMotor;
	public Victor rightMotor;
	public Victor armMotor;
	public AnalogInput pot1;
	public Joystick joystick;
	double leftDrive;
	double rightDrive;
	int top = 4000;
	int bottom = 1000;
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		leftMotor = new Victor(0);
		rightMotor = new Victor(1);
		armMotor = new Victor(2);
		joystick = new Joystick(0);
		pot1 = new AnalogInput(0);
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
		leftDrive = joystick.getRawAxis(1);
		rightDrive = joystick.getRawAxis(5);
		leftMotor.set(leftDrive);
		rightMotor.set(rightDrive);
		System.out.println(pot1.getValue());
		if(pot1.getValue() < top && joystick.getRawButton(3)) {
			armMotor.set(0.8);
		}
		else if(armMotor.get() > 0 && pot1.getValue() > top) {
			armMotor.set(0);
		}
		else if(pot1.getValue() > bottom && joystick.getRawButton(1)) {
			armMotor.set(-0.8);
		}
		else if(pot1.getValue() < bottom && armMotor.get() < 0) {
			armMotor.set(0);
		}
		else {
			armMotor.set(0);
		}
		
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
		
	}
}
