package org.usfirst.frc.team6851.robot.commands.autonomous;

import org.usfirst.frc.team6851.robot.Constant;
import org.usfirst.frc.team6851.robot.commands.FirstDelay;
import org.usfirst.frc.team6851.robot.commands.SecondDelay;
import org.usfirst.frc.team6851.robot.commands.WaitForRobotNotRotating;
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
		
		System.out.println("CenterToCarrot");
		
		addSequential(new ResetNavX());

		System.out.println("CenterToCarrot - post navx reset");
		
//		addSequential(new MonterPelle());
		addSequential(new MoveTime(MoveSpeedMiddle, 0.0, 1.729)); //37pouce /s
		
		addSequential(new WaitCommand(1.0));
		//addSequential(new MoveTime(MoveSpeedFast, 0.0, 1));  // 90pouce/s
		
		addSequential(new MoveTime(0.0, -MoveSpeedMiddle, 0.4)); // 0.85pour 90

		addSequential(new WaitCommand(1.0));
		addSequential(new MoveTime(MoveSpeedMiddle, 0.0, 2.4));
		
		addSequential(new WaitCommand(1.0));
		addSequential(new MoveTime(0.0, MoveSpeedMiddle, 0.85));
		
		addSequential(new WaitCommand(1.0));
		addSequential(new MoveTime(MoveSpeedMiddle, 0.0, 0.9));
		
//		addSequential(new MoveTime(-MoveSpeedMiddle, 0.0, 1));
		
//		addSequential(new TurnRobotCommand(-45.0 * angleFactor, MoveSpeedFast));
//		addSequential(new MoveDistanceNavX(-60.0, 0, 1, MoveSpeedMiddle));
		
//		addSequential(new DescendrePelle());
		
//		addSequential(new FirstDelay());
//		addSequential(new MoveDistance(1*12, MoveSpeedMiddle));
//		addSequential(new WaitForRobotNotRotating());
//		addSequential(new TurnRobotCommand(-20 * angleFactor, MoveSpeedFast));
//		addSequential(new MoveDistance(10*12, MoveSpeedFast));
//		addSequential(new WaitForRobotNotRotating());
//		addSequential(new TurnRobotCommand(110 * angleFactor, TurnSpeedSlow));
//		
//		addSequential(new SmashTheWallForJohn());
//		addSequential(new SecondDelay());
//		
//		addSequential(new MoveDistance(-1*12, MoveSpeedMiddle));
//		addSequential(new WaitForRobotNotRotating());
//		addSequential(new TurnRobotCommand(90 * angleFactor, TurnSpeedSlow));
//		
//		//addParallel(new SetGrabberDown(Constant.SCREW_AUTO_SPEED));
//		addParallel(new MoveDistance(3*12, MoveSpeedMiddle));
//		
//		addSequential(new TurnRobotCommand(-90 * angleFactor, TurnSpeedSlow));
//		addSequential(new MoveDistance(4*12, MoveSpeedMiddle));
	}
	
}
