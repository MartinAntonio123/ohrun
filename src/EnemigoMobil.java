import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class EnemigoMobil extends Object{
	private int estado, velocidad, fps;
	boolean vivo, rep;
	private BufferedImage[] scorrer, smorir;

	public EnemigoMobil(int x, int y, BufferedImage[] scorrer, BufferedImage[] smorir){
		super(x,y);
		estado = 0;
		velocidad = 0;
		fps = 10;
		vivo = true;
    rep = true;
		this.scorrer =  scorrer;
		this.smorir = smorir;
	}

	public void avanzar(int dist){
    this.x = this.x - dist;
    if(rep){
      velocidad ++;
      if(velocidad == fps){
        velocidad = 0;
        estado ++;
        if(estado == 7){
          if (vivo)
            estado = 0;
          else {
            estado = 6;
            rep = false;
          }
        }
      }
    }
	}
	public void paint(Graphics g){
		Graphics2D draw= (Graphics2D) g;
		if(vivo)
			draw.drawImage(scorrer[estado],x,y,-150,100,null);
		else
			draw.drawImage(smorir[estado],x,y,-150,100,null);
	}
  public boolean chocar(Personaje miPersonaje){
    if(!this.vivo){
      return false;
    }
    if((miPersonaje.getX()+100)>(this.x-50)&&((miPersonaje.getX())<(this.x))){
      if(((miPersonaje.getY()+100)>(this.y))&&((miPersonaje.getY())<(this.y+100))){
        if (miPersonaje.getAttack()) {
          vivo = false;
          return false;
        }
        else{
          return true;
        }
      }
      else{
        return false;
      }
    }
    else{
      return false;
    }
  }
}
