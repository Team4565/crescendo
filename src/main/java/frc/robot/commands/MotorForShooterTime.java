// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.MotorForShooter;

/** An example command that uses an example subsystem. */
public class MotorForShooterTime extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final MotorForShooter motorForShooter;
  private final double speed;
  private final boolean oppDirection;
  private double startingTime;
  private double time;

  public MotorForShooterTime(MotorForShooter motorForShooter, double speed, boolean oppDirection, double time) {
    this.motorForShooter = motorForShooter;
    this.speed = speed;
    this.oppDirection = oppDirection;
    this.time = time;
    
    addRequirements(motorForShooter);
  }

  @Override
  public void execute() {
    motorForShooter.setMotorSpeed(speed);
    motorForShooter.setOppDirection(oppDirection);

  }

  @Override
  public void initialize() {
    startingTime = Timer.getFPGATimestamp();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    motorForShooter.setMotorSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (Timer.getFPGATimestamp() > startingTime + time);
  }

}
