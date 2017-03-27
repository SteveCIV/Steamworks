package org.usfirst.frc.team4180.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Autonomous {
	KinematicLocator location;
	State state;
	Timer autoTime;
	DriveTrain drive;
	Ramp ramp;
	
	double previousTime;
	
	int startLocation;
	
	private static final double WAITING_TIME = 5;
	private static final double DRIVING_TIME_1 = 2;
	private static final double DRIVING_TIME_2 = 0.9;
	private static final double TURNING_TIME = 0.75;
	
	public Autonomous (KinematicLocator loc, DriveTrain drive, Ramp ramp){
		previousTime = 0;
		location = loc;
		state = State.Beginning;
		autoTime = new Timer();
		this.drive = drive;
		this.drive.setBackwards(false);
		this.drive.setGear(true);
		this.ramp = ramp;
		this.ramp.set(DoubleSolenoid.Value.kReverse);
		String locationStr = SmartDashboard.getString("DB/String 5", "0");
		try {
			startLocation = Integer.parseInt(locationStr);
		} catch (Exception e) {
			startLocation = 0;
		}
	}
	
	public void Periodic(){
		switch (state) {
		
		case Beginning:
			SmartDashboard.putString("DB/String 6", "Beginning");
			autoTime.start();
			if(startLocation == 0){
				changeState(State.Done, 0);
			}
			else{
				changeState(State.Waiting,0);
			}
			break;
			
		case Waiting:
			SmartDashboard.putString("DB/String 6", "Waiting");
			changeState(State.Driving, WAITING_TIME);
			break;
			
		case Driving:
			SmartDashboard.putString("DB/String 6", "Driving");
			drive.updateSpeed(new double[]{0,-0.4,0});
			if(startLocation == 2){
				changeState(State.Done, DRIVING_TIME_1);
			}
			else{
				changeState(State.Turning, DRIVING_TIME_2);
			}
			break;
			
		case Turning:
			SmartDashboard.putString("DB/String 6", "Turning {" +(startLocation - 2)*0.4+", "+ -0.4+ "}");
			drive.updateSpeed(new double[]{(startLocation - 2)*0.4, -0.75, 0});
			changeState(State.Done, TURNING_TIME);
			break;
		
		case Done:
			SmartDashboard.putString("DB/String 6", "Done");
			drive.updateSpeed(new double[]{0,0,0});
			break;
		}
	}
	
	private void changeState(State s, double time){
		SmartDashboard.putString("DB/String 7", Math.round(autoTime.get())+" >= "+Math.round(time+previousTime));
		if(autoTime.get() >= time + previousTime){
			state = s;
			previousTime = autoTime.get();
		}
	}
	
	//State Machine
	public enum State {
		Beginning, Waiting, Driving, Turning, Done
	}
}
