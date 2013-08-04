package com.rosenthal.captainandrew.level.tile.spawn_level;

import com.rosenthal.captainandrew.graphics.Screen;
import com.rosenthal.captainandrew.graphics.Sprite;
import com.rosenthal.captainandrew.level.tile.Tile;

public class SpawnGrassTile extends Tile{

	public SpawnGrassTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}

}
