package org.usfirst.frc.team6334.robot.commands;

import org.usfirst.frc.team6334.robot.RobotMap;

/**
 *
 */
public class SeekBox extends CommandBase {

	double KpX, min_Kp, xError, target, throttleAdjustment;

    public SeekBox() {
        requires(driveTrain);
        requires(vision);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	KpX = RobotMap.L_KpX;
    	min_Kp = RobotMap.L_min_Kp;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	xError = vision.getXOffset();
    	target = vision.getTarget(); //gives 0 for no target, 1 for target acquired. The issue here will be making sure the robot gets the correct box.
    	throttleAdjustment = 0;

    	if(target == 0) {
    		throttleAdjustment = 0.3;
    	}
    	else {
    		throttleAdjustment = KpX * xError;
    	}
    	driveTrain.setMotorValues(0.25 - throttleAdjustment, 0.25 + throttleAdjustment);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	driveTrain.setMotorValues(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	driveTrain.setMotorValues(0, 0);
    }
}
