package org.usfirst.frc.team6334.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LimelightTest extends CommandGroup {

    public LimelightTest() {
    	System.out.println("In command");
    	addSequential(new autoResetSensors());
    	System.out.println("Sensors reset");
        addSequential(new SeekBox());
    }
}
