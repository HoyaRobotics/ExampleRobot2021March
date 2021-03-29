/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.DriveBase;
import edu.wpi.first.wpilibj2.command.CommandBase;
/**
 * This command allows the drivetrain to run at a certain
 * percent output for a certain time.
 * 
 * This is only used in autonomous.
 */
public class DriveForTime extends CommandBase {
  //variables
  private final DriveBase driveBase;
  private final double speed;

  private int counter = 0;
  private int target = 0;
  
  /**
   * Creates a new DriveForTime.
   */
  public DriveForTime(DriveBase driveBase, double speed, double seconds) {
    this.driveBase = driveBase;
        this.speed = speed;

        // Convert time in seconds to robot cycles (50 cycles/s)
        target = (int)(seconds * 50);

        addRequirements(driveBase);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(counter<target)
      counter++;
    
    driveBase.arcadeDrive(speed, 0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveBase.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return counter >= target;
  }
}
