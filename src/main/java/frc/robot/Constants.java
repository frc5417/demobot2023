// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
    public static final int kManipulatorControllerPort = 1;

    public static final double deadBand = 0.18;
  }

  public static class MotorControllerPorts {
    public static final int kDriveLeft1 = 3;
    public static final int kDriveLeft2 = 4;
    public static final int kDriveRight1 = 1;
    public static final int kDriveRight2 = 2;

    public static final int kArm1 = 7;
    public static final int kArm2 = 8;

    public static final int kManipulator = 5;

    public static final int kClaw1Solenoid = 1;
    public static final int kClaw2Solenoid = 2;
  }

  public static final double armMaxSpeed = 0.5;
  public static final double manipulatorSpeed = 0.5;
  public static final double tankDriveSpeed = 0.420;

  public static final double armkP = 2;
}
