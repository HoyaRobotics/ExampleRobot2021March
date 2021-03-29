/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class AutonomousPicker extends SubsystemBase {
  public enum StartingPosition {
    LEFT, CENTRE, RIGHT
  }

  //Declare class variables
  public StartingPosition startingPosition = null;
  private SendableChooser<StartingPosition> startPositionChooser;

  /**
   * Creates a new AutonomousPicker.
   */
  public AutonomousPicker() {
    System.out.println("In auto picker");
    startPositionChooser = new SendableChooser<>();
    startPositionChooser.setDefaultOption("Left", StartingPosition.LEFT);
    startPositionChooser.addOption("Centre", StartingPosition.CENTRE);
    startPositionChooser.addOption("Right", StartingPosition.RIGHT);


    SmartDashboard.putData("Starting Position", startPositionChooser);
    System.out.println("out of autopicker");
  }

  public StartingPosition getAutonomous(){
    
    return startPositionChooser.getSelected();
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
