package org.usfirst.frc.team6334.robot.commands;

import org.usfirst.frc.team6334.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class autoCenterToRightSwitchThreeCube extends CommandGroup {

    public autoCenterToRightSwitchThreeCube(boolean depositThirdCube) {
    	addSequential(new autoResetSensors());
    	addParallel(new autoLift(RobotMap.switchHeight));
        addSequential(new moveDistanceX(24, 0.7, true));
        addSequential(new autoTurn(35, 0.45, 1), 2);
        addSequential(new moveDistanceX(40, 0.7, true), 3);
        addSequential(new autoTurn(0.01, 0.45, -1), 1.5);
        addSequential(new moveDistanceX(35, 0.7, true), 1.5);
        addSequential(new autoIntake(true, 0.5), 0.5);
        addSequential(new moveDistanceX(24, -0.7, true));
        addParallel(new autoLift(RobotMap.resetHeight));
        
    	//2nd cube
        addSequential(new moveDistanceX(18, -0.7, true));
        addSequential(new autoTurn(-47, 0.45, -1), 1);
        addSequential(new moveDistanceX(24, 0.5, true), 1);
        addSequential(new autoIntake(false, 1.5), 1.5);
        addParallel(new autoLift(RobotMap.switchHeight - 2000));
        addSequential(new moveDistanceX(20, -0.7, true), 1);
        addSequential(new autoTurn(-3, 0.45, 1), 1);
        addSequential(new moveDistanceX(48, 0.7, true));
        addSequential(new autoIntake(true, 0.5), 0.5);
        addParallel(new autoLift(RobotMap.resetHeight));
        addSequential(new moveDistanceX(24, -0.7, true));
        
        //3rd cube
        addSequential(new moveDistanceX(18, -0.7, true));
        addSequential(new autoTurn(-35, 0.45, -1), 1);
        addSequential(new moveDistanceX(20, 0.4, true), 1);
        addSequential(new autoIntake(false, 1), 1);
        if(depositThirdCube) {
	        addParallel(new autoLift(RobotMap.switchHeight - 2000));
	        addSequential(new moveDistanceX(35, -0.7, true), 1);
	        addSequential(new autoTurn(-3, 0.45, 1), 1);
	        addSequential(new moveDistanceX(38, 0.7, true));
	        addSequential(new autoIntake(true, 1), 1);
        } else {
        	addSequential(new moveDistanceX(40, -0.7, true), 1);
        }
    }
}
