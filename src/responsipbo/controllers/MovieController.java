/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsipbo.controllers;
import javax.swing.JOptionPane;
import responsipbo.models.Movie;

/**
 *
 * @author cemil
 */
public class MovieController extends Controller{
   Movie movie;
   Object[][] movies = new Object[100][4];
    public MovieController(Movie movie){
       this.movie = movie;
    }
    
    public Object[][] index(){
       movies = movie.getMovie();
       return movies;
   } 
    
    public void store(String judul, double alur, double penokohan, double akting){
        boolean sudahada = false;
        for (int i = 0; movies[i][0] != null; i++) {
            if(movies[i][0].toString().equals(judul)){
                sudahada = true;
                break;
            }
        }
        if(sudahada){
            JOptionPane.showMessageDialog(null,"Movie Sudah ada dalam database!");
        } else {
            if(alur > 5.0 || penokohan > 5.0 || akting > 5.0){
               JOptionPane.showMessageDialog(null,"Maksimal alur, penokohan, dan akting adalah 5!"); 
            } else if(alur < 0 || penokohan < 0 || akting < 0){
                JOptionPane.showMessageDialog(null,"Minimal alur, penokohan, dan akting adalah 0!");
            } else{
                movie.insert(judul, alur, penokohan, akting);
                JOptionPane.showMessageDialog(null,"Berhasil Menambahkan Movie!");
            }
        }
    }
    
    public void update(String judul, double alur, double penokohan, double akting){
        boolean ketemu = false;
        int index = -1;
        for (int i = 0; movies[i][0] != null; i++) {
            if(movies[i][0].toString().equals(judul)){
                index = i;
                ketemu = true;
                break;
            }
        }
        if(ketemu){
            if(alur > 5.0 || penokohan > 5.0 || akting > 5.0){
               JOptionPane.showMessageDialog(null,"Maksimal alur, penokohan, dan akting adalah 5!"); 
            } else if(alur < 0 || penokohan < 0 || akting < 0){
                JOptionPane.showMessageDialog(null,"Minimal alur, penokohan, dan akting adalah 0!");
            } else{
                movie.update(movies[index][0].toString(), alur, penokohan, akting);
                JOptionPane.showMessageDialog(null,"Berhasil Mengupdate Movie!");
            }
        }else{
           JOptionPane.showMessageDialog(null,"Movie tidak ditemukan!"); 
        }
    }
    
    public void delete(String judul){
        boolean ketemu = false;
        int index = -1;
        for (int i = 0; movies[i][0] != null; i++) {
            if(movies[i][0].toString().equals(judul)){
                index = i;
                ketemu = true;
                break;
            }
        }
        if(ketemu){
            movie.delete(movies[index][0].toString());
            JOptionPane.showMessageDialog(null,"Berhasil Menghapus Movie!");
        }else{
           JOptionPane.showMessageDialog(null,"Movie tidak ditemukan!"); 
        }
    }
}
