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
	boolean coastModeEnabled, turboEnabled;

	public TankDrive() {
		super("TankDrive");
		requires(driveTrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		leftStick = oi.getLeftStick();
		rightStick = oi.getRightStick();
		coastModeEnabled = false;
		turboEnabled = false;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		
		if (leftStick.getRawButtonPressed(RobotMap.changeTurbo) && leftStick.getRawButtonPressed(12)) {
			turboEnabled = true;
		} else if (leftStick.getRawButtonReleased(RobotMap.changeTurbo) && leftStick.getRawButtonReleased(12)){
			turboEnabled = false;
		}
		
		leftThrottle = leftStick.getY();
		rightThrottle = rightStick.getY();
		
		if (leftStick.getRawButtonPressed(RobotMap.shiftDown)) {
			driveTrain.setLowGear();
		}
		
		if (leftStick.getRawButtonPressed(RobotMap.shiftUp)){
			driveTrain.setHighGear();
		}
		
		if (leftStick.getRawButtonPressed(RobotMap.coastMode)) {
			driveTrain.changeBrakeMode(coastModeEnabled);
			coastModeEnabled = !coastModeEnabled;
		}
		
		driveTrain.driveWithControllers(rightThrottle, leftThrottle);
		//driveTrain.automaticTransmission(throttle);
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
