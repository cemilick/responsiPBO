/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsipbo;

import responsipbo.models.Database;
import responsipbo.views.ViewHome;

/**
 *
 * @author cemil
 */
public class ResponsiPBO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Database DB = new Database();
        ViewHome viewhome = new ViewHome(DB);
        viewhome.setVisible(true);
    }
    
}
