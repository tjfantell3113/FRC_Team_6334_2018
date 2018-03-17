package org.usfirst.frc.team6334.robot.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class autoIntake extends CommandBase {

	double runTime;
	boolean ejectBox = true, finished = false, faultyIntakeDesign;
	
    public autoIntake(boolean eject, double time) {
        requires(intake);
        ejectBox = eject;
        runTime = time;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	faultyIntakeDesign = false; //This is a dig at Allen's belt intake... It was really bad.
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	/*
    	if(ejectBox && faultyIntakeDesign) {
    		int sign = 1;
    		for(int i = 0; i < 10; i++) {
    			intake.setIntakePower(-sign);
    			sign *= -1;
    			Timer.delay(runTime/10);
    		}
    	} 
    	*/
    	
    	if (ejectBox){
    		intake.setIntakePower(-1);
    		Timer.delay((runTime/2));
    		intake.openIntake();
    		Timer.delay((runTime/2));
    		
    	} else {
    		intake.openIntake();
    		intake.setIntakePower(1);
    		
    		//Run intake for however long it take to fully acquire the cube
    		/*
    		for(int i = 100; i > 0; i--) {
    			if (intake.hasCube()) {
    				i = 0;
    			}
    			Timer.delay(runTime/100);
    		}
    		*/
    		Timer.delay(runTime);
    	}
    	finished = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	intake.setIntakePower(0);
    	if(ejectBox)  intake.openIntake();
    	if(!ejectBox) intake.closeIntake();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	intake.setIntakePower(0);
    }
}
