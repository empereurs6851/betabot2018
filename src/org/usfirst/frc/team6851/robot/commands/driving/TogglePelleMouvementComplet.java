package org.usfirst.frc.team6851.robot.commands.driving;

import org.usfirst.frc.team6851.robot.Robot;
import org.usfirst.frc.team6851.robot.commands.CommandBase;

public class TogglePelleMouvementComplet extends CommandBase{

	private static boolean PelleEstMontee;
	
	@Override
	protected void initialize() {
		if(PelleEstMontee) {
			pelle.Monter();
			pelle.Avancer();
		}
		else {
			pelle.Descendre();
			pelle.Reculer();
		}
		PelleEstMontee = !PelleEstMontee;
	}
		
	@Override
	protected boolean isFinished() {
		return true;
	}

}
