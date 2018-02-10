package org.usfirst.frc.team6334.robot.subsystems;
 
import edu.wpi.first.wpilibj.DoubleSolenoid;
//import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6334.robot.RobotMap;
import org.usfirst.frc.team6334.robot.commands.IntakeDrive;
 
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
 
public class Intake extends Subsystem {
 
  WPI_TalonSRX right, left;
  DoubleSolenoid intakeSolenoid;
  Boolean solenoidState;
  
  public Intake(){
    right = new WPI_TalonSRX(RobotMap.intakeRight);
    left = new WPI_TalonSRX(RobotMap.intakeLeft);
    
    left.setInverted(true); //Inverted motor subject to change
    intakeSolenoid = new DoubleSolenoid(RobotMap.intakeRevert, RobotMap.intakeExpand);
    solenoidState = false;
  }
  
  public void setIntakePower(double throttle) {
    right.set(throttle);
    left.set(throttle);
  }
  
    public void initDefaultCommand() {
        setDefaultCommand(new IntakeDrive());
    }
    
    public void changeSolenoidState() {
      if (solenoidState) {
        intakeSolenoid.set(DoubleSolenoid.Value.kReverse);
        solenoidState = !solenoidState;
      } else {
        intakeSolenoid.set(DoubleSolenoid.Value.kForward);
        solenoidState = !solenoidState;
      }
    }
}
 
 