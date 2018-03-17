package org.usfirst.frc.team6334.robot.commands;

import org.usfirst.frc.team6334.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class autoLeftToRightScale extends CommandGroup {

    public autoLeftToRightScale() {
//    	addSequential(new autoResetSensors());				//Reset sensors to zero them
//    	addSequential(new moveDistanceX(1, 0.2));			//Accelerate
//    	addSequential(new moveDistanceX(1, 0.3));			//Accelerate
//        addSequential(new moveDistanceX(1, 0.4));			//Accelerate
//        addSequential(new moveDistanceX(1, 0.5));			//Accelerate
//        addSequential(new moveDistanceX(1, 0.6));			//Accelerate
//        addSequential(new moveDistanceX(125, 0.70));		//Move forward
//        addSequential(new moveDistanceX(30, 0.20));			//Decelerate
//        addSequential(new autoTurn(80, 0.3, 1));			//Turn to pass through middle
//        addSequential(new moveDistanceX(180, 0.5));			//Move forward
//        addParallel(new autoLift(RobotMap.scaleHeight));	//Lift up
//        addSequential(new moveDistanceX(15, 0.2));			//Decelerate
//        addSequential(new autoTurn(0.01, 0.3, -1), 3);			//Turn towards scale
//        addSequential(new moveDistanceX(6, 0.3));			//Move forward
//        addSequential(new moveDistanceX(28, 0.5));			//Move forward
//        addSequential(new moveDistanceX(3, 0.2));			//Move forward
//        addSequential(new autoTurn(-80, 0.3, -1), 3);			//Actually turn to scale
//        addSequential(new moveDistanceX(26, 0.2), 2);			//Straighten out
//        addSequential(new autoIntake(true, 1));			//Eject cube
//        addSequential(new moveDistanceX(20, -0.3));			//Move Backwards
//        addSequential(new autoLift(RobotMap.resetHeight));	//Lower lift
    }
}
