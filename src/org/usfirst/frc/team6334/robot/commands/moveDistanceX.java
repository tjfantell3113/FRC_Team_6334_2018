package org.usfirst.frc.team6334.robot.commands;

import org.usfirst.frc.team6334.robot.RobotMap;

/**
 *
 */
public class moveDistanceX extends CommandBase {

	int initialRight, initialLeft, moveXTicks, encoderPIDCompensation;
	double turn_error, distance_error, initialAngle, turn, throttle, distance;
	boolean backwards;

	
	public moveDistanceX(int pdistance, double pthrottle) {
        requires(driveTrain);
        distance = pdistance;
        throttle = pthrottle;
        if (throttle < 0) {
        	backwards = true;
        } else {
        	backwards = false;
        }
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	initialRight = driveTrain.getRightEncoderPos();
    	initialLeft = driveTrain.getLeftEncoderPos();
    	encoderPIDCompensation = initialRight - initialLeft;
    	initialAngle = driveTrain.getChassisBearing();
    	moveXTicks = (int) ((distance*360)/(Math.PI * 6* 3));
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	turn_error = driveTrain.getRightEncoderPos() - (driveTrain.getLeftEncoderPos() + encoderPIDCompensation);
    	turn = (turn_error * 0.3 * RobotMap.gyro_kP);
    	System.out.println(-throttle + turn);
    	driveTrain.setMotorValues(-throttle + turn, -throttle - turn);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return ((Math.abs((driveTrain.getRightEncoderPos()-initialRight)) > moveXTicks) && (Math.abs((driveTrain.getLeftEncoderPos()-initialLeft)) > moveXTicks));
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