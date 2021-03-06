/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Drive extends Command {
  private Joystick stick = new Joystick(1);

  private double speed = 0;
  private double rotation = 0;
  private double scale = 0.75; //SWITCH TO 0.7 FOR HAB2

  public Drive() {
    requires(Robot.drivebase);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    if (stick.getRawAxis(3) > 0) {
      speed = stick.getRawAxis(3);

    } else if (stick.getRawAxis(2) > 0) {
      speed = -stick.getRawAxis(2);

    } else {
      speed = 0;

    }

    if (stick.getRawButton(5)) {
      scale = 0.4;
    } else if (stick.getRawButton(6)) {
        scale = 0.6;
    }

    /*
    speed = stick.getRawAxis(3) - stick.getRawAxis(2);
    */

    rotation = stick.getRawAxis(0);
    Robot.drivebase.driveRobot(speed, rotation, scale);
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
  }
}
