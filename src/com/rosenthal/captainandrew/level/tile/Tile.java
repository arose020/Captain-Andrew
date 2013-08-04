package com.rosenthal.captainandrew.level.tile;

import com.rosenthal.captainandrew.graphics.Screen;
import com.rosenthal.captainandrew.graphics.Sprite;
import com.rosenthal.captainandrew.level.tile.spawn_level.SpawnFloorTile;
import com.rosenthal.captainandrew.level.tile.spawn_level.SpawnGrassTile;
import com.rosenthal.captainandrew.level.tile.spawn_level.SpawnHedgeTile;
import com.rosenthal.captainandrew.level.tile.spawn_level.SpawnWallTile;
import com.rosenthal.captainandrew.level.tile.spawn_level.SpawnWaterTile;

public class Tile {
	
	public int x, y;
	public Sprite sprite;
	
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile flower = new FlowerTile(Sprite.flower);
	public static Tile tree = new TreeTile(Sprite.tree);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	
	public static Tile spawn_grass = new SpawnGrassTile(Sprite.spawn_grass);
	public static Tile spawn_hedge = new SpawnHedgeTile(Sprite.spawn_hedge);
	public static Tile spawn_water = new SpawnWaterTile(Sprite.spawn_water);
	public static Tile spawn_wall1 = new SpawnWallTile(Sprite.spawn_wall1);
	public static Tile spawn_wall2 = new SpawnWallTile(Sprite.spawn_wall2);
	public static Tile spawn_floor = new SpawnFloorTile(Sprite.spawn_floor);
	
	/* Spawn Grass = 00FF00
	 * Spawn Hedge = 007F0E
	 * Spawn Water = 00FFFF
	 * Spawn Wall 1 = 808080
	 * Spawn Wall 2 = 303030
	 * Spawn Floor = 833B00
	 */
	
	public static final int col_spawn_grass = 0xFF00FF00;
	public static final int col_spawn_hedge = 0xFF007F0E;
	public static final int col_spawn_water = 0xFF00FFFF;
	public static final int col_spawn_wall1 = 0xFF808080;
	public static final int col_spawn_wall2 = 0xFF303030;
	public static final int col_spawn_floor = 0xFF8E3B00;

	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen) {	
	}
	
	public boolean solid() {
		return false;
	}
}
