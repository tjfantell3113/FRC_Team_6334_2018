package org.usfirst.frc.team6334.robot.commands;

import org.usfirst.frc.team6334.robot.RobotMap;

/**
 *
 */
public class autoGrabBox extends CommandBase {

	int initialRight, initialLeft, encoderPIDCompensation;
	double throttle, turn_error, turn;
	
    public autoGrabBox(double pthrottle) {
        requires(driveTrain);
        requires(intake);
        throttle = pthrottle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	initialRight = driveTrain.getRightEncoderPos();
    	initialLeft = driveTrain.getLeftEncoderPos();
    	encoderPIDCompensation = initialRight - initialLeft;
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
        return intake.getRawIR();
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
