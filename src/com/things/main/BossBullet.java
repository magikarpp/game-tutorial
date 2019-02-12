package com.things.main;

import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class BossBullet extends GameObject {
  Handler handler;
  Random r = new Random();

  public BossBullet(float x, float y, ID id, Handler handler){
    super(x, y, id);
    this.handler = handler;

    velX = (r.nextInt(5 -  -5)+ -5);
    velY = 5;
  }

  public Rectangle getBounds(){
    return new Rectangle((int)x, (int)y, 16, 16);
  }

  @Override
  public void tick(){
    x += velX;
    y += velY;

    if(y >= Game.height) handler.removeObject(this);
  }

  @Override
  public void render(Graphics g){
    g.setColor(Color.red);
    g.fillRect((int)x, (int)y, 16, 16);
  }

}
