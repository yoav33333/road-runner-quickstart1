package org.firstinspires.ftc.teamcode.TeleOp;

import com.arcrobotics.ftclib.hardware.SensorColor;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.wraper.MotorSu;

import java.util.List;

@TeleOp
public class BASE_LOOP extends LinearOpMode {
    MotorEx motor;

    MotorSu SuMotor;
    List<LynxModule> allHubs = hardwareMap.getAll(LynxModule.class);
    public List<MotorSu> motors;
    public List<SensorColor> sensorColors;
    @Override
    public void runOpMode() throws InterruptedException {
        motors = hardwareMap.getAll(MotorSu.class);
        SuMotor = new MotorSu(hardwareMap, "Su", Motor.GoBILDA.RPM_312);
        for (LynxModule module : allHubs) {
            module.setBulkCachingMode(LynxModule.BulkCachingMode.MANUAL);
        }

        waitForStart();
        while (opModeIsActive()){
            for (LynxModule module : allHubs) {
                module.clearBulkCache();
            }


    }
}}