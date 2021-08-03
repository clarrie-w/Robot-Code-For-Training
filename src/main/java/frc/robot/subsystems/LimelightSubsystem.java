// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class LimelightSubsystem extends SubsystemBase {
  /** Creates a new LimelightSubsystem. */
  NetworkTable table; // radio
  NetworkTableEntry tx; // position to target
  NetworkTableEntry ty;
  NetworkTableEntry ta; // area
  double x;
  double y;
  double area;

  public LimelightSubsystem() {
    table = NetworkTableInstance.getDefault().getTable("limelight"); // find limelight device
    tx = table.getEntry("tx"); // takes data for x position from radio
    ty = table.getEntry("ty");
    ta = table.getEntry("ta");
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(1); // turns on camera
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    x = tx.getDouble(0.0);
    y = ty.getDouble(0.0);
    area = ta.getDouble(0.0);
  }

  public double getx() {
    return x;
  }

  public double gety() {
    return y;
  }

  public double getArea() {
    return area;
  }
}
