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
        addParallel(new autoLift(30400));
        System.out.println("lift up");
        addSequential(new moveDistanceX(1, 0.3));
        System.out.println("move 15");
        addSequential(new moveDistanceX(1, 0.4));
        System.out.println("move 15");
        addSequential(new moveDistanceX(1, 0.5));
        System.out.println("move 15");
        addSequential(new moveDistanceX(175, 0.7));
        System.out.println("move 15");
        addSequential(new moveDistanceX(50, 0.3));
        System.out.println("move 15");
        addSequential(new moveDistanceX(25, 0.1));
        System.out.println("move 15");
        addSequential(new autoTurn(-90, 0.35));
        System.out.println("turn");
        addSequential(new moveDistanceX(6, 0.2));
        System.out.println("move 1 foot");
        addSequential(new autoIntake(true, 1));
        System.out.println("intake"); 
        addSequential(new moveDistanceX(12, -0.3));
        System.out.println("move back 2 feet");
        addSequential(new moveDistanceX(12, -0.3));
        System.out.println("move back 2 feet");
        addParallel(new autoLift(100));
        System.out.println("lift down");
        addSequential(new autoTurn(-160, 0.3));
        System.out.println("turn");
        addSequential(new moveDistanceX(85, 0.5));
    }
}
