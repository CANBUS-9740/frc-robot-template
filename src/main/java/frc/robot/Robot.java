package frc.robot;

import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class Robot extends TimedRobot {

    SparkMax motor;
    XboxController controller;
    Ultrasonic ultrasonic;
    @Override
    public void robotInit() {
        motor = new SparkMax(46, SparkLowLevel.MotorType.kBrushless);

        XboxController controller = new XboxController(0);

        Ultrasonic ultrasonic = new Ultrasonic(6,5);
        Ultrasonic.setAutomaticMode(true);
        SparkMaxConfig config = new SparkMaxConfig();
        config.encoder.
                positionConversionFactor(1/ 3).
                velocityConversionFactor(1 / 3);
        config.idleMode(SparkBaseConfig.IdleMode.kBrake);
        config.smartCurrentLimit(0,0);

        motor.configure(config , SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters);
        motor.set(0.5);





    }

    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
    }

    @Override
    public void simulationInit() {

    }

    @Override
    public void simulationPeriodic() {

    }

    @Override
    public void disabledInit() {

    }

    @Override
    public void disabledPeriodic() {

    }

    @Override
    public void disabledExit() {

    }

    @Override
    public void teleopInit() {

    }

    @Override
    public void teleopPeriodic() {
        if (controller.getAButton()) {
            motor.set(0.5);
            if (ultrasonic.getRangeMM() < 10) {
                motor.stopMotor();
            }
        }
    }

    @Override
    public void teleopExit() {

    }

    @Override
    public void autonomousInit() {

    }

    @Override
    public void autonomousPeriodic() {

    }

    @Override
    public void autonomousExit() {

    }

    @Override
    public void testInit() {

    }

    @Override
    public void testPeriodic() {

    }

    @Override
    public void testExit() {

    }
}
