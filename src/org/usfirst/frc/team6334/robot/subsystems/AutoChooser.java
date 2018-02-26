package org.usfirst.frc.team6334.robot.subsystems;

import org.usfirst.frc.team6334.robot.RobotMap;
import org.usfirst.frc.team6334.robot.commands.LimeLightTest;
import org.usfirst.frc.team6334.robot.commands.autoLeftToScaleSameSide;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class AutoChooser extends Subsystem {

	String gameData;
	Command choice;
	DigitalInput auto0, auto1;

    public AutoChooser() {
    	gameData = null;
    	choice = null;
    	
    	auto0 = new DigitalInput(RobotMap.auto0);
    	auto1 = new DigitalInput(RobotMap.auto1);
    }
    
    public void grabGameData() {
    	boolean dataCorrect;
    	
    	//I'm apprehensive about this loop cause loops in loops suck.
    	do {
    		if(gameData == null) {
    			dataCorrect = false;
    			gameData = DriverStation.getInstance().getGameSpecificMessage();
    		} else {
    			dataCorrect = true;
    		}
    		System.out.println("in loop");
    	} while(dataCorrect == false);
    	System.out.println("out of loop");
    }
    
    public void chooseAuto(char currentSide) {
    	grabGameData();
    	
    	if(currentSide == 'C') {
    		switch (gameData) {
    			case "LLL": //choice = new autoCenterLLL();
    				break;
    				
    			case "LRL": //choice = new autoCenterLRL();
    				break;
    				
    			case "RLR": //choice = new autoCenterRLR();
    				break;
    				
    			case "RRR": //choice = new autoCenterRRR();
    		}
    	} else if (currentSide == 'L') {
    		switch (gameData) {
				case "LLL": choice = new autoLeftToScaleSameSide();
							System.out.println("correct");
					break;
					
				case "LRL": //choice = new autoLeftLRL();
					break;
					
				case "RLR": //choice = new autoLeftRLR();
					break;
					
				case "RRR": //choice = new autoLeftRRR();
    		}
    	} else if (currentSide == 'R') {
    		switch (gameData) {
				case "LLL": //choice = new autoRightLLL();
					break;
					
				case "LRL": //choice = new autoRightLRL();
					break;
					
				case "RLR": //choice = new autoRightRLR();
					break;
					
				case "RRR": //choice = new autoRightRRR();
			}
    	}
    	
    	if(choice != null) { 
    		choice.start();
    		System.out.println("auto chosen and started");
    	}
    }
    
    public void testSeek() {
    	Command LimelightTest = new LimeLightTest();
    	LimelightTest.start();
    }
    
    public void cancelAuto() {
    	if(choice != null) choice.cancel();
    }
    
    public void initDefaultCommand() {
    	//no default command
    }
}

