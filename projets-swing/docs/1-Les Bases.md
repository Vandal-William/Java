# JFrame

Pour avoir une fenètre graphique avec swing, il est nécéssaire d'utiliser une JFrame

```java
import javax.swing.JFrame;
```
Il faut ensuite "étandre" la classe principale de l'application pour utilisé la JFrame

```java
public class Main extends JFrame{ 
    public static void main(String[] args){

    }
}
```

# Donner un titre a la fenètre principale

```java
public class MainWindow extends JFrame{ 
    //appel au constructeur parent
    public MainWindow(){
        super("Ma première application swing");
    }
    public static void main(String[] args){

    }
}
```

# Appeler la fenètre principale

```java
import javax.swing.JFrame;

public class MyWindow extends JFrame{ 
    public MyWindow(){
        super("Ma première application swing");
        // par défaut lorsque l'on ferme une fenètre swing
        // celle ci devient juste invisible, pour palier a 
        //ce problème : (libère toute les ressource de la fenètre)
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // choisir la taille de la fenètre
        this.setSize(600, 400);
        // je définit ou doit s'ouvrir la fenètre a l'écrant (en haut a 
        // droite, en bas a gauche...)
        // ici la fenètre sera toujour centré
        // attention la taille de la fenètre devra etre défini avant  
        // cette ligne
        this.setLocationRelativeTo(null);
    }
    public static void main(String[] args){
        // J'appel la fenètre principale
        MyWindow mainWindow = new MyWindow();
        // je demande a ce qu'elle soit visible
        mainWindow.setVisible(true);
    }
}
```
# Jpanel : (contentPane)

Un Jpanel dans une JFrame est un composant graphique qui va contenir des composant graphique.

```java
import javax.swing.JPanel;
```
```java
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyWindow extends JFrame{ 
    public MyWindow(){
        super("Ma première application swing");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(900, 800);
        this.setLocationRelativeTo(null);
        // je déclare un container qui va contenir d'autre composant
        JPanel contentPane = (JPanel) this.getContentPane();
    }
    public static void main(String[] args){
        MyWindow mainWindow = new MyWindow();
        mainWindow.setVisible(true);
    }
}

```

# Layaout 

Un Layaout est une stratégie de positionnement, permet de positionner les widget a l'intérieur d'un container

## FlowLayout

la stratégie de positionnement d'un flowlayout est de positionner les élement de la fenèrte en ligne, les élément seront taller au plus juste en fonction de leur contenue, les éléments vont a la ligne quand la fenètre est trop petite.

```java
import java.awt.FlowLayout;
```

```java
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class MyWindow extends JFrame{ 
    public MyWindow(){
        super("Ma première application swing");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(900, 800);
        this.setLocationRelativeTo(null);
        JPanel contentPane = (JPanel) this.getContentPane();
        // j'ajoute une stratégie de positionnement et je configure 
        // le FlowLayout pour que les éléments soi férer a gauche
        contentPane.setLayout(new FlowLayout(FlowLayout.LEFT));
        // j'ajoute des éléments graphique dans le content pane

        // Des bouttons
        contentPane.add(new JButton("click me !"));
        contentPane.add(new JButton("push me !!!"));
        // case a cocher
        contentPane.add(new JCheckBox("check me"));
        // zone de texte
        contentPane.add(new JTextField("edit me"));
    }
    public static void main(String[] args){
        MyWindow mainWindow = new MyWindow();
        mainWindow.setVisible(true);
    }
}

```

# les plaf : Look'n feel

premettent de changer l'apparance de la fenêtre JFrame

# NimbusLookAndFeel

```java
import javax.swing.UIManager;
// ce look peut déclancher une exception et je laisse le soin
// a java d'afficher l'erreur (ou j'utilise un try catch)
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
```
```java
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class MyWindow extends JFrame{ 
    public MyWindow(){
        super("Ma première application swing");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(900, 800);
        this.setLocationRelativeTo(null);
        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(new FlowLayout(FlowLayout.LEFT));
        contentPane.add(new JButton("click me !"));
        contentPane.add(new JButton("push me !!!"));
        contentPane.add(new JCheckBox("check me"));
        contentPane.add(new JTextField("edit me"));
    }
    // ici je rajoute throws UnsupportedLookAndFeelException
    // pour afficher l'erreur si il y en a une
    public static void main(String[] args) throws UnsupportedLookAndFeelException{
        // je change l'apparence par defaut 
        // de la fenêtre
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        MyWindow mainWindow = new MyWindow();
        mainWindow.setVisible(true);
    }
}
```