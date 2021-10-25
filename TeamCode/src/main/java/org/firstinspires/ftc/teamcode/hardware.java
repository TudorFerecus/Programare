package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class hardware
{
    public DcMotor[] motor = new DcMotor[4];
    public Servo brat = null;
    public Servo gheara = null;

    private HardwareMap hardwareMap = null;
    public ElapsedTime runTime = new ElapsedTime();

    public hardware(HardwareMap hdMap)
    {
        initializare(hdMap);
    }

    private void initializare(HardwareMap hdMap)
    {
        this.hardwareMap = hdMap;
        brat = hardwareMap.get(Servo.class, "brat");
        gheara = hardwareMap.get(Servo.class, "gheara");

        initMotors();
    }

    private void initMotors() {
        for (int i = 0; i < motor.length; i++) {
            motor[i] = hardwareMap.get(DcMotor.class, "m" + Integer.toString(i));
            motor[i].setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            motor[i].setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motor[i].setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            motor[i].setPower(0);
            motor[i].setDirection(DcMotorSimple.Direction.REVERSE);
        }
    }

}
