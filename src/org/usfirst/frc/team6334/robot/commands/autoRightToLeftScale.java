package org.usfirst.frc.team6334.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;


public class autoRightToLeftScale extends CommandGroup {

    public autoRightToLeftScale() {
    	System.out.println("In command");
    	addSequential(new autoResetSensors());
    	System.out.println("Sensors reset");
        //addParallel(new autoLift(30400));
        //System.out.println("lift up");
    	addSequential(new moveDistanceX(1, 0.2));
    	addSequential(new moveDistanceX(1, 0.3));
        addSequential(new moveDistanceX(1, 0.4));
        System.out.println("move 1");
        addSequential(new moveDistanceX(1, 0.5));
        System.out.println("move 1");
        addSequential(new moveDistanceX(1, 0.6));
        System.out.println("move 1");
        addSequential(new moveDistanceX(125, 0.70));
        System.out.println("move 130");
        addSequential(new moveDistanceX(30, 0.20));
        addSequential(new autoTurn(80, -0.3));
        addSequential(new moveDistanceX(178, 0.5));
        addSequential(new autoTurn(0, 0.3));
        addSequential(new moveDistanceX(6, 0.1));
        addSequential(new moveDistanceX(45, 0.5));
        addSequential(new moveDistanceX(1, 0.2));
        //addSequential(new autoTurn(90, 0.6));
        //addSequential(new moveDistanceX(140, 0.70));
        /*
        System.out.println("move 15");
        addSequential(new moveDistanceX(55, 0.1));
        System.out.println("move 55");
        addSequential(new autoTurn(90, 0.35));
        System.out.println("turn");
        addSequential(new moveDistanceX(3, 0.2));
        System.out.println("move 3");
        addSequential(new autoIntake(true, 1));
        System.out.println("intake"); 
        addSequential(new moveDistanceX(12, -0.3));
        System.out.println("move back 2 feet");
        addSequential(new moveDistanceX(12, -0.3));
        System.out.println("move back 2 feet");
        //addParallel(new autoLift(100));
        System.out.println("lift down");
        addSequential(new autoTurn(160, 0.35));
        System.out.println("turn");
        addSequential(new moveDistanceX(70, 0.5));
        System.out.println("Turning to box.");
        //addSequential(new TurnToBox());
        System.out.println("Moving to grab.");
        //addSequential(new autoGrabBox());
         * */
    }
}
