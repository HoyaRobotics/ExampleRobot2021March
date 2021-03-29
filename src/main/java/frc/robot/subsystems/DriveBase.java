/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

/**
 * This subsystem encapsulates the motors running the
 * robot's drivebase.
 * We use two CIM motors (one on each side).
 * 
 * It is used with the arcade drive control scheme,
 * where the joystick's y-axis controls throttle and 
 * the x-axis controls rotation.
 */
public class DriveBase extends SubsystemBase {
  //Motor controllers
  private final Talon leftLeader  = new Talon(Constants.FRONT_LEFT_DRIVE);
  private final Talon rightLeader = new Talon(Constants.FRONT_RIGHT_DRIVE);

  private final DifferentialDrive drive = new DifferentialDrive(leftLeader, rightLeader);
  /**
   * Creates a new DriveBase.
   */
  public DriveBase() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  /**
  * Drives the robot with arcade controls, supplying throttle and rotation.
  */
  public void arcadeDrive(double throttle, double rotation){
    rotation *= -1;

    drive.arcadeDrive(throttle, rotation);
  }
}
