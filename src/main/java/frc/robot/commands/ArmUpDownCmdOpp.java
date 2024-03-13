// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmUpDownOppSubsystem;

/** An example command that uses an example subsystem. */
public class ArmUpDownCmdOpp extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ArmUpDownOppSubsystem armUpDownOpp;
  private final double speed;
  private final boolean upDownDirectionOpp;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ArmUpDownCmdOpp(ArmUpDownOppSubsystem armUpDownOpp, double speedrotate, boolean upDownDirectionOpp) {
    this.armUpDownOpp = armUpDownOpp;
    this.speed = speedrotate;
    this.upDownDirectionOpp = upDownDirectionOpp;
    


  
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(armUpDownOpp);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    armUpDownOpp.setUpDownOppSpeed(speed);
    armUpDownOpp.setUpDownDirectionOpp(upDownDirectionOpp);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    armUpDownOpp.setUpDownOppSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
