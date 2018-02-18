package org.usfirst.frc.team6334.robot.subsystems;

import org.usfirst.frc.team6334.robot.commands.autoLeftToScaleSameSide;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class AutoChooser extends Subsystem {

	String gameData;

    public AutoChooser() {
    	gameData = null;
    }
    
    public void grabGameData() {
    	boolean dataCorrect;
    	
    	//I'm apprehensive about this loop cause loops in loops suck.
    	do {
    		if(gameData.isEmpty()) {
    			dataCorrect = false;
    			gameData = DriverStation.getInstance().getGameSpecificMessage();
    		} else {
    			dataCorrect = true;
    		}
    		System.out.println("in loop");
    	} while(dataCorrect == false);
    }
    
    public Command chooseAuto(char currentSide) {
    	grabGameData();
    	Command choice = null; //Default auto, just move forward.
    	/*
    	if(currentSide == 'C') {
    		switch (gameData) {
    			case "LLL": choice = new autoCenterLLL();
    				break;
    				
    			case "LRL": choice = new autoCenterLRL();
    				break;
    				
    			case "RLR": choice = new autoCenterRLR();
    				break;
    				
    			case "RRR": choice = new autoCenterRRR();
    		}
    	} else if (currentSide == 'L') {
    		switch (gameData) {
				case "LLL": choice = new autoLeftLLL();
					break;
					
				case "LRL": choice = new autoLeftLRL();
					break;
					
				case "RLR": choice = new autoLeftRLR();
					break;
					
				case "RRR": choice = new autoLrftRRR();
    		}
    	} else if (currentSide == 'R') {
    		switch (gameData) {
				case "LLL": choice = new autoRightLLL();
					break;
					
				case "LRL": choice = new autoRightLRL();
					break;
					
				case "RLR": choice = new autoRightRLR();
					break;
					
				case "RRR": choice = new autoRightRRR();
			}
    	}
    	*/
    	
    	return new autoLeftToScaleSameSide();
    }
    
    public void initDefaultCommand() {
    	//no default command
    }
}

