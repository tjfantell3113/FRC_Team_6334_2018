package org.usfirst.frc.team6334.robot.subsystems;

import org.usfirst.frc.team6334.robot.RobotMap;
import org.usfirst.frc.team6334.robot.commands.*;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class AutoChooser extends Subsystem {

	String gameData = "";
	
	char currentSide = 'C';
	
	boolean oneCube = false;
	boolean twoCubes = true;
	
	boolean centerTwoCubes = true;
	boolean centerThreeCubes = false;
	boolean centerDepositThirdCube = true;
	
	boolean threeCubes = false;
	boolean backAlley = true;
	
	Command choice;
	DigitalInput leftDIO, rightDIO, switchDIO;

    public AutoChooser() {
    	choice = null;
    	
    	leftDIO = new DigitalInput(RobotMap.leftDIO);
    	rightDIO = new DigitalInput(RobotMap.rightDIO);
    	//centerDIO = new DigitalInput(RobotMap.centerDIO);
    	switchDIO = new DigitalInput(RobotMap.switchDIO);
    	//scaleDIO = new DigitalInput(RobotMap.scaleDIO);
    	
    	if(oneCube) {
    		twoCubes = false;
    		threeCubes = false;
    	}
    }
    
    public void grabGameData() {
    	
    	if(gameData.equals("")) {
    		System.out.println("rip");
    		gameData = DriverStation.getInstance().getGameSpecificMessage();
    		grabGameData();
    	} else System.out.println("Yay!");
    	
    	System.out.println(currentSide);
    	System.out.println(threeCubes);
    	System.out.println(gameData);

    	/*
    	if(!leftDIO.get()) {
    		currentSide = 'L';
    		System.out.println("Left side auto...");
    	} else if (!rightDIO.get()) {
    		currentSide = 'R';
    		System.out.println("Right side auto...");
    	} else if (!rightDIO.get() && !leftDIO.get()) {
    		currentSide = 'C';
    		System.out.println("Center auto...");
    	}
    	
    	if(!switchDIO.get()) {
    		goForSwitch = true;
    		System.out.println("Switch is preference!");
    	} else {
    		goForSwitch = false;
    		System.out.println("Scale is preference!");
    	} //else if (!scaleDIO.get()) {
    		//goForSwitch = false;
    		//System.out.println("Going for scale as preference!");
    	//}*/
    }
    
    public void chooseAuto() {
    	grabGameData();
    	
    	System.out.println("gamedata grabbed");
    	
    	if(currentSide == 'C') {
    		if(centerTwoCubes) {
	    		switch (gameData) {
					case "LLL": choice = new autoCenterToLeftSwitchTwoCube();
						break;
						
					case "LRL": choice = new autoCenterToLeftSwitchTwoCube();
						break;
						
					case "RLR": choice = new autoCenterToRightSwitchTwoCube();
						break;
						
					case "RRR": choice = new autoCenterToRightSwitchTwoCube();
						break;
	    		}
    		} else if (centerThreeCubes) {
    			switch (gameData) {
					case "LLL": choice = new autoCenterToLeftSwitchThreeCube(centerDepositThirdCube);
						break;
						
					case "LRL": choice = new autoCenterToLeftSwitchThreeCube(centerDepositThirdCube);
						break;
						
					case "RLR": choice = new autoCenterToRightSwitchThreeCube(centerDepositThirdCube);
						break;
						
					case "RRR": choice = new autoCenterToRightSwitchThreeCube(centerDepositThirdCube);
						break;
    			}
    		} else {
    			switch (gameData) {
					case "LLL": choice = new autoCenterToLeftSwitch();
						break;
						
					case "LRL": choice = new autoCenterToLeftSwitch();
						break;
						
					case "RLR": choice = new autoCenterToRightSwitch();
						break;
						
					case "RRR": choice = new autoCenterToRightSwitch();
						break;
    			}
    		}
    	} else if (currentSide == 'L') {
    		if(backAlley) {
	    		if(threeCubes) {
	    			switch (gameData) {
						case "LLL": choice = new autoLeftToLeftSwitchThreeCube();
							break;
							
						case "LRL": choice = new autoLeftToLeftSwitchThreeCube();
							break;
							
						case "RLR": choice = new autoLeftToRightSwitch();
							break;
							
						case "RRR": choice = new autoLeftToRightSwitch();
							break;
	    			}
	    		} else {
	    			switch (gameData) {
						case "LLL": choice = new autoLeftToLeftSwitch(twoCubes);
							break;
							
						case "LRL": choice = new autoLeftToLeftSwitch(twoCubes);
							break;
							
						case "RLR": choice = new autoLeftToRightSwitch();
							break;
							
						case "RRR": choice = new autoLeftToRightSwitch();
							break;
	    			}
	    		}
    		} else {
    			if(threeCubes) {
    				switch (gameData) {
						case "LLL": choice = new autoLeftToLeftSwitchThreeCube();
							break;
							
						case "LRL": choice = new autoLeftToLeftSwitchThreeCube();
							break;
							
						case "RLR": choice = new autoMoveForward();
							break;
							
						case "RRR": choice = new autoMoveForward();
							break;
	    			}
    			} else {
    				switch (gameData) {
						case "LLL": choice = new autoLeftToLeftSwitch(twoCubes);
							break;
							
						case "LRL": choice = new autoLeftToLeftSwitch(twoCubes);
							break;
							
						case "RLR": choice = new autoMoveForward();
							break;
							
						case "RRR": choice = new autoMoveForward();
							break;
	    			}
    			}
    		}
    	} else if (currentSide == 'R') {
    		if(backAlley) {
	    		if(threeCubes) {
	    			switch (gameData) {
						case "RRR": choice = new autoRightToRightSwitchThreeCube();
							break;
							
						case "RLR": choice = new autoRightToRightSwitchThreeCube();
							break;
							
						case "LRL": choice = new autoRightToLeftSwitch();
							break;
							
						case "LLL": choice = new autoRightToLeftSwitch();
							break;
	    			}
	    		} else {
	    			switch (gameData) {
						case "RRR": choice = new autoRightToRightSwitch(twoCubes);
							break;
							
						case "RLR": choice = new autoRightToRightSwitch(twoCubes);
							break;
							
						case "LRL": choice = new autoRightToLeftSwitch();
							break;
							
						case "LLL": choice = new autoRightToLeftSwitch();
							break;
	    			}
	    		}
    		} else {
    			if(threeCubes) {
    				switch (gameData) {
						case "RRR": choice = new autoRightToRightSwitchThreeCube();
							break;
							
						case "RLR": choice = new autoRightToRightSwitchThreeCube();
							break;
							
						case "LRL": choice = new autoMoveForward();
							break;
							
						case "LLL": choice = new autoMoveForward();
							break;
	    			}
    			} else {
    				switch (gameData) {
						case "RRR": choice = new autoRightToRightSwitch(twoCubes);
							break;
							
						case "RLR": choice = new autoRightToRightSwitch(twoCubes);
							break;
							
						case "LRL": choice = new autoMoveForward();
							break;
							
						case "LLL": choice = new autoMoveForward();
							break;
	    			}
    			}
    		}
    	} else {
    		choice = new autoMoveForward();
    	}
    	
    	if(choice != null) { 
    		choice.start();
    		System.out.println("auto chosen and started");
    	} else {
    		System.out.println("Null auto!!!");
    		choice = new autoMoveForward();
    		choice.start();
    	}
    }
    
    public void testAuto() {
    	Command testThisAuto = new autoLeftToLeftSwitch(twoCubes);
    	testThisAuto.start();
    }
    
    public void cancelAuto() {
    	if(choice != null) choice.cancel();
    }
    
    public void initDefaultCommand() {
    	//no default command
    }
}

