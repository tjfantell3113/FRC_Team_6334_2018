package org.usfirst.frc.team6334.robot.commands;

import org.usfirst.frc.team6334.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 */
public class IntakeDrive extends CommandBase {

	Joystick intakeStick;

	public IntakeDrive() {
		requires(intake);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		intakeStick = oi.getIntakeStick();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {/*
		double throttle = intakeStick.getY();
		if (!intakeStick.getRawButton(RobotMap.climberButton) && !intakeStick.getRawButton(RobotMap.pivotButton)) {
			if (intakeStick.getRawButton(RobotMap.ejectBox)) { // rawButton over rawButtonPressed because rawButton will
																// continue to return true as long as the button is held
																// down
				intake.setIntakePower(1);
			} else if (Math.abs(throttle) > 0.05) {
				intake.setIntakePower(throttle);
			} else {
				intake.setIntakePower(0);
			}

		} else {
			intake.setIntakePower(0);
		}
		intake.updateDash(); */
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		intake.setIntakePower(0);
	}
}
