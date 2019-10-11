package main.block;
import static org.lwjgl.opengl.GL11.*;

public class Block {
	
	private int x;
	private int y;
	private int z;
	
	public Block(int x,int y,int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void cube() {

	     glEnable(GL_DEPTH_TEST);
	     glTranslatef(x,1,z);             
	     glRotatef(45f,0.0f,1.0f,0.0f);               
	     glColor3f(0.5f,0.5f,1.0f);  

	     glBegin(GL_QUADS);    
	        glColor3f(1.0f,1.0f,0.0f);           
	        glVertex3f( 1.0f, 1.0f,-1.0f);        
	        glVertex3f(-1.0f, 1.0f,-1.0f);        
	        glVertex3f(-1.0f, 1.0f, 1.0f);
	        glVertex3f( 1.0f, 1.0f, 1.0f);  
	        glColor3f(1.0f,0.5f,0.0f);            
	        glVertex3f( 1.0f,-1.0f, 1.0f);
	        glVertex3f(-1.0f,-1.0f, 1.0f);
	        glVertex3f(-1.0f,-1.0f,-1.0f);
	        glVertex3f( 1.0f,-1.0f,-1.0f);
	        glColor3f(1.0f,0.0f,0.0f);
	        glVertex3f( 1.0f, 1.0f, 1.0f);
	        glVertex3f(-1.0f, 1.0f, 1.0f);
	        glVertex3f(-1.0f,-1.0f, 1.0f);
	        glVertex3f( 1.0f,-1.0f, 1.0f);
	        glColor3f(1.0f,1.0f,0.0f);
	        glVertex3f( 1.0f,-1.0f,-1.0f);
	        glVertex3f(-1.0f,-1.0f,-1.0f);
	        glVertex3f(-1.0f, 1.0f,-1.0f);
	        glVertex3f( 1.0f, 1.0f,-1.0f);
	        glColor3f(0.0f,0.0f,1.0f);
	        glVertex3f(-1.0f, 1.0f, 1.0f);
	        glVertex3f(-1.0f, 1.0f,-1.0f);
	        glVertex3f(-1.0f,-1.0f,-1.0f);
	        glVertex3f(-1.0f,-1.0f, 1.0f);
	        glColor3f(1.0f,0.0f,1.0f);
	        glVertex3f( 1.0f, 1.0f,-1.0f);
	        glVertex3f( 1.0f, 1.0f, 1.0f);
	        glVertex3f( 1.0f,-1.0f, 1.0f);
	        glVertex3f( 1.0f,-1.0f,-1.0f);
	    glEnd();    

	 }
	}
	
