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
		
		LeftMotor1.setInverted(true);
		LeftMotor2.setInverted(true);
		LeftMotor3.setInverted(true);
		
		RightMotor1.setNeutralMode(NeutralMode.Brake);
		RightMotor2.setNeutralMode(NeutralMode.Brake);
		RightMotor3.setNeutralMode(NeutralMode.Brake);
		LeftMotor1.setNeutralMode(NeutralMode.Brake);
		LeftMotor2.setNeutralMode(NeutralMode.Brake);
		LeftMotor3.setNeutralMode(NeutralMode.Brake);
		
		RightMotor2.follow(RightMotor1);
		RightMotor3.follow(RightMotor1);
		LeftMotor2.follow(LeftMotor1);
		LeftMotor3.follow(LeftMotor1);
		
		
		//Encoders require two D/IO ports, whether the encoder is inverted or not, and the k#X is the accuracy that is obtained (4 times is the most)		
		leftEncoder = new Encoder(RobotMap.encLeftIn, RobotMap.encLeftOut, false, Encoder.EncodingType.k4X);  //false = don't invert counting direction
		rightEncoder = new Encoder(RobotMap.encRightIn, RobotMap.encRightOut, false, Encoder.EncodingType.k4X); //need to find correct ports
	}
	
	/**
	 * Set acceleration on a value up to one.
	 * @param right Value for right motors.
	 * @param left Value for left motors.
	 */
	public void setMotorValues(double right, double left){
		if(Math.abs(left) < 0.07) left = 0; // comment these two if statements out when we move to dual joysticks
		if(Math.abs(right) < 0.07) right = 0;
		
		RightMotor1.set(right);
		LeftMotor1.set(left);
	}
	
	public void driveWithController(double rightStick, double leftStick){
		double right = rightStick;
		double left = leftStick;
		
		if(Math.abs(right) <= 0.05)
			right = 0;
		if(right > 1)
			right = 0.98;
		if(right < -1)
			right = -0.98;
		if(Math.abs(left) <= 0.05)
			left = 0;
		if(left > 1)
			left = 0.98;
		if(left < -1)
			left = -0.98;
		
		setMotorValues(right, left);
	}
	
	public void resetEncoderPos() {
		leftEncoder.reset();
		rightEncoder.reset();
	}
	
	/**
	 * Returns the left encoders position.
	 * @return int
	 */
	public int getLeftEncoderPos() {
		return leftEncoder.get();
	}
	
	public int getRightEncoderPos() {
		return rightEncoder.get();
	}
	
	public double getRightEncoderRate() {
		return rightEncoder.getRate();
	}
	
	public double getLeftEncoderRate() {
		return leftEncoder.getRate();
	}
	
	public double getEncoderRateAvg() {
		double average;
		average = (leftEncoder.getRate() + rightEncoder.getRate())/2;
		return average;
	}

	public void setLowGear() {
			leftGearChange.set(DoubleSolenoid.Value.kForward);
			rightGearChange.set(DoubleSolenoid.Value.kForward);
	}
	
	public void setHighGear() {
			leftGearChange.set(DoubleSolenoid.Value.kReverse);
			rightGearChange.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void automaticShift(boolean enabled) {
		if(enabled) {
			if (getEncoderRateAvg() > RobotMap.automaticShiftValue) {
				setHighGear();
			} else {
				setLowGear();
			}
		}
	}
	
	public boolean testCompressor() {
		return compressor.enabled();
	}

	public void updateDash() {
		SmartDashboard.putNumber("Right Motor Master Voltage", RightMotor1.getMotorOutputVoltage());
		SmartDashboard.putNumber("Right Motor Follower 1 Voltage", RightMotor2.getMotorOutputVoltage());
		SmartDashboard.putNumber("Right Motor Follower 2 Voltage", RightMotor3.getMotorOutputVoltage());
		SmartDashboard.putNumber("Left Motor Master Voltage", LeftMotor1.getMotorOutputVoltage());
		SmartDashboard.putNumber("Left Motor Follower 1 Voltage", LeftMotor2.getMotorOutputVoltage());
		SmartDashboard.putNumber("Left Motor Follower 2 Voltage", LeftMotor3.getMotorOutputVoltage());
	}
	
	//true makes the robot enter break mode, false will put it into coast (This is a CAN only function)
	public void changeBrakeMode(boolean brakeMode) {
		RightMotor1.setNeutralMode(brakeMode ? NeutralMode.Brake : NeutralMode.Coast);
		RightMotor2.setNeutralMode(brakeMode ? NeutralMode.Brake : NeutralMode.Coast);
		RightMotor3.setNeutralMode(brakeMode ? NeutralMode.Brake : NeutralMode.Coast);
		LeftMotor1.setNeutralMode(brakeMode ? NeutralMode.Brake : NeutralMode.Coast);
		LeftMotor2.setNeutralMode(brakeMode ? NeutralMode.Brake : NeutralMode.Coast);
		LeftMotor3.setNeutralMode(brakeMode ? NeutralMode.Brake : NeutralMode.Coast);
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new TankDrive());
    }

}

