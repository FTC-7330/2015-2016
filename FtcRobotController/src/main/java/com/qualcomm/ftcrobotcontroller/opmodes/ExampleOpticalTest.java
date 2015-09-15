package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;

/**
 * Created by jacks on 9/14/2015.
 */
public class ExampleOpticalTest extends OpMode {
    DcMotor motorFrontRight;
    DcMotor motorBackRight;
    DcMotor motorFrontLeft;
    DcMotor motorBackLeft;
    OpticalDistanceSensor distanceSensor;

    public void init()
    {
        //for tank drive
        motorFrontRight = hardwareMap.dcMotor.get("motorFrontRight");
        motorBackRight = hardwareMap.dcMotor.get("motorBackRight");
        motorFrontLeft = hardwareMap.dcMotor.get("motorFrontLeft");
        motorBackLeft = hardwareMap.dcMotor.get("motorBackLeft");

        motorFrontLeft.setDirection(DcMotor.Direction.REVERSE);
        motorBackLeft.setDirection(DcMotor.Direction.REVERSE);

        //need name for sensor
        distanceSensor = hardwareMap.opticalDistanceSensor.get("sensor_OPTICALMAGIC");
    }
    public void loop()
    {
        double reflectLight = distanceSensor.getLightDetected();
        if(reflectLight <= 1 )
        {

            //set motor values to number that i don't know
            motorBackLeft.setPower(800);
            motorFrontLeft.setPower(0);
            motorFrontRight.setPower(800);
            motorBackRight.setPower(0);
        }
        else
        {
            motorBackLeft.setPower(0);
            motorFrontLeft.setPower(400);
            motorFrontRight.setPower(0);
            motorBackRight.setPower(800);
            telemetry.addData("Light value", reflectLight);
        }

    }
}
