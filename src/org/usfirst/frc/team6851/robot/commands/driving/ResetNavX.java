package org.usfirst.frc.team6851.robot.commands.driving;
 
import org.usfirst.frc.team6851.robot.commands.OneShotCommandBase;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ResetNavX extends OneShotCommandBase{

	@Override
	protected void initialize() {
		driveBase.resetNavX();
		SmartDashboard.putBoolean("NavX", driveBase.correctOrientationWithNavx);
	}
}
