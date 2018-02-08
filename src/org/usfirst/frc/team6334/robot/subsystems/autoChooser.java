package org.usfirst.frc.team6334.robot.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class autoChooser extends Subsystem {

	String gameData;
	char currentSide, allianceSwitch, scale, oppositeSwitch; // C = center, L = left, R = right

    public autoChooser() {
    	gameData = "";
    	
    	//Break the string into bits
    	allianceSwitch = gameData.charAt(0);
    	scale = gameData.charAt(1);
    	oppositeSwitch = gameData.charAt(2);
    	
    	//default to center
    	currentSide = 'C'; 
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
    	} while(dataCorrect == false);
    }
    
    public int chooseAuto() {
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
    	
    	return choice;
    }
    
    public void initDefaultCommand() {
    	//int choice = chooseAuto();
    	/*
    	switch (choice) {
    		case 0: setDefaultCommand(new moveForwardAuto());
    			break;
    		case 1: setDefaultCommand(new AutoWhatever());
				break;
    		case 2: setDefaultCommand(new AutoWhatever());
				break;
    		case 3: setDefaultCommand(new AutoWhatever());
				break;
    		case 4: setDefaultCommand(new AutoWhatever());
				break;
    		case 5: setDefaultCommand(new AutoWhatever());
				break;
    		case 6: setDefaultCommand(new AutoWhatever());
				break;
    		case 7: setDefaultCommand(new AutoWhatever());
				break;
    		case 8: setDefaultCommand(new AutoWhatever());
				break;
    		case 9: setDefaultCommand(new AutoWhatever());
				break;
    		case 10: setDefaultCommand(new AutoWhatever());
				break;
    		case 11: setDefaultCommand(new AutoWhatever());
				break;
    		case 12: setDefaultCommand(new AutoWhatever());
				break;
    	} */
    }
}

