package org.firstinspires.ftc.teamcode.wraper;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.hardware.HardwareMap;


import java.util.List;

public class GLOBAL_CHCKING_SYSTEM {
    List<LynxModule> allHubs = hardwareMap.getAll(LynxModule.class);
    List<MotorSu> Motors;
    List<SensorColorSu> ColorSensors;
    public GLOBAL_CHCKING_SYSTEM(HardwareMap hardwareMap) {
        Motors = hardwareMap.getAll(MotorSu.class);
        ColorSensors = hardwareMap.getAll(SensorColorSu.class);
        for (LynxModule module : allHubs) {
            module.setBulkCachingMode(LynxModule.BulkCachingMode.MANUAL);
        }
    }
    public void EndCycle(){
        powerMotors();
        clearCash();


    }
    private void powerMotors(){
        for (int i = 0; i < Motors.size(); i++){
            Motors.get(i).changePower();
        }
    }
    private void CheckColorSensor(){
        for (int i = 0; i < ColorSensors.size(); i++){
            ColorSensors.get(i).ReadData();
        }
    }
    private void clearCash(){
        for (LynxModule module : allHubs) {
            module.clearBulkCache();

        }
    }
}
