// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.HatchSubsystem;
import edu.wpi.first.wpilibj2.command.InstantCommand;

/** An example command that uses an example subsystem. */
public class ReleaseHatch extends InstantCommand {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ReleaseHatch(HatchSubsystem doubleSolenoidRelease) {
      super(doubleSolenoidRelease::releaseHatch, doubleSolenoidRelease);
    
    // Use addRequirements() here to declare subsystem dependencies.

      addRequirements(doubleSolenoidRelease);
  }
}
