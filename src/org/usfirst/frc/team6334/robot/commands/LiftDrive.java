package org.usfirst.frc.team6334.robot.commands;
 
import org.usfirst.frc.team6334.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
 
/**
 *
 */
public class LiftDrive extends CommandBase {
  
  Joystick elevatorStick;
  boolean endTask;
  
    public LiftDrive() {
        requires(lift);
    }
 
    // Called just before this Command runs the first time
    protected void initialize() {
      elevatorStick = oi.getElevatorStick();
      endTask = false;
      lift.resetEncoderPos();
    }
 
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
      double throttle = elevatorStick.getY();
      if (Math.abs(throttle) > 0.05 && !elevatorStick.getRawButton(1)) {
        lift.setLiftPower(throttle, false);
      } else {
        lift.setLiftPower(-0.065, false);
      }
      
      //override
      if (elevatorStick.getRawButton(RobotMap.liftOverride)) {
    	  lift.resetEncoderPos();
      }
      
      lift.updateDash();
      
      if(elevatorStick.getRawButton(RobotMap.endLiftTask)) {
    	  endTask = true;
      }
    }
 
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return endTask;
    }
 
    // Called once after isFinished returns true
    protected void end() {
    }
    
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	lift.setLiftPower(0, false);
    }
}
 