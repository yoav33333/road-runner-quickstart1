package org.firstinspires.ftc.teamcode.wraper;

import static org.firstinspires.ftc.teamcode.wraper.SensorColorSu.Color.Alpha;
import static org.firstinspires.ftc.teamcode.wraper.SensorColorSu.Color.Blue;
import static org.firstinspires.ftc.teamcode.wraper.SensorColorSu.Color.Green;
import static org.firstinspires.ftc.teamcode.wraper.SensorColorSu.Color.Red;

import com.arcrobotics.ftclib.hardware.SensorColor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.Arrays;

public class SensorColorSu extends SensorColor {
    private ColorSensor colorSensor;
    private int TestingRate;
    boolean needToReadRed = false;
    boolean needToReadBlue = false;
    boolean needToReadGreen = false;
    boolean needToReadAlpha = false;
    public int HighestValue = 0;
    enum Color{
        Red,
        Blue,
        Green,
        Alpha
    }
    int calls = 0;
    int[] colorArry = {0,0,0,0};

    public SensorColorSu(ColorSensor colorSensor) {
        super(colorSensor);
        this.colorSensor = colorSensor;
    }

    public SensorColorSu(HardwareMap hardwareMap, String name, int testingRate) {
        this(hardwareMap.get(ColorSensor.class, name));
        TestingRate = testingRate;
    }
    public SensorColorSu(HardwareMap hardwareMap, String name) {
        this(hardwareMap.get(ColorSensor.class, name));
        TestingRate = 1;
    }
    public int[] ReadData(){
        if (calls%TestingRate == 0) {
            if (needToReadRed) {
                needToReadRed = false;
                colorArry[0] = colorSensor.red();
            }
            if (needToReadBlue){
                needToReadBlue = false;
                colorArry[1] = colorSensor.blue();
            }
            if (needToReadGreen){
                needToReadGreen = false;
                colorArry[2] = colorSensor.green();
            }
            if (needToReadAlpha){
                needToReadAlpha = false;
                colorArry[3] = colorSensor.alpha();
            }
        }
        return colorArry;
    }
    public int getRed(){
        return colorArry[0];
    }
    public int getBlue(){
        return colorArry[1];
    }
    public int getGreen(){
        return colorArry[2];
    }
    public int getAlpha(){
        return colorArry[3];
    }
    public Color dominantColor(){

        HighestValue = Arrays.stream(colorArry).max().getAsInt();
        if (HighestValue == getRed()){
            return Red;
        }
        else if (HighestValue == getBlue()){
            return Blue;
        }
        else if (HighestValue == getGreen()){
            return Green;
        }
        else {
            return Alpha;
        }

    }


}
