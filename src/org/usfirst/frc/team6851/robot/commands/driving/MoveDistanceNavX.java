package org.usfirst.frc.team6851.robot.commands.driving;

import org.usfirst.frc.team6851.robot.Constant;
import org.usfirst.frc.team6851.robot.Dashboard;
import org.usfirst.frc.team6851.robot.commands.CommandBase;

public class MoveDistanceNavX extends CommandBase {
	private double distanceInInchX;
	private double distanceInInchY;
	private double distanceAtInitX;
	private double distanceAtInitY;
	private double orientationAtInit;
	private int mouvementMask;
	private double speed;
	
	public MoveDistanceNavX(double distanceInInchX, double distanceInInchY, int mouvementMask, double speed) {
		requires(driveBase);
		this.speed = speed;
		this.distanceInInchX = distanceInInchX;
		this.distanceInInchY = distanceInInchY;
		this.mouvementMask = mouvementMask;
	}
	
	@Override
	protected void initialize() {
		Dashboard.nextAutonomousStep();
		super.initialize();
		//this.distanceAtInitX = driveBase.getDisplacementX();
		//this.distanceAtInitY = driveBase.getDisplacementY();
		this.orientationAtInit = driveBase.getOrientation();
	}
	
	@Override
	protected void execute() {
		double s = speed;
		driveBase.drive(s, 0);
		Dashboard.updateAutonomousStep("Moving at " + s);
	}
	@Override
	protected boolean isFinished() {
		double diff = driveBase.getOrientation() - this.orientationAtInit;
		if(Math.abs(diff) > 0.1) {
			System.out.println("DRIFT !");
			driveBase.drive(0, diff);
		}
		if(mouvementMask == 1) {
			//MouvementX only
			return (driveBase.getDisplacementX() > this.distanceInInchX);
		}
		else if(mouvementMask == 2) {
			//MouvementY only
			return (driveBase.getDisplacementY() > this.distanceInInchY);
		}
		else if(mouvementMask == 3) {
			//MouvementXY
			return (driveBase.getDisplacementY() > this.distanceInInchY &&
					driveBase.getDisplacementX() > this.distanceInInchX);
		}	
		return false;
	}
	@Override
	protected void end() {
		driveBase.drive(0,0);
	}

}