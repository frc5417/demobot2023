// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {
  private final static CANSparkMax leftmotors1 = new CANSparkMax(Constants.MotorControllerPorts.kDriveLeft1, MotorType.kBrushless);
  private final static CANSparkMax leftmotors2 = new CANSparkMax(Constants.MotorControllerPorts.kDriveLeft2, MotorType.kBrushless);
  private final static CANSparkMax rightmotors1 = new CANSparkMax(Constants.MotorControllerPorts.kDriveRight1, MotorType.kBrushless);
  private final static CANSparkMax rightmotors2 = new CANSparkMax(Constants.MotorControllerPorts.kDriveRight2, MotorType.kBrushless);
  
  public Drive() {
    rightmotors1.setInverted(true);
    rightmotors2.setInverted(true);

    leftmotors1.setIdleMode(IdleMode.kCoast);
    leftmotors2.setIdleMode(IdleMode.kCoast);
    rightmotors1.setIdleMode(IdleMode.kCoast);
    rightmotors2.setIdleMode(IdleMode.kCoast);
  }
  
  public void setPower(double leftPower, double rightPower) {
    if (Math.abs(leftPower) < Constants.OperatorConstants.deadBand) {
      leftPower = 0;
    }

    if (Math.abs(rightPower) < Constants.OperatorConstants.deadBand) {
      rightPower = 0;
    }

    System.out.println(leftPower + ", " + rightPower);

    leftmotors1.set(leftPower);
    leftmotors2.set(leftPower);

    rightmotors1.set(rightPower);
    rightmotors2.set(rightPower);
  }

  @Override
  public void periodic() {}

}
