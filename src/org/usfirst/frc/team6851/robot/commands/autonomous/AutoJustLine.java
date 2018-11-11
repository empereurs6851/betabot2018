package org.usfirst.frc.team6851.robot.commands.autonomous;

import org.usfirst.frc.team6851.robot.commands.FirstDelay;
import org.usfirst.frc.team6851.robot.commands.WaitForRobotNotRotating;
import org.usfirst.frc.team6851.robot.commands.claw.MonterPelle;
import org.usfirst.frc.team6851.robot.commands.claw.DescendrePelle;
import org.usfirst.frc.team6851.robot.commands.claw.AvancerPelle;
import org.usfirst.frc.team6851.robot.commands.claw.ReculerPelle;
import org.usfirst.frc.team6851.robot.commands.driving.MoveDistance;
import org.usfirst.frc.team6851.robot.commands.driving.MoveTime;
import org.usfirst.frc.team6851.robot.commands.driving.TurnRobotCommand;
import org.usfirst.frc.team6851.robot.commands.oldAuto.AutonomousCommand;

import edu.wpi.first.wpilibj.command.WaitCommand;

public class AutoJustLine extends AutonomousCommand {

	public AutoJustLine(boolean angleReversed) {
		double angleFactor = angleReversed ? -1 : 1;
		int i;
		
		addSequential(new FirstDelay());
		i=0;
//		while (i<10)  {
		addSequential(new AvancerPelle());
//		addSequential(new WaitCommand(0.5));
		addSequential(new MonterPelle());
//		addSequential(new WaitCommand(0.5));
//		addSequential(new ReculerPelle());
//		addSequential(new WaitCommand(0.5));
//		addSequential(new DescendrePelle());
//		addSequential(new WaitCommand(0.5));
//		i++;
//		}
		addSequential(new MoveTime(MoveSpeedMiddle, 0, 5)); //avance
//		addSequential(new WaitCommand(5));
		addSequential(new MoveTime(0, -MoveSpeedLow, 1)); // tourne a gauche
//		addSequential(new WaitCommand(5));
		addSequential(new MoveTime(MoveSpeedMiddle, 0, 5));  // avance
//		addSequential(new WaitCommand(5));
		addSequential(new MoveTime(0, MoveSpeedMiddle, 1)); // tourne a droite
//		addSequential(new WaitCommand(5));
		addSequential(new MoveTime(MoveSpeedFast, 0, 5));  // avance
//		addSequential(new WaitCommand(5));
//		addSequential(new MoveTime(0, 0, 0));
//		addSequential(new TurnRobotCommand(-45 * angleFactor, MoveSpeedFast));
//		addSequential(new WaitForRobotNotRotating());
//		addSequential(new MoveDistance(4*12,MoveSpeedMiddle));
//		addSequential(new WaitForRobotNotRotating());
	}
	

}
