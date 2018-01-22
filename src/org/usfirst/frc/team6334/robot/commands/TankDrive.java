package org.usfirst.frc.team6334.robot.commands;

import org.usfirst.frc.team6334.robot.RobotMap;

import edu.wpi.first.wpilibj.*;


/**
 *
 */
public class TankDrive extends CommandBase {

	double leftThrottle, rightThrottle;
	Joystick stick;
	
    public TankDrive() {
        super("TankDrive");
    	requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	 
    }

	// Called repeatedly when this Command is scheduled to run
    protected void execute(){
		stick = oi.getXboxStick();
		leftThrottle = stick.getRawAxis(RobotMap.xboxLeftYAxis);
		rightThrottle = stick.getRawAxis(RobotMap.xboxRightYAxis);
		
		if (stick.getRawButton(RobotMap.xboxAButton)) {
			driveTrain.setHighGear();
		}
		else if(stick.getRawButton(RobotMap.xboxBButton)) {
			driveTrain.setLowGear();
		}
		else{
			driveTrain.driveWithController(rightThrottle, leftThrottle);
		}
		driveTrain.updateDash();
	}

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false; //Returning false makes this the default command when there are not others.
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
