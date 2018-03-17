package org.usfirst.frc.team6334.robot.commands;

import org.usfirst.frc.team6334.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class autoCenterToRightSwitch extends CommandGroup {

    public autoCenterToRightSwitch() {
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
    }
}
