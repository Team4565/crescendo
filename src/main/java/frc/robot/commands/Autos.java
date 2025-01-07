// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.GyroSubsystem;
//import frc.robot.subsystem.MotorForShooter;
//import frc.robot.subsystem.HatchSubsystem;
import frc.robot.subsystems.HatchSubsystem;
import frc.robot.subsystems.MotorForShooter;

import javax.swing.GroupLayout.SequentialGroup;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

@SuppressWarnings("removal")
public final class Autos {
  /** Example static factory for an autonomous command. */
  public static Command exampleAuto(ExampleSubsystem subsystem) {
    return Commands.sequence(subsystem.exampleMethodCommand(), new ExampleCommand(subsystem));
  }

  @SuppressWarnings("removal")

  public static SequentialCommandGroup driveForTime(DrivetrainSubsystem drivetrain) {
    SequentialCommandGroup group = new SequentialCommandGroup(
      new DriveForTime(drivetrain, 1, 0.8),
      new DriveForTime(drivetrain, 1, -0.8)
    );
    return group; 
  }

  public static SequentialCommandGroup driveForTime2(DrivetrainSubsystem drivetrain) {
    SequentialCommandGroup group = new SequentialCommandGroup(
      new DriveForTime(drivetrain, 1.6, -0.7)
    );
    return group; 
  }

  /*public static SequentialCommandGroup shootInSpeaker(MotorForShooterTime motorForShooterTime) {
    SequentialGroup group = new SequentialCommandGroup(
      new MotorForShooterCmd(motorForShooter, 1, false),
      new HatchSubssystem(HatchSubsystem)
    )
  }
  */

  public static SequentialCommandGroup releaseHatch(HatchSubsystem releaseHatch) {
    SequentialCommandGroup group = new SequentialCommandGroup(
      new ReleaseHatch(releaseHatch)
      
    );
    return group;
  }

  public static SequentialCommandGroup grabHatch(HatchSubsystem doubleSolenoidGrab) {
    SequentialCommandGroup group = new SequentialCommandGroup(
      new GrabHatch(doubleSolenoidGrab)
    );
    return group;
  }

  public static SequentialCommandGroup motorForTimeTest(MotorForShooter motorForShooter, HatchSubsystem releaseHatch, HatchSubsystem doubleSolenoidGrab) {
    SequentialCommandGroup group = new SequentialCommandGroup(
      new ReleaseHatch(releaseHatch),
      new MotorForShooterTime(motorForShooter, 1, false, 3),
      new GrabHatch(doubleSolenoidGrab)
    );
    return group;
  }

  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}
