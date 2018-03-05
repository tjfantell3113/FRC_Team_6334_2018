package org.usfirst.frc.team6334.robot.commands;

import org.usfirst.frc.team6334.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class autoLeftToScaleSameSide extends CommandGroup {

    public autoLeftToScaleSameSide() {
    	addSequential(new autoResetSensors());			//Reset sensors so they are zeroed
        addParallel(new autoLift(RobotMap.scaleHeight));			    //Lift Up
        addSequential(new moveDistanceX(6, 0.3));		//Move off of the wall
        addSequential(new autoTurn(-10, 0.3, -1));		//Turn towards the side (This creates a bigger gap between the robot and the scale so quick turns can be completed)
        addSequential(new moveDistanceX(36, 0.3));		//Move forward
        addSequential(new autoTurn(-6.5, 0.3, 1));		//Turn back towards, but not totally, to zero
        addSequential(new moveDistanceX(1, 0.4));		//Accelerate
        addSequential(new moveDistanceX(1, 0.5));		//Accelerate
        addSequential(new moveDistanceX(160, 0.7));		//Move to scale
        addSequential(new moveDistanceX(15, 0.3));		//Decelerate
        addSequential(new moveDistanceX(35, 0.1));		//Decelerate
        addSequential(new moveDistanceX(5, -0.3));		//"Lock up" motor controllers for incoming turn
        addSequential(new autoTurn(80, 0.35, 1));		//Turn to 90 degrees. Turning to 80 quick saves time and cancels of turn overshoot.
        addSequential(new moveDistanceX(2, 0));			//Let the robot drift towards scale
        addSequential(new moveDistanceX(3, 0.15));		//Move to the scale to drop cube.
        addSequential(new autoIntake(true, 0.5));		//Open intake
        addSequential(new moveDistanceX(20, -0.3));		//Back up to prepare for turn
        addParallel(new autoLift(RobotMap.resetHeight));					//Lift down
        addSequential(new autoTurn(153, 0.35, 1));	//Turn towards next cube (Soon to be vision controlled... hopefully)
        addSequential(new moveDistanceX(70, 0.5));		//Drive to cube
        
        //Not tested yet.
        addSequential(new autoIntake(false, 0.5));		//Intake the cube
        addSequential(new autoLift(RobotMap.switchHeight));				//Lift up to switch height
        addSequential(new moveDistanceX(5, 0.4));		//Move into scale
        addSequential(new autoIntake(true, 1));			//Drop cube into switch
        
        //Taken out to test further. Not enough test time to use these yet.
        //addSequential(new TurnToBox());
        //addSequential(new autoGrabBox());
    }
}
