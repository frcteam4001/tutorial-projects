package org.usfirst.frc.team4001.robot;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
public class Robot extends IterativeRobot {
	Victor LeftDrive = new Victor (0);
	Victor RightDrive = new Victor (1);
	Victor Shooter = new Victor (2);
    Joystick driverstick = new Joystick(0);
    Encoder shooterencoder = new Encoder(1,2, false, Encoder.EncodingType.k4X);
	double LeftStickValue;
	double RightStickValue;
	int shootersetpoint = 40000;// the rpm rate of the shooter encoder
	@Override
	public void robotInit() {
	}
	@Override
	public void autonomousInit() {	
	}
	@Override
	public void autonomousPeriodic() {
		}	
	@Override
	public void teleopPeriodic() {
//Drive train tank	     
		LeftStickValue = driverstick.getRawAxis(1);
		RightStickValue = driverstick.getRawAxis(5);
		LeftDrive.set(-LeftStickValue);
		RightDrive.set(RightStickValue);
		System.out.println("shooter rpm " + shooterencoder.getRate() + "set" +shootersetpoint);
	 if((driverstick.getRawButton(4))  &&  shooterencoder.getRate() > shootersetpoint ) {
		 Shooter.set(-0.5); 
	 }else if((driverstick.getRawButton(4))  &&  shooterencoder.getRate() < shootersetpoint ) {
		 Shooter.set(-.6);    				 			 	 
     }else{
		 Shooter.set(0.0);}
			
	}
    @Override
	public void testPeriodic() {
    LiveWindow.run();
	}
}

