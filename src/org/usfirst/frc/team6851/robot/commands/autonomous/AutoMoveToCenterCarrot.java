package org.usfirst.frc.team6851.robot.commands.autonomous;

import org.usfirst.frc.team6851.robot.Constant;
import org.usfirst.frc.team6851.robot.commands.FirstDelay;
import org.usfirst.frc.team6851.robot.commands.SecondDelay;
import org.usfirst.frc.team6851.robot.commands.WaitForRobotNotRotating;
import org.usfirst.frc.team6851.robot.commands.claw.AvancerPelle;
import org.usfirst.frc.team6851.robot.commands.claw.ReculerPelle;
import org.usfirst.frc.team6851.robot.commands.claw.DescendrePelle;
//import org.usfirst.frc.team6851.robot.commands.claw.SetGrabberDown;
import org.usfirst.frc.team6851.robot.commands.claw.MonterPelle;
import org.usfirst.frc.team6851.robot.commands.driving.MoveDistance;
import org.usfirst.frc.team6851.robot.commands.driving.MoveDistanceNavX;
import org.usfirst.frc.team6851.robot.commands.driving.MoveTime;
import org.usfirst.frc.team6851.robot.commands.driving.ResetNavX;
import org.usfirst.frc.team6851.robot.commands.driving.SmashTheWallForJohn;
import org.usfirst.frc.team6851.robot.commands.driving.TurnRobotCommand;
import org.usfirst.frc.team6851.robot.commands.oldAuto.AutonomousCommand;

import edu.wpi.first.wpilibj.command.WaitCommand;

public class AutoMoveToCenterCarrot extends AutonomousCommand {
	
	public AutoMoveToCenterCarrot(boolean angleReversed) {
		double angleFactor = angleReversed ? -1 : 1; 
		double SpeedFast = 1.0;
		double SpeedMiddle = 0.7;
		double SpeedSlow = 0.6;
		int PositionJeu = 101; 
/*
 * 		0 = test
 * 		1 = A
 * 		2 = B
 * 		3 = C
 * 		4 = D
 * 		11 = A miroir
 * 		12 = B miroir
 * 		13 = C miroir
 * 		14 = D miroir
 * 		101 = A - ramene carotte
 * 		102 = B - ramene carotte
 * 		103 = C - ramene carotte
 * 		104 = D - ramene carotte
 * 		111 = A miroir - ramene carotte
 * 		112 = B miroir - ramene carotte
 * 		113 = C miroir - ramene carotte
 * 		114 = D miroir - ramene carotte
 */
		
		System.out.println("CenterToCarrot");
		addSequential(new ResetNavX());
		System.out.println("CenterToCarrot - post navx reset");
		
//		addSequential(new MonterPelle());
//		addSequential(new DescendrePelle());
//		addSequential(new AvancerPelle());
//		addSequential(new ReculerPelle());
//      addSequential(new MoveTime(SpeedFast, 0.0, 1, 0));  // 90pouce/s
//		addSequential(new MoveTime(SpeedMiddle, 0.0, 1, 0)); //37pouce /s
//		addSequential(new MoveTime(0.0, -SpeedMiddle, 0.85, 0)); // pour 90 degress
/*		MoveTime, premier parametre, vitesse en ligne droite
		MoveTime, second parametre, vitesse en rotation
		MoveTime, troisieme parametre, temps de la commande
		MoveTime, quatrieme parametre, angle de rotation desire (negatif vers la droite), si <>0 ne tient pas compte du temps
*/
		
		if (PositionJeu == 0)  { // si test - test de correction de drift en ligne droite, puis test de 180 degres 
			//addSequential(new MonterPelle());
		    //descente de la plateforme
		    addSequential(new MoveTime(SpeedSlow, 0.0, 10, 0));
			//addSequential(new MoveTime(0.0, -SpeedSlow, 0.85, -90)); // pour 90 degress 
		    addSequential(new WaitCommand(0.1));
		}
		if (PositionJeu == 101)  { // si position A - ramene carotte
			addSequential(new MonterPelle());
		    addSequential(new WaitCommand(0.5));
		    //descente de la plateforme
		    addSequential(new MoveTime(SpeedMiddle, 0.0, 1.729, 0)); //37pouce /s
		    addSequential(new WaitCommand(0.1));
		    // tourne de 42 degres vers la droite
		    addSequential(new MoveTime(0.0, -SpeedSlow, 0.4, -42)); // 0.85pour 90
		    addSequential(new WaitCommand(0.1));
		    // avance vers la carotte a ramasse
		    addSequential(new MoveTime(SpeedFast, 0.0, 1, 0));
		    addSequential(new WaitCommand(0.1));
			addSequential(new AvancerPelle());
		    addSequential(new WaitCommand(0.5));
		    // avance doucement vers la carotte
		    addSequential(new MoveTime(SpeedSlow, 0.0, 3, 0));
		    addSequential(new WaitCommand(0.1));
			addSequential(new DescendrePelle());
		    addSequential(new WaitCommand(0.5));
			addSequential(new ReculerPelle());
		    addSequential(new WaitCommand(0.5));
		    // recule vers la plateforme 
		    addSequential(new MoveTime(-SpeedSlow, 0.0, 3, 0));
		    addSequential(new WaitCommand(0.1));
		    addSequential(new MoveTime(-SpeedFast, 0.0, 1, 0));
		    addSequential(new WaitCommand(0.1));
		    // tourne de 42 degres vers la gauche
		    addSequential(new MoveTime(0.0, SpeedSlow, 0.4, 42)); // 0.85pour 90
		    addSequential(new WaitCommand(0.1));
		    // recule sur la plateforme 
		    addSequential(new MoveTime(-SpeedMiddle, 0.0, 1.729, 0)); //37pouce /s
		}
		if (PositionJeu == 102)  { // si position B - ramene carotte
			PositionJeu = 2;
		}
		if (PositionJeu == 103)  { // si position C - ramene carotte
			PositionJeu = 3;
		}
		if (PositionJeu == 104)  { // si position D - ramene carotte
			PositionJeu = 4;
		}
		if (PositionJeu == 111)  { // si position A - miroir - ramene carotte
			PositionJeu = 11;
		}
		if (PositionJeu == 112)  { // si position B - miroir - ramene carotte
			PositionJeu = 12;
		}
		if (PositionJeu == 113)  { // si position C - miroir - ramene carotte
			PositionJeu = 13;
		}
		if (PositionJeu == 114)  { // si position D - miroir - ramene carotte
			PositionJeu = 14;
		}
		if (PositionJeu == 2)  { // si Position B
			PositionJeu = 1;
		}
		if (PositionJeu == 1)  { // si Position A
			addSequential(new MonterPelle());
		    //descente de la plateforme
		    addSequential(new MoveTime(SpeedMiddle, 0.0, 1.729, 0)); //37pouce /s
		    addSequential(new WaitCommand(0.1));
		    // tourne de 42 degres vers la droite
		    addSequential(new MoveTime(0.0, -SpeedSlow, 0.4, -42)); // 0.85pour 90
		    addSequential(new WaitCommand(0.1));
		    // avance vers le centre
		    addSequential(new MoveTime(SpeedMiddle, 0.0, 2.8, 0));
		    addSequential(new WaitCommand(0.1));
		    // tourne vers la carotte centrale
		    addSequential(new MoveTime(0.0, SpeedSlow, 0.85, 75));
		    addSequential(new WaitCommand(0.1));
			addSequential(new AvancerPelle());
		    // avance vers la carotte centrale 
		    addSequential(new MoveTime(SpeedSlow, 0.0, 0.1, 0));		
		}
		if (PositionJeu == 3)  { // si Position C
			addSequential(new MonterPelle());
		    //descente de la plateforme
		    addSequential(new MoveTime(SpeedMiddle, 0.0, 1.729, 0)); //37pouce /s
		    addSequential(new WaitCommand(0.1));
		    // tourne de 48 degres vers la gauche
		    addSequential(new MoveTime(0.0, SpeedMiddle, 0.4, 48)); // 0.85pour 90
		    addSequential(new WaitCommand(0.1));
		    // avance vers l'autre extremite du terrain
		    addSequential(new MoveTime(SpeedMiddle, 0.0, 2, 0));
		    addSequential(new WaitCommand(0.1));
		    // tourne de 90 degres vers la droite
		    addSequential(new MoveTime(0.0, -SpeedMiddle, 0.85, -90));
		    addSequential(new WaitCommand(0.1));
		    // avance vers le centre
		    addSequential(new MoveTime(SpeedMiddle, 0.0, 2.4, 0));
		    addSequential(new WaitCommand(0.1));
		    // tourne vers la carotte centrale
		    addSequential(new MoveTime(0.0, -SpeedMiddle, 0.85, -90));
		    addSequential(new WaitCommand(0.1));
			addSequential(new AvancerPelle());
		    // avance vers la carotte centrale 
		    addSequential(new MoveTime(SpeedMiddle, 0.0, 0.9, 0));		
		}
		if (PositionJeu == 4)  { // si Position D
			addSequential(new MonterPelle());
		    //descente de la plateforme
		    addSequential(new MoveTime(SpeedMiddle, 0.0, 1.729, 0)); //37pouce /s
		    addSequential(new WaitCommand(0.1));
		    // tourne de 48 degres vers la gauche
		    addSequential(new MoveTime(0.0, SpeedMiddle, 0.4, 48)); // 0.85pour 90
		    addSequential(new WaitCommand(0.1));
		    // avance vers le centre du terrain
		    addSequential(new MoveTime(SpeedMiddle, 0.9, 2, 0));
		    addSequential(new WaitCommand(0.1));
		    // tourne de 90 degres vers la droite
		    addSequential(new MoveTime(0.0, -SpeedMiddle, 0.85, -90));
		    addSequential(new WaitCommand(0.1));
			addSequential(new AvancerPelle());
		    // avance vers la carotte centrale 
		    addSequential(new MoveTime(SpeedMiddle, 0.0, 2.4, 0));		
		}
		if (PositionJeu == 12)  { // si Position B - miroir
			PositionJeu=11;
		}
		if (PositionJeu == 11)  { // si Position A - miroir
			addSequential(new MonterPelle());
		    //descente de la plateforme
		    addSequential(new MoveTime(SpeedMiddle, 0.0, 1.729, 0)); //37pouce /s
		    addSequential(new WaitCommand(0.1));
		    // tourne de 42 degres vers la droite
		    addSequential(new MoveTime(0.0, SpeedSlow, 0.4, 42)); // 0.85pour 90
		    addSequential(new WaitCommand(0.1));
		    // avance vers le centre
		    addSequential(new MoveTime(SpeedMiddle, 0.0, 2.8, 0));
		    addSequential(new WaitCommand(0.1));
		    // tourne vers la carotte centrale
		    addSequential(new MoveTime(0.0, -SpeedSlow, 0.85, -75));
		    addSequential(new WaitCommand(0.1));
			addSequential(new AvancerPelle());
		    // avance vers la carotte centrale 
		    addSequential(new MoveTime(SpeedSlow, 0.0, 0.1, 0));		
		}
		if (PositionJeu == 13)  { // si Position C - miroir
			addSequential(new MonterPelle());
		    //descente de la plateforme
		    addSequential(new MoveTime(SpeedMiddle, 0.0, 1.729, 0)); //37pouce /s
		    addSequential(new WaitCommand(0.1));
		    // tourne de 48 degres vers la gauche
		    addSequential(new MoveTime(0.0, -SpeedMiddle, 0.4, -48)); // 0.85pour 90
		    addSequential(new WaitCommand(0.1));
		    // avance vers l'autre extremite du terrain
		    addSequential(new MoveTime(SpeedMiddle, 0.0, 2, 0));
		    addSequential(new WaitCommand(0.1));
		    // tourne de 90 degres vers la droite
		    addSequential(new MoveTime(0.0, SpeedMiddle, 0.85, 90));
		    addSequential(new WaitCommand(0.1));
		    // avance vers le centre
		    addSequential(new MoveTime(SpeedMiddle, 0.0, 2.4, 0));
		    addSequential(new WaitCommand(0.1));
		    // tourne vers la carotte centrale
		    addSequential(new MoveTime(0.0, SpeedMiddle, 0.85, 90));
		    addSequential(new WaitCommand(0.1));
			addSequential(new AvancerPelle());
		    // avance vers la carotte centrale 
		    addSequential(new MoveTime(SpeedMiddle, 0.0, 0.9, 0));		
		}
		if (PositionJeu == 14)  { // si Position D - miroir
			addSequential(new MonterPelle());
		    //descente de la plateforme
		    addSequential(new MoveTime(SpeedMiddle, 0.0, 1.729, 0)); //37pouce /s
		    addSequential(new WaitCommand(0.1));
		    // tourne de 48 degres vers la gauche
		    addSequential(new MoveTime(0.0, -SpeedMiddle, 0.4, -48)); // 0.85pour 90
		    addSequential(new WaitCommand(0.1));
		    // avance vers le centre du terrain
		    addSequential(new MoveTime(SpeedMiddle, 0.9, 2, 0));
		    addSequential(new WaitCommand(0.1));
		    // tourne de 90 degres vers la droite
		    addSequential(new MoveTime(0.0, SpeedMiddle, 0.85, 90));
		    addSequential(new WaitCommand(0.1));
			addSequential(new AvancerPelle());
		    // avance vers la carotte centrale 
		    addSequential(new MoveTime(SpeedMiddle, 0.0, 2.4, 0));		
		}
	}
	
}
