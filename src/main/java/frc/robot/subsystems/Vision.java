/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSink;
import edu.wpi.cscore.VideoSource.ConnectionStrategy;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Vision extends SubsystemBase {
  public UsbCamera camera1;
  public UsbCamera camera2;
  public VideoSink server;
  public int currentCamera = 0;
  /**
   * Creates a new Vision.
   */
  public Vision() {
    this.camera1 = CameraServer.getInstance().startAutomaticCapture(0);
    this.camera2 = CameraServer.getInstance().startAutomaticCapture(1);
    server = CameraServer.getInstance().getServer();

    camera1.setResolution(320, 240);
    camera2.setResolution(320, 240);
    camera1.setConnectionStrategy(ConnectionStrategy.kKeepOpen);
    camera2.setConnectionStrategy(ConnectionStrategy.kKeepOpen);
    server.setSource(camera1);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void changeCamera()
  {
    if(currentCamera == 0){
      currentCamera = 1;
      server.setSource(camera2);
    }else{
      currentCamera = 0;
      server.setSource(camera1);
    }
  }

}
