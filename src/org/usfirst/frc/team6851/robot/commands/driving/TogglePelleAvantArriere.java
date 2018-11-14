package org.usfirst.frc.team6851.robot.commands.driving;

import org.usfirst.frc.team6851.robot.Robot;
import org.usfirst.frc.team6851.robot.commands.CommandBase;

public class TogglePelleAvantArriere extends CommandBase{

	private static boolean PelleEstAvancee;
	
	@Override
	protected void initialize() {
		if(PelleEstAvancee) {
			pelle.Reculer(); 
		}
		else {
			pelle.Avancer();
		}
		PelleEstAvancee = !PelleEstAvancee;
	}
		
	@Override
	protected boolean isFinished() {
		return true;
	}

}
