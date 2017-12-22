package org.usfirst.frc.team4001.robot;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	Victor LeftDrive = new Victor (0);
	Victor RightDrive = new Victor (1);
    Joystick driverstick = new Joystick(0);
	double LeftStickValue;
	double RightStickValue;
	Encoder encoderleft = new Encoder(6, 7, false, Encoder.EncodingType.k4X);	
	Encoder encoderright = new Encoder(8, 9, false, Encoder.EncodingType.k4X);	
	@Override
	public void robotInit() {
		
	}
	@Override
	public void autonomousInit() {	
		encoderleft.reset();
		encoderright.reset();		
	}
	@Override
	public void autonomousPeriodic() {	
		System.out.println("LEFT: " + encoderleft.getRaw() + ", RIGHT: " + encoderright.getRaw());
			LeftDrive.set(-0.5);
			RightDrive.set(0.5);
		 if (encoderleft.getRaw() >1200) {
			LeftDrive.set(0);}
	     if (encoderright.getRaw()<-1200){
			RightDrive.set(0);	}			}

	public void teleopInit() {			
		encoderleft.reset();
		encoderright.reset();	
	}
	@Override
	public void teleopPeriodic() { 		
	    LeftStickValue = driverstick.getRawAxis(5);
	    RightStickValue = driverstick.getRawAxis(1);
        LeftDrive.set(-LeftStickValue);
		RightDrive.set(RightStickValue); 	
		System.out.println("LEFT: " + encoderleft.getRate() + ", RIGHT: " + encoderright.getRate());
		System.out.println("LEFT: " + encoderleft.getRaw() + ", RIGHT: " + encoderright.getRaw());	
	 }	
	@Override
	public void testPeriodic() {
    LiveWindow.run();
	}
}
