package org.firstinspires.ftc.teamcode.TeleOp;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.wraper.GLOBAL_CHCKING_SYSTEM;
import org.firstinspires.ftc.teamcode.wraper.MotorSu;
import org.firstinspires.ftc.teamcode.wraper.SensorColorSu;

@TeleOp
public class BASE_LOOP extends LinearOpMode {
    MotorEx motor;

    MotorSu SuMotor;
    SensorColorSu sensorColorSu;
    GLOBAL_CHCKING_SYSTEM chckingSystem;

    @Override
    public void runOpMode() throws InterruptedException {
        sensorColorSu = new SensorColorSu(hardwareMap, "SC_Su");

        chckingSystem = new GLOBAL_CHCKING_SYSTEM(hardwareMap);
        SuMotor = new MotorSu(hardwareMap, "Su", Motor.GoBILDA.RPM_312);


        waitForStart();
        while (opModeIsActive()){
            SuMotor.SuperSetPower(1);
        chckingSystem.EndCycle();

    }
}}