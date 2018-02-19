package org.usfirst.frc.team6334.robot.subsystems;

import org.usfirst.frc.team6334.robot.RobotMap;
import org.usfirst.frc.team6334.robot.commands.Climb;

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
	
	public Climber() {
		lift1 = new WPI_TalonSRX(RobotMap.climberLift1);
		lift2 = new WPI_TalonSRX(RobotMap.climberLift2);
		pivot = new WPI_TalonSRX(RobotMap.hookPivot);
		
		lift1.setNeutralMode(NeutralMode.Brake);
		lift2.setNeutralMode(NeutralMode.Brake);
		pivot.setNeutralMode(NeutralMode.Coast);
	}
	
	public void raiseClimber(double throttle) {
		throttle = Math.abs(throttle);
		if (throttle > 0.05) {
			lift1.set(throttle);
			lift2.set(throttle);
		}
	}
	
	public void raisePivot(double throttle) {
		throttle = Math.abs(throttle);
		if (throttle > 0.05) {
			pivot.set(throttle);
		}
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new Climb());
    }
}

