import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Background{
	private int x, y;
	private int a,b,c, contador=0;
	private BufferedImage  imagen, imagen2, imagen3;

	public Background(String bg){
		x=300;
		y=40;
		a=0;
		b=a+900;
		c=b+900;
	    String nomImagen = bg;
	    File archImagen = new File(nomImagen);
        try {
            imagen = ImageIO.read(archImagen);
        } catch (IOException e) {

            e.printStackTrace();
        }
        try {
            imagen2 = ImageIO.read(archImagen);
        } catch (IOException e) {

            e.printStackTrace();
        }
        try {
            imagen3 = ImageIO.read(archImagen);
        } catch (IOException e) {

            e.printStackTrace();
        }

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void paint(Graphics g)
	{
		Graphics2D draw= (Graphics2D) g;
		draw.drawImage(imagen,a,0,900,600,null);
		draw.drawImage(imagen2,b,0,900,600,null);
		draw.drawImage(imagen3,c,0,900,600,null);
	}
	public void avanza(int dist)
	{
		a= a-dist;
		b=b-dist;
		c=c-dist;
		contador=contador+dist;
		if(contador==900)
		{
			a=c+900;
		}
		if(contador==(900*2))
		{
			b=a+900;
		}
		if(contador==(900*3))
		{
			c=b+900;
			contador=0;
		}
	}

}
