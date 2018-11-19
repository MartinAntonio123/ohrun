import java.awt.Canvas;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Iterator;
import java.util.Random;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class EnemigoSMoviles extends Canvas{
  private LinkedList<EnemigoMobil> lista;
  private int cont, next;
  private String nombre;
  private BufferedImage[] scorrera, smorira, scorrerb, smorirb, scorrerc, smorirc;
  Random random;

	public EnemigoSMoviles(){
		super();
    nombre = "../enemigo/stone/Prop_2.png";
		lista = new LinkedList<EnemigoMobil>();
		cont=1;
    next = 200;
    random = new Random();

    scorrera = new BufferedImage[7];
  	for(int i = 0; i < 7; i++){
  		String nomImagen = "../enemigo/"+ 1 +"_TROLL/WALK/WALK_00" + i + ".png";
  	    File archImagen = new File(nomImagen);
          try {
              scorrera[i] = ImageIO.read(archImagen);
          } catch (IOException e) {
              e.printStackTrace();
          }
  	}
  	smorira = new BufferedImage[7];
  	for(int i = 0; i < 7; i++){
  		String nomImagen = "../enemigo/"+1+"_TROLL/DIE/DIE_00" + i + ".png";
  	    File archImagen = new File(nomImagen);
          try {
              smorira[i] = ImageIO.read(archImagen);
          } catch (IOException e) {
              e.printStackTrace();
          }
    }
    scorrerb = new BufferedImage[7];
  	for(int i = 0; i < 7; i++){
  		String nomImagen = "../enemigo/"+ 2 +"_TROLL/WALK/WALK_00" + i + ".png";
  	    File archImagen = new File(nomImagen);
          try {
              scorrerb[i] = ImageIO.read(archImagen);
          } catch (IOException e) {
              e.printStackTrace();
          }
    }
  	smorirb = new BufferedImage[7];
  	for(int i = 0; i < 7; i++){
  		String nomImagen = "../enemigo/"+2+"_TROLL/DIE/DIE_00" + i + ".png";
  	    File archImagen = new File(nomImagen);
          try {
              smorirb[i] = ImageIO.read(archImagen);
          } catch (IOException e) {
              e.printStackTrace();
          }
  	}
    scorrerc = new BufferedImage[7];
    for(int i = 0; i < 7; i++){
      String nomImagen = "../enemigo/"+ 3 +"_TROLL/WALK/WALK_00" + i + ".png";
        File archImagen = new File(nomImagen);
          try {
              scorrerc[i] = ImageIO.read(archImagen);
          } catch (IOException e) {
              e.printStackTrace();
          }
    }
    smorirc = new BufferedImage[7];
    for(int i = 0; i < 7; i++){
      String nomImagen = "../enemigo/"+3+"_TROLL/DIE/DIE_00" + i + ".png";
        File archImagen = new File(nomImagen);
          try {
              smorirc[i] = ImageIO.read(archImagen);
          } catch (IOException e) {
              e.printStackTrace();
          }}
    lista.add(new EnemigoMobil(900, 460, scorrera, smorira));
}

	public void paint(Graphics g){
		super.paint(g);
		Iterator<EnemigoMobil> iterator = lista.listIterator();
		while(iterator.hasNext()){
			EnemigoMobil aux = iterator.next();
			aux.paint(g);
		}
	}
	public void avanza(int dist){
		cont++;
    Iterator<EnemigoMobil> iterator = lista.listIterator();
		while(iterator.hasNext()){
			EnemigoMobil aux = iterator.next();
			aux.avanzar(dist);
		}
    if (cont == next) {
      anadir();
      cont = 0;
      next = random.nextInt(500) + 150;
    }

	}
	public void anadir(){
    int randomInt = random.nextInt(3) + 1;
    if(randomInt == 1)
		this.lista.add(new EnemigoMobil(900, 460, scorrera, smorira));
    else if(randomInt == 2)
    lista.add(new EnemigoMobil(900, 460, scorrerb, smorirb));
    else
    lista.add(new EnemigoMobil(900, 460, scorrerc, smorirc));
  	}
	public boolean choque(Personaje miPersonaje){
    Iterator<EnemigoMobil> iterator = lista.listIterator();
    while(iterator.hasNext()){
      EnemigoMobil aux = iterator.next();
      if(aux.chocar(miPersonaje)){
        return true;
      }
    }
		return false;
	}
}
