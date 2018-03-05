package org.usfirst.frc.team6334.robot.commands;

import org.usfirst.frc.team6334.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class autoRightToLeftSwitch extends CommandGroup {

    public autoRightToLeftSwitch() {
    	addSequential(new autoResetSensors());				//Reset sensors to zero them
    	addSequential(new moveDistanceX(1, 0.2));			//Accelerate
    	addSequential(new moveDistanceX(1, 0.3));			//Accelerate
        addSequential(new moveDistanceX(1, 0.4));			//Accelerate
        addSequential(new moveDistanceX(1, 0.5));			//Accelerate
        addSequential(new moveDistanceX(1, 0.6));			//Accelerate
        addSequential(new moveDistanceX(125, 0.70));		//Move forward
        addSequential(new moveDistanceX(30, 0.20));			//Decelerate
        addSequential(new autoTurn(-80, 0.3, -1));			//Turn to pass through middle
        addSequential(new moveDistanceX(135, 0.5));			//Move forward
        addSequential(new moveDistanceX(15, 0.2));			//Decelerate
        addParallel(new autoLift(RobotMap.switchHeight));	//Lift up
        addSequential(new autoTurn(-170, 0.35, -1),2);			//Turn towards switch
        addSequential(new moveDistanceX(18, 0.3), 2);
        addSequential(new autoIntake(true, 0.5));
        addSequential(new moveDistanceX(18, -0.3));
        addSequential(new autoLift(RobotMap.resetHeight));
    }
}
