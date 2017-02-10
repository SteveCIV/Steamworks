package org.usfirst.frc.team4180.robot;
import edu.wpi.first.wpilibj.Timer;

public class StressTests {
	Timer timer = new Timer();
	int seconds = 60;
	Climber climber = new Climber(Robot.CLIMBER_PORT, Robot.TOP_SWITCH_PORT);
	public void climberTest() throws InterruptedException{
		timer.start();
		while((int)timer.get()< seconds){
			climber.updateSpeed(new double[]{0.0,0.2,0.0});
			Thread.sleep(seconds/6 * 1000);
			climber.updateSpeed(new double [] {0.0, 0.6, 0.0});
			Thread.sleep(seconds/6 * 1000);
			climber.updateSpeed(new double [] {0.0 ,0.8, 0.0});
			Thread.sleep(seconds/6 * 1000);
			climber.updateSpeed(new double [] {0.0, 0.6 ,0.0});	
		}	
	}
	}
