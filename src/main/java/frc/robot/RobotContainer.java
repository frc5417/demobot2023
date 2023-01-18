// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.*;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Manipulator;
import frc.robot.commands.TankDrive;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // subsystems are defined here:
  private static final Drive m_drive = new Drive();
  private static final Manipulator m_manipulator = new Manipulator();
  
  // commands are defined here:
  private static TankDrive tankDrive = new TankDrive(m_drive);
  private static Arm armCommand = new Arm(m_manipulator);
  private static ManipulatorToggle manipulatorCommand = new ManipulatorToggle(m_manipulator);

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private static final CommandXboxController m_driverController =
    new CommandXboxController(OperatorConstants.kDriverControllerPort);
  private static final CommandXboxController m_manipulatorController =
    new CommandXboxController(OperatorConstants.kManipulatorControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    System.out.println("Configuring buttons");

    configureButtonBindings();
  }

  public void configureButtonBindings() {
    m_manipulatorController.a().whileTrue(manipulatorCommand);

    System.out.println("Buttons Configured");
  }

  public static CommandXboxController getDriverController() {
    return m_driverController;
  }

  public static double getDriverLeftJoystick() {
    return m_driverController.getRawAxis(1);
  }

  public static double getDriverRightJoystick() {
    return m_driverController.getRawAxis(5);
  }

  public static double getManipulatorLeftJoystick() {
    return m_manipulatorController.getRawAxis(1);
  }
  
  public static double getManipulatorRightJoystick() {
    return m_manipulatorController.getRawAxis(5);
  }

  public static void initTelopCommands() {
    tankDrive.schedule();
    armCommand.schedule();
  }
}