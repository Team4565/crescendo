// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ArmUpDownSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class ArmUpDownCmd extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ArmUpDownSubsystem armUpDown;
  private final double speed;
  private final boolean upDownDirection;


  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ArmUpDownCmd(ArmUpDownSubsystem armUpDown, double speedrotate, boolean upDownDirection) {
    this.armUpDown = armUpDown;
    this.speed = speedrotate;
    this.upDownDirection = upDownDirection;
    


  
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(armUpDown);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    armUpDown.setUpDownSpeed(speed);
    armUpDown.setUpDownDirection(upDownDirection);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    armUpDown.setUpDownSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
