package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

import static org.firstinspires.ftc.teamcode.MethodSlave.beaconCheckIn;
import static org.firstinspires.ftc.teamcode.MethodSlave.encoderForward;
import static org.firstinspires.ftc.teamcode.MethodSlave.gyroTurn;
import static org.firstinspires.ftc.teamcode.MethodSlave.realEncoderForwardLeft;
import static org.firstinspires.ftc.teamcode.MethodSlave.realEncoderForwardRight;
import static org.firstinspires.ftc.teamcode.MethodSlave.shootOne;
import static org.firstinspires.ftc.teamcode.MethodSlave.shootTwo;

/**
 * Created by Fluff on 2/26/2017.
 */

@Autonomous(name="Corner Shoot Two Park Blue", group="Park Corner")
public class VVShootTwoParkCornerBlue extends LinearOpMode {
    //initialize motors, servos, booleans, and sensors
    DcMotor leftMotor;
    DcMotor rightMotor;
    DcMotor loader;
    DcMotor launcher;

    Servo buttonPresser;
    Servo floodgate;

    ColorSensor color;

    OpticalDistanceSensor eopd;

    TouchSensor touch;

    GyroSensor gyro;

    @Override
    public void runOpMode() throws InterruptedException {
        //initializes components to names on phone
        leftMotor = hardwareMap.dcMotor.get("left");
        rightMotor = hardwareMap.dcMotor.get("right");
        loader = hardwareMap.dcMotor.get("loader");
        launcher = hardwareMap.dcMotor.get("launcher");

        buttonPresser = hardwareMap.servo.get("button");
        floodgate = hardwareMap.servo.get("floodGate");

        color = hardwareMap.colorSensor.get("color");

        eopd = hardwareMap.opticalDistanceSensor.get("eopd");

        touch = hardwareMap.touchSensor.get("touch");

        gyro = hardwareMap.gyroSensor.get("gyro");

        //close the floodgate
        floodgate.setPosition(1);
        buttonPresser.setPosition(1);

        //waits for user to press start
        waitForStart();

        sleep(10000);
        leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        encoderForward(12, 1.0, leftMotor, rightMotor, opModeIsActive());
        shootTwo(floodgate, launcher, opModeIsActive());
        realEncoderForwardRight(2.5, 1.0, leftMotor, rightMotor, opModeIsActive());
        encoderForward(-67, -1.0, leftMotor, rightMotor, opModeIsActive());
    }

}

