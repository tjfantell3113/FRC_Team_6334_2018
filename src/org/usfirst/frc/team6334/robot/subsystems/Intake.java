package org.usfirst.frc.team6334.robot.subsystems;

//import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6334.robot.RobotMap;

/**
 * I started this, but then realized that I don't know the number of solenoids we are going to use.
 */
public class Intake extends Subsystem {

	//private Solenoid intakeSolenoid;
	
	public Intake(){
		//intakeSolenoid = new Solenoid(RobotMap.intakeSolenoid);
	}
	
	public void changePosition() {
		/*if(intakeSolenoid.get()) {
			intakeSolenoid.set(false);
		}
		else {
			intakeSolenoid.set(true);
		}*/
	}
	
	public void resetIntake() {
		//intakeSolenoid.set(false);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

