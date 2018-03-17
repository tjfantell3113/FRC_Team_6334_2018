package org.usfirst.frc.team6334.robot.commands;

/**
 *
 */
public class autoTurn extends CommandBase {
	
	double wantedAngle, deltaAngle, throttle, minTurn, kP, kI, turnDirection;
	boolean isFinished;
	
    public autoTurn(double angle, double pthrottle, double pturnDirection) {
        requires(driveTrain);
        wantedAngle = angle;
        isFinished = false;
        throttle = pthrottle;
        turnDirection = pturnDirection;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	minTurn = 0.3;
    	kP = 0.003;
    	deltaAngle = driveTrain.getChassisBearing() - wantedAngle;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	/*
    	deltaAngle = driveTrain.getChassisBearing() - wantedAngle;
    	turnThrottle = (deltaAngle * kP) + minTurn;
    	if (turnThrottle > 1) turnThrottle = 0.95;
    	else if (turnThrottle < -1) turnThrottle = -0.95;
    	driveTrain.setMotorValues(turnThrottle, -turnThrottle);
    	*/
    	
    	driveTrain.setMotorValues((throttle * turnDirection), -(throttle * turnDirection));
    	
    	if ((((int) driveTrain.getChassisBearing()) - wantedAngle) > -3 && (((int) driveTrain.getChassisBearing()) - wantedAngle) < 3) {
    		isFinished = true;
    		System.out.println("finished turning");
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isFinished;
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
