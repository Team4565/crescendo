// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;



import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.PneumaticsBase;
import edu.wpi.first.wpilibj.PneumaticsControlModule;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants.HatchConstants;
import edu.wpi.first.util.sendable.SendableBuilder;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kForward;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kReverse;


/** An example command that uses an example subsystem. */
public class HatchSubsystem extends SubsystemBase {
@SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  private final DoubleSolenoid m_hatchSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, HatchConstants.kHatchSolenoidPorts[0], HatchConstants.kHatchSolenoidPorts[1]);

  public void grabHatch() {
    m_hatchSolenoid.set(kForward);
  }

  public void releaseHatch() {
    m_hatchSolenoid.set(kReverse);
  }

  @Override
  public void initSendable(SendableBuilder builder){
    super.initSendable(builder);

    builder.addBooleanProperty("extended", () -> m_hatchSolenoid.get() == kForward, null);
  }





  //public boolean getCompressor(){
  //  return compressor.getCompressor();
  //}

  // public boolean getPressureSwitch(){
  //   return compressor.getPressureSwitch();
  // }

  // public void enableCompressorHybrid(){
  //   compressor.enableCompressorHybrid(40, 100);
  // }

  // public double getCompressorCurrent(){
  //   return compressor.getCompressorCurrent();
  // }

  // public double getPressure(){
  //   return compressor.getPressure(0);
  // }


  //public double

  //public double

  //public double

  //public int



  //public

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  

  // @Override
  // public void periodic(){
  //   SmartDashboard.getBoolean("Presure Switch T/F:", getPressureSwitch());
  //   SmartDashboard.putNumber("Compressor Current:", getCompressorCurrent());
  //   SmartDashboard.putNumber("Current Pressure:", getPressure());

  // }

  // public void teleopPeriodic(){

  // }

}

