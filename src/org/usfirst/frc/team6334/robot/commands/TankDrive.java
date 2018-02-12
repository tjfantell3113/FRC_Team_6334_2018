package org.usfirst.frc.team6334.robot.commands;

import org.usfirst.frc.team6334.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 */
@SuppressWarnings("unused")
public class TankDrive extends CommandBase {

	double leftThrottle, rightThrottle;
	Joystick leftStick, rightStick;
	boolean automaticShift, coastModeEnabled, shifted;

	public TankDrive() {
		super("TankDrive");
		requires(driveTrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		//leftStick = oi.getLeftStick();
		//rightStick = oi.getRightStick();
		coastModeEnabled = false;
		//stick = oi.getXboxStick();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		//leftThrottle = leftStick.getY();
		//rightThrottle = rightStick.getY();
		
		/*
		leftThrottle = stick.getRawAxis(RobotMap.xboxLeftYAxis);
		rightThrottle = stick.getRawAxis(RobotMap.xboxRightYAxis);
		
		if (stick.getRawButtonPressed(RobotMap.xboxXButton)) {
			driveTrain.changeBrakeMode(false);
		} else if (stick.getRawButton(RobotMap.xboxYButton)) {
			System.out.println(driveTrain.testCompressor());
		}
		
		if (stick.getRawButtonPressed(RobotMap.xboxRightBumper)) {
			driveTrain.setHighGear();
		} else if (stick.getRawButtonPressed(RobotMap.xboxLeftBumper)) {
			driveTrain.setLowGear();
		} else {
			driveTrain.driveWithController(rightThrottle, leftThrottle);
		}*/
		
		if (leftStick.getRawButtonPressed(RobotMap.shiftDown) || rightStick.getRawButtonPressed(RobotMap.shiftDown)) {
			driveTrain.setLowGear();
		}
		
		if (rightStick.getRawButtonPressed(RobotMap.shiftUp) || rightStick.getRawButtonPressed(RobotMap.shiftUp)) {
			driveTrain.setHighGear();
		}
		
		if (leftStick.getRawButtonPressed(RobotMap.coastMode) || rightStick.getRawButtonPressed(RobotMap.coastMode)) {
			driveTrain.changeBrakeMode(coastModeEnabled);
			coastModeEnabled = !coastModeEnabled;
		}
		
		if (leftStick.getRawButtonPressed(RobotMap.resetEncoders) || rightStick.getRawButtonPressed(RobotMap.resetEncoders)) {
			driveTrain.resetEncoderPos();
		}
		
		driveTrain.driveWithControllers(rightThrottle, leftThrottle);
		driveTrain.updateDash();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false; // Returning false makes this the default command when there are not others.
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
