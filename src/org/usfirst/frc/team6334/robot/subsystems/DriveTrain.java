package org.usfirst.frc.team6334.robot.subsystems;

//import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team6334.robot.RobotMap;
import org.usfirst.frc.team6334.robot.commands.TankDrive;

// This is CAN only, you will notice a trend from here.
// import com.ctre.phoenix.motorcontrol.NeutralMode;
//import com.ctre.phoenix.motorcontrol.can.*;

public class DriveTrain extends Subsystem {
	
	//WPI_TalonSRX RightMotor1, RightMotor2, RightMotor3, LeftMotor1, LeftMotor2, LeftMotor3;
	Talon RightMotor1, RightMotor2, RightMotor3, LeftMotor1, LeftMotor2, LeftMotor3;
	//Solenoid leftGearChange, rightGearChange;
		
	public DriveTrain() {
		RightMotor1 = new Talon(RobotMap.RightDrive1);
		RightMotor2 = new Talon(RobotMap.RightDrive2);
		RightMotor3 = new Talon(RobotMap.RightDrive3);
		LeftMotor1 = new Talon(RobotMap.LeftDrive1);
		LeftMotor2 = new Talon(RobotMap.LeftDrive2);
		LeftMotor3 = new Talon(RobotMap.LeftDrive3);
		
		//leftGearChange = new Solenoid(RobotMap.leftGearChange);
		//rightGearChange = new Solenoid(RobotMap.rightGearChange);
		
		//Make the extra motors mirror the first motors (CAN only)
		/*
		RightMotor2.follow(RightMotor1);
		RightMotor3.follow(RightMotor1);
		LeftMotor2.follow(LeftMotor1);
		LeftMotor3.follow(LeftMotor1);
		*/
	}
	
	public void setMotorValues(double right, double left){
		if(Math.abs(left) < 0.09) left = 0;
		if(Math.abs(right) < 0.09) right = 0;
		
		RightMotor1.set(right);
		RightMotor2.set(right);
		RightMotor3.set(right);
		LeftMotor1.set(-left);
		LeftMotor2.set(-left);
		LeftMotor3.set(-left);
		
		SmartDashboard.putData("Left Motor Power", RightMotor1);
		SmartDashboard.putData("Right Motor Power", LeftMotor1);
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
	/*
	public void setLowGear() {
		leftGearChange.set(true);
		rightGearChange.set(true);
	}
	
	public void setHighGear() {
		leftGearChange.set(false);
		rightGearChange.set(false);
	}
	*/
	
	//true makes the robot enter break mode, false will put it into coast (This is a CAN only function)
	/*
	public void changeBrakeMode(boolean brakeMode) {
		RightMotor1.setNeutralMode(brakeMode ? NeutralMode.Brake : NeutralMode.Coast);
	}
	*/

    public void initDefaultCommand() {
    	setDefaultCommand(new TankDrive());
    }

}

