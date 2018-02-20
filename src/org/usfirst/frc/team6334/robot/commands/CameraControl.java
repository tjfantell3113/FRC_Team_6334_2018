package org.usfirst.frc.team6334.robot.commands;

import org.usfirst.frc.team6334.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 */
public class CameraControl extends CommandBase {

	Joystick arcadeStick;
	
    public CameraControl() {
        requires(camera);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	arcadeStick = oi.getArcadeStick();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (arcadeStick.getRawButtonPressed(RobotMap.changeCameraSource)) {
    		if (camera.getSelectedCamera() == "intake") {
    			camera.setBackCamera();
    		} else {
    			camera.setFrontCamera();
    		}
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
