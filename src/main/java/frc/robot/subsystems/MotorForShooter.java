// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class MotorForShooter extends SubsystemBase {

  @SuppressWarnings("removal")
  private final WPI_TalonFX shooterMotor;
  

  @SuppressWarnings("removal")
  public MotorForShooter() {
    shooterMotor = new WPI_TalonFX(6);
    


    
  }

  @SuppressWarnings("removal")
  public void setMotorSpeed (double speed) {

    shooterMotor.set(speed);

  }

  @SuppressWarnings("removal")
  public void setOppDirection (boolean oppDirection) {
    shooterMotor.setInverted(oppDirection);
  }

}
