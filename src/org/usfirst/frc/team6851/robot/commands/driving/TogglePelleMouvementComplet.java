package org.usfirst.frc.team6851.robot.commands.driving;

import org.usfirst.frc.team6851.robot.Robot;
import org.usfirst.frc.team6851.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.command.WaitCommand;

public class TogglePelleMouvementComplet extends CommandBase{

	private static boolean PelleEstEtendue;
	
	@Override
	protected void initialize() {
		if(PelleEstEtendue) {
			pelle.Descendre();
			WaitCommand(0.25);
			pelle.Reculer(); }
		else {
			pelle.Monter();
			WaitCommand(0.25);
   		    pelle.Avancer(); }
		PelleEstEtendue = !PelleEstEtendue;
	}
		
	@Override
	protected boolean isFinished() {
		return true;
	}

}
