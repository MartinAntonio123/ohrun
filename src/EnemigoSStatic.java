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

public class EnemigoSStatic extends Canvas{
  private LinkedList<EnemigoEstatic> lista;
  private int cont, next;
  private String nombre;
  private BufferedImage piedra;
  Random random;


	public EnemigoSStatic(){
		super();
		lista = new LinkedList<EnemigoEstatic>();
		cont=1;
    next = 200;
    random = new Random();
    File archImagen = new File("../enemigo/stone/Prop_2.png");
      try {
          piedra = ImageIO.read(archImagen);
      } catch (IOException e) {
          e.printStackTrace();
      }
      lista.add(new EnemigoEstatic(900, 510, piedra));
	}

	public void paint(Graphics g){
		super.paint(g);
		Iterator<EnemigoEstatic> iterator = lista.listIterator();
		while(iterator.hasNext()){
			EnemigoEstatic aux = iterator.next();
			aux.paint(g);
		}
	}
	public void avanza(int dist){
		cont++;
    Iterator<EnemigoEstatic> iterator = lista.listIterator();
		while(iterator.hasNext()){
			EnemigoEstatic aux = iterator.next();
			aux.avanzar(dist);
		}
    if (cont == next) {
      anadir();
      cont = 0;
      next = random.nextInt(500) + 150;
      System.out.println(next);
    }

	}
	public void anadir(){
		this.lista.add(new EnemigoEstatic(900, 510, piedra));
	}
	public boolean choque(Personaje miPersonaje){
    Iterator<EnemigoEstatic> iterator = lista.listIterator();
    while(iterator.hasNext()){
      EnemigoEstatic aux = iterator.next();
      if(aux.chocar(miPersonaje)){
        return true;
      }
    }
		return false;
	}

}
