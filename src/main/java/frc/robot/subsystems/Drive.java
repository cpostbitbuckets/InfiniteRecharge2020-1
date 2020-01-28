/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.nerdherd.lib.drivetrain.experimental.Drivetrain;
import com.nerdherd.lib.drivetrain.teleop.ArcadeDrive;
import com.nerdherd.lib.motor.motorcontrollers.CANMotorController;
import com.nerdherd.lib.motor.motorcontrollers.NerdyTalon;
import com.nerdherd.lib.motor.motorcontrollers.NerdyVictorSPX;

import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.constants.DriveConstants;

// import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends Drivetrain {
  /**
   * Creates a new Drive.
   */
  public Drive() {
    super(new NerdyTalon(RobotMap.kLeftMasterTalonID), new NerdyTalon(RobotMap.kRightMasterTalonID),
    new CANMotorController[] {
      new NerdyTalon(RobotMap.kLeftSlaveTalon1ID),
    },
    new CANMotorController[] {
      new NerdyTalon(RobotMap.kRightSlaveTalon1ID),
    },
     true, false, 1);
    
     super.configAutoChooser(Robot.chooser);
     super.configMaxVelocity(DriveConstants.kMaxVelocity);
     super.configSensorPhase(false, false);
     
     super.configTicksPerFoot(DriveConstants.kLeftTicksPerFoot, DriveConstants.kRightTicksPerFoot);
     super.configLeftPIDF(0.0, 0, 0, DriveConstants.kLeftF);
     super.configRightPIDF(0.0, 0, 0, DriveConstants.kRightF);
     super.configStaticFeedforward(DriveConstants.kLeftStatic, DriveConstants.kRightStatic);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}