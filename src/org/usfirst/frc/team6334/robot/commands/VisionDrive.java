package org.usfirst.frc.team6334.robot.commands;

import org.usfirst.frc.team6334.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class VisionDrive extends CommandBase {
	
	Joystick elevatorStick;
	int counter, counter2;
	
    public VisionDrive() {
        requires(vision);
        counter = 0;
        counter2 = 0;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	elevatorStick = oi.getElevatorStick();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(elevatorStick.getRawButton(RobotMap.changeLimeLightCam)) {
        	counter += 1;
        	vision.changeVisionMode((counter % 2));
        	Timer.delay(0.5);
        }
        
        if(elevatorStick.getRawButton(RobotMap.changeLimeLightLED)) {
        	counter2 += 1;
        	vision.changeLedMode((counter2 % 2));
        	Timer.delay(0.5);
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
