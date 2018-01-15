package org.usfirst.frc.team6334.robot.commands;

import org.usfirst.frc.team6334.robot.OI;
import org.usfirst.frc.team6334.robot.subsystems.*;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    
    public static DriveTrain driveTrain;
    public static Vision vision;

    
    public static void init() { 
    	driveTrain = new DriveTrain();
    	vision = new Vision();
    	
        oi = new OI();
        
        SmartDashboard.putData(driveTrain);
        SmartDashboard.putData(vision);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
        
    }
}