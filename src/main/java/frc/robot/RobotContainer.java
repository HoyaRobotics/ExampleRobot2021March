/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import static frc.robot.Constants.*;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.DriveForTime;
import frc.robot.commands.DriveWithJoyStick;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.RunIntake;
import frc.robot.commands.setCamera;
//import frc.robot.commands.Autonomous.StartingPosition;
import frc.robot.subsystems.DriveBase;
import frc.robot.subsystems.AutonomousPicker;
import frc.robot.commands.Autonomous;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Vision;
import frc.robot.subsystems.AutonomousPicker.StartingPosition;
//import sun.swing.SwingAccessor;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.InstantCommand;
/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  // Controller
  private final XboxController driver = new XboxController(DRIVER);

  // Robot subsystems
  private final DriveBase driveBase = new DriveBase();
  private final AutonomousPicker autonomousPicker = new AutonomousPicker();
  private final Vision vision = new Vision();
  private final Intake intake = new Intake();

  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final Autonomous autonomous = new Autonomous(autonomousPicker, driveBase, intake);
  private final setCamera setcamera = new setCamera(vision);// = new 
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  private RunIntake runIntake;
 // private final Autonomous auto = new Autonomous();


  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    System.out.println("Robot Container");
    // Drivebase control
    driveBase.setDefaultCommand(new DriveWithJoyStick(driveBase, 
      () -> driver.getY(Controls.DRIVE), 
      () -> driver.getX(Controls.DRIVE)));
      
      JoystickButton btnADriver = new JoystickButton(driver, Button.kA.value);
      btnADriver.whenPressed(new InstantCommand(() -> {setcamera.cc();}));

      JoystickButton timeIntake = new JoystickButton(driver, Controls.RUN_INTAKE_BKW);
      timeIntake.whenPressed(new RunIntake(intake, 0.1, true, 2));

      
      JoystickButton runIntakeFwd = new JoystickButton(driver, Controls.RUN_INTAKE_FWD);
      runIntakeFwd.whenPressed(new InstantCommand(()->
      {
        intake.setIntakeSpeed(0.5);
      }
      ));
      runIntakeFwd.whenReleased(new InstantCommand(()->
      {
        intake.setIntakeSpeed(0);
      }
      ));
      // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return autonomous.runAutonomous();
  }
}
