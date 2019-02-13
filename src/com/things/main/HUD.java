package com.things.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {

  private Game game;
  private Handler handler;

  public static float health = 100;
  private float greenVal = 255;

  private float score = 0;
  private float level = 1;

  public HUD(Game game, Handler handler){
    this.game = game;
    this.handler = handler;
  }

  public void tick(){
    health = Game.clamp(health, 0, 100);
    greenVal = Game.clamp(greenVal, 0, 255);

    greenVal = health * 2;

    score++;

    isDead();
  }

  public void render(Graphics g){
    g.setColor(Color.gray);
    g.fillRect(15, 15, 200, 32);
    g.setColor(new Color(75, (int)greenVal, 0));
    g.fillRect(15, 15, (int)(health * 2), 32);
    g.setColor(Color.white);
    g.drawRect(15, 15, 200, 32);

    g.drawString("Score: " + (int)score, 15, 64);
    g.drawString("Level: " + (int)level, 15, 80);

  }

  public void isDead(){
    if(health <= 0){
      handler.clearEverything();
      game.gameState = Game.STATE.Dead;
      health = 100;
      greenVal = 255;
      score = 0;
      level = 1;
    }
  }

  public void setScore(float score){
    this.score = score;
  }

  public float getScore(){
    return score;
  }

  public float getLevel(){
    return level;
  }

  public void setLevel(float level){
    this.level = level;
  }

}
