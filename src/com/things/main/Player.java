package com.things.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject {

  private Handler handler;

  public Player(float x, float y, ID id, Handler handler){
    super(x, y, id);
    this.handler = handler;

  }

  public Rectangle getBounds(){
    return new Rectangle((int)x, (int)y, 32, 32);
  }

  @Override
  public void tick(){
    x += velX;
    y += velY;

    x = Game.clamp(x, 0, Game.width - 32);
    y = Game.clamp(y, 0, Game.height - 32);

    collision();
  }

  private void collision(){
    for(int i = 0; i < handler.object.size(); i++){
      GameObject tempObject = handler.object.get(i);

      if(handler.difficulty == Handler.DIFF.Baby){
        if(tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy){
          if(getBounds().intersects(tempObject.getBounds())){
            HUD.health -= 2;
          }
        }
        if(tempObject.getId() == ID.Boss1){
          if(getBounds().intersects(tempObject.getBounds())){
            HUD.health = 0;
          }
        }


      } else if(handler.difficulty == Handler.DIFF.Child){
        if(tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy){
          if(getBounds().intersects(tempObject.getBounds())){
            HUD.health -= 4;
          }
        }
        if(tempObject.getId() == ID.Boss1){
          if(getBounds().intersects(tempObject.getBounds())){
            HUD.health = 0;
          }
        }



      } else if(handler.difficulty == Handler.DIFF.Adult){
        if(tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy || tempObject.getId() == ID.Boss1){
          if(getBounds().intersects(tempObject.getBounds())){
            HUD.health = 0;
          }
        }

      }

    }
  }

  @Override
  public void render(Graphics g){
    g.setColor(Color.white);
    g.fillRect((int)x, (int)y, 32, 32);
  }



}
