package org.usfirst.frc.team6334.robot.commands;

import org.usfirst.frc.team6334.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 */
public class ClimbDrive extends CommandBase {
	
	Joystick climberStick;
	boolean endTask;

    public ClimbDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	super("Climb");
    	requires(climber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	climberStick = oi.getClimberStick();
    	endTask = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double throttle = climberStick.getY();
    	
    	if (climberStick.getRawButton(RobotMap.climberButton)) {
    		climber.raiseClimber(throttle, false);
    	} else if (climberStick.getRawButton(RobotMap.climbBackDrive1) && climberStick.getRawButton(RobotMap.climbBackDrive2)){
    		climber.raiseClimber(throttle, true);
    	} else if (climberStick.getRawButton(RobotMap.hookArmSlowMode)) {
    		climber.raisePivot(throttle*0.25);
    	} else if (climberStick.getRawButton(RobotMap.hookArmFastMode)){
    		climber.raisePivot(throttle);
    	} else {
    		climber.raiseClimber(0, false);
    		climber.raisePivot(0);
    	}
    	
    	if(climberStick.getRawButton(RobotMap.endClimberTask)) {
    		endTask = true;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return endTask;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
