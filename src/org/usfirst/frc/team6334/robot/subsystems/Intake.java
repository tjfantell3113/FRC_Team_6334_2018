package org.usfirst.frc.team6334.robot.subsystems;

//import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6334.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Intake extends Subsystem {

	WPI_TalonSRX right, left;
	
	public Intake(){
		right = new WPI_TalonSRX(RobotMap.intakeRight);
		left = new WPI_TalonSRX(RobotMap.intakeLeft);
		
		left.setInverted(true); //Inverted motor subject to change
	}
	
	public void setIntakePower(double throttle) {
		right.set(throttle);
		left.set(throttle);
	}
	
    public void initDefaultCommand() {
        //setDefaultCommand(new IntakeDrive());
    }
}

