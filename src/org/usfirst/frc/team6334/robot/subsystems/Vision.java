package org.usfirst.frc.team6334.robot.subsystems;

import org.usfirst.frc.team6334.robot.commands.VisionDrive;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 */
public class Vision extends Subsystem {
	
	NetworkTable visionTable;
	NetworkTableEntry tx, ty, ta, tv, ts;
	double xOffset, yOffset, targetArea, targetSkew, targetAquired;
	
	public Vision() {
		visionTable = NetworkTableInstance.getDefault().getTable("limelight");
		tx = visionTable.getEntry("tx");
		ty = visionTable.getEntry("ty");
		ta = visionTable.getEntry("ta");
		tv = visionTable.getEntry("tv");
		ts = visionTable.getEntry("ts");
		visionTable.getEntry("ledMode").setDouble(1);
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
		targetAquired = tv.getDouble(0);
		return targetAquired;
	}
	public double getXOffset() {
		xOffset = tx.getDouble(0);
		return xOffset;
	}
	public double getYOffset() {
		yOffset = ty.getDouble(0);
		return yOffset;
	}
	public double getTargetArea() {
		targetAquired = tv.getDouble(0);
		return targetArea;
	}
	public double getRotation() {
		targetSkew = ts.getDouble(0);
		return targetSkew;
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new VisionDrive());
    }
}
