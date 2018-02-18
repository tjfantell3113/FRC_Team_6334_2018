package org.usfirst.frc.team6334.robot.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class autoIntake extends CommandBase {

	double runTime;
	boolean ejectBox = true, finished = false;
	
    public autoIntake(boolean eject, double time) {
        requires(intake);
        ejectBox = eject;
        runTime = time;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(ejectBox) {
    		intake.setIntakePower(1);
    	} else {
    		intake.setIntakePower(-1);
    	}
    	Timer.delay(runTime);
    	finished = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	intake.setIntakePower(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	intake.setIntakePower(0);
    }
}