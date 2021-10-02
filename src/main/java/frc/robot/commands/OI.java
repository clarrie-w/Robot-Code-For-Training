// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.commands.SetArmPosition;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.AimArm;

// creating class OI
public class OI {
    public XboxController driver; // instance variables 
    public JoystickButton AButton;
    public JoystickButton BButton;
    public JoystickButton XButton;
    
    // constructor setting the initial value for the instance variables
    public OI() {
        driver = new XboxController(0);
        AButton = new JoystickButton(driver, 1);
        AButton.whenPressed(new SetArmPosition(90));
        BButton = new JoystickButton(driver, 2);
        BButton.whenPressed(new SetArmPosition(45));
        XButton = new JoystickButton(driver, 3);
        XButton.whenPressed(new AimArm(45, 90));
    }

    // method that takes speed to go forwards or backwards from bumpers of controller depending on how hard driver presses
    public double getSpeed() {
        return driver.getTriggerAxis(Hand.kLeft) - driver.getTriggerAxis(Hand.kRight);
    }

    // method that allows for joystick control to determine turns to left/right
    public double getTurn() {
        return driver.getRawAxis(0);
    }
}
