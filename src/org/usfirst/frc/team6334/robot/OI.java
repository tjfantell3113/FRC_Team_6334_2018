/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6334.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	private Joystick xboxStick = new Joystick(RobotMap.xboxPort);
	
	//Xbox Buttons
	private JoystickButton aButton = new JoystickButton(xboxStick, RobotMap.xboxAButton);
	private JoystickButton bButton = new JoystickButton(xboxStick, RobotMap.xboxBButton);
	private JoystickButton xButton = new JoystickButton(xboxStick, RobotMap.xboxXButton);
	private JoystickButton yButton = new JoystickButton(xboxStick, RobotMap.xboxYButton);
	private JoystickButton rightBumper = new JoystickButton(xboxStick, RobotMap.xboxRightBumper);
	private JoystickButton leftBumper = new JoystickButton(xboxStick, RobotMap.xboxLeftBumper);
	private JoystickButton viewButton = new JoystickButton(xboxStick, RobotMap.xboxViewButton);
	private JoystickButton menuButton = new JoystickButton(xboxStick, RobotMap.xboxMenuButton);
	private JoystickButton rightStickButton = new JoystickButton(xboxStick, RobotMap.xboxRightStickButton);
	private JoystickButton leftStickButton = new JoystickButton(xboxStick, RobotMap.xboxLeftStickButton);
	
	//put button press events here
	public OI(){
		
	}
	
	public Joystick getXboxStick(){
		return xboxStick;
	}
	public JoystickButton getAButton(){
		return aButton;
	}
	public JoystickButton getBButton(){
		return bButton;
	}
	public JoystickButton getXButton(){
		return xButton;
	}
	public JoystickButton getYButton(){
		return yButton;
	}
	public JoystickButton getLeftBumper(){
		return leftBumper;
	}
	public JoystickButton getRightBumper(){
		return rightBumper;
	}
	public JoystickButton getLeftStickButton(){
		return leftStickButton;
	}
	public JoystickButton getRightStickButton(){
		return rightStickButton;
	}
	public JoystickButton getviewButton(){
		return viewButton;
	}
	public JoystickButton getMenuButton(){
		return menuButton;
	}

}
