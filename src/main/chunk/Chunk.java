package main.chunk;

import main.block.Block;

public class Chunk {
	
	private int sizeX; 
	private int sizeY; 

	
	public Chunk(int sizeX,int sizeY) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;
	}
	
	
	public void generateChunk() {
		
		for(int x=0;x<=sizeX;x++) {
			for(int z=0;z<=sizeX;z++) {
				Block block = new Block(x,1,z);
				block.cube();
			}
		}
	
	
	}
	
}
