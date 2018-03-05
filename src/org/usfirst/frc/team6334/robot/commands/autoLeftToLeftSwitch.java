package org.usfirst.frc.team6334.robot.commands;

import org.usfirst.frc.team6334.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class autoLeftToLeftSwitch extends CommandGroup {

    public autoLeftToLeftSwitch() {
    	addSequential(new autoResetSensors());		//Reset the sensors to zero them.
    	addSequential(new moveDistanceX(3, 0.2));	//Accelerate
    	addSequential(new moveDistanceX(3, 0.3));	//Accelerate
        addSequential(new moveDistanceX(3, 0.4));	//Accelerate
        addSequential(new moveDistanceX(72, 0.7));	//Move forward
        addSequential(new moveDistanceX(5, -0.3));	//Decelerate
        addSequential(new moveDistanceX(5, 0.3));	//Decelerate
        addParallel(new autoLift(RobotMap.switchHeight));
        addSequential(new moveDistanceX(5, -0.3));	//Decelerate
        addSequential(new moveDistanceX(5, 0.3));	//Decelerate
        addSequential(new autoTurn(85, 0.35, 1), 3);	//Turn to switch
        addSequential(new moveDistanceX(36, 0.35), 2);	//Move to switch
        addSequential(new autoIntake(true, 1), 1.1);	//Eject the box
        addSequential(new moveDistanceX(6, -0.3)); 	//Move back to get ready to turn to be tele-op ready.
        addSequential(new autoTurn(0.01, 0.35, -1));	//Turn to front
        addSequential(new moveDistanceX(60, -0.3));
    }
}
