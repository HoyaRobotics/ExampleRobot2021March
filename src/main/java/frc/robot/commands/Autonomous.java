/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.AutonomousPicker;
import frc.robot.subsystems.DriveBase;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class Autonomous extends CommandBase {
  private final AutonomousPicker autonomousPicker;
  private final DriveBase driveBase;
  private final Intake intake;
 
  /**
   * Creates a new Autonomous.
   */
  public Autonomous(AutonomousPicker autonomousPicker, DriveBase driveBase, Intake intake) {
    this.autonomousPicker = autonomousPicker;
    this.driveBase = driveBase;
    this.intake = intake;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(autonomousPicker);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  public Command runAutonomous(){

        SequentialCommandGroup autoCommands = new SequentialCommandGroup();
        switch (autonomousPicker.getAutonomous()) {
          case LEFT:
            System.out.println("Went left");
          autoCommands = 
              new SequentialCommandGroup(
              new DriveForTime(driveBase, 1 , 4),
              new RunIntake(intake, 0.5, true, 3)
            );
            break;
          case RIGHT:
            System.out.println("Went right");
            autoCommands =           new SequentialCommandGroup(
              new DriveForTime(driveBase, -1, 4),
              new DriveForTime(driveBase, 0, 3)
            );
            break;
        
          default:
            autoCommands =  new SequentialCommandGroup(
              new DriveForTime(driveBase, 0, 0)
            );
            break;
        }
        return autoCommands;
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
