package org.usfirst.frc.team6334.robot.subsystems;

//import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6334.robot.RobotMap;

/**
 * I started this, but then realized that I don't know the number of solenoids we are going to use.
 */
public class Intake extends Subsystem {

	//private Solenoid intakeUp, intakeDown;
	
	public Intake(){
		//intakeUp = new Solenoid(RobotMap.intakeUp);
		//intakeDown = new Solenoid(RobotMap.intakeDown);
	}
	
	public void changePosition() {
		
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

