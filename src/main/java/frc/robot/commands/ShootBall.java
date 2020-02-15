/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.constants.ShooterConstants;

public class ShootBall extends CommandBase {
  /**
   * Creates a new ShootBall.
   */
  public ShootBall() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.index, Robot.hopper, Robot.hood);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.hood.setStoredAngle();
    Robot.index.setPower(0.5);
    Robot.hopper.setPower(0.69, 0.6);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    Robot.index.setPower(0);
    Robot.hopper.setPower(0, 0);

    return false;
  }
}