package org.usfirst.frc.team6334.robot.commands;
 
import edu.wpi.first.wpilibj.Joystick;
 
/**
 *
 */
public class LiftDrive extends CommandBase {
  
  Joystick elevatorStick;
  
    public LiftDrive() {
        requires(lift);
    }
 
    // Called just before this Command runs the first time
    protected void initialize() {
      elevatorStick = oi.getElevatorStick();
    }
 
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
      double throttle = elevatorStick.getY();
      if (Math.abs(throttle) > 0.05) {
        lift.setLiftPower(throttle);
      } else {
        lift.setLiftPower(0);
      }
 
        
          
    }
 
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }
 
    // Called once after isFinished returns true
    protected void end() {
    }
    
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	lift.setLiftPower(0);
    }
}
 