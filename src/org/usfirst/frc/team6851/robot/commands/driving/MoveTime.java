package org.usfirst.frc.team6851.robot.commands.driving;

import org.usfirst.frc.team6851.robot.Constant;
import org.usfirst.frc.team6851.robot.Dashboard;
import org.usfirst.frc.team6851.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.Timer;

public class MoveTime extends CommandBase {
	private double distanceInRotation;
	private double distanceToFinishRight;
	private double distanceToFinishLeft;
	private double speedX;
	private double speedY;
	private double Time;
	private double EndTime;
	
	public MoveTime(double speedX, double speedY, double Time) {
		requires(driveBase);
		this.speedX = speedX;
		this.speedY = speedY;
		this.Time = Time;
	}
	
	@Override
	protected void initialize() {
		Dashboard.nextAutonomousStep();
		super.initialize();
		this.EndTime = System.currentTimeMillis()+this.Time*1000;
		//this.distanceToFinishRight = driveBase.getRightEncoderDistance() + distanceInRotation;
		//this.distanceToFinishLeft = driveBase.getLeftEncoderDistance() + distanceInRotation;
	}
	
	@Override
	protected void execute() {
		
		driveBase.drive(speedX, speedY);
		Dashboard.updateAutonomousStep("Moving at X: " + speedX + "MoveY:" + speedY);
	}
	@Override
	protected boolean isFinished() {
//		WaitCommand(Time);
		if (System.currentTimeMillis()>this.EndTime) { 
			return true;	
		} else {
			return false;
		}
	}
	@Override
	protected void end() {
		driveBase.drive(0.0, 0.0);     
	}

}
