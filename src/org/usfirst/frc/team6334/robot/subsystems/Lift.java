package org.usfirst.frc.team6334.robot.subsystems;

import org.usfirst.frc.team6334.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.Encoder;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lift extends Subsystem {
	
	VictorSP LiftMotor;
	Encoder liftEncoder;
	
    public void initDefaultCommand() {
    	LiftMotor = new VictorSP(RobotMap.Lift);
    	
    	liftEncoder = new Encoder(RobotMap.liftEncIn, RobotMap.liftEncOut, false, Encoder.EncodingType.k4X);
    }
    
  /** Use y-axis of aux-stick to test positions. We can add buttons to control up 
      and down functions of the lift, or just set certain positions of the lift with buttons, such as high
      position for the scale and low position for switches.
     **/
    
	public void setLiftValue(double auxStick){         
		LiftMotor.set(auxStick);
	}
	
    public void liftMechanism(double auxStick){
    	
    	if(Math.abs(auxStick) > 1){
    		auxStick = 0.98;	
    	}
    	if(Math.abs(auxStick) <= -1)
    		auxStick = -0.98;
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
	
}