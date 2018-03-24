package org.usfirst.frc.team6334.robot.commands;

import org.usfirst.frc.team6334.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class autoLeftToLeftSwitchThreeCube extends CommandGroup {

    public autoLeftToLeftSwitchThreeCube() {
    	addSequential(new autoResetSensors());		//Reset the sensors to zero them.
    	addParallel(new autoLift(RobotMap.switchHeight));
        addSequential(new moveDistanceX(110, 1, true));	//Move forward
        addSequential(new moveDistanceX(3, -0.3, true));	//Decelerate
        addSequential(new moveDistanceX(3, 0.3, true));	//Decelerate
        addSequential(new moveDistanceX(3, -0.3, true));	//Decelerate
        addSequential(new autoTurn(82, 0.45, 1), 2);	//Turn to switch
        addSequential(new moveDistanceX(24, 1, true), 0.5);	//Move to switch
        addSequential(new autoIntake(true, 0.5), 0.5);	//Eject the box
        
        //2nd Cube
        addSequential(new moveDistanceX(18, -1, true)); 	//Move back to get ready to turn to be tele-op ready.
        addParallel(new autoLift(RobotMap.resetHeight));  //JK, go for another cube?
        addSequential(new autoTurn(5, 0.45, -1));	//Turn to front
        addSequential(new moveDistanceX(70, 1, true));
        addSequential(new autoTurn(135, 0.4, 1), 2);	//<-------------------------------- !!!edit this angle!!!
        addSequential(new moveDistanceX(30, 0.5, true), 2);
        //addSequential(new TurnToBox(1));
        addSequential(new autoIntake(false, 1), 1.01);
        addSequential(new autoLift((RobotMap.switchHeight)));
        addSequential(new autoTurn(140, 0.45, 1));
        addSequential(new moveDistanceX(24, 0.5, true), 1);
        addSequential(new autoIntake(true, 0.5), 0.5);
        
        //3rd cube?
        addParallel(new autoLift(RobotMap.resetHeight));
        addSequential(new moveDistanceX(12, -0.5, true), 1);
        addSequential(new autoTurn(100, 0.45, -1), 1);
        addSequential(new moveDistanceX(30, 0.5, true), 1);
        addSequential(new autoIntake(false, 1), 1);
        addParallel(new autoLift(RobotMap.switchHeight));
        addSequential(new moveDistanceX(30, -0.5, true), 1);
        addSequential(new autoTurn(140, 0.45, 1), 1);
        addSequential(new moveDistanceX(12, 0.5, true), 1);
    }
}
