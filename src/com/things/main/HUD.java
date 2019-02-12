package com.things.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {

  public static int health = 100;
  private int greenVal = 255;

  private int score = 0;
  private int level = 1;

  public void tick(){
    health = Game.clamp(health, 0, 100);
    greenVal = Game.clamp(greenVal, 0, 255);

    greenVal = health * 2;

    score++;
  }

  public void render(Graphics g){
    g.setColor(Color.gray);
    g.fillRect(15, 15, 200, 32);
    g.setColor(new Color(75, greenVal, 0));
    g.fillRect(15, 15, health * 2, 32);
    g.setColor(Color.white);
    g.drawRect(15, 15, 200, 32);

    g.drawString("Score: " + score, 15, 64);
    g.drawString("Level: " + level, 15, 80);

  }

  public void setScore(int score){
    this.score = score;
  }

  public int getScore(){
    return score;
  }

  public int getLevel(){
    return level;
  }

  public void setLevel(int level){
    this.level = level;
  }

}
