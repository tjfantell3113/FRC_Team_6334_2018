package org.usfirst.frc.team6334.robot.commands;

/**
 *
 */
public class autoResetSensors extends CommandBase {

	boolean isFinished;
    public autoResetSensors() {
        requires(driveTrain);
        requires(lift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	isFinished = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	lift.resetEncoderPos();
    	driveTrain.resetEncoders();
    	driveTrain.resetGyro();
    	isFinished = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}