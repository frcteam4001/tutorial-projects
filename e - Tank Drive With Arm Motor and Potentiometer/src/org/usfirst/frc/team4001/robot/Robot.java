package org.usfirst.frc.team4001.robot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
public class Robot extends IterativeRobot {
	Victor LeftDrive = new Victor (0);
	Victor RightDrive = new Victor (1);
	Victor Armmotor = new Victor (2);
    Joystick driverstick = new Joystick(0);
	double LeftStickValue;
	double RightStickValue;
	AnalogInput pot1 = new AnalogInput(0);
//Armmotor potentiometer set points
	int top = 3033;
	int bottom = 1000;
	@Override
	public void robotInit() {
	}
	@Override
	public void autonomousInit() {	
	}
	@Override
	public void autonomousPeriodic() {	
	}		
	public void teleopPeriodic() {
//Drive train tank	     
	    LeftStickValue = driverstick.getRawAxis(0);
	    RightStickValue = driverstick.getRawAxis(1);
        LeftDrive.set(-LeftStickValue);
		RightDrive.set(RightStickValue);
        pot1.getAverageVoltage();
        System.out.println(pot1.getValue());
// Armmotor up button 4 down button 1 with Potentiometer MAINTAINED BUTTONS
		if  ((pot1.getValue() < top)&&(driverstick.getRawButton(4))){
			Armmotor.set(0.9);    
		}else if  (( Armmotor.get() > 0) && (pot1.getValue() >  top)){
			Armmotor.set(0.0);  	
	    }else if ((pot1.getValue() >  bottom)&&(driverstick.getRawButton(2))){
			 Armmotor.set(-0.2);   
		}else if (( Armmotor.get() < 0) && (pot1.getValue() <  bottom)){
			Armmotor.set(0.0); }
}	
	@Override
		public void testPeriodic() {
		LiveWindow.run();
	}
}
