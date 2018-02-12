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
	public final static int intakeStick = 2;
	public final static int elevatorStick = 1;
	public final static int arcadeStickPort = 0;
	public final static int leftStick = 1;
	public final static int rightStick = 0;

	// Xbox Axis
	public final static int xboxLeftXAxis = 0;
	public final static int xboxLeftYAxis = 1;
	public final static int xboxLeftTrigger = 2; // Joystick buttons must be mapped out.
	public final static int xboxRightTrigger = 3;
	public final static int xboxRightXAxis = 4;
	public final static int xboxRightYAxis = 5;
	
	// Joystick Buttons
	public final static int shiftDown = 3;
	public final static int shiftUp = 5;
	public final static int coastMode = 9;
	public final static int resetEncoders = 7;
	public final static int changeTurbo = 8;
	
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

	// TalonSRX ID's and values (CAN range is 1 to 62)
	public final static int RightDrive1 = 9;
	public final static int RightDrive2 = 8;
	public final static int RightDrive3 = 7;
	public final static int LeftDrive1 = 0;
	public final static int LeftDrive2 = 1;
	public final static int LeftDrive3 = 2;
	public final static int liftMotor1 =  59;
	public final static int liftMotor2 =  60;
	public final static int intakeRight =  61;
	public final static int intakeLeft =  62;
	

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
	public final static int liftEncIn = 0;
	public final static int liftEncOut = 1;
	public final static int driveEncTicks = 360;
	public final static double automaticShiftValue = 3.5;

	// Solenoids (D I/O slots)
	public final static int gearChange1 = 0;
	public final static int gearChange2 = 1;

	// Pathfinder constants
	public final static double timeStep = 0.05; //larger time for steps means faster calculation, however lower accuracy. 5ms is a good standard.
	public final static double maxVel = 4;
	public final static double maxAccel = 3;
	public final static double maxJerk = 10;
	public final static double kp = 0;
	public final static double ki = 0;
	public final static double kd = 0;
	public final static double kv = 1 / maxVel;
	public final static double ka = 0;

	//Drive Train constants
	public final static double wheelBase = 2.375;
	public final static double middleOfWheelbase = 19.25;
	public final static double wheelDiameter = 0.5; //6 inches
	public final static double deadzone = 0;
	
	//Lift Constants
	public static final int ejectBox = 1;
	public static final int liftPos1 = 100;
	public static final int liftPos2 = 200;
	public static final int lift_kP = 0;
	public static final int lift_kI= 0;
	public static int liftUpperBound = 10000;
	public static int liftLowerBound = 10;
}
