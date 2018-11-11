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
	private long Time;
	private double EndTime;
	
	public MoveTime(double speedX, double speedY, long Time) {
		requires(driveBase);
		this.speedX = speedX;
		this.speedY = speedY;
		this.Time = Time;
	}
	
	@Override
	protected void initialize() {
		Dashboard.nextAutonomousStep();
		super.initialize();
		this.EndTime = Timer.getFPGATimestamp()+this.Time;
		this.distanceToFinishRight = driveBase.getRightEncoderDistance() + distanceInRotation;
		this.distanceToFinishLeft = driveBase.getLeftEncoderDistance() + distanceInRotation;
	}
	
	@Override
	protected void execute() {
		
		driveBase.drive(speedX, speedY);
//		Dashboard.updateAutonomousStep("Moving at " + s);
	}
	@Override
	protected boolean isFinished() {
//		WaitCommand(Time);
		if (Timer.getFPGATimestamp()>this.EndTime) { 
			return true;	
		} else {
			return false;
		}
	}
	@Override
	protected void end() {
		driveBase.drive(speedX, speedY);     
	}

}
