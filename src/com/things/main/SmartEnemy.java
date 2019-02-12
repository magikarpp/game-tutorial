package com.things.main;

import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics;

public class SmartEnemy extends GameObject {
  private Handler handler;
  private GameObject player;

  public SmartEnemy(float x, float y, ID id, Handler handler){
    super(x, y, id);
    this.handler = handler;

    for(int i = 0; i < handler.object.size(); i++){
      if(handler.object.get(i).getId() == ID.Player){
        player = handler.object.get(i);
      }
    }


  }

  public Rectangle getBounds(){
    return new Rectangle((int)x, (int)y, 16, 16);
  }

  @Override
  public void tick(){
    x += velX;
    y += velY;

    float diffX = x - player.getX() - 8;
    float diffY = y - player.getY() - 8;
    float distance = (float) Math.sqrt((x-player.getX())*(x-player.getX())+(y-player.getY())*(y-player.getY()));

    velX = (float) ((-1/distance) * diffX);
    velY = (float) ((-1/distance) * diffY);

    if(y <= 0 || y >= Game.height - 32){
      velY *= -1;
    }
    if(x <= 0 || x >= Game.width - 32){
      velX *= -1;
    }
  }

  @Override
  public void render(Graphics g){
    g.setColor(Color.cyan);
    g.fillRect((int)x, (int)y, 16, 16);
  }

}
