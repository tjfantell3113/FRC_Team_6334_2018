package org.usfirst.frc.team6334.robot.commands;

import org.usfirst.frc.team6334.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 */
@SuppressWarnings("unused")
public class ArcadeDrive extends CommandBase {

	double throttle, turn;
	Joystick leftStick, rightStick, arcadeStick;
	boolean automaticShift, coastModeEnabled, shifted, turboEnabled;

	public ArcadeDrive() {
		super("ArcadeDrive");
		requires(driveTrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		arcadeStick = oi.getArcadeStick();
		coastModeEnabled = false;
		shifted = false;
		turboEnabled = false;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		
		if (arcadeStick.getRawButtonPressed(RobotMap.changeTurbo)) {
			turboEnabled = true;
		} else if (arcadeStick.getRawButtonReleased(RobotMap.changeTurbo)){
			turboEnabled = false;
		}
		
		throttle = arcadeStick.getY();
		turn = arcadeStick.getX();
		
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
		
		if (arcadeStick.getRawButtonPressed(12)) {
			driveTrain.moveX(50);
		}
		
		driveTrain.driveWithController(throttle, turn, turboEnabled);
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
