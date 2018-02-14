package org.usfirst.frc.team6334.robot.commands;

import org.usfirst.frc.team6334.robot.OI;
import org.usfirst.frc.team6334.robot.subsystems.*;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
@SuppressWarnings("unused")
public abstract class CommandBase extends Command {

    public static OI oi;
    
    public static DriveTrain driveTrain;
    public static Intake intake;
    public static Lift lift;

    
    public static void init() { 
    	driveTrain = new DriveTrain();
    	intake = new Intake();
    	lift = new Lift();
    	
    	
        oi = new OI();
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
        
    }
}