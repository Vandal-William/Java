# Les Layout

## gérer le positionnement soi même (a ne pas faire)

```java
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
        contentPane.setLayout(null);
        // rangement du composant dans une variable
        JButton btnClickMe = new JButton("click me !");
        // je positionne le composant en x et y 
        // puis je le dimantionne (width et height)
        btnClickMe.setBounds(200, 20, 160, 30);
        // J'ajoute mon composant au container
        contentPane.add(btnClickMe);
        
    }
    public static void main(String[] args) throws UnsupportedLookAndFeelException{
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        MyWindow mainWindow = new MyWindow();
        mainWindow.setVisible(true);
    }
}
```
# FlowLayout
## Definir une taille préférer

```java
import java.awt.Dimension;
```
```java
JTextField editMe = new JTextField("edit me");
    // je redimentionne ma zone de texte
    editMe.setPreferredSize(new Dimension(120, 30));
    contentPane.add(editMe);
```

## definir l'alignement et le margin du FlowLayout

```java
// left, right, center
// marge hgap : entre les élément et vgap : autour des élément
contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 100, 100));
```
# GridLayout

le GridLayout ignore les préférences de taille, un composant va donc occuper toute la céllule dans lequelle il est mis. Les margin ne sont effectif qu'entre les composants

```java
import java.awt.GridLayout;
```

```java
// ligne, colonne, hgap et vgap
contentPane.setLayout(new GridLayout(2, 2, 20, 20));
```

# BorderLayout

le BorderLayout est le layout par defaut, il divise l'espace en 5 partie(centrale, haut, bas, gauche, droite), les éléments son positionnable dans ces différentes zone. Les éléments placer en haut et en bas prandrons 100% de la longeur disponnible et les élément a droite et a gauche prendrons 100% de la hauteur disponnible.

```java
contentPane.setLayout(new BorderLayout());
```
```java
import java.awt.BorderLayout;
import java.awt.Dimension;

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
        contentPane.setLayout(new BorderLayout());

        JButton btnClickMe = new JButton("click me !");
        // j'ajoute une contrainte pour 
        // placer mon élément en haut
        contentPane.add(btnClickMe, BorderLayout.NORTH);

        JButton btnPushMe = new JButton("push me !!!");
        // La hauteur ne pourra pas etre changer même
        // si l'on ajoute des valeurs 
        btnPushMe.setPreferredSize(new Dimension(300, 0));
        // j'ajoute une contrainte pour 
        // placer mon élément a gauche
        contentPane.add(btnPushMe, BorderLayout.WEST);

        JCheckBox checkMe = new JCheckBox("check me");
        // j'ajoute une contrainte pour 
        // placer mon élément en bas
        contentPane.add(checkMe, BorderLayout.SOUTH);

        JTextField editMe = new JTextField("edit me");
         // si je ne met rien l'element sera au centre
        contentPane.add(editMe);
    }
    public static void main(String[] args) throws UnsupportedLookAndFeelException{
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        MyWindow mainWindow = new MyWindow();
        mainWindow.setVisible(true);
    }
}
```
# Mixage des stratégie

On va donc utiliser le conteneur principale, avec une stratégie de positionnement et des méthodes qui crérons des sous conteneur qui aurrons des stratégies de positionnement différente et qui serron placer dans le conteneur principale.

```java
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JTree;
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

        contentPane.setLayout(new BorderLayout());

        // j'insère la toolBar dans mon composant contentPane
        contentPane.add(createToolBar(), BorderLayout.NORTH);

        // je définie une scroll bar a gauche
        // la scroll bar est construite par rapport a une 
        // arboraissance de base qui sera créer (JTree)
        JScrollPane westComponent = new JScrollPane(new JTree());
        westComponent.setPreferredSize(new Dimension(200, 0));
        contentPane.add(westComponent, BorderLayout.WEST);

        contentPane.add(createRightPanel(), BorderLayout.EAST);

        contentPane.add(createStatusBar(), BorderLayout.SOUTH);

        JTextArea txtContent = new JTextArea("edit me");
        // J'ajoute une barre de scroll dans txtContent
        JScrollPane scrContent = new JScrollPane(txtContent);
        contentPane.add(scrContent);
    }

    // J'utilise une méthode pour créer une toolBar
    private JToolBar createToolBar(){
        JToolBar toolBar = new JToolBar();

        JButton btnClickMe = new JButton("click me !");
        toolBar.add(btnClickMe);

        JButton btnPushMe = new JButton("push me !!!");
        toolBar.add(btnPushMe);

        JCheckBox checkMe = new JCheckBox("check me");
        toolBar.add(checkMe);

        JTextField editMe = new JTextField("edit me");
        editMe.setPreferredSize(new Dimension(140, 0));
        toolBar.add(editMe);

        return toolBar;
    }
    // j'utilise une méthode pour créer une barre de statut
    private JPanel createStatusBar(){
        JPanel statusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel labelStatus1 = new JLabel("Message 1");
        labelStatus1.setPreferredSize(new Dimension(100, 30));
        statusBar.add(labelStatus1);

        JLabel labelStatus2 = new JLabel("Message 2");
        labelStatus2.setPreferredSize(new Dimension(100, 30));
        statusBar.add(labelStatus2);

        JLabel labelStatus3 = new JLabel("Message 3");
        labelStatus3.setPreferredSize(new Dimension(100, 30));
        statusBar.add(labelStatus3);

        return statusBar;
    }
    // méthode pour créer un panel a droite 
    private JPanel createRightPanel(){
        JPanel panel = new JPanel(new GridLayout(4, 1));
        panel.add(new JButton("Button 1"));
        panel.add(new JButton("Button 2"));
        panel.add(new JButton("Button 3"));
        panel.add(new JButton("Button 4"));

        return panel;
    }
    public static void main(String[] args) throws UnsupportedLookAndFeelException{
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        MyWindow mainWindow = new MyWindow();
        mainWindow.setVisible(true);
    }
}


```

