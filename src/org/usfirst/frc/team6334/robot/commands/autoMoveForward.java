package org.usfirst.frc.team6334.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class autoMoveForward extends CommandGroup {

    public autoMoveForward() {
        addSequential(new moveDistanceX(168, 0.3, true));
        addSequential(new moveDistanceX(3, -0.1, true));
        addSequential(new moveDistanceX(3, 0.1, true));
    }
}
