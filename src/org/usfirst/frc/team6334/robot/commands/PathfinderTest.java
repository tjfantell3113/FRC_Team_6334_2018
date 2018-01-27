package org.usfirst.frc.team6334.robot.commands;

import org.usfirst.frc.team6334.robot.RobotMap;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;

/**
 *
 */
public class PathfinderTest extends CommandBase {

    @SuppressWarnings("unused")
	public PathfinderTest() {
    	// Create the Trajectory Configuration
    	//
    	// Arguments:
    	// Fit Method:          HERMITE_CUBIC or HERMITE_QUINTIC
    	// Sample Count:        SAMPLES_HIGH (100 000)
    	//    	                SAMPLES_LOW  (10 000)
    	//    	                SAMPLES_FAST (1 000)
    	Trajectory.Config config = new Trajectory.Config(
    			Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH,
    			RobotMap.timeStep, RobotMap.maxVel, RobotMap.maxAccel, RobotMap.maxJerk);
    	
        Waypoint[] points = new Waypoint[] {
                new Waypoint(0, 0, 0), //Waypoints take a x, a y, and an angle.
                new Waypoint(1, 0, Pathfinder.d2r(45)), //d2r is degrees to radians
                new Waypoint(2, 1, 0)
        };

        //wheel diameter = 6 inches
        Trajectory trajectory = Pathfinder.generate(points, config);
        TankModifier modifier = new TankModifier(trajectory).modify(RobotMap.wheelBase);
        Trajectory left = modifier.getLeftTrajectory();
        Trajectory right = modifier.getRightTrajectory();
        
        EncoderFollower efl = new EncoderFollower(left);
        EncoderFollower efr = new EncoderFollower(right);
        efl.configureEncoder(driveTrain.getLeftEncoderPos(), RobotMap.encDriveTicks, RobotMap.wheelDiameter);
        efl.configureEncoder(driveTrain.getRightEncoderPos(), RobotMap.encDriveTicks, RobotMap.wheelDiameter);
        efr.configurePIDVA(RobotMap.kp, RobotMap.ki, RobotMap.kd, RobotMap.kv, RobotMap.ka);
        efl.configurePIDVA(RobotMap.kp, RobotMap.ki, RobotMap.kd, RobotMap.kv, RobotMap.ka);
        
        
        // Do something with the new Trajectories...
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
    }
}
