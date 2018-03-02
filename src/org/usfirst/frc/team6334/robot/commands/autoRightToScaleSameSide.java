package org.usfirst.frc.team6334.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class autoRightToScaleSameSide extends CommandGroup {

    public autoRightToScaleSameSide() {
    	System.out.println("In command");
    	addSequential(new autoResetSensors());
    	System.out.println("Sensors reset");
        //addParallel(new autoLift(30400));
        System.out.println("lift up");
        addSequential(new moveDistanceX(6, 0.3));
        System.out.println("move 1");
        addSequential(new autoTurn(10, 0.3, 1));
        addSequential(new moveDistanceX(36, 0.3));
        addSequential(new autoTurn(6.5, 0.3, -1));
        addSequential(new moveDistanceX(1, 0.4));
        System.out.println("move 1");
        addSequential(new moveDistanceX(1, 0.5));
        System.out.println("move 1");
        addSequential(new moveDistanceX(160, 0.7));
        System.out.println("move 180");
        addSequential(new moveDistanceX(15, 0.3));
        System.out.println("move 15");
        addSequential(new moveDistanceX(35, 0.1));
        System.out.println("move 55");
        addSequential(new moveDistanceX(5, -0.3));
        addSequential(new autoTurn(-80, 0.35, -1));
        System.out.println("turn");
        addSequential(new moveDistanceX(2, 0));
        addSequential(new moveDistanceX(3, 0.15));
        System.out.println("move 3");
        addSequential(new autoIntake(true, 1));
        System.out.println("intake"); 
        addSequential(new moveDistanceX(12, -0.3));
        System.out.println("move back 2 feet");
        //addParallel(new autoLift(100));
        System.out.println("lift down");
        addSequential(new autoTurn(-153, 0.35, -1));
        System.out.println("turn");
        addSequential(new moveDistanceX(70, 0.5));
        System.out.println("Turning to box.");
        //addSequential(new TurnToBox());
        System.out.println("Moving to grab.");
        //addSequential(new autoGrabBox());
    }
}
