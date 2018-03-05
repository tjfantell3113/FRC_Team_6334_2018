package org.usfirst.frc.team6334.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
@SuppressWarnings("static-access")
public class Vision extends Subsystem {
	
	public Vision() {
		
	}
	/*
	NetworkTable visionTable;
	NetworkTableEntry tx, ty, ta, tv, ts;
	double xOffset, yOffset, targetArea, targetSkew, targetAquired;
	
	public Vision() {
		visionTable = NetworkTableInstance.getDefault().getTable("limelight");
		tx = visionTable.getInstance().getDefault().getTable("limelight").getEntry("tx");
		ty = visionTable.getInstance().getDefault().getTable("limelight").getEntry("ty");
		ta = visionTable.getInstance().getDefault().getTable("limelight").getEntry("ta");
		tv = visionTable.getInstance().getDefault().getTable("limelight").getEntry("tv");
		ts = visionTable.getInstance().getDefault().getTable("limelight").getEntry("ts");
	}
	
	public void changeLedMode(int num) {
		visionTable.getInstance().getDefault().getTable("limelight").getEntry("ledMode").setNumber(num);
	}
	
	public void changeVisionMode(int num) {
		visionTable.getInstance().getDefault().getTable("limelight").getEntry("camMode").setNumber(num);
	}
	
	public void changePipeline(int num) {
		visionTable.getInstance().getDefault().getTable("limelight").getEntry("pipeline").setNumber(num);
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
    }*/

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}
