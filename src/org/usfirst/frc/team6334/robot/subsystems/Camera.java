package org.usfirst.frc.team6334.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team6334.robot.RobotMap;
import org.usfirst.frc.team6334.robot.commands.CameraControl;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSink;
import edu.wpi.first.wpilibj.CameraServer;


/**
 *
 */
public class Camera extends Subsystem {
	
	UsbCamera intakeFacingCamera = CameraServer.getInstance().startAutomaticCapture(RobotMap.frontFacingCamera);
	VideoSink server = CameraServer.getInstance().getServer();
	String selectedCamera;
	
	public Camera () {		
		server.setSource(intakeFacingCamera);
		selectedCamera = "intake";
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void setFrontCamera () {
		server.setSource(intakeFacingCamera);
		selectedCamera = "intake";
	}
	
	public void setBackCamera () {
		server.setSource(intakeFacingCamera); // when second camera is added, add here as another option.
		selectedCamera = "behind"; // TODO: find better name
	}
	
	public String getSelectedCamera () {
		return selectedCamera;
	}
	
	/*
	public UsbCamera getIntakeCamera() { // replicate this method for other cameras
		return intakeFacingCamera;
	}
	*/

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new CameraControl());
    }
}

