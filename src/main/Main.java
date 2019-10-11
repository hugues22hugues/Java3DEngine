package main;

import org.lwjgl.opengl.Display;

import main.chunk.World;
import main.math.Vector3f;
import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import main.render.Camera;
import main.render.DisplayManager;

public class Main {
	
	public static final float FRAME_CAP = 1000;
	private boolean running = false;
	Camera cam;
	
	public Main() {
		
		DisplayManager.create(720, 480, "Titre"); //Création de la fenêtre
		cam = new Camera(new Vector3f(0,0,0));
		cam.setPerspectiveProjection(70.0f, 0.1f, 1000.0f);
	}
	
	
	public void start() {

		running = true;
		loop();
	}
	
	public void stop() {
		running = false;
	}
	
	public void exit() {
		DisplayManager.dispose();
		System.exit(0);
	}
	
	public void loop() {
		
		long lastTickTime = System.nanoTime();
		long lastRenderTime = System.nanoTime();
		
		double tickTime = 1000000000.0 / 60.0;
		double renderTime = 1000000000.0 / FRAME_CAP;

		
		int ticks = 0;
		int frames = 0;
		
		long timer = System.currentTimeMillis();
		
		
		while(running) { //temps que la fenetre n'est pas fermer
			
			if(DisplayManager.isClosed()) stop();
			boolean rendered = false;
			
			if(System.nanoTime() - lastTickTime > tickTime){
				ticks++;
				update();
				lastTickTime += tickTime;
				
			}
			
			else if(System.nanoTime() - lastRenderTime > renderTime) {
				
				render();
				DisplayManager.update();
				frames++;
				rendered = true; 
				lastRenderTime += renderTime;
				
			}
			
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				//System.out.println(ticks + "ticks" + frames + "fps");
				ticks = 0;
				frames = 0;
			}
			
			if(rendered && FRAME_CAP >= 60) {
				try {
					Thread.sleep((int)(1000.0 / FRAME_CAP));
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
		exit();
	}
	
	public void update() {
		if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) Mouse.setGrabbed(false);
		if(Mouse.isButtonDown(0)) Mouse.setGrabbed(true);
		if(!Mouse.isGrabbed()) return;
		cam.input();
	}
	
	
	public void render() {
		World world = new World();
		DisplayManager.clearBuffers();
		cam.getPerspectiveProjection();
		cam.update();
		cam.affichage();
		world.newWorld();
		glColor3f(0.2f,0.1f,54);
		glBegin(GL_QUADS);
			glVertex3f(-1,-0.5f,-1);
			glVertex3f(1,-0.5f,-1);
			glVertex3f(1,-0.5f,-3);
			glVertex3f(-1,-0.5f,-3);
		glEnd();
		
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.start();
	}
}
