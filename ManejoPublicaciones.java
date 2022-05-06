/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorial;
import java.util.ArrayList;
import java.util.Iterator;
import jerarquiaHerencia.*;
import vista.Mostrar;
/**
 *
 * @author Veronica Martínez
 */

public class ManejoPublicaciones {
    static ArrayList<Publicaciones> ArrPublica = new ArrayList<Publicaciones>();
    private Periodico objPeriodico;
    private Libro objLibro;
    private Revista objRevista;
    private Publicaciones objPublica;
    
    public ManejoPublicaciones() {
        
    }
    public ManejoPublicaciones(String tit, double precio, int np) {
        objPublica = new Publicaciones();
        objPublica.setTitulo(tit);
        objPublica.setPrecio(precio);
        objPublica.setNoPag(np);
    }
    
    public void altaLibro(String ISBN, String Autor, String edicion) {
        objLibro = new Libro();
        objLibro.setTitulo(objPublica.getTitulo());
        objLibro.setPrecio(objPublica.getPrecio());
        objLibro.setNoPag(objPublica.getNoPag());
        objLibro.setISBN(ISBN);
        objLibro.setAutor(Autor);
        objLibro.setEdicion(edicion);
        ArrPublica.add(objLibro);
    }
    public void altaRevista(String ISSN, int num) {
        objRevista = new Revista();
        objRevista.setTitulo(objPublica.getTitulo());
        objRevista.setPrecio(objPublica.getPrecio());
        objRevista.setNoPag(objPublica.getNoPag());
        objRevista.setNum(num);
        objRevista.setISSN(ISSN);
        ArrPublica.add(objRevista);
    }
    
    public void altaPeriodico(String editor) {
        objPeriodico = new Periodico();
        objPeriodico.setTitulo(objPublica.getTitulo());
        objPeriodico.setPrecio(objPublica.getPrecio());
        objPeriodico.setNoPag(objPublica.getNoPag());
        objPeriodico.setEditor(editor);
        ArrPublica.add(objPeriodico);
    }
    
    public void desplegar() {
        vista.Mostrar.txtConsulta.setText("OBJETOS EN LA PUBLICACIÓN");
        System.out.println("....OBJETOS EN LA PUBLICACIÓN....");
        Iterator<Publicaciones> itrPublica = ArrPublica.iterator();
        while(itrPublica.hasNext()) {
            Publicaciones publica = itrPublica.next();
            if (publica instanceof Libro) {
                Libro book = new Libro();
                book = (Libro) publica;
                System.out.println("ISBN: " + book.getISBN());
                System.out.println("Titulo: " + book.getTitulo());
            } else if (publica instanceof Revista) {
                Revista rev = new Revista();
                rev = (Revista) publica;
                System.out.println("ISSN: " + rev.getISSN());
                System.out.println("Titulo: " + rev.getTitulo());
            } else if(publica instanceof Periodico) {
                Periodico per = new Periodico();
                per = (Periodico) publica;
                System.out.println("Editor: " + per.getEditor());
                System.out.println("Titulo: " + per.getTitulo());
            }
        }
    }
    
}
