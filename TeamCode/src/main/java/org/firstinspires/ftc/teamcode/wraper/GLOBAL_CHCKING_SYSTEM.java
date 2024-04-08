package org.firstinspires.ftc.teamcode.wraper;

import androidx.annotation.NonNull;

import com.arcrobotics.ftclib.hardware.SensorColor;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.List;

public class GLOBAL_CHCKING_SYSTEM {
    List<MotorSu> Motors;
    public GLOBAL_CHCKING_SYSTEM(List<MotorSu> motors) {
        Motors = motors;
    }
    public void check(){
        for (int i = 0; i<Motors.size(); i++){
            Motors.get(i).changePower();
        }
    }
}
