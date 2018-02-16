package org.usfirst.frc.team6334.robot.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class AutoChooser extends Subsystem {

	String gameData;

    public AutoChooser() {
    	gameData = "";
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
    
    public int chooseAuto(char currentSide) {
    	grabGameData();
    	int choice = 0; //Default auto, just move forward.
    	
    	if(currentSide == 'C') {
    		switch (gameData) {
    			case "LLL": choice = 1;
    				break;
    				
    			case "LRL": choice = 2;
    				break;
    				
    			case "RLR": choice = 3;
    				break;
    				
    			case "RRR": choice = 4;
    		}
    	} else if (currentSide == 'L') {
    		switch (gameData) {
				case "LLL": choice = 5;
					break;
					
				case "LRL": choice = 6;
					break;
					
				case "RLR": choice = 7;
					break;
					
				case "RRR": choice = 8;
    		}
    	} else if (currentSide == 'R') {
    		switch (gameData) {
				case "LLL": choice = 9;
					break;
					
				case "LRL": choice = 10;
					break;
					
				case "RLR": choice = 11;
					break;
					
				case "RRR": choice = 12;
			}
    	} else {
    		choice = 0;
    	}
    	
    	System.out.println(choice);
    	return choice;
    }
    
    public void initDefaultCommand() {
    	//no default command
    }
}

