package org.usfirst.frc.team6334.robot.commands;

import org.usfirst.frc.team6334.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class autoCenterToRightSwitchTwoCube extends CommandGroup {

    public autoCenterToRightSwitchTwoCube() {
    	addSequential(new autoResetSensors());
        addSequential(new moveDistanceX(24, 0.4, true));
        addSequential(new autoTurn(30, 0.3, 1), 3);
        addParallel(new autoLift(RobotMap.switchHeight));
        addSequential(new moveDistanceX(23, 0.4, true), 3);
        addSequential(new autoTurn(0.01, 0.35, -1), 1.5);
        addSequential(new moveDistanceX(24, 0.4, true), 1.5);
        addSequential(new autoIntake(true, 1), 1.1);
        addSequential(new moveDistanceX(24, -0.3, true));
        addParallel(new autoLift(RobotMap.resetHeight));
        
    	//2nd cube
        addSequential(new moveDistanceX(18, -0.3, true));
        addParallel(new autoLift(RobotMap.resetHeight));
        addSequential(new autoTurn(-75, 0.45, -1), 1);
        addParallel(new autoIntake(false, 1), 1);
        addParallel(new autoLift(RobotMap.switchHeight));
        addSequential(new moveDistanceX(50, 0.5, true), 1);
        addSequential(new autoTurn(-0.01, 0.45, 1), 1);
        addSequential(new moveDistanceX(18, 0.3, true));
        addSequential(new autoIntake(true, 1), 1);
    }
}
