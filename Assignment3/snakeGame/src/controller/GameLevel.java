package controller;

import java.util.ArrayList;

public class GameLevel {
	 public final LevelItem[][] level;
	 public Position     player = new Position(0, 0);
	 public final int  rows, cols;
	public GameLevel(ArrayList<String> gameLevelRows) {
		int c = 0;
        for (String s : gameLevelRows) if (s.length() > c) c = s.length();
        rows = gameLevelRows.size();
        cols = c;
        level = new LevelItem[rows][cols];
		
	}
	public void printLevel(){
        int x = player.x, y = player.y;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (i == y && j == x)
                    System.out.print('@');
                else 
                    System.out.print(level[i][j].representation);
            }
            System.out.println("");
        }
    }

}
