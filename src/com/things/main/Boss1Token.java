package com.things.main;

import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics;

public class Boss1Token extends GameObject {
  private Handler handler;

  public Boss1Token(float x, float y, ID id, Handler handler){
    super(x, y, id);
    this.handler = handler;

    velX = 0;
    velY = 0;
  }

  public Rectangle getBounds(){
    return new Rectangle((int)x, (int)y, 16, 16);
  }

  @Override
  public void tick(){

    collision();
  }

  private void collision(){
    for(int i = 0; i < handler.object.size(); i++){
      GameObject tempObject = handler.object.get(i);

      if(tempObject.getId() == ID.Player){
        if(getBounds().intersects(tempObject.getBounds())){
          for(int j = 0; j < handler.bossObjects.size(); j++){
            Boss1 tempBoss = handler.bossObjects.get(j);
            if(tempBoss.getId() == ID.Boss1){
              tempBoss.setHealth(tempBoss.getHealth()-20);
            }
          }
          handler.removeObject(this);
        }
      }
    }
  }

  @Override
  public void render(Graphics g){
    g.setColor(Color.green);
    g.fillRect((int)x, (int)y, 16, 16);
  }

}
