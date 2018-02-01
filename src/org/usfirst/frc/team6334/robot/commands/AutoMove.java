package org.usfirst.frc.team6334.robot.commands;

import org.usfirst.frc.team6334.robot.Robot;
import org.usfirst.frc.team6334.robot.RobotMap;
import org.usfirst.frc.team6334.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoMove extends Command {
	private int target;
	private double absolute_target;
	private DriveTrain driveTrain = Robot.driveTrain;
	private double speed = 0.75;
	
    public AutoMove( int encoderCounts ) {
    	target = encoderCounts;
    }
    
    public AutoMove( int encoderCounts, double speed ){
    	this.speed = speed;
    	target = encoderCounts;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	absolute_target = driveTrain.getEncoderRateAvg() + target;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putString( 8, String.valueOf ( driveTrain.getEncoderRateAvg() ));
    	if( target > 0 ){
    		driveTrain.driveWithController( -speed, 0 );
    	}else{
    		driveTrain.driveWithController( speed, 0 );
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if( target > 0 ){
    		return driveTrain.getEncoderRateAvg() > this.absolute_target - 15.4 * this.speed;
    	}else{
    		return driveTrain.getEncoderRateAvg() < this.absolute_target + 15.4 * this.speed;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	driveTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}