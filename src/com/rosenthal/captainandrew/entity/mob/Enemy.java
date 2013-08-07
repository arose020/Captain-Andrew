package com.rosenthal.captainandrew.entity.mob;

import com.rosenthal.captainandrew.Game;
import com.rosenthal.captainandrew.entity.projectile.EnemyProjectile;
import com.rosenthal.captainandrew.entity.projectile.Projectile;
import com.rosenthal.captainandrew.graphics.Screen;
import com.rosenthal.captainandrew.graphics.Sprite;

public class Enemy extends Mob {

	private Sprite sprite;
	private int anim = 0;
	private boolean walking = false;

	private int fireRate = 0;
	private double enemyRange = 85;
	private Player player = Game.getPlayer();
	private int counter = 0;

	public Enemy(int x, int y) {
		this.x = x;
		this.y = y;
		fireRate = EnemyProjectile.FIRE_RATE;
	}

	private double playerDistance() {
		int playerDistanceX = player.getX() - this.x;
		int playerDistanceY = player.getY() - this.y;
		double playerDistance = Math.sqrt(playerDistanceX * playerDistanceX + playerDistanceY * playerDistanceY);
		return playerDistance;

	}

	public void update() {
		if (fireRate > 0) fireRate--;
		int xa = 0, ya = 0;
		if (anim < 7500)
			anim++;
		else
			anim = 0;
		if (counter == 1) {
			if (this.x < player.getX()) {
				xa++;
			}

			if (this.x > player.getX()) {
				xa--;
			}

			if (this.y < player.getY()) {
				ya++;
			}

			if (this.y > player.getY()) {
				ya--;
			}
			counter = 0;
		}

		else {
			counter++;
		}

		if (xa != 0 || ya != 0) {
			if (playerDistance() < enemyRange) {
				move(xa, ya);
				walking = true;
			}
		} else {
			walking = false;
		}
		clear();
		updateShooting();
	}

	private void clear() {
		for (int i = 0; i < level.getProjectiles().size(); i++) {
			Projectile ep = level.getProjectiles().get(i);
			if (ep.isRemoved()) level.getProjectiles().remove(i);
		}
	}

	private void updateShooting() {
		if (fireRate <= 0) {
			double dx = Game.getPlayer().getX() - this.x;
			double dy = Game.getPlayer().getY() - this.y;
			double dir = Math.atan2(dy, dx);
			if (playerDistance() < enemyRange) {
				enemyShoot(x, y, dir);
			}
			fireRate = EnemyProjectile.FIRE_RATE;
		}
	}

	public void render(Screen screen) {
		int flip = 0;
		if (dir == 0) {
			sprite = Sprite.enemy_forward;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.enemy_forward_1;
				} else {
					sprite = Sprite.enemy_forward_2;
				}
			}
		}
		if (dir == 1) {
			sprite = Sprite.enemy_side;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.enemy_side_1;
				} else {
					sprite = Sprite.enemy_side_2;
				}
			}
		}
		if (dir == 2) {
			sprite = Sprite.enemy_back;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.enemy_back_1;
				} else {
					sprite = Sprite.enemy_back_2;
				}
			}
		}
		if (dir == 3) {
			sprite = Sprite.enemy_side;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.enemy_side_1;
				} else {
					sprite = Sprite.enemy_side_2;
				}
			}
			flip = 1;
		}
		screen.renderPlayer(x - 16, y - 16, sprite, flip);
	}

}
