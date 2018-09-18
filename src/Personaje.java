import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Personaje extends Object{
	private int estado, velocidad, fps;
	boolean corre, salta, ataca;
	private BufferedImage[] scorrer, satacar, ssaltar; 
	
	public Personaje(){
		super(40,455);
		estado = 0;
		velocidad = 0;
		fps = 4;
		corre = true;
		salta = false;
		ataca = false;
		scorrer = new BufferedImage[5];
		for(int i = 0; i < 5; i++){
			String nomImagen = "personaje/3_RUN_00" + i + ".png";
		    File archImagen = new File(nomImagen);
	        try {
	            scorrer[i] = ImageIO.read(archImagen);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
		satacar = new BufferedImage[5];
		for(int i = 0; i < 5; i++){
			String nomImagen = "personaje/5_ATTACK_00" + i + ".png";
		    File archImagen = new File(nomImagen);
	        try {
	            satacar[i] = ImageIO.read(archImagen);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
		ssaltar = new BufferedImage[5];
		for(int i = 0; i < 5; i++){
			String nomImagen = "personaje/4_JUMP_00" + i + ".png";
		    File archImagen = new File(nomImagen);
	        try {
	            ssaltar[i] = ImageIO.read(archImagen);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
	}
	public void atacar(){
		corre = false;
		salta = false;
		ataca = true;
		estado = 0;
	}
	public void saltar(){
		if(!salta){
			corre = false;
			salta = true;
			ataca = false;
			estado = 0;
			fps = 6;
		}
	}
	public void avanzar(){
		velocidad ++;
		if(velocidad == fps){
			velocidad = 0;
			estado ++;
			if(salta){
				if(estado < 3){
					y = y-20;
				}
				else if(estado > 3){
					y = y+20;
				}
			}
			if(estado == 5){
				estado = 0;
				corre = true;
				salta = false;
				ataca = false;
				fps = 4;
			}
		}		
	}
	public void paint(Graphics g){
		Graphics2D draw= (Graphics2D) g;
		if(corre)
			draw.drawImage(scorrer[estado],x,y,100,100,null);
		else if(ataca)
			draw.drawImage(satacar[estado],x,y,100,100,null);
		else if(salta)
			draw.drawImage(ssaltar[estado],x,y,100,100,null);
	}
}
