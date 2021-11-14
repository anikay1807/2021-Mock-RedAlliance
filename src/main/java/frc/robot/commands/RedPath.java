// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
//import frc.robot.subsystems.DriveTrain;

public class Path extends SequentialCommandGroup;

  private RobotContainer rc = new RobotContainer();
  //private DriveTrain dt = newDriveTrain();

  //Creates new Path
  public Path() {
    addComands(new EncoderDrive)
  }