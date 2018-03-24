package org.usfirst.frc.team6334.robot.commands;

import org.usfirst.frc.team6334.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class autoLeftToLeftSwitch extends CommandGroup {

    public autoLeftToLeftSwitch() {
    	addSequential(new autoResetSensors());		//Reset the sensors to zero them.
    	addParallel(new autoLift(RobotMap.switchHeight));
        addSequential(new moveDistanceX(110, 0.7, true));	//Move forward
        addSequential(new moveDistanceX(3, -0.3, true));	//Decelerate
        addSequential(new moveDistanceX(3, 0.3, true));	//Decelerate
        addSequential(new moveDistanceX(3, -0.3, true));	//Decelerate
        addSequential(new autoTurn(85, 0.45, 1), 2);	//Turn to switch
        addSequential(new moveDistanceX(24, 0.35, true), 1);	//Move to switch
        addSequential(new autoIntake(true, 1), 1.01);	//Eject the box
        
        //Not tested code... please test? If not comment out or remove limelight code.
        addSequential(new moveDistanceX(18, -0.3, true)); 	//Move back to get ready to turn to be tele-op ready.
        addParallel(new autoLift(RobotMap.resetHeight));  //JK, go for another cube?
        addSequential(new autoTurn(4, 0.35, -1));	//Turn to front
        addSequential(new moveDistanceX(70, 0.6, true));
        addSequential(new autoTurn(130, 0.4, 1), 2);	//<-------------------------------- !!!edit this angle!!!
        addSequential(new moveDistanceX(30, 0.3, true), 2);
        //addSequential(new TurnToBox(1));
        addSequential(new autoIntake(false, 1), 1.01);
        addSequential(new autoLift((RobotMap.switchHeight)));
        addSequential(new autoTurn(140, 0.45, 1));
        addSequential(new moveDistanceX(24, 0.5, true), 1);
        addSequential(new autoIntake(true, 1), 1.01);
    }
}
