package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
//import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.util.sendable.SendableRegistry;
//import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.RobotController;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
//import edu.wpi.first.wpilibj.RobotController;

public class Robot extends TimedRobot {
    private final CANSparkMax m_topmotor = new CANSparkMax(3, MotorType.kBrushed);
    private final CANSparkMax m_bottommotor = new CANSparkMax(4, MotorType.kBrushed);
    //private final RobotController m_Controller = new RobotController (m_topmotor,m_bottommotor);
    private final DifferentialDrive m_kitmotordrive = new DifferentialDrive(m_topmotor, m_bottommotor);
    private final XboxController kitbot_stick = new XboxController(0);
    //private final Joystick swervedrive_stick = new Joystick(1);

    @Override
    public void robotInit() {
        SendableRegistry.addChild(m_kitmotordrive, m_topmotor);
        SendableRegistry.addChild(m_kitmotordrive, m_bottommotor);
        m_topmotor.setInverted(true);
        m_bottommotor.setInverted(false);
    }

    @Override
    public void robotPeriodic() {
        // Periodic code here
    }

    @Override
    public void autonomousInit() {
        // Autonomous initialization code here
    }

    @Override
    public void autonomousPeriodic() {
        // Autonomous periodic code here
    }

    @Override
    public void teleopInit() {
        // Teleop initialization code here
    }

    @Override
    public void teleopPeriodic() {
        // Teleop periodic code here
        // Drive the robot using arcade drive with joystick inputs
        //m_kitmotordrive.arcadeDrive(-kitbot_stick.getRawAxis(1), -kitbot_stick.getRawAxis(4));

        //This set of code should turn on the motors together when the left bumper is pressed which is button 5.
        //Once the button is release, the motors should stop spinning automatically. The same thing applies to button
        //6, when it is pressed the motors will intake the music note.

        if (kitbot_stick.getRawButtonPressed(5)) {
            m_kitmotordrive.setMaxOutput(1);
        }
        else if (kitbot_stick.getRawButtonPressed(6)) {
            m_kitmotordrive.setMaxOutput(-1);
        }
        else if (kitbot_stick.getRawButtonReleased(5)) {
            m_kitmotordrive.setMaxOutput(0);
        }
         else if (kitbot_stick.getRawButtonReleased(6)) {
            m_kitmotordrive.setMaxOutput(0);
        }

    }

}
