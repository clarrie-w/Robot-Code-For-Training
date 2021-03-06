// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PneumaticsSubsystem extends SubsystemBase {
  /** Creates a new PneumaticsSubsystem. */
  Compressor compressor;

  public PneumaticsSubsystem() {
    compressor = new Compressor(0);
    compressor.setClosedLoopControl(true); // pump air
  }

  public void pumpAirOn() {
    compressor.setClosedLoopControl(true);
  }

  public void pumpAirOff() {
    compressor.setClosedLoopControl(false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
