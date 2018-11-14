package org.usfirst.frc.team6851.robot.commands.driving;

import org.usfirst.frc.team6851.robot.Robot;
import org.usfirst.frc.team6851.robot.commands.CommandBase;

public class TogglePelleUpDown extends CommandBase{

	private static boolean PelleEstMontee;
	
	@Override
	protected void initialize() {
		if(PelleEstMontee) {
			pelle.Descendre();
		}
		else {
			pelle.Monter();
		}
		PelleEstMontee = !PelleEstMontee;
	}
		
	@Override
	protected boolean isFinished() {
		return true;
	}

}
