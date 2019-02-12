package com.things.main;

import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics;

public class FastEnemy extends GameObject {
  private Handler handler;

  public FastEnemy(float x, float y, ID id, Handler handler){
    super(x, y, id);
    this.handler = handler;

    velX = 3;
    velY = 9;
  }

  public Rectangle getBounds(){
    return new Rectangle((int)x, (int)y, 16, 16);
  }

  @Override
  public void tick(){
    x += velX;
    y += velY;

    if(y <= 0 || y >= Game.height - 32){
      velY *= -1;
    }
    if(x <= 0 || x >= Game.width - 32){
      velX *= -1;
    }
  }

  @Override
  public void render(Graphics g){
    g.setColor(Color.magenta);
    g.fillRect((int)x, (int)y, 16, 16);
  }

}
