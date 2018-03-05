package org.usfirst.frc.team6334.robot.subsystems;

import org.usfirst.frc.team6334.robot.RobotMap;
import org.usfirst.frc.team6334.robot.commands.LiftDrive;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Lift extends Subsystem {
	
	WPI_TalonSRX liftMotor1, liftMotor2;
	int updateBoundries;
	
    public Lift() {
    	liftMotor1 = new WPI_TalonSRX(RobotMap.liftMotor1);
    	liftMotor2 = new WPI_TalonSRX(RobotMap.liftMotor2);
    	
    	liftMotor1.setNeutralMode(NeutralMode.Brake);
    	liftMotor2.setNeutralMode(NeutralMode.Brake);
    	
    	liftMotor2.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1, 10);
		liftMotor2.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 10);
		liftMotor2.setSelectedSensorPosition(0, 0, 10);
		updateBoundries = 0;
    }
    
	/* Use y-axis of aux-stick to test positions. We can add buttons to control up 
	and down functions of the lift, or just set certain positions of the lift with buttons, such as high
	position for the scale and low position for switches. */
    
	public void setLiftPower(double throttle, boolean override){         
		if(Math.abs(throttle) < 0.07) throttle = 0;
		
		/*
		if(override) {
			liftMotor1.set(-throttle);
			liftMotor2.set(-throttle);
		} else if(getEncoderPos() < (RobotMap.liftLowerBound + updateBoundries)) {
			liftMotor1.set(0.25);
			liftMotor2.set(0.25);
		} else if (getEncoderPos() > (RobotMap.liftUpperBound + updateBoundries)) {
			liftMotor1.set(-0.25);
			liftMotor2.set(-0.25);
		} else {
			liftMotor1.set(-throttle);
			liftMotor2.set(-throttle);
		} */
		
		liftMotor1.set(-throttle);
		liftMotor2.set(-throttle);
	}

	public void resetEncoderPos() {
		liftMotor2.setSelectedSensorPosition(0, 0, 10);
	}
	
	public int getEncoderPos() {
		return liftMotor2.getSelectedSensorPosition(0);
	}
	
	public boolean inBoundries() {
		int pos = getEncoderPos();
		if (pos > RobotMap.liftUpperBound || pos < RobotMap.liftLowerBound) {
			return false;
		} else {
			return true;
		}
	}
	
	public void updateBoundries() {
		updateBoundries = getEncoderPos();
	}
	
	public double getEncoderRate() {
		return liftMotor2.getSelectedSensorVelocity(0);
	}
	
	public void liftPosMin(){   	
    	if(getEncoderPos() < RobotMap.liftPosMin) {
    		setLiftPower(1, false);
    	} else if (getEncoderPos() > RobotMap.liftPosMin) {
    		setLiftPower(-1, false);
    	} else {
    		setLiftPower(0, false);
    	}
    }
	
	public void liftPosMax(){   	
    	if(getEncoderPos() < RobotMap.liftPosMax) {
    		setLiftPower(1, false);
    	} else if (getEncoderPos() > RobotMap.liftPosMax) {
    		setLiftPower(-1, false);
    	} else {
    		setLiftPower(0, false);
    	}
    }
	
	public void updateDash() {
		SmartDashboard.putNumber("LiftEncoder Position", getEncoderPos());
	}
	
	public void initDefaultCommand() {
        setDefaultCommand(new LiftDrive());
    }
	
}