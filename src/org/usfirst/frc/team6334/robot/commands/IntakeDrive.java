package org.usfirst.frc.team6334.robot.commands;

import org.usfirst.frc.team6334.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 */
public class IntakeDrive extends CommandBase {

	Joystick elevatorStick, arcadeStick;
	boolean endTask, intakeSolenoidState;

	public IntakeDrive() {
		requires(intake);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		elevatorStick = oi.getElevatorStick();
		arcadeStick = oi.getArcadeStick();
		intake.closeIntake();
		endTask = false;
		intakeSolenoidState = false;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		//double throttle = intakeStick.getY();
		if (elevatorStick.getRawButton(11)) {
			intake.setIntakePower(1);
		}
		intake.updateDash();
		
		if (arcadeStick.getRawButton(RobotMap.intakeIn)) {
			intake.setIntakePower(1.0);
		} else if (arcadeStick.getRawButton(RobotMap.intakeOut)) {
			intake.setIntakePower(-1.0);
		} else {
			intake.setIntakePower(0);
		}
		
		if (arcadeStick.getRawButtonPressed(RobotMap.changeIntakeSolenoid)) {
			if (intakeSolenoidState) { // if the intake is open, close it
				intake.closeIntake();
				intakeSolenoidState = !intakeSolenoidState;
			} else { // else open it
				intake.openIntake();
				intakeSolenoidState = !intakeSolenoidState;
			}
		}
		
		if(elevatorStick.getRawButton(RobotMap.endIntakeTask)) {
			endTask = true;
		}
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
