package org.usfirst.frc.team6334.robot.subsystems;

import org.usfirst.frc.team6334.robot.RobotMap;
import org.usfirst.frc.team6334.robot.commands.LiftDrive;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lift extends Subsystem {
	
	WPI_TalonSRX liftMotor1, liftMotor2;
	int kP, kI;
	
    public Lift() {
    	liftMotor1 = new WPI_TalonSRX(RobotMap.liftMotor1);
    	liftMotor2 = new WPI_TalonSRX(RobotMap.liftMotor2);
    	
    	liftMotor2.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1, 10);
		liftMotor2.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
    }
    
	/* Use y-axis of aux-stick to test positions. We can add buttons to control up 
	and down functions of the lift, or just set certain positions of the lift with buttons, such as high
	position for the scale and low position for switches. */
    
	public void setLiftPower(double throttle){         
		
		
		/*if(getEncoderPos() < RobotMap.liftLowerBound) {
			liftMotor1.set(-0.25);
			liftMotor2.set(-0.25);
		} else if (getEncoderPos() > RobotMap.liftUpperBound) {
			liftMotor1.set(0.25);
			liftMotor2.set(0.25);
		} else {
			liftMotor1.set(throttle);
			liftMotor2.set(throttle);
		}*/
		
		liftMotor1.set(-throttle);
		liftMotor2.set(-throttle);
	}

	public void resetEncoderPos() {
		liftMotor2.setSelectedSensorPosition(0, 0, 10);
	}
	
	public int getEncoderPos() {
		return liftMotor2.getSelectedSensorPosition(0);
	}
	
	public boolean inBoundaries() {
		int pos = getEncoderPos();
		if (pos > RobotMap.liftUpperBound || pos < RobotMap.liftLowerBound) {
			return false;
		} else {
			return true;
		}
	}
	
	public double getEncoderRate() {
		return liftMotor2.getSelectedSensorVelocity(0);
	}
	
	public void liftPos1(){   	
    	if(getEncoderPos() < RobotMap.liftPos1) {
    		setLiftPower(1);
    	} else if (getEncoderPos() > RobotMap.liftPos1) {
    		setLiftPower(-1);
    	} else {
    		setLiftPower(0);
    	}
    }
	
	public void initDefaultCommand() {
        setDefaultCommand(new LiftDrive());
    }
	
}