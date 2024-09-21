// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.simulation.EncoderSim;

@SuppressWarnings("removal")

public class DrivetrainSubsystem extends SubsystemBase {
  
  private static DifferentialDrive diffDrive;

  private final Compressor compressor = new Compressor(PneumaticsModuleType.CTREPCM);
 
  private final WPI_TalonFX leftLead;
  private final WPI_TalonFX rightLead; 
  private final WPI_TalonFX leftFollower;
  private final WPI_TalonFX rightFollower;
  
  //private final PWMSparkMax shooterMotor;
  //private final PWMSparkMax shooterMotorTwo;

  private String driveMode;


  public DrivetrainSubsystem() {
    //shooterMotor = new PWMSparkMax(0);
    //shooterMotorTwo = new PWMSparkMax(0);



    leftLead = new WPI_TalonFX(1);
    rightLead = new WPI_TalonFX(3);
    leftFollower = new WPI_TalonFX(2);
    rightFollower = new WPI_TalonFX(4);

    CurrentLimitsConfigs config = new CurrentLimitsConfigs();
    SupplyCurrentLimitConfiguration configSupply = new SupplyCurrentLimitConfiguration();
    config.StatorCurrentLimit = 40;
    config.SupplyCurrentLimit = 40;
    config.StatorCurrentLimitEnable = true;
    config.SupplyCurrentLimitEnable = true;

    leftLead.configSupplyCurrentLimit(configSupply);
    leftFollower.configSupplyCurrentLimit(configSupply);
    rightLead.configSupplyCurrentLimit(configSupply);
    rightFollower.configSupplyCurrentLimit(configSupply);


    leftLead.setInverted(true);
    leftFollower.setInverted(true);
    

    leftFollower.follow(leftLead);

    
    rightFollower.follow(rightLead);

    diffDrive = new DifferentialDrive(leftLead, rightLead);

    driveMode = "normal";
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  public void updateDriveMode(String mode) {
    driveMode = mode;
  }

  public void teleopDrive(double driveValue, double turnValue) {
    switch(driveMode) {
      case "max":
        diffDrive.arcadeDrive(driveValue * .80, turnValue * 0.75);
        diffDrive.arcadeDrive(driveValue * .85, turnValue * 0.80);
        diffDrive.arcadeDrive(driveValue * .90, turnValue * 0.85);
        diffDrive.arcadeDrive(driveValue * .95, turnValue * 0.90);
        diffDrive.arcadeDrive(driveValue, turnValue);
      break;

      /**case "fast":
        diffDrive.arcadeDrive(driveValue * 0.80, turnValue * 0.80);
      break; */

      case "normal":
        diffDrive.arcadeDrive(driveValue * 0.80, turnValue * 0.75);
      break;

      case "creep speed (slow)":
        diffDrive.arcadeDrive(driveValue * 0.5 , turnValue * 0.65);
      break;

      case "no speed":
        diffDrive.arcadeDrive(driveValue * 0 , turnValue * 0);
      break;
    }

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void setRaw(double driveValue, double turnValue){
    diffDrive.arcadeDrive(driveValue, turnValue);
  }

}
