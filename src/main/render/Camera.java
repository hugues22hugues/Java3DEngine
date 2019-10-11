package main.render;

import org.lwjgl.util.glu.GLU;

import main.math.Vector3f;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

public class Camera {
	private float fov;
	private float zNear;
	private float zFar;
	private float aspect = Display.getWidth()/Display.getHeight();
	private float speed = 0.1f;
	
	private Vector3f position;
	private Vector3f rotation;
	
	public Camera(Vector3f position) {
		this.position = position;
		rotation = new Vector3f();
	}
	
	public Camera setPerspectiveProjection(float fov,float zNear,float zFar) {
		this.fov = fov;
		this.zNear = zNear;
		this.zFar = zFar;
		
		return this;
		
	}
	
	
	public Vector3f getForward() {
		Vector3f r = new Vector3f();
		Vector3f rot = new Vector3f(rotation);
		
		float cosY = (float) Math.cos(Math.toRadians(rot.getY() + 90));
		float sinY = (float) Math.sin(Math.toRadians(rot.getY() + 90));
		float cosP = (float) Math.cos(Math.toRadians(rot.getX()));
		float sinP = (float) Math.sin(Math.toRadians(rot.getX()));
		
		r.setX(cosY * cosP);  
		r.setY(sinP);  
		r.setZ(sinY * cosP);  

		return r;
	}
	
	public Vector3f getRight() {
		Vector3f r = new Vector3f();
		Vector3f rot = new Vector3f(rotation);
		
		float cosY = (float) Math.cos(Math.toRadians(rot.getY()));
		float sinY = (float) Math.sin(Math.toRadians(rot.getY()));

		
		r.setX(cosY);
		r.setZ(sinY);
		return r;
	}
	
	
	public void getPerspectiveProjection() {
		glEnable(GL_PROJECTION);
		glLoadIdentity();
		GLU.gluPerspective(fov, aspect, zNear, zFar);
		glEnable(GL_MODELVIEW);
	}
	
	

	public void update() {
		glPushAttrib(GL_TRANSFORM_BIT);
			glRotatef(rotation.getX(), 1,0,0);
			glRotatef(rotation.getY(), 0,1,0);
			glRotatef(rotation.getZ(), 0,0,1);
			glTranslatef(-position.getX(), -position.getY(), -position.getZ());
		glPopMatrix();
		
	}
	
	public void input() {
		
		rotation.addX(-Mouse.getDY());
		rotation.addY(Mouse.getDX());

		
		if(Keyboard.isKeyDown(Keyboard.KEY_Z)) {
			position.add(getForward().mul(new Vector3f(-speed,-speed,-speed)));
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_S)) {
			position.add(getForward().mul(new Vector3f(speed,speed,speed)));
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_Q)) {
			position.add(getRight().mul(new Vector3f(-speed,-speed,-speed)));
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_D)) {
			position.add(getRight().mul(new Vector3f(speed,speed,speed)));
		}
		
		
		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
			position.add(new Vector3f(0,-speed,0));
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
			position.add(new Vector3f(0,speed*2,0));
		}
	}
	
	
	public Vector3f getPosition() {
		return position;
		
	}
	
	public void affichage() {
		
		System.out.println("X : " + position.getX());
		System.out.println("Y : " + position.getY());
		System.out.println("Z : " + position.getZ());
		collision();
	}
	
	
	
	public void collision() {
		
		if(position.getY() <= 0.1f) {
			position.setY(0.1f);
 		}		
	}
	
	public void setPosition(Vector3f position) {
		this.position = position;
	}
	
	
}
