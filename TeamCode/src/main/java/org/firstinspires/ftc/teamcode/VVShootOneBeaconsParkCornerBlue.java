package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

import static org.firstinspires.ftc.teamcode.MethodSlave.beaconCheck;
import static org.firstinspires.ftc.teamcode.MethodSlave.encoderForward;
import static org.firstinspires.ftc.teamcode.MethodSlave.encoderTurn;
import static org.firstinspires.ftc.teamcode.MethodSlave.lineApproach;
import static org.firstinspires.ftc.teamcode.MethodSlave.lineFollow;
import static org.firstinspires.ftc.teamcode.MethodSlave.shootOne;

/**
 * Created by Hasan on 12/1/2016.
 */

//sets program name and group on phone, and groups are in alphabetic order
@Autonomous(name="Corner Shoot One Beacons Park Blue", group="Beacon")
public class VVShootOneBeaconsParkCornerBlue extends LinearOpMode {

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

        //close the floodgate
        floodgate.setPosition(1);
        buttonPresser.setPosition(0.5);
        //waits for user to press start
        waitForStart();

        encoderForward(49, 0.5, leftMotor, rightMotor,opModeIsActive());
        shootOne(floodgate, launcher, opModeIsActive());
        encoderTurn(12.5, 1.0, false, leftMotor, rightMotor, opModeIsActive());
        encoderForward(72, 1.0, leftMotor, rightMotor, opModeIsActive());
        encoderTurn(6.25, 1.0, false, leftMotor, rightMotor, opModeIsActive());
        lineApproach(0.25, 0.5, true, leftMotor, rightMotor, eopd, opModeIsActive());
        lineFollow(0.25, 0.5, true, leftMotor, rightMotor, touch, eopd, opModeIsActive());
        beaconCheck(true, color, buttonPresser);
        sleep(1000);
        buttonPresser.setPosition(0.5);
        encoderForward(-48, -1, leftMotor, rightMotor, opModeIsActive());
        encoderTurn(5.5, 1.0, true, leftMotor, rightMotor, opModeIsActive());
        lineApproach(0.25, 0.5, true, leftMotor, rightMotor, eopd, opModeIsActive());
        lineFollow(0.25, 0.5, true, leftMotor, rightMotor, touch, eopd, opModeIsActive());
        beaconCheck(true, color, buttonPresser);
        sleep(1000);
        buttonPresser.setPosition(0.5);
        encoderForward(-18, -1, leftMotor, rightMotor, opModeIsActive());
        encoderTurn(12.5, 1, false, leftMotor, rightMotor, opModeIsActive());
        encoderForward(144, 1, leftMotor, rightMotor, opModeIsActive());
        encoderTurn(6.25, 1, true, leftMotor, rightMotor, opModeIsActive());
        encoderForward(12, 1, leftMotor, rightMotor, opModeIsActive());
    }


}
