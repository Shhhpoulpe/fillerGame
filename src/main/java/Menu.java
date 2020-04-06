import javax.swing.JFrame;

public class Menu extends JFrame {

    public Menu() { 
        initUI(); //appel de la methode d'initialisation du menu dans le constructeur
    }
    
    private void initUI() { 
        add(new ControlePanel()); // appel d'un nouveau "Board" déclencheur du lancement du jeu et de l'interface
        
        pack(); // permet à la fenetre de maintenir les bonnes dimensions au lancement
        setTitle("fillerGame"); // titre de la fenetre
        setLocationRelativeTo(null); // centre la fenetre au millieu de l'écran
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // termine le programme quand l'utilisateur ferme la fenetre
    }


    public static void main(String[] args) {
            Menu myGame = new Menu();
            myGame.setVisible(true); // permet à la fenetre d'etre visible pour l'utilisateur
    }
}