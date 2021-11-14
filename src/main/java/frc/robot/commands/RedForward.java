// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;

//import org.graalvm.compiler.nodes.java.DynamicNewInstanceNode;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class RedForward extends CommandBase {
  private DriveTrain d;
  private double distance;
  private double speed;
  private double error;

  //Cretes a new EncoderDrive
  public RedForward(DriveTrain d, double distance, double speed) {
    //Use addRequirements() here to declare subsystem dependencies
    this.d = d;
    this.distance = distance;
    this.speed = speed;

    addRequirements(d);
  }
  
  //Called when the command is initially scheduled
  @Override
  public void initialize() {
    d.resetEncoders();
  }

  //Called everytime the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    error = distance - d.getPosition();
    error = error / distance;
    speed = error * 0.7;

    if(speed > 0.7) {
      speed = 0.1;
    }

    d.tankDrive(speed,speed);
  }
  
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    d.tankDrive(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (d.getPosition() < distance);
  }
}
