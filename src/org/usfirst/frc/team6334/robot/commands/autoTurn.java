package org.usfirst.frc.team6334.robot.commands;

/**
 *
 */
public class autoTurn extends CommandBase {
	
	double wantedAngle, deltaAngle, turnThrottle, minTurn, kP, kI;
	
    public autoTurn(double angle) {
        requires(driveTrain);
        wantedAngle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	minTurn = 0.3;
    	kP = 0.003;
    	deltaAngle = driveTrain.getChassisBearing() - wantedAngle;
    	if (deltaAngle < 0) {
    		minTurn = -0.15;
    	} else minTurn = 0.15;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	deltaAngle = driveTrain.getChassisBearing() - wantedAngle;
    	turnThrottle += (deltaAngle * kP) + minTurn;
    	if (turnThrottle > 1) turnThrottle = 0.95;
    	else if (turnThrottle < -1) turnThrottle = -0.95;
    	driveTrain.setMotorValues(turnThrottle, -turnThrottle);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (deltaAngle > 0) return (driveTrain.getChassisBearing() - wantedAngle < 1);
        else return (driveTrain.getChassisBearing() - wantedAngle > 1);
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
