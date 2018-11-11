package org.usfirst.frc.team6851.robot.commands.claw;

import org.usfirst.frc.team6851.robot.commands.CommandBase;

public class AvancerPelle extends CommandBase {

	public AvancerPelle() {
		//setTimeout(10);
	}
	
	@Override
	protected void execute() {
		pelle.Avancer();;
	}
	
	@Override
	protected void end() {
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}

}
