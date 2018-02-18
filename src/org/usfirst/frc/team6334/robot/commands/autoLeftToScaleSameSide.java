package org.usfirst.frc.team6334.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class autoLeftToScaleSameSide extends CommandGroup {

    public autoLeftToScaleSameSide() {
        addSequential(new moveDistanceX(175));
        addParallel(new moveDistanceX(140));
        addParallel(new autoLift(31000));
        addSequential(new autoTurn(-90));
        addSequential(new moveDistanceX(12));
        addSequential(new autoIntake(true, 1));
    }
}
