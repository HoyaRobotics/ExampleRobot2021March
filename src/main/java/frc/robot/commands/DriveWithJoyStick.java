/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveBase;
import frc.robot.util.Utils;

/**
 * This class allows for control of the drivetrain
 * using a joystick. It runs the drivetrain in
 * arcade drive mode.
 * (the joystick's y-axis controls throttle and
 * x-axis controls rotation)
 */
public class DriveWithJoyStick extends CommandBase {

  //variables
  private final DriveBase driveBase;
  private final DoubleSupplier throttle;
  private final DoubleSupplier rotation;

  /**
   * Creates a new DriveWithJoyStick.
   */
  public DriveWithJoyStick(DriveBase driveBase, DoubleSupplier throttle, DoubleSupplier rotation) {
    this.driveBase = driveBase;
    this.throttle = throttle;
    this.rotation = rotation;
    
    addRequirements(driveBase);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putNumber("Throttle", throttle.getAsDouble());
    driveBase.arcadeDrive(
      Utils.applyDeadband(throttle.getAsDouble(), Constants.CONTROL_DEADBAND),
      Utils.applyDeadband(rotation.getAsDouble(), Constants.CONTROL_DEADBAND)
    );
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveBase.arcadeDrive(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
