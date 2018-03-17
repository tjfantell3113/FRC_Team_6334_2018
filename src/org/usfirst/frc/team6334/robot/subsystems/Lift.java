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
	
	WPI_TalonSRX liftMotor;
	int updateBoundries;
	
    public Lift() {
    	liftMotor = new WPI_TalonSRX(RobotMap.liftMotor);
    	
    	liftMotor.setNeutralMode(NeutralMode.Brake);
    	
    	liftMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1, 10);
		liftMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 10);
		updateBoundries = 0;
    }
    
	/* Use y-axis of aux-stick to test positions. We can add buttons to control up 
	and down functions of the lift, or just set certain positions of the lift with buttons, such as high
	position for the scale and low position for switches. */
    
	public void setLiftPower(double throttle, boolean override){         
		if(Math.abs(throttle) < 0.07) throttle = 0;
		if(override) {
			liftMotor.set(-throttle);
			//liftMotor2.set(-throttle);
		} else if(getEncoderPos() < (-10 + updateBoundries)) {
			liftMotor.set(0.1);
			//liftMotor2.set(0.25);
		} else if (getEncoderPos() > (24000 + updateBoundries)) {
			liftMotor.set(-0.1);
			//liftMotor2.set(-0.25);
		} else {
			liftMotor.set(-throttle);
			//liftMotor2.set(-throttle);
		}
		
		liftMotor.set(-throttle);
	}

	public void resetEncoderPos() {
		liftMotor.setSelectedSensorPosition(0, 0, 10);
	}
	
	public int getEncoderPos() {
		return liftMotor.getSelectedSensorPosition(0);
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
		return liftMotor.getSelectedSensorVelocity(0);
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