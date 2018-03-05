package org.usfirst.frc.team6334.robot.commands;

import org.usfirst.frc.team6334.robot.RobotMap;

/**
 *
 */
public class TurnToBox extends CommandBase {

	double KpX, min_Kp, xError, target, throttleAdjustment, turnDirection;
	
    public TurnToBox(double pturnDirection) {
        requires(driveTrain);
        requires(vision);
        requires(intake);
        turnDirection = pturnDirection;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	KpX = -RobotMap.L_KpX;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//xError = vision.getXOffset();
    	//target = vision.targetAcquired(); //gives 0 for no target, 1 for target acquired. The issue here will be making sure the robot gets the correct box.
    	throttleAdjustment = 0;

    	System.out.print("xError: " + xError + " | ");
    	
    	if(target == 0) {
    		System.out.print("turning...");
    		throttleAdjustment = 0.3;
    		driveTrain.setMotorValues(throttleAdjustment * turnDirection, -throttleAdjustment * turnDirection);
    	}
    	else if (target == 1 && !intake.hasCube()) {
    		System.out.print("seeking...");
    		throttleAdjustment = KpX * xError;
    		if (Math.abs(throttleAdjustment) > 0.5) {
    			int sign = 1;
    			if (throttleAdjustment < 0) {
    				sign = -1;
    			}
    			
    			throttleAdjustment = sign * 0.5;
    		}
    		driveTrain.setMotorValues(-throttleAdjustment, throttleAdjustment);
    	}
    	System.out.println(" | throttleAdjustment: " + throttleAdjustment);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (xError > -0.05 && xError < 0.05);
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
