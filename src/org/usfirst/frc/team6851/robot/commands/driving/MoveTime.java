package org.usfirst.frc.team6851.robot.commands.driving;

import org.usfirst.frc.team6851.robot.Constant;
import org.usfirst.frc.team6851.robot.Dashboard;
import org.usfirst.frc.team6851.robot.commands.CommandBase;
import org.usfirst.frc.team6851.robot.subsystems.DriveBase;

import edu.wpi.first.wpilibj.Timer;

public class MoveTime extends CommandBase {
	private double distanceInRotation;
	private double distanceToFinishRight;
	private double distanceToFinishLeft;
	private double speedX;
	private double speedY;
	private double Time;
	private double EndTime;
	private double AngleDepart;
	private double RotationAngle;
	
	public MoveTime(double speedX, double speedY, double Time, double rotationangle) {
		requires(driveBase);
		this.speedX = speedX;
		this.speedY = speedY;
		this.Time = Time;
		this.RotationAngle = rotationangle;
	}
	
	@Override
	protected void initialize() {
		Dashboard.nextAutonomousStep();
		super.initialize();
		this.EndTime = System.currentTimeMillis()+this.Time*1000;
		this.AngleDepart = driveBase.getOrientation();
		//this.distanceToFinishRight = driveBase.getRightEncoderDistance() + distanceInRotation;
		//this.distanceToFinishLeft = driveBase.getLeftEncoderDistance() + distanceInRotation;
	}
	
	@Override
	protected void execute() {
		if (this.RotationAngle == 0) {
			this.speedY = this.speedY+((this.AngleDepart-driveBase.getOrientation())/(500*this.speedX));
		}	
		driveBase.drive(this.speedX, this.speedY);
		Dashboard.updateAutonomousStep("Moving at X: " + this.speedX + "MoveY:" + this.speedY);
	}
	@Override
	protected boolean isFinished() {
//		WaitCommand(Time);
		if (this.RotationAngle == 0) {
		   return (System.currentTimeMillis()>this.EndTime);
		} else {
			if (this.RotationAngle < 0) {
			   return (driveBase.getOrientation()<(this.AngleDepart+this.RotationAngle));	
			} else {
			   return (driveBase.getOrientation()>(this.AngleDepart+this.RotationAngle));					
			}
		}
	}
	@Override
	protected void end() {
		driveBase.drive(0.0, 0.0);     
	}

}
