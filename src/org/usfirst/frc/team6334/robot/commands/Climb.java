package org.usfirst.frc.team6334.robot.commands;

import org.usfirst.frc.team6334.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 */
public class Climb extends CommandBase {
	
	Joystick intakeStick;

    public Climb() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	super("Climb");
    	requires(climber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	intakeStick = oi.getIntakeStick();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double throttle = intakeStick.getY();
    	
    	if (intakeStick.getRawButton(RobotMap.climberButton)) {
    		climber.raiseClimber(throttle, false);
    	} else if (intakeStick.getRawButton(4) && intakeStick.getRawButton(11)){
    		climber.raiseClimber(throttle, true);
    	} else if (intakeStick.getRawButton(1)) {
    		climber.raisePivot(throttle*0.25);
    	} else if (intakeStick.getRawButton(2)){
    		climber.raisePivot(throttle);
    	} else {
    		climber.raiseClimber(0, false);
    		climber.raisePivot(0);
    	}
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
