package com.things.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

  private Handler handler;

  public KeyInput(Handler handler){
    this.handler = handler;

  }

  public void keyPressed(KeyEvent e){
    int key = e.getKeyCode();

    for(int i = 0; i < handler.object.size(); i++){
      GameObject tempObject = handler.object.get(i);

      if(tempObject.getId() == ID.Player){
          if(key == KeyEvent.VK_W || key == KeyEvent.VK_UP) tempObject.setVelY(-5);
          if(key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) tempObject.setVelY(5);
          if(key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) tempObject.setVelX(-5);
          if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) tempObject.setVelX(5);
      }

    }
  }

  public void keyReleased(KeyEvent e){
    int key = e.getKeyCode();

    for(int i = 0; i < handler.object.size(); i++){
      GameObject tempObject = handler.object.get(i);

      if(tempObject.getId() == ID.Player){
          if(key == KeyEvent.VK_W || key == KeyEvent.VK_UP) tempObject.setVelY(0);
          if(key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) tempObject.setVelY(0);
          if(key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) tempObject.setVelX(0);
          if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) tempObject.setVelX(0);
      }

    }
  }

}
