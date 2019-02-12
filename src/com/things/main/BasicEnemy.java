package com.things.main;

import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics;

public class BasicEnemy extends GameObject {

  public BasicEnemy(int x, int y, ID id){
    super(x, y, id);

    velX = 5;
    velY = 5;
  }

  public Rectangle getBounds(){
    return new Rectangle(x, y, 16, 16);
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
    g.setColor(Color.red);
    g.fillRect(x, y, 16, 16);
  }

}
