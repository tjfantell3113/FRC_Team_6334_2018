/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6334.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// Controller Ports
	public final static int xboxPort = 2;
	public final static int leftStickPort = 1; // Mainstick and auxstick in preparation for switch over to joystick tank drive
	public final static int rightStickPort = 0;

	// Xbox Axis
	public final static int xboxLeftXAxis = 0;
	public final static int xboxLeftYAxis = 1;
	public final static int xboxLeftTrigger = 2; // Joystick buttons must be mapped out.
	public final static int xboxRightTrigger = 3;
	public final static int xboxRightXAxis = 4;
	public final static int xboxRightYAxis = 5;
	
	// Joystick Buttons
	public final static int shiftUp = 3;
	public final static int shiftDown = 2;
	
	// Xbox Buttons
	public final static int xboxAButton = 1;
	public final static int xboxBButton = 2;
	public final static int xboxXButton = 3;
	public final static int xboxYButton = 4;
	public final static int xboxLeftBumper = 5;
	public final static int xboxRightBumper = 6;
	public final static int xboxViewButton = 7;
	public final static int xboxMenuButton = 8;
	public final static int xboxLeftStickButton = 9;
	public final static int xboxRightStickButton = 10;

	// TalonSRX ID's and values (Fixed for PWM values, otherwise when using CAN use left = odd
	// and right = even with the range of 1 to 62)
	public final static int RightDrive1 = 9;
	public final static int RightDrive2 = 8;
	public final static int RightDrive3 = 7;
	public final static int LeftDrive1 = 0;
	public final static int LeftDrive2 = 1;
	public final static int LeftDrive3 = 2;
	public final static int kTimeoutMs = 10;

	// Limelight
	public final static double L_KpX = 0.07;
	public final static double L_KpY = 0.05;
	public final static double L_min_Kp = 0.05;
	public final static int ledOn = 0;
	public final static int ledOff = 1;
	public final static int ledBlink = 2;
	public final static int camVisionProccesor = 0;
	public final static int camDriver = 1;
	public final static int pipeline0 = 0;
	public final static int pipeline1 = 1;
	public final static int pipeline2 = 2;
	public final static int pipeline3 = 3;
	public final static int pipeline4 = 4;
	public final static int pipeline5 = 5;
	public final static int pipeline6 = 6;
	public final static int pipeline7 = 7;
	public final static int pipeline8 = 8;
	public final static int pipeline9 = 9;

	// Encoders
	public final static int encLeftIn = 6;
	public final static int encLeftOut = 7;
	public final static int encRightIn = 8;
	public final static int encRightOut = 9;
	public final static int encDriveTicks = 360;
	public final static double automaticShiftValue = 1000;

	// Solenoids (D I/O slots)
	public final static int leftGearChange1 = 0;
	public final static int leftGearChange2 = 1;
	public final static int rightGearChange1 = 2;
	public final static int rightGearChange2 = 3;
	public final static int intakeSolenoid = 2;

	// Pathfinder constants
	public final static double timeStep = 0.05;
	public final static double maxVel = 1;
	public final static double maxAccel = 2;
	public final static double maxJerk = 5;
	public final static double wheelBase = 0.643;
	public final static double wheelDiameter = 0.1524; //6 inches
	public final static double kp = 1;
	public final static double ki = 0;
	public final static double kd = 1;
	public final static double kv = 1 / maxAccel;
	public final static double ka = 0;

}
