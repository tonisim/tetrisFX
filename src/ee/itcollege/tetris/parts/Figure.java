package ee.itcollege.tetris.parts;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class Figure extends ArrayList<Block> {


	public void move(int deltaX, int deltaY) {

		for (Block block : this) {
			block.setX(block.getX() + deltaX * Block.SIZE);
			block.setY(block.getY() + deltaY * Block.SIZE);
		}

	}
	public void rotate(){
		for (Block block :this){
		    block.setX(block.getY() + 45 - 40);
		    block.setY(45 + 40 - block.getX() - Block.SIZE);
            System.out.println(block.getX() + ", " + block.getY());
        }
	}
}





