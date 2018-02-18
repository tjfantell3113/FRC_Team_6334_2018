package org.usfirst.frc.team6334.robot.commands;

import org.usfirst.frc.team6334.robot.RobotMap;

/**
 *
 */
public class moveDistanceX extends CommandBase {

	int initialRight, initialLeft, moveXTicks;
	double turn_error, distance_error, initialAngle, turn, throttle, distance;

	
    public moveDistanceX(int pdistance) {
        requires(driveTrain);
        distance = pdistance;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	initialRight = driveTrain.getRightEncoderPos();
    	initialLeft = driveTrain.getLeftEncoderPos();
    	initialAngle = driveTrain.getChassisBearing();
    	moveXTicks = (int) ((distance*360)/(Math.PI * 6* 3));
    	throttle = 0.3;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	turn_error = driveTrain.getChassisBearing() - initialAngle;
    	turn += (turn_error * RobotMap.kP) + (turn_error * 0.2 * RobotMap.kI) + (turn_error / 0.2 * RobotMap.kD);
    	driveTrain.setMotorValues(throttle + turn, throttle - turn);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return ((driveTrain.getRightEncoderPos()-initialRight) > moveXTicks) && ((driveTrain.getLeftEncoderPos()-initialLeft) > moveXTicks);
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