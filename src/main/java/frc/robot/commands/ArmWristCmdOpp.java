// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.subsystems.ArmWristOppSubsystem;

/** An example command that uses an example subsystem. */
public class ArmWristCmdOpp extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ArmWristOppSubsystem armWrist;
  private final double speed;
  private final double targetAngle;
  private final boolean direction;

  public ArmWristCmdOpp (ArmWristOppSubsystem armWrist, double speed, double targetAngle, boolean direction) {
    this.armWrist = armWrist;
    this.speed = speed;
    this.targetAngle = targetAngle;
    this.direction = direction;

    addRequirements(armWrist);
  
  }

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  
  

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    armWrist.setarmrotatingSpeed(speed);
    armWrist.setdirection(direction);
    armWrist.setTargetAngle(targetAngle);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    armWrist.setarmrotatingSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
