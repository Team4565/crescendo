// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.math.controller.PIDController;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotContainer;

@SuppressWarnings("removal")
public class ArmWristSubsystem extends SubsystemBase {
  
  @SuppressWarnings("removal")
  
  private final WPI_TalonFX ArmWrist;

  private final double minAngle = 60;

  private final double maxAngle = 120;

  private final PIDController angleController = new PIDController(0.1, 0, 0);

  @SuppressWarnings("removal")
  public ArmWristSubsystem() {

    ArmWrist = new WPI_TalonFX(6);
    ArmWrist.setNeutralMode(NeutralMode.Brake);
    
  

  }

  public void setarmrotatingSpeed (double speed){

    ArmWrist.set(speed);

  }

  public void setdirection (boolean direction){

    ArmWrist.setInverted(direction);

  }

  public void setTargetAngle (double targetAngle){

    double output = angleController.calculate(getCurrentAngle(), targetAngle);

    if (output > 0 && getCurrentAngle() >= maxAngle) {
      output = 0;
    } else if (output < 0 && getCurrentAngle() <= minAngle){
      output = 0;
    }
  }

  private double getCurrentAngle() {
    return 0;
  }

  private String twoTurningThings;

  public void updateTurning(String mode) {
     twoTurningThings = mode;
  }

  public void turning (double turningspeed){
    switch(twoTurningThings) {
        case "Counterclockwise":
        ArmWrist.set(0.045);
        break;

        case "Clockwise":
        ArmWrist.set(-0.045);
        break;
    }

  }

  
}
