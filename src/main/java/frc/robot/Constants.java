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
    public static final int intakeLimitPort = 3;

    public static final int kClaw1Solenoid = 1;
    public static final int kClaw2Solenoid = 2;
  }

  public static class PIDConstants {
    public static final double kArmP = 0.25d;
    public static final double kArmI = 0d;
    public static final double kArmD = 700.0d;

    public static final double cycleTime = 50.0;

    public static final double kDriveP = 0.0075;
    public static final double kDriveI = 0.0;
  }

  public static final double armMaxSpeed = 0.3d;
  public static final double manipulatorSpeed = 1.0d;
  public static final double tankDriveSpeed = 0.8d;

  public static final double driveMinCommand = 0.1;

}
