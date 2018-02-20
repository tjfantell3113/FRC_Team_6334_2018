package org.usfirst.frc.team6334.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team6334.robot.RobotMap;
import org.usfirst.frc.team6334.robot.commands.ArcadeDrive;
//CAN only libraries
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class DriveTrain extends Subsystem {
	
	WPI_TalonSRX RightMotor1, RightMotor2, RightMotor3, LeftMotor1, LeftMotor2, LeftMotor3;
	DoubleSolenoid gearChange;
	Compressor compressor;
	Encoder leftEncoder, rightEncoder;
	AHRS navx;
	Double SF1, SF2, SF3, SF4;
	Boolean shifted;
	
	public DriveTrain() {
		
		//Initialize the Talon SRX's using CTRE's WPI class.
		RightMotor1 = new WPI_TalonSRX(RobotMap.RightDrive1);
		RightMotor2 = new WPI_TalonSRX(RobotMap.RightDrive2);
		RightMotor3 = new WPI_TalonSRX(RobotMap.RightDrive3);
		LeftMotor1 = new WPI_TalonSRX(RobotMap.LeftDrive1);
		LeftMotor2 = new WPI_TalonSRX(RobotMap.LeftDrive2);
		LeftMotor3 = new WPI_TalonSRX(RobotMap.LeftDrive3);
		
		//Initialize the pneumatic system (solenoids and compressor).
		gearChange = new DoubleSolenoid(RobotMap.gearChange1, RobotMap.gearChange2); 
		compressor = new Compressor(0);
		compressor.setClosedLoopControl(true);

		
		//Invert the left side motor controllers so inputs do not have to be opposite for each side.
		LeftMotor1.setInverted(true);
		LeftMotor2.setInverted(true);
		LeftMotor3.setInverted(true);
		
		//Set Talon control modes to break for autonomous so trajectories are correct.
		RightMotor1.setNeutralMode(NeutralMode.Brake);
		RightMotor2.setNeutralMode(NeutralMode.Brake);
		RightMotor3.setNeutralMode(NeutralMode.Brake);
		LeftMotor1.setNeutralMode(NeutralMode.Brake);
		LeftMotor2.setNeutralMode(NeutralMode.Brake);
		LeftMotor3.setNeutralMode(NeutralMode.Brake);
		
		//Set the two extra Talons to mirror the main Talon (on each side).
		RightMotor2.follow(RightMotor1);
		RightMotor3.follow(RightMotor1);
		LeftMotor2.follow(LeftMotor1);
		LeftMotor3.follow(LeftMotor1);
		
		
		//Encoders require two D/IO ports, whether the encoder is inverted or not, and the k#X is the accuracy that is obtained (4 times is the most)		
		leftEncoder = new Encoder(RobotMap.encLeftIn, RobotMap.encLeftOut, false, Encoder.EncodingType.k4X);  //false = don't invert counting direction
		rightEncoder = new Encoder(RobotMap.encRightIn, RobotMap.encRightOut, true, Encoder.EncodingType.k4X); //need to find correct ports
		
		navx = new AHRS(SPI.Port.kMXP);
		navx.reset();
		
		SF1 = .6;    // 'SF' stands for scaling factor
		SF2 = .17;
		SF3 = .11;
		SF4 = 2.5;
		
		shifted = true;
	}
	
	/**
	 * Set acceleration on a value up to one.
	 * @param right Value for right motors.
	 * @param left Value for left motors.
	 */
	public void setMotorValues(double right, double left){
		//Sets a deadzone for the controllers (whether this is xBox or joystick)
		if(Math.abs(left) < RobotMap.deadzone) left = 0;
		if(Math.abs(right) < RobotMap.deadzone) right = 0;
		
		//Makes sure the percentage of power is not under or over the Talon's limits.
		if(Math.abs(right) <= 0.05) right = 0;
		
		if(right > 1) right = 0.99;
		if(right < -1) right = -0.99;
		
		if(Math.abs(left) <= 0.05) left = 0;
		
		if(left > 1) left = 0.99;
		if(left < -1) left = -0.99;
		
		RightMotor1.set(right);
		LeftMotor1.set(left);
	}
	
	//Tank Drive Method
	public void driveWithControllers(double rightStick, double leftStick){
		double right = rightStick;
		double left = leftStick;
		
		setMotorValues(right, left);
	}
	
	//Arcade Drive Method
	public void driveWithController(double throttle, double turn, boolean turboEnabled) {
		double right = throttle;
		double left = throttle;
		double turningThrottleScale;
		
		turningThrottleScale = Math.abs(throttle) * 2;

		if(Math.abs(right) <= 0.05)
			right = 0;
		if(Math.abs(left) <= 0.05)
			left = 0;
		
		if(throttle <= 0) {
			right += turn * turningThrottleScale;  
			left -= turn * turningThrottleScale;
		} else {
			right -= turn * turningThrottleScale;  
			left += turn * turningThrottleScale;
		}
		
		if (turboEnabled) {
			setMotorValues(right * RobotMap.throttleModifier, left * RobotMap.throttleModifier);
		} else {
			setMotorValues(right, left);
		}
	}
	
	public void resetEncoders() {
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
		return -leftEncoder.getRate();
	}
	
	public double getEncoderRateAvg() {
		double average;
		average = (leftEncoder.getRate() + rightEncoder.getRate())/2;
		return average;
	}

	public void setLowGear() {                     // high gear - more speed, less power
		gearChange.set(DoubleSolenoid.Value.kForward);
	}
	
	public void setHighGear() {                   // low gear - more power, less speed
		gearChange.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void automaticTransmission(double stick) {
		double power = stick;
	
		if(shifted || power > SF1) { //setHighGear() ||
			setHighGear();
			power = (power - SF1) * SF4 + SF2;
		}
		else if(power < SF3) {
			setLowGear();
			power = stick;
		}
		else if(getEncoderRateAvg() < 1 && power > SF2){
			setLowGear();
			power = stick;
		}
		
		
	}
	
	public void updateDash() {
		SmartDashboard.putNumber("Right Motor Master Voltage", RightMotor1.getMotorOutputVoltage());
		SmartDashboard.putNumber("Right Motor Follower 1 Voltage", RightMotor2.getMotorOutputVoltage());
		SmartDashboard.putNumber("Right Motor Follower 2 Voltage", RightMotor3.getMotorOutputVoltage());
		SmartDashboard.putNumber("Left Motor Master Voltage", LeftMotor1.getMotorOutputVoltage());
		SmartDashboard.putNumber("Left Motor Follower 1 Voltage", LeftMotor2.getMotorOutputVoltage());
		SmartDashboard.putNumber("Left Motor Follower 2 Voltage", LeftMotor3.getMotorOutputVoltage());
		SmartDashboard.putNumber("Left Motor Follower 2 Voltage", LeftMotor3.getMotorOutputVoltage());
		SmartDashboard.putNumber("Left Encoder Pos", getLeftEncoderPos());
		SmartDashboard.putNumber("Right Encoder Pos", getRightEncoderPos());
		SmartDashboard.putNumber("Left Encoder Rate", getLeftEncoderRate());
		SmartDashboard.putNumber("Right Encoder Rate", getRightEncoderRate());
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
	
	public double getChassisBearing() {
		return navx.getAngle();
	}
	
	public void resetGyro() {
		navx.reset();
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new ArcadeDrive());
    }

}

