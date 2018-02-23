package org.usfirst.frc.team6334.robot.subsystems;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

import org.usfirst.frc.team6334.robot.commands.SeekBox;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
@SuppressWarnings("deprecation")
public class Vision extends Subsystem {
	NetworkTable visionTable;
	double xOffset, yOffset, targetArea, targetSkew, targetAquired;
	
	public Vision() {
		visionTable = NetworkTable.getTable("limelight");
		xOffset = visionTable.getNumber("tx", 0);
		yOffset = visionTable.getNumber("ty", 0);
		targetArea = visionTable.getNumber("ta", 0);
		targetSkew = visionTable.getNumber("ts", 0);
		targetAquired = visionTable.getNumber("tv", 0);
	}
	
	public void changeLedMode(int num) {
		visionTable.putNumber("ledMode", num);
	}
	
	public void changeVisionMode(int num) {
		visionTable.putNumber("camMode", num);
	}
	
	public void changePipeline(int num) {
		visionTable.putNumber("pipeline", num);
	}
	
	public int targetAcquired() {
		return (int)targetAquired;
	}
	public double getXOffset() {
		return xOffset;
	}
	public double getYOffset() {
		return yOffset;
	}
	public double getTargetArea() {
		return targetArea;
	}
	public double getRotation() {
		return targetSkew;
	}

    public void initDefaultCommand() {
        setDefaultCommand(new SeekBox());
    }
}
