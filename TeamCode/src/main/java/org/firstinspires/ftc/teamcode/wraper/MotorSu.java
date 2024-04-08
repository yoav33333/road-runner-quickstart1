package org.firstinspires.ftc.teamcode.wraper;

import androidx.annotation.NonNull;

import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class MotorSu extends MotorEx {
    private double currentPwr;
    private double newPwr;


    public MotorSu(@NonNull HardwareMap hMap, String id) {
        this(hMap, id, GoBILDA.NONE);
        ACHIEVABLE_MAX_TICKS_PER_SECOND = motorEx.getMotorType().getAchieveableMaxTicksPerSecond();
    }

    public MotorSu(@NonNull HardwareMap hMap, String id, @NonNull GoBILDA gobildaType) {
        super(hMap, id, gobildaType);
        motorEx = (DcMotorEx) super.motor;
    }


    public MotorSu(@NonNull HardwareMap hMap, String id, double cpr, double rpm) {
        super(hMap, id, cpr, rpm);
        motorEx = (DcMotorEx) super.motor;
    }
    public boolean isBusy(){
        return motorEx.isBusy();
    }
    public void SetRPM(double RPM){
        motorEx.setVelocity(ACHIEVABLE_MAX_TICKS_PER_SECOND/getMaxRPM()*60*RPM);
    }
    public void SuperSetPower(double pwr){
        newPwr = pwr;
    }
    public void changePower(){
        if (currentPwr!=newPwr){
            motorEx.setPower(newPwr);
            currentPwr = newPwr;
        }
    }

}
