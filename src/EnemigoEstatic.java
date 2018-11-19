import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class EnemigoEstatic extends Object{
	private int estado, velocidad, fps;
	private BufferedImage imagen;
  private int ancho, alto;

	public EnemigoEstatic(int x, int y, BufferedImage imagen){
		super(x,y);
		estado = 0;
		velocidad = 0;
    ancho = 50;
    alto = 30;
    this.imagen = imagen;
		}

	public void avanzar(int dist){
		this.x = this.x - dist;
	}
	public void paint(Graphics g){
		Graphics2D draw= (Graphics2D) g;
		draw.drawImage(imagen,x,y,50,70,null);
	}
  public boolean chocar(Personaje miPersonaje){
    if((miPersonaje.getX()+30)>(this.x)&&((miPersonaje.getX())<(this.x+10))){
      if(((miPersonaje.getY()+70)>(this.y))&&((miPersonaje.getY())<(this.y+10))){
        return true;
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
