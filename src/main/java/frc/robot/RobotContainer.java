// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.ArmUpDownCmd;
import frc.robot.commands.ArmUpDownCmdOpp;
import frc.robot.commands.ArmWristCmd;
import frc.robot.commands.ArmWristCmdOpp;
import frc.robot.commands.Autos;
import frc.robot.commands.ChangeDriveMode;
import frc.robot.commands.GrabArm;
import frc.robot.commands.GrabChain;
import frc.robot.commands.GrabHatch;
import frc.robot.commands.ReleaseArm;
import frc.robot.commands.ReleaseChain;
import frc.robot.commands.ReleaseHatch;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.HatchSubsystem;
//import frc.robot.subsystems.VisionSubsystem;
import frc.robot.subsystems.ArmUpDownSubsystem;
import frc.robot.subsystems.ArmWristOppSubsystem;
import frc.robot.subsystems.ArmWristSubsystem;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.ArmGrabSubsystem;
import frc.robot.subsystems.ArmUpDownOppSubsystem;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.MotorForShooter;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.internal.DriverStationModeThread;
import edu.wpi.first.wpilibj.simulation.JoystickSim;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import java.io.IOException;
import java.nio.file.Path;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryUtil;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.MotorForShooterCmd;
import frc.robot.subsystems.MotorForShooter;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  // private final x y = new x();

  private final DrivetrainSubsystem m_drivetrainSubsystem = new DrivetrainSubsystem();

  private final ArmUpDownSubsystem m_armmotorSubsystem = new ArmUpDownSubsystem();

  //private final Pneumatic m_pneumatics = new Pneumatic();

  private final ArmWristSubsystem armWrist = new ArmWristSubsystem();

  private final ArmUpDownSubsystem armUpDown = new ArmUpDownSubsystem();

  private final ArmWristOppSubsystem armWristOpp = new ArmWristOppSubsystem();

  private final ArmUpDownOppSubsystem armUpDownOpp = new ArmUpDownOppSubsystem();

  //private final VisionSubsystem visionSubsystem = new VisionSubsystem();

  private final ArmUpDownCmd armUpDownCmd = new ArmUpDownCmd(armUpDown, 0, false);

  private final ArmUpDownCmdOpp armUpDownCmdOpp = new ArmUpDownCmdOpp(armUpDownOpp, 0, false);

  private final ArmWristCmd armWristCmd = new ArmWristCmd(armWrist, 0, 0, false);

  private final ArmWristCmdOpp armWristCmdOpp = new ArmWristCmdOpp(armWristOpp, 0, 0, false);

  private final HatchSubsystem m_hatchSubsystem = new HatchSubsystem();

  private final ClimbSubsystem m_climbSubsystem = new ClimbSubsystem();

  private final ArmGrabSubsystem m_armGrabSubsystem = new ArmGrabSubsystem();

  private final MotorForShooter m_MotorForShooter = new MotorForShooter();

  private final MotorForShooterCmd motorForShooterCmd = new MotorForShooterCmd(m_MotorForShooter, 0, false);


  private final Command m_driveForTime = Autos.driveForTime(m_drivetrainSubsystem);

  private final Command m_driveForTime2 = Autos.driveForTime2(m_drivetrainSubsystem);

  private final Command m_releaseHatch = Autos.releaseHatch(m_hatchSubsystem);

  private final Command m_grabHatch = Autos.grabHatch(m_hatchSubsystem);

  private final Command m_motorForShooter = Autos.motorForTimeTest(m_MotorForShooter, m_hatchSubsystem, m_hatchSubsystem);


  // Replace with CommandPS4Controller or CommandJoystick if needed

  private final XboxController m_driverController =
      new XboxController(OperatorConstants.kDriverControllerPort);

  private final XboxController m_driverControllerTwo = 
      new XboxController(OperatorConstants.kDriverControllerPortTwo);

  public SendableChooser<Command> m_chooser = new SendableChooser<>();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();

    m_drivetrainSubsystem.setDefaultCommand(new RunCommand(() ->
    //m_drivetrainSubsystem.teleopDrive(m_driverController.getLeftY(), m_driverController.getRightX()), m_drivetrainSubsystem));
    m_drivetrainSubsystem.teleopDrive(m_driverController.getLeftY(), m_driverController.getLeftX()), m_drivetrainSubsystem));

    // armUpDown.setDefaultCommand(new RunCommand(ArmUpDownSubsystem.setUpDownDirection(m_driverControllerTwo.getLeftY()), armUpDown));
    /**m_drivetrainSubsystem.setDefaultCommand(new RunCommand(() ->
    *m_drivetrainSubsystem.teleopDrive(m_driverController.getLeftY(), m_driverController.getRightX()), m_drivetrainSubsystem));
    *m_drivetrainSubsystem.teleopDrive(m_driverController.getLeftY(), m_driverController.getLeftX()), m_drivetrainSubsystem));
    */






    m_chooser.addOption("Release Hatch", m_releaseHatch);
    m_chooser.addOption("Grab Hatch", m_grabHatch);
    m_chooser.addOption("Backwards then forwards", m_driveForTime);
    m_chooser.addOption("Forwards", m_driveForTime2);
    m_chooser.addOption("Motor testin", m_motorForShooter);
    

    SmartDashboard.putData(m_chooser);
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  
  private void configureBindings() {
    
    /* // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_exampleSubsystem));

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
    */
  
      //Spins Motor if April Tags are Recognized for 20 Ticks
      new JoystickButton(m_driverController, XboxController.Button.kY.value).onTrue(new ChangeDriveMode(m_drivetrainSubsystem, "max"));
      //new JoystickButton(m_driverController, XboxController.Button.kB.value).onTrue(new ChangeDriveMode(m_drivetrainSubsystem, "fast"));
      new JoystickButton(m_driverController, XboxController.Button.kB.value).onTrue(new ChangeDriveMode(m_drivetrainSubsystem, "normal"));
      new JoystickButton(m_driverController, XboxController.Button.kX.value).onTrue(new ChangeDriveMode(m_drivetrainSubsystem, "creep speed (slow)"));
      new JoystickButton(m_driverController, XboxController.Button.kStart.value).onTrue(new ChangeDriveMode(m_drivetrainSubsystem, "no speed"));

      new JoystickButton(m_driverController, XboxController.Button.kRightBumper.value).whileTrue(new MotorForShooterCmd(m_MotorForShooter, 0.7, true));
      new JoystickButton(m_driverController, XboxController.Button.kLeftBumper.value).whileTrue(new MotorForShooterCmd(m_MotorForShooter, 1, false));

      //new JoystickButton(m_driverController, XboxController.Button.kX.value).whileTrue(new ArmUpDownCmdOpp(armUpDownOpp, 1, true));
      //new JoystickButton(m_driverController, XboxController.Button.kA.value).whileTrue(new ArmUpDownCmd(armUpDown, 4, false));

      new JoystickButton(m_driverController, XboxController.Button.kA.value).onTrue(new GrabHatch(m_hatchSubsystem));
      new JoystickButton(m_driverController, XboxController.Button.kBack.value).onTrue(new ReleaseHatch(m_hatchSubsystem));

      //new JoystickButton(m_driverControllerTwo, XboxController.Button.kLeftBumper.value).onTrue(new GrabChain(m_climbSubsystem));
      //new JoystickButton(m_driverControllerTwo, XboxController.Button.kRightBumper.value).onTrue(new ReleaseChain(m_climbSubsystem));


    }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return m_chooser.getSelected();
  
  }

  // public void teleopPeriodic(){

  //   if (m_driverController.getLeftBumperPressed()) {
  //       m_pneumatics.m_pneumaticsSubsystem.set(Value.kForward);
  //     }
  //     else {
  //       m_pneumatics.m_pneumaticsSubsystem.set(Value.kReverse);
  //     }

  // }
}