/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.auto;

import com.nerdherd.lib.drivetrain.auto.DriveStraightContinuous;
import com.nerdherd.lib.motor.commands.SetDualMotorPower;
import com.nerdherd.lib.motor.commands.SetMotorPower;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Robot;
import frc.robot.commands.AutolineShot;
import frc.robot.commands.ShootBall;
import frc.robot.commands.flywheel.InfiniteRecharge;

/**
 * Add your docs here.
 */
public class BasicAuto extends SequentialCommandGroup {

    public BasicAuto() {
        addCommands(
            new AutolineShot(), 
            new InstantCommand(() -> Robot.hood.setStoredAngle(), Robot.hood), 
            new WaitCommand(2),
            new ShootBall(),
            new WaitCommand(2),
            new DriveStraightContinuous(Robot.drive, 10000, -0.25)
        );
    }

}