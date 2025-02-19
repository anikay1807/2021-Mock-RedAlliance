// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

//import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
//import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.DriveTrain;

public class EncoderDrive extends CommandBase {

  DriveTrain d;
  private double speed;
  private double distance;

  /** Creates a new EncoderDrive. */
  public EncoderDrive(DriveTrain driveTrain, double speed, double distance) {
    // Use addRequirements() here to declare subsystem dependencies.
    d = new DriveTrain();
    this.speed = speed;
    this.distance = distance;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    d.resetEncoders();
  }


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    d.tankDrive(speed, speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    d.tankDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return d.getPosition() >= distance;
  }
}