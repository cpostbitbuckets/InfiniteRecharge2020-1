/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.nerdherd.lib.motor.motorcontrollers.NerdyTalon;
import com.nerdherd.lib.motor.motorcontrollers.SmartCANMotorController;
import com.nerdherd.lib.motor.single.mechanisms.SingleMotorArm;

import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile;
import frc.robot.RobotMap;
import frc.robot.constants.HoodConstants;

public class Hood extends SingleMotorArm  {
  public double storedAngle = -10;

  public Hood() {
    super(RobotMap.kHoodID, "Hood", true, true);
    // super(RobotMap.kHoodID, "Hood", true, true );
    super.configAngleConversion(HoodConstants.kHoodAngleRatio, HoodConstants.kHoodAngleOffset);
    super.configTrapezoidalConstraints(new TrapezoidProfile.Constraints(HoodConstants.kHoodVel, HoodConstants.kHoodAccel));
    super.configPIDF(HoodConstants.kHoodP, 0, 0, HoodConstants.kHoodF);
    super.configFFs(HoodConstants.kHoodGravityFF, HoodConstants.kHoodStaticFriction);
    super.configOblargConstants(HoodConstants.kHoodS, HoodConstants.kHoodCos, HoodConstants.kHoodV, HoodConstants.kHoodA);
    super.configMotionMagic(HoodConstants.kMotionMagicAcceleration, HoodConstants.kMotionMagicVelocity);
    super.configDeadband(0.0004);
    
  //96 for entire arm, -28 for start of middle of hood
  //
  }

  public void storeAngle(double angle){
    storedAngle = angle;
  }

  public void setStoredAngle(){
    this.setAngleMotionMagic(storedAngle);
  }
}