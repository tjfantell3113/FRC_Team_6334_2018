package org.usfirst.frc.team6334.robot.commands;

import org.usfirst.frc.team6334.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 */
@SuppressWarnings("unused")
public class ArcadeDrive extends CommandBase {

	double leftThrottle, rightThrottle;
	Joystick leftStick, rightStick, arcadeStick;
	boolean automaticShift, coastModeEnabled, shifted;

	public ArcadeDrive() {
		super("ArcadeDrive");
		requires(driveTrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		arcadeStick = oi.getArcadeStick();
		//leftStick = oi.getLeftStick();
		//rightStick = oi.getRightStick();
		coastModeEnabled = false;
		//stick = oi.getXboxStick();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		//leftThrottle = leftStick.getY();
		//rightThrottle = rightStick.getY();

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
		if (arcadeStick.getRawButtonPressed(RobotMap.shiftDown)) {
			driveTrain.setLowGear();
		}
		
		if (arcadeStick.getRawButtonPressed(RobotMap.shiftUp)){
			driveTrain.setHighGear();
		}
		
		if (arcadeStick.getRawButtonPressed(RobotMap.coastMode)) {
			driveTrain.changeBrakeMode(coastModeEnabled);
			coastModeEnabled = !coastModeEnabled;
		}
		driveTrain.driveWithController(arcadeStick.getX(), arcadeStick.getY());
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
