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
    	if (wantedPos < initialPos) {
    		direction = 1;
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	lift.setLiftPower(1 * direction, false);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (direction == -1)
        	return (lift.getEncoderPos() >= wantedPos);
    	else return (wantedPos >= (lift.getEncoderPos() + 1000)); //add a 1000 tick buffer to account for back drive due to gravity.
    }

    // Called once after isFinished returns true
    protected void end() {
    	lift.setLiftPower(0, false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	lift.setLiftPower(0, false);
    }
}
