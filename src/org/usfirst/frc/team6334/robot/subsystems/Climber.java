package org.usfirst.frc.team6334.robot.subsystems;

import org.usfirst.frc.team6334.robot.RobotMap;
import org.usfirst.frc.team6334.robot.commands.ClimbDrive;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	WPI_TalonSRX lift1, lift2, pivot;
	
	Double climbThrottle, pivotThrottle;
	
	public Climber() {
		lift1 = new WPI_TalonSRX(RobotMap.climberLift1);
		lift2 = new WPI_TalonSRX(RobotMap.climberLift2);
		pivot = new WPI_TalonSRX(RobotMap.hookPivot);
		
		lift1.setNeutralMode(NeutralMode.Brake);
		lift2.setNeutralMode(NeutralMode.Brake);
		pivot.setNeutralMode(NeutralMode.Brake);
	}
	
	public void raiseClimber(double val, boolean override) {
		if(Math.abs(val) < 0.05) val = 0;
		if(!override) climbThrottle = -Math.abs(val);
		else climbThrottle = val;
		lift1.set(climbThrottle);
		lift2.set(climbThrottle);
	}
	
	public void raisePivot(double val) {
		pivotThrottle = val;
		pivot.set(pivotThrottle);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ClimbDrive());
    }
}

