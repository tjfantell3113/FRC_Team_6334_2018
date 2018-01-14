package org.usfirst.frc.team6334.robot.commands;

import org.usfirst.frc.team6334.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 *
 *
 *
 *
 *
 *	THIS IS NOT FINISHED BY ANY MEANS, PLEASE DO NOT TOUCH!
 *
 *
 *
 *
 *
 *
 */
public class SeekBox extends CommandBase {

	double kPx, kPy, min_kP, xError, yError, throttleAdjustTurn, throttleAdjustDistance;
	
    public SeekBox() {
        requires(driveTrain);
        requires(vision);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	kPx = RobotMap.L_kPx;
    	kPy = RobotMap.L_kPy;
    	min_kP = RobotMap.L_min_kP;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	xError = vision.getXOffset();
    	yError = vision.getYOffset();
    	throttleAdjustTurn = 0;
    	throttleAdjustDistance = 0;
    	
    	if(xError > 1) {
    		throttleAdjustTurn = kPx * xError - min_kP;
    	}
    	else if (xError < 1) {
    		throttleAdjustTurn = kPx * xError + min_kP;
    	}
    	
    	throttleAdjustDistance = kPy * yError;
    	
    	driveTrain.setMotorValues(0.5 - (throttleAdjustTurn + throttleAdjustDistance), 0.5 + (throttleAdjustTurn + throttleAdjustDistance));
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
    }
}
