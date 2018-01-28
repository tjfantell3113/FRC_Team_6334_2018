package org.usfirst.frc.team6334.robot.commands;

import org.usfirst.frc.team6334.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 */
@SuppressWarnings("unused")
public class TankDrive extends CommandBase {

	double leftThrottle, rightThrottle;
	Joystick stick, leftStick, rightStick;
	boolean automaticShift, coastModeEnabled;

	public TankDrive() {
		super("TankDrive");
		requires(driveTrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		automaticShift = true;
		leftStick = oi.getLeftStick();
		rightStick = oi.getRightStick();
		coastModeEnabled = false;
		//stick = oi.getXboxStick();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		leftThrottle = leftStick.getY();
		rightThrottle = rightStick.getY();

		//leftThrottle = stick.getRawAxis(RobotMap.xboxLeftYAxis);
		//rightThrottle = stick.getRawAxis(RobotMap.xboxRightYAxis);

		/*
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
		}
		*/
		if (leftStick.getRawButtonPressed(2)) {
			driveTrain.setLowGear();
		} else if (leftStick.getRawButtonPressed(3)) {
			driveTrain.setHighGear();
		}
		
		if (rightStick.getRawButtonPressed(2)) {
			driveTrain.setLowGear();
		} else if (rightStick.getRawButtonPressed(3)) {
			driveTrain.setHighGear();
		}
		
		if (leftStick.getRawButtonPressed(4)) {
			driveTrain.changeBrakeMode(coastModeEnabled);
			coastModeEnabled = !coastModeEnabled;
		} else if (rightStick.getRawButtonPressed(4)) {
			driveTrain.changeBrakeMode(coastModeEnabled);
			coastModeEnabled = !coastModeEnabled;
		}

		driveTrain.driveWithController(rightThrottle, leftThrottle);
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
