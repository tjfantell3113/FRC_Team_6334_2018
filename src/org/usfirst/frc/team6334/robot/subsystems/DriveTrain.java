package org.usfirst.frc.team6334.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team6334.robot.RobotMap;
import org.usfirst.frc.team6334.robot.commands.TankDrive;

//CAN only libraries
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class DriveTrain extends Subsystem {
	
	WPI_TalonSRX RightMotor1, RightMotor2, RightMotor3, LeftMotor1, LeftMotor2, LeftMotor3;
	//Talon RightMotor1, RightMotor2, RightMotor3, LeftMotor1, LeftMotor2, LeftMotor3;
	DoubleSolenoid leftGearChange, rightGearChange;
	Compressor compressor;
	Encoder leftEncoder, rightEncoder;
	
	public DriveTrain() {
		
		RightMotor1 = new WPI_TalonSRX(RobotMap.RightDrive1);
		RightMotor2 = new WPI_TalonSRX(RobotMap.RightDrive2);
		RightMotor3 = new WPI_TalonSRX(RobotMap.RightDrive3);
		LeftMotor1 = new WPI_TalonSRX(RobotMap.LeftDrive1);
		LeftMotor2 = new WPI_TalonSRX(RobotMap.LeftDrive2);
		LeftMotor3 = new WPI_TalonSRX(RobotMap.LeftDrive3);
		/*
		RightMotor1 = new Talon(RobotMap.RightDrive1);
		RightMotor2 = new Talon(RobotMap.RightDrive2);
		RightMotor3 = new Talon(RobotMap.RightDrive3);
		LeftMotor1 = new Talon(RobotMap.LeftDrive1);
		LeftMotor2 = new Talon(RobotMap.LeftDrive2);
		LeftMotor3 = new Talon(RobotMap.LeftDrive3);
		*/
		
		leftGearChange = new DoubleSolenoid(RobotMap.leftGearChange1, RobotMap.leftGearChange2);
		rightGearChange = new DoubleSolenoid(RobotMap.rightGearChange1, RobotMap.rightGearChange2);
		compressor = new Compressor(0);
		compressor.setClosedLoopControl(true);

		
		//Make the extra motors mirror the first motors (CAN only)
		
		RightMotor2.follow(RightMotor1);
		RightMotor3.follow(RightMotor1);
		LeftMotor1.setInverted(true);
		LeftMotor2.setInverted(true);
		LeftMotor3.setInverted(true);
		LeftMotor2.follow(LeftMotor1);
		LeftMotor3.follow(LeftMotor1);
		
		leftEncoder = new Encoder(RobotMap.encLeftIn, RobotMap.encLeftOut, false, Encoder.EncodingType.k4X);  //false = don't invert counting direction
		leftEncoder = new Encoder(RobotMap.encRightIn, RobotMap.encRightOut, false, Encoder.EncodingType.k4X); //need to find correct ports
	}
	
	public void setMotorValues(double right, double left){
		if(Math.abs(left) < 0.09) left = 0;
		if(Math.abs(right) < 0.09) right = 0;
		
		RightMotor1.set(right);
		RightMotor2.set(right);
		RightMotor3.set(right);
		LeftMotor1.set(left);
		LeftMotor2.set(left);
		LeftMotor3.set(left);	
	}
	
	public void driveWithController(double rightStick, double leftStick){
		double right = rightStick;
		double left = leftStick;
		
		if(Math.abs(right) <= 0.05)
			right = 0;
		if(Math.abs(left) <= 0.05)
			left = 0;
		
		setMotorValues(right, left);
	}
	
	public void resetEncoderPos() {
		leftEncoder.reset();
		rightEncoder.reset();
	}
	
	public int getLeftEncoderPos() {
		return leftEncoder.get();
	}
	public int getRightEncoderPos() {
		return rightEncoder.get();
	}

	public void setLowGear() {
			leftGearChange.set(DoubleSolenoid.Value.kForward);
			rightGearChange.set(DoubleSolenoid.Value.kForward);
	}
	
	public void setHighGear() {
			leftGearChange.set(DoubleSolenoid.Value.kReverse);
			rightGearChange.set(DoubleSolenoid.Value.kReverse);
	}
	
	public boolean testCompressor() {
		return compressor.enabled();
	}

	public void updateDash() {
		SmartDashboard.putData("Left Motor Power", RightMotor1);
		SmartDashboard.putData("Right Motor Power", LeftMotor1);
	}
	
	//true makes the robot enter break mode, false will put it into coast (This is a CAN only function)
	public void changeBrakeMode(boolean brakeMode) {
		RightMotor1.setNeutralMode(brakeMode ? NeutralMode.Brake : NeutralMode.Coast);
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new TankDrive());
    }

}

