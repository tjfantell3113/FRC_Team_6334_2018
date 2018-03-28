package org.usfirst.frc.team6334.robot.commands;

import org.usfirst.frc.team6334.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class autoCenterToLeftSwitchTwoCube extends CommandGroup {

    public autoCenterToLeftSwitchTwoCube() {
    	addSequential(new autoResetSensors());
        addSequential(new moveDistanceX(24, 0.5, true), 2);
        addParallel(new autoLift(RobotMap.switchHeight));
        addSequential(new autoTurn(-60, 0.4, -1), 1.5);
        addSequential(new moveDistanceX(50, 0.5, true), 2);
        addSequential(new autoTurn(0.01, 0.4, 1), 1.5);
        addSequential(new moveDistanceX(30, 0.5, true), 1);
        addSequential(new autoIntake(true, 0.5), 0.5);
        
        //2nd cube
        addSequential(new moveDistanceX(18, -0.3, true));
        addParallel(new autoLift(RobotMap.resetHeight));
        addSequential(new autoTurn(75, 0.45, 1), 1);
        addParallel(new autoIntake(false, 1), 1);
        addParallel(new autoLift(RobotMap.switchHeight));
        addSequential(new moveDistanceX(30, 0.5, true), 1);
        addSequential(new autoTurn(0.01, 0.45, -1), 1);
        addSequential(new moveDistanceX(18, 0.3, true));
        addSequential(new autoIntake(true, 1), 1);
    }
}
