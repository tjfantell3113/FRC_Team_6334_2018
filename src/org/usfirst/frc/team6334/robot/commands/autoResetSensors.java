package org.usfirst.frc.team6334.robot.commands;

/**
 *
 */
public class autoResetSensors extends CommandBase {

	boolean isFinished;
    public autoResetSensors() {
        requires(driveTrain);
        requires(lift);
        requires(vision);
        requires(intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	isFinished = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	intake.closeIntake();
    	lift.resetEncoderPos();
    	driveTrain.resetEncoders();
    	driveTrain.resetGyro();
    	driveTrain.setHighGear();
    	vision.changeVisionMode(0);
    	vision.changeLedMode(0);
    	
    	isFinished = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	intake.closeIntake();
    	lift.resetEncoderPos();
    	driveTrain.resetEncoders();
    	driveTrain.resetGyro();
    	driveTrain.setHighGear();
    	vision.changeVisionMode(0);
    	vision.changeLedMode(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	intake.closeIntake();
    	lift.resetEncoderPos();
    	driveTrain.resetEncoders();
    	driveTrain.resetGyro();
    	driveTrain.setHighGear();
    	vision.changeVisionMode(0);
    	vision.changeLedMode(0);
    }
}
