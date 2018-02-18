package org.usfirst.frc.team6334.robot.commands;

/**
 *
 */
public class autoLift extends CommandBase {

	int initialPos, wantedPos;
	int direction = -1; //The directions are inverted so up is negative.
	
    public autoLift(int pos) {
        requires(lift);
        wantedPos = pos;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	initialPos = lift.getEncoderPos();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (wantedPos < initialPos) {
    		direction = 1;
    	}
    	
    	lift.setLiftPower(0.5 * direction);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (initialPos < wantedPos)
        	return (lift.getEncoderPos() > wantedPos);
    	else return (lift.getEncoderPos() < wantedPos);
    }

    // Called once after isFinished returns true
    protected void end() {
    	lift.setLiftPower(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	lift.setLiftPower(0);
    }
}
