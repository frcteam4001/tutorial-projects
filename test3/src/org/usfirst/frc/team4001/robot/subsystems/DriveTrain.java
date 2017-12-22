package org.usfirst.frc.team4001.robot.subsystems;

import org.usfirst.frc.team4001.robot.ElectricalConstants;
import org.usfirst.frc.team4001.robot.commands.ArcadeDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class DriveTrain extends Subsystem {

    private final RobotDrive drive;
    
    private final Victor frontLeftMotor;
    private final Victor frontRightMotor;
	
    
    public DriveTrain()
    {
    	frontLeftMotor = new Victor(0);
    	frontRightMotor = new Victor(0);
    	
    	drive = new RobotDrive(frontLeftMotor, frontRightMotor);
    	
    	LiveWindow.addActuator("DriveTrain", "frontLeftMotor", frontLeftMotor);
    	LiveWindow.addActuator("DriveTrain", "frontRightMotor", frontRightMotor);
    	
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new ArcadeDrive());
    }
    
    public void arcadeDrive(double forward, double turn)
    {
    	drive.arcadeDrive(forward, -turn, false);
    }
    
    public void hardStop()
    {
    	drive.arcadeDrive(0, 0);
    }
}

