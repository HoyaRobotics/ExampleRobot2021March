/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController.Button;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static class Controls{
        //Drive controls
        public static final Hand DRIVE  = Hand.kLeft;
        public static final int RUN_INTAKE_FWD = Button.kBumperRight.value;
        public static final int RUN_INTAKE_BKW = Button.kBumperLeft.value;

    }
    //USB ids
    public static final int DRIVER = 0;

    //PWM ids
    public static final int FRONT_LEFT_DRIVE = 0;
    public static final int FRONT_RIGHT_DRIVE = 1;

    // DriveBase
    public static final double CONTROL_DEADBAND = 0.10;

    //Can bus ids
    public static final int INTAKE_MOTOR = 25;
}
