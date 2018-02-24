package org.usfirst.frc.team6334.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Vision extends Subsystem {
	NetworkTable visionTable;
	double xOffset, yOffset, targetArea, targetSkew, targetAquired;
	
	public Vision() {
		visionTable = NetworkTableInstance.getDefault().getTable("limelight");
		NetworkTableEntry tx = visionTable.getEntry("tx");
		NetworkTableEntry ty = visionTable.getEntry("ty");
		NetworkTableEntry ta = visionTable.getEntry("ta");
		NetworkTableEntry tv = visionTable.getEntry("tv");
		NetworkTableEntry ts = visionTable.getEntry("ts");
		xOffset = tx.getDouble(0);
		yOffset = ty.getDouble(0);
		targetAquired = tv.getDouble(0);
		targetArea = ta.getDouble(0);
		targetSkew = ts.getDouble(0);
	}
	
	public void changeLedMode(int num) {
		visionTable.getEntry("ledMode").setDouble(num);
	}
	
	public void changeVisionMode(int num) {
		visionTable.getEntry("camMode").setDouble(num);
	}
	
	public void changePipeline(int num) {
		visionTable.getEntry("pipeline").setDouble(num);
	}
	
	public double targetAcquired() {
		return targetAquired;
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
    }
}
