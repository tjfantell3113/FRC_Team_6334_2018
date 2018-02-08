package org.usfirst.frc.team6334.robot.commands;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 */
public class LiftDrive extends CommandBase {
	
	Joystick auxStick;
	
    public LiftDrive() {
        requires(lift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	auxStick = oi.getAuxStick();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	/*//
    	if(auxStick.getRawButtonPressed(1)){
    		lift.setLiftPower(0.25);
    	} else if (auxStick.getRawButtonPressed(2)) {
    		lift.setLiftPower(0.5);
    	} else if (auxStick.getRawButtonPressed(3)) {
    		lift.setLiftPower(0.75);
    	} else if (auxStick.getRawButtonPressed(4)) {
    		lift.setLiftPower(0.99);
    	} else if (auxStick.getRawButtonPressed(5)) {
    		lift.setLiftPower(-0.5);
    	}
    	*/
    	double throttle = auxStick.getY();
    	if (Math.abs(throttle) > 0.05) {
    		lift.setLiftPower(throttle);
    	} else {
    		lift.setLiftPower(0);
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
    	lift.setLiftPower(0);
    }
}
