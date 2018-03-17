package org.usfirst.frc.team6334.robot.commands;

import org.usfirst.frc.team6334.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class autoRightToLeftSwitch extends CommandGroup {

    public autoRightToLeftSwitch() {
    	addSequential(new autoResetSensors());				//Reset sensors to zero them
        addSequential(new moveDistanceX(180, 0.70, true));		//Move forward
        addSequential(new moveDistanceX(30, 0.20, true));			//Decelerate
        addSequential(new autoTurn(-85, 0.4, -1), 1.5);			//Turn to pass through middle
        addParallel(new autoLift(RobotMap.switchHeight));	//Lift up
        addSequential(new moveDistanceX(115, 0.7, true));			//Move forward
        addSequential(new moveDistanceX(15, 0.2, true));			//Decelerate
        addSequential(new autoTurn(-175, 0.45, -1), 2);			//Turn towards switch
        addSequential(new moveDistanceX(18, 0.3, true), 1);
        addSequential(new autoIntake(true, 0.5));
        
        //Not tested, remove if problems arise.
        addParallel(new autoLift(RobotMap.resetHeight));
        addSequential(new moveDistanceX(24, -0.3, true), 1);
        addSequential(new autoTurn(-165, 0.45, 1), 1);
        addSequential(new moveDistanceX (24, 0.3, true), 1);
        addSequential(new autoIntake(false, 1), 1.01);
        addSequential(new autoLift(RobotMap.switchHeight));
        addSequential(new autoTurn(-175, 0.45, -1), 1);
        addSequential(new moveDistanceX (12, 0.4, true), 1);
        addSequential(new autoIntake(true, 1), 1.01);
    }
}
