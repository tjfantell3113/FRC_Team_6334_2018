package org.usfirst.frc.team6334.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6334.robot.RobotMap;
import org.usfirst.frc.team6334.robot.commands.TankDrive;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.*;



public class DriveTrain extends Subsystem {
	
	WPI_TalonSRX RightMotor1, RightMotor2, RightMotor3, LeftMotor1, LeftMotor2, LeftMotor3;
		
	public DriveTrain() {
		RightMotor1 = new WPI_TalonSRX(RobotMap.RightDrive1);
		RightMotor2 = new WPI_TalonSRX(RobotMap.RightDrive2);
		RightMotor3 = new WPI_TalonSRX(RobotMap.RightDrive3);
		LeftMotor1 = new WPI_TalonSRX(RobotMap.LeftDrive1);
		LeftMotor2 = new WPI_TalonSRX(RobotMap.LeftDrive2);
		LeftMotor3 = new WPI_TalonSRX(RobotMap.LeftDrive3);
		
		//Make the extra motors mirror what the first motor
		RightMotor2.follow(RightMotor1);
		RightMotor3.follow(RightMotor1);
		LeftMotor2.follow(LeftMotor1);
		LeftMotor3.follow(LeftMotor1);
	}
	
	public void setMotorValues(double right, double left){
		if(Math.abs(left) < 0.075) left = 0;
		if(Math.abs(right) < 0.075) right = 0;
		
		RightMotor1.set(-right);
		LeftMotor1.set(left);
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
	
	//true makes the robot enter break mode, false will put it into coast
	public void changeBrakeMode(boolean brakeMode) {
		RightMotor1.setNeutralMode(brakeMode ? NeutralMode.Brake : NeutralMode.Coast);
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new TankDrive());
    }

}

