package org.usfirst.frc.team6334.robot.commands;

import org.usfirst.frc.team6334.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class autoCenterToRightSwitch extends CommandGroup {

    public autoCenterToRightSwitch() {
        addSequential(new moveDistanceX(48, 0.4));
        addSequential(new autoTurn(35, 0.4, 1), 3);
        addParallel(new autoLift(RobotMap.switchHeight));
        addSequential(new moveDistanceX(47, 0.4), 3);
        addSequential(new autoTurn(0.01, 0.35, -1), 3);
        addSequential(new moveDistanceX(54, 0.4), 3);
        addSequential(new autoIntake(true, 1), 1.1);
        addSequential(new moveDistanceX(24, -0.3));
        addParallel(new autoLift(RobotMap.resetHeight));
    }
}
