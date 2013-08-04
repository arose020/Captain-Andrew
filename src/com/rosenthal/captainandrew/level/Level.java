package com.rosenthal.captainandrew.level;

import java.util.ArrayList;
import java.util.List;

import com.rosenthal.captainandrew.entity.Entity;
import com.rosenthal.captainandrew.entity.mob.Enemy;
import com.rosenthal.captainandrew.entity.projectile.Projectile;
import com.rosenthal.captainandrew.graphics.Screen;
import com.rosenthal.captainandrew.level.tile.Tile;

public class Level {

	protected int width, height;
	protected int[] tilesInt;
	protected int[] tiles;
	protected int tile_size;
	
	public Enemy enemy;
	
	private List<Entity> entities = new ArrayList<Entity>();
	private List<Projectile> projectiles = new ArrayList<Projectile>();

	public static Level spawn = new SpawnLevel("/levels/spawn.png");
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		generateLevel();
		generateNpc(enemy);
	}
	
	public Level(String path) {
		loadLevel(path);
		generateLevel();
		
	}
	
	private void generateNpc(Enemy npc) {
		npc = new Enemy(100, 200);
		npc.init(this);
		add(npc);
	}

	protected void generateLevel() {
		for (int y = 0; y < 64; y++) {
			for (int x = 0; x < 64; x++ ) {
				getTile(x, y);
			}
		}
		tile_size = 16;
	}	
	
	protected void loadLevel(String path) {		
	}
	
	public void update() {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).update();
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update(); 
		}
	}
		
	public List<Projectile> getProjectiles () {
		return projectiles;
	}
	
	public List<Entity> getEntities() {
		return entities;
	}
	
	@SuppressWarnings("unused")
	private void time() {
	}
	
	public boolean tileCollision(double x, double y, double nx, double ny, int size) {
		boolean solid = false;
		for(int c = 0; c < 4; c++) {
			int xt = (((int)x + (int)nx) + c % 2 * size * 2 - 12) / 16;
			int yt = (((int)y + (int)ny) + c / 2 * size * 2) / 16;
			if (getTile(xt, yt).solid()) solid = true;
		}
		return solid;
	}
	
	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;
		for(int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
			}
		}
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render(screen);
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).render(screen);
		}
	}
	
	public void add(Entity e) {
		entities.add(e);
	}
	
	public void addProjectile(Projectile p) {
		p.init(this);
		projectiles.add(p);
	}
	
	public void addEnemyProjectile(Projectile ep) {
		ep.init(this);
		projectiles.add(ep);
	}
	/*  
	
    Grass = 0xff00FF00
    Flower = 0xffFFFF00
    Tree = 0xff7F7F00
    
	 */    
	
	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
		if (tiles[x + y * width] == Tile.col_spawn_floor) return Tile.spawn_floor;
		if (tiles[x + y * width] == Tile.col_spawn_grass) return Tile.spawn_grass;
		if (tiles[x + y * width] == Tile.col_spawn_wall1) return Tile.spawn_wall1;
		if (tiles[x + y * width] == Tile.col_spawn_wall2) return Tile.spawn_wall2;
		if (tiles[x + y * width] == Tile.col_spawn_water) return Tile.spawn_water;
		if (tiles[x + y * width] == Tile.col_spawn_hedge) return Tile.spawn_hedge;
		return Tile.voidTile;
	}
}
