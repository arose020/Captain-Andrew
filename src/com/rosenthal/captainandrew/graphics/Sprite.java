package com.rosenthal.captainandrew.graphics;

public class Sprite {

	public final int SIZE;
	private int x, y;
	private int width, height;
	public int[] pixels;
	private SpriteSheet sheet;

	// General Sprites are found here!
	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite flower = new Sprite(16, 1, 0, SpriteSheet.tiles);
	public static Sprite tree = new Sprite(16, 2, 0, SpriteSheet.tiles);
	public static Sprite voidSprite = new Sprite(16, 0x1B87E0);

	// Spawn Level Sprites go here!
	public static Sprite spawn_grass = new Sprite(16, 0, 0, SpriteSheet.spawn_level);
	public static Sprite spawn_hedge = new Sprite(16, 1, 0, SpriteSheet.spawn_level);
	public static Sprite spawn_water = new Sprite(16, 2, 0, SpriteSheet.spawn_level);
	public static Sprite spawn_wall1 = new Sprite(16, 0, 1, SpriteSheet.spawn_level);
	public static Sprite spawn_wall2 = new Sprite(16, 0, 2, SpriteSheet.spawn_level);
	public static Sprite spawn_floor = new Sprite(16, 1, 1, SpriteSheet.spawn_level);

	// Player Sprites go here!
	public static Sprite player_forward = new Sprite(32, 2, 5, SpriteSheet.tiles);
	public static Sprite player_back = new Sprite(32, 0, 5, SpriteSheet.tiles);
	public static Sprite player_side = new Sprite(32, 1, 5, SpriteSheet.tiles);

	public static Sprite player_forward_1 = new Sprite(32, 2, 6, SpriteSheet.tiles);
	public static Sprite player_forward_2 = new Sprite(32, 2, 7, SpriteSheet.tiles);

	public static Sprite player_side_1 = new Sprite(32, 1, 6, SpriteSheet.tiles);
	public static Sprite player_side_2 = new Sprite(32, 1, 7, SpriteSheet.tiles);

	public static Sprite player_back_1 = new Sprite(32, 0, 6, SpriteSheet.tiles);
	public static Sprite player_back_2 = new Sprite(32, 0, 7, SpriteSheet.tiles);

	// Enemy Sprites go here!
	public static Sprite enemy_forward = new Sprite(32, 5, 5, SpriteSheet.tiles);
	public static Sprite enemy_back = new Sprite(32, 3, 5, SpriteSheet.tiles);
	public static Sprite enemy_side = new Sprite(32, 4, 5, SpriteSheet.tiles);

	public static Sprite enemy_forward_1 = new Sprite(32, 5, 6, SpriteSheet.tiles);
	public static Sprite enemy_forward_2 = new Sprite(32, 5, 7, SpriteSheet.tiles);

	public static Sprite enemy_side_1 = new Sprite(32, 4, 6, SpriteSheet.tiles);
	public static Sprite enemy_side_2 = new Sprite(32, 4, 7, SpriteSheet.tiles);

	public static Sprite enemy_back_1 = new Sprite(32, 3, 6, SpriteSheet.tiles);
	public static Sprite enemy_back_2 = new Sprite(32, 3, 7, SpriteSheet.tiles);

	// Projectile sprites go here!
	public static Sprite captain_projectile = new Sprite(16, 0, 0, SpriteSheet.projectile_captain);
	public static Sprite enemy_projectile = new Sprite(16, 0, 0, SpriteSheet.projectile_enemy);
	
	// Particle Sprites go here!
	public static Sprite particle_normal = new Sprite(3, 0xAAAAAA);

	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.width = size;
		this.height = size;
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}

	public Sprite(int width, int height, int colour) {
		SIZE = -1;
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		setColour(colour);
	}

	public Sprite(int size, int colour) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		setColour(colour);
	}

	private void setColour(int colour) {
		for (int i = 0; i < width * height; i++) {
			pixels[i] = colour;
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	private void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
	}
}
