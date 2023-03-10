// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.InstantCommand;
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
  private static final Arm m_arm = new Arm();
  private static final Intake m_intake = new Intake();
  private static final Limelight m_limelight = new Limelight();
  
  // commands are defined here:
  private static TankDrive tankDrive = new TankDrive(m_drive);
  private static ArmSetPos armSetPos8 = new ArmSetPos(0.8d, m_arm);
  private static ArmSetPos armSetPos85 = new ArmSetPos(0.85d, m_arm);
  private static ArmSetPos armSetPos75 = new ArmSetPos(0.75d, m_arm);
  private static ArmSetPos armSetPos7 = new ArmSetPos(0.7d, m_arm);
  private static ArmSetPos armSetPos9 = new ArmSetPos(0.9d, m_arm);
  private static ArmMovement armCommand = new ArmMovement(m_arm);
  private static ClawPiston clawPistonCommand = new ClawPiston(m_intake);
  private static ManipulatorIn manipulatorInCommand = new ManipulatorIn(m_intake);
  private static ManipulatorOut manipulatorOutCommand = new ManipulatorOut(m_intake);
  private static AutoAlign autoAlign = new AutoAlign(m_limelight, m_drive);
  
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

    m_driverController.a().whileTrue(autoAlign);


    m_manipulatorController.a().whileTrue(armSetPos9);
    m_manipulatorController.b().whileTrue(armSetPos85);
    m_manipulatorController.y().whileTrue(armSetPos8);
    m_manipulatorController.x().whileTrue(armSetPos75);
    m_manipulatorController.rightBumper().whileTrue(armSetPos7);
    
    m_manipulatorController.leftTrigger().whileTrue(manipulatorInCommand);
    m_manipulatorController.rightTrigger().whileTrue(manipulatorOutCommand);
    // m_manipulatorController.x().whileTrue(clawPistonCommand);
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
    // armCommand.schedule();
  }

  public static void initTankDrive() {
    tankDrive.schedule();
  }

  public static void initArmMovement() {
    // armCommand.schedule();
  }
}