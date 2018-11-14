package org.usfirst.frc.team6851.robot.commands.claw;

import org.usfirst.frc.team6851.robot.commands.CommandBase;

public class ReculerPelle extends CommandBase {

	public ReculerPelle() {
		//setTimeout(10);
	}
	
	@Override
	protected void execute() {
		pelle.Reculer();;
	}
	
	@Override
	protected void end() {
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}

}
