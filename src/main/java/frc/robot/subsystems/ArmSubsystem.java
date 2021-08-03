// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;

public class ArmSubsystem extends SubsystemBase {
  CANSparkMax arm;
  CANEncoder encoder;
  CANPIDController controller;
  
  /** Creates a new ArmSubsystem. */
  public ArmSubsystem(double P, double I, double D) {
    arm = new CANSparkMax(4, MotorType.kBrushless);
    encoder = arm.getEncoder();
    controller = arm.getPIDController();
    controller.setP(P);
    controller.setI(I);
    controller.setD(D);
    controller.setOutputRange(-1, 1);
  }

  public void setArmTarget(double target) {
    controller.setReference(target, ControlType.kPosition);
  }

  public double getArmPosition() {
    return encoder.getPosition();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
