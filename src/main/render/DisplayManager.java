package main.render;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static  org.lwjgl.opengl.GL11.*;

public class DisplayManager {
	
	public static void create(int width,int height,String title) { //Cr�ation de la fen�tre
		
		
		try {
			Display.setDisplayMode(new DisplayMode(width,height));
			Display.setTitle(title);
			Display.setResizable(true);
			Display.create();
			
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		

		
	}
	
	public static void update() { //Permet de rafraichir la fenetre
		Display.update();
	}
	
	public static void clearBuffers() { //Permet de nettoyer les r�sidut l'orsque un objet bouge
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	}
	
	public static boolean isClosed() {
		return Display.isCloseRequested();
	}
	
	public static void dispose() {
		Display.destroy();
	}
	
}
