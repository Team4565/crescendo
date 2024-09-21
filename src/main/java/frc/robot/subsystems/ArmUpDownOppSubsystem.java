// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotContainer;

@SuppressWarnings("removal")
public class ArmUpDownOppSubsystem extends SubsystemBase {
  
  @SuppressWarnings("removal")
  
  private final WPI_TalonFX ArmUpDownOpp;

  public ArmUpDownOppSubsystem() {

    ArmUpDownOpp = new WPI_TalonFX(5);
    
  }

  

  public void setUpDownOppSpeed (double speed) {

    ArmUpDownOpp.set(speed);

  }

  public void setUpDownDirectionOpp (boolean upDownDirectionOpp) {
    ArmUpDownOpp.setInverted(upDownDirectionOpp);
  }

}
