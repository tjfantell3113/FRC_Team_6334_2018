package org.usfirst.frc.team6334.robot.commands;

import org.usfirst.frc.team6334.robot.RobotMap;

/**
 *
 */
public class SeekBox extends CommandBase {

	double KpX, min_Kp, xError, target, throttleAdjustment;
	boolean targetLocked;

    public SeekBox() {
        requires(driveTrain);
        requires(vision);
        requires(intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	KpX = RobotMap.L_KpX;
    	min_Kp = RobotMap.L_min_Kp;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	xError = vision.getXOffset();
    	target = vision.targetAcquired(); //gives 0 for no target, 1 for target acquired. The issue here will be making sure the robot gets the correct box.
    	throttleAdjustment = 0;

    	if(target == 0) {
    		throttleAdjustment = 0.3;
    		driveTrain.driveWithControllers(-throttleAdjustment, throttleAdjustment);
    	}
    	else if (target == 1 && !intake.hasCube()) {
    		throttleAdjustment = KpX * xError;
    		if (!targetLocked) {
    			//intake.openIntake();
    			targetLocked = true;
    		} else {
    			//intake.setIntakePower(-1.0);
    		}
    		driveTrain.driveWithControllers(0.1 - throttleAdjustment, 0.1 + throttleAdjustment);
    	} else if (target == 1 && intake.hasCube()) {
    		//intake.closeIntake();
    		targetLocked = false;
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return intake.hasCube();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
