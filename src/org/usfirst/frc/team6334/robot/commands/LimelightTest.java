package org.usfirst.frc.team6334.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LimeLightTest extends CommandGroup {

    public LimeLightTest() {
        addSequential(new SeekBox());
    }
}
