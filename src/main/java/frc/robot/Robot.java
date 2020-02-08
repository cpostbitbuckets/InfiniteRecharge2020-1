/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.nerdherd.lib.logging.LoggableLambda;
import com.nerdherd.lib.logging.NerdyBadlog;
import com.nerdherd.lib.misc.AutoChooser;
import com.nerdherd.lib.motor.dual.DualMotorIntake;
import com.nerdherd.lib.motor.single.SingleMotorMechanism;
import com.nerdherd.lib.pneumatics.Piston;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Hood;
import frc.robot.subsystems.Jevois;
import frc.robot.subsystems.Shooter;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
	public static final String kDate = "2020_01_25_";
  
  public static AutoChooser chooser;
  public static Drive drive;
  public static Jevois jevois;
  public static Hood hood;
  public static DriverStation ds;
  public static Shooter shooter;
  public static DualMotorIntake feeder;
  public static SingleMotorMechanism intakeRoll;
  public static SingleMotorMechanism index;
  // public static SingleMotorMechanism motor;
  public static PowerDistributionPanel pdp;
  public static OI oi;
  public static Command m_autonomousCommand;
  public static Piston intake;
  public static Piston climber;
  public static Piston panelPos;
  public static SingleMotorMechanism panelRot;


  
  @Override
  public void robotInit() {
    hood = new Hood();
    // drive = new Drive();
    // jevois = new Jevois(115200, SerialPort.Port.kUSB);
		// jevois.startCameraStream();
    shooter = new Shooter();
    // motor = new SingleMotorMechanism(6, "Motor", true, true);
    ds = DriverStation.getInstance();
    feeder = new DualMotorIntake(new SingleMotorMechanism(RobotMap.kFeederID1, "Top Intake", true, false), new SingleMotorMechanism(RobotMap.kFeederID2, "Bottom Intake", false, false));
    index = new SingleMotorMechanism(RobotMap.kIndex, "Index", false, true);
    intakeRoll = new SingleMotorMechanism(RobotMap.kIntakeRoll, "Intake", true, true);
    intake = new Piston(RobotMap.kIntakePort1, RobotMap.kIntakePort2);
    chooser = new AutoChooser();
    pdp = new PowerDistributionPanel();
    climber = new Piston(1, 2);
    panelPos = new Piston(3, 4);
    panelRot = new SingleMotorMechanism(5, "Control Panel", false, false);
    oi = new OI();
    // drive.setDefaultCommand(new ArcadeDrive(Robot.drive, Robot.oi));
    LoggableLambda busVoltage = new LoggableLambda("Bus Voltage", () -> pdp.getVoltage());

    NerdyBadlog.initAndLog("/media/sdb1/logs/", "FeederToShooter", 0.02, shooter, feeder, index, busVoltage, drive);


  }

  @Override
  public void robotPeriodic() {
    // CommandScheduler.getInstance().run();
    // CameraServer.getInstance().
    shooter.reportToSmartDashboard();
    // feeder.reportToSmartDashboard();
    // index.reportToSmartDashboard();
    // jevois.reportToSmartDashboard();
    // motor.reportToSmartDashboard();
    hood.reportToSmartDashboard();
  }

  @Override
  public void disabledInit() {
    // hood.resetEncoder();
  }
  @Override
  public void autonomousInit() {
    if (m_autonomousCommand != null) { 
      m_autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {
    CommandScheduler.getInstance().run();
    
  }

  @Override
  public void teleopInit() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void teleopPeriodic() {
    CommandScheduler.getInstance().run();
  
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

}
