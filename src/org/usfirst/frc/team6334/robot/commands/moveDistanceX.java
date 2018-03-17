package org.usfirst.frc.team6334.robot.commands;

import org.usfirst.frc.team6334.robot.RobotMap;

/**
 *
 */
public class moveDistanceX extends CommandBase {

	int initialRight, initialLeft, moveXTicks, encoderPIDCompensation, lastRightPos, lastLeftPos, stopCounter;
	double turn_error, distance_error, initialAngle, turn, targetThrottle, distance, throttle;
	boolean backwards, highGear, stopped;

	
	public moveDistanceX(int pdistance, double pthrottle, boolean highgear) {
        requires(driveTrain);
        distance = pdistance;
        targetThrottle = pthrottle;
        throttle = RobotMap.startUpThrottle;
        highGear = highgear;        
        if (targetThrottle < 0) {
        	backwards = true;
        } else {
        	backwards = false;
        }
        
        //if things break blame this
        lastRightPos = 0;
        lastLeftPos = 0;
        stopCounter = 0;
        stopped = false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	initialRight = driveTrain.getRightEncoderPos();
    	initialLeft = driveTrain.getLeftEncoderPos();
    	encoderPIDCompensation = initialRight - initialLeft;
    	initialAngle = driveTrain.getChassisBearing();
    	
    	double gearRatio = 4.77;
    	if(!highGear) gearRatio = 22.67;
    	
    	moveXTicks = (int) ((1440/(Math.PI * 6 * 3 * gearRatio)) * distance);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	turn_error = driveTrain.getRightEncoderPos() - (driveTrain.getLeftEncoderPos() + encoderPIDCompensation);
    	turn = (turn_error * 0.3 * RobotMap.gyro_kP);
    	
    	if(!backwards) {
    		if(throttle < targetThrottle) {
        		throttle += 0.03;
        	}
    	} else {
    		if(Math.abs(throttle) < Math.abs(targetThrottle)) {
        		throttle -= 0.03;
        	}
    	}
    	
    	driveTrain.setMotorValues(-throttle + turn, -throttle - turn);
    	
    	//if things break blame this
    	stopped = stopCheck();
    }
    
    //if things break blame this
    public boolean stopCheck() {
    	boolean stopped = false;
    	if((lastLeftPos == driveTrain.getLeftEncoderPos()) && (lastRightPos == driveTrain.getRightEncoderPos())) {
    		stopCounter++;
    		if(stopCounter >= 50) {
    			stopped = true;
    		}
    	} else {
    		stopCounter = 0;
    	}
    	lastLeftPos = driveTrain.getLeftEncoderPos();
    	lastRightPos = driveTrain.getRightEncoderPos();
    	return stopped;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (((Math.abs((driveTrain.getRightEncoderPos()-initialRight)) >= moveXTicks) && (Math.abs((driveTrain.getLeftEncoderPos()-initialLeft)) >= moveXTicks)) || stopped);
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