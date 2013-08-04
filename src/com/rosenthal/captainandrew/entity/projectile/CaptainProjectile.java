package com.rosenthal.captainandrew.entity.projectile;

import com.rosenthal.captainandrew.graphics.Screen;
import com.rosenthal.captainandrew.graphics.Sprite;

public class CaptainProjectile extends Projectile {

	public static final int FIRE_RATE = 10;
	//Higher = slower; Lower = faster
	
	public CaptainProjectile(int x, int y, double dir) {
		super(x, y, dir);
		range = random.nextInt(10) + 110;
		//range is 110/120
		speed = 4;
		//higher = faster
		dammage = 20;
		sprite = Sprite.captain_projectile;
		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
	}
	
	public void update() {
			if (level.tileCollision(x, y, nx, ny, 7)) remove(); 
			move();
	}
	
	protected void move() {
		x += nx;
		y += ny;
		if (distance() > range) remove();
	}
	
	private double distance() {
		double dist = 0;
		dist = Math.sqrt(Math.abs((xOrigin - x) * (xOrigin - x) + (yOrigin - y) * (yOrigin - y)));
		return dist;
	}

	public void render(Screen screen) {
		screen.renderProjectile((int) x - 12, (int) y - 2, this);
	}

}
