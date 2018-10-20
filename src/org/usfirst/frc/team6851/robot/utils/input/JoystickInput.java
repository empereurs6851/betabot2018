package org.usfirst.frc.team6851.robot.utils.input;

import org.usfirst.frc.team6851.robot.utils.Gamepad.GamepadAxis;

import edu.wpi.first.wpilibj.Joystick;

public class JoystickInput extends AxisInputBase{

	Joystick controlStick;
	int axies;
	double axieDeadZone;
	double factor = 1;
	
	
	public JoystickInput(Joystick controlStick, GamepadAxis axies, double joystick_zero_threshold) {
		this.controlStick = controlStick;
		this.axies = axies.value();
		this.axieDeadZone = joystick_zero_threshold;
	}
	public JoystickInput(Joystick controlStick, GamepadAxis axies, double joystick_zero_threshold, double factor) {
		this.controlStick = controlStick;
		this.axies = axies.value();
		this.axieDeadZone = joystick_zero_threshold;
		this.factor = factor;
	}
	
	public double getInput(){
		double inputedYaw = controlStick.getRawAxis(axies);
		
		
		return adjustForDeadZone(inputedYaw, axieDeadZone) * factor;
	}
	
}
