package org.usfirst.frc.team6334.robot.commands;

import org.usfirst.frc.team6334.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class autoCenterToLeftSwitchTwoCube extends CommandGroup {

    public autoCenterToLeftSwitchTwoCube() {
    	addSequential(new autoResetSensors());
        addSequential(new moveDistanceX(24, 0.4, true), 2);
        addParallel(new autoLift(RobotMap.switchHeight));
        addSequential(new autoTurn(-60, 0.4, -1), 1.5);
        addSequential(new moveDistanceX(57, 0.4, true), 2);
        addSequential(new autoTurn(0.01, 0.4, 1), 1.5);
        addSequential(new moveDistanceX(50, 0.4, true), 1);
        addSequential(new autoIntake(true, 1), 1);
        addSequential(new moveDistanceX(24, -0.3, true));
        addParallel(new autoLift(RobotMap.resetHeight));
        
        //2nd cube
        addSequential(new moveDistanceX(18, -0.3, true));
        addSequential(new autoTurn(35, 0.4, 1), 1);
        addParallel(new autoIntake(false, 2), 2);
        addSequential(new moveDistanceX(12, 0.25, true), 1);
        addParallel(new autoLift(RobotMap.switchHeight));
        addSequential(new moveDistanceX(50, -0.4, true), 1);
        addSequential(new autoTurn(5, 0.45, -1), 1);
        addSequential(new moveDistanceX(42, 0.25, true));
        addSequential(new autoIntake(true, 1), 1);
    }
}
