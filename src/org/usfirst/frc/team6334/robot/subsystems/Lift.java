package org.usfirst.frc.team6334.robot.subsystems;

import org.usfirst.frc.team6334.robot.RobotMap;
import org.usfirst.frc.team6334.robot.commands.LiftDrive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lift extends Subsystem {
	
	WPI_TalonSRX liftMotor1, liftMotor2;
	Encoder liftEncoder;
	int kP, kI;
	
    public Lift() {
    	liftMotor1 = new WPI_TalonSRX(RobotMap.liftMotor1);
    	liftMotor2 = new WPI_TalonSRX(RobotMap.liftMotor2);
    	
    	liftEncoder = new Encoder(RobotMap.liftEncIn, RobotMap.liftEncOut, false, Encoder.EncodingType.k4X);
    }
    
	/* Use y-axis of aux-stick to test positions. We can add buttons to control up 
	and down functions of the lift, or just set certain positions of the lift with buttons, such as high
	position for the scale and low position for switches. */
    
	public void setLiftPower(double throttle){         
		liftMotor1.set(throttle);
		liftMotor2.set(throttle);
	}

	public void resetEncoderPos() {
		liftEncoder.reset();
	}
	
	public int getEncoderPos() {
		return liftEncoder.get();
	}
	
	public double getEncoderRate() {
		return liftEncoder.getRate();
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