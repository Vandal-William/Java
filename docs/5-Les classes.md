# Les classes

une classe est un modele de construction d'une entité, d'un concepte ou d'une idée
une instance donne vie a l'entité, le concepte ou l'idée en créant un objet

Une classe = un fichier

1. je créer un fichier Cat.java

```java
public class Cat {
    // constructeur de la class Cat
    public Cat(){
        // le mot clé this fait référence a Cat chacque Cat sera une entité bien distinct
        System.out.println("je suis un chat : " + this);
    }
}

```
2. J'instencie la classe dans ma classe principale

```java
public class MainApp {
    public static void main (String[] args){
        // java retrouve les classe tous seule pas besoin de les importer
        // puis j'instancie la classe Cat
        Cat miaou = new Cat();
        Cat miaou2 = new Cat();
    }
}

```

3. je compile tous mes fichiers

```shell
javac *.java
```
4. Je lance ma classe principale

```shell
java MainApp
```

Sortie en console :

@37... est un identifiant mémoire

```
je suis un chat : Cat@372f7a8d
je suis un chat : Cat@2f92e0f4
```
# Les attributs 

```java
public class Cat {
    // des attributs sont des variable lier a une classe, leurs porter est en priver
    // c'est a dire accéssible uniquement dans la classe ou ils sont déclarée
    private String name;
    private int age;
    // Je passe les attributs au constructeur
    public Cat(String name, int age){
        // j'affecte les attributs
        this.name = name;
        this.age = age;

        // puis j'utilise les attributs
        System.out.println(this.name + " - " + this.age);
    }
}

```
```java
public class MainApp {
    public static void main (String[] args){
        // instancier la classe Cat avec les arguments
        Cat miaou = new Cat("kitty", 1);
    }
}

```
# Les méthodes

c'est une fonction a l'intérieur d'une class.
une méthode = une action

```java
public class MainApp {
    public static void main (String[] args){
        // appel de la méthode
        prog();
    }

    // pour les méthodes déclarer dans la classe principale
    // elle devrons etre en static et en public
    // void indique que la fonction ne retourne rien
    public static void prog(){
        System.out.println("Bonjour");
        System.out.println("Comment vas tu ?");
    }

}

```

```java
public class MainApp {

    public static void main (String[] args){

        int number = getNumber();
        System.out.println(number);
    }

    public static int getNumber(){

        boolean info = true;

        if(info){
            return 2;
        }else{
            return 0;
        }
    }

}
```
```java
public class MainApp {
    public static void main (String[] args){
        say("Hello !");
      
    }
    public static void say(String msg){
        System.out.println(msg);
    }

}
```

# La surcharge des méthodes

```java
public class MainApp {
    public static void main (String[] args){

        System.out.println(sum(2, 5));
        System.out.println(sum(2.3, 5.6));
      
    }
    // en java 2 methode peuvent porter le même nom si elle ne
    // sont pas du même type, java trouvera lui même la méthode 
    // a éxécuter en fonction du type des argument utilisé lors
    // de l'appel de la fonction
    public static int sum( int a, int b){
        return a + b;
    }
    public static double sum( double a, double b){
        return a + b;
    }  
}

```
# gérer plusieur constructeur

```java
public class Player {
  
    private String name;
    private int level;

    // ici j'utilise 3 constructeur pour la classe Player
    // cas n°1 si la classe est instantier sans paramettre
    public Player(){
        // j'affecte des paramettre par defaut
        this.name = "Inconnu";
        this.level = 1;

        System.out.println(this.name + " - " + this.level);
        
    }

    // cas n°2 si la class est instantier juste avec un nom
    public Player(String name){
        this.name = name;
        // J'affect un lvl par défaut
        this.level = 1;

        System.out.println(this.name + " - " + this.level);
    }

    // cas n°3 la class est instancier avec un nom et un lvl
    public Player(String name, int level){
        this.name = name;
        this.level = level;

        System.out.println(this.name + " - " + this.level);
    }
}

```
```java
public class MainApp {
    public static void main (String[] args){
        Player p1 = new Player();
        Player p2 = new Player("Jason");
        Player p3 = new Player("charle", 5);
    }
   
}

```
# Utiliser la méthode d'une classe
```java
public class Player {
  
    private String name;
    private int level;

    public Player(){
        this.name = "Inconnu";
        this.level = 1;

        System.out.println(this.name + " - " + this.level);   
    }

    public void attack(){
        System.out.println(this.name + " attaque une cible");
    }

}
```
```java
public class MainApp {
    public static void main (String[] args){
        Player p1 = new Player();
        p1.attack();
    }
   
}
```

# Emcapsulation : les Accesseur

```java
public class SoftwareRegistration{
    /*
    * [ACCESSEUR]
    * getters : accès à un attribut (lecture)
    * setters : modification d'un attribut 
    */
    
    private int expirationYear;

    public SoftwareRegistration(int expiration){
        this.expirationYear = expiration;
        System.out.println("valide j'usqu'en " + this.expirationYear);
    }

    // Getter
    public int getExpirationYear(){
        return this.expirationYear;
    }

    // setter
    public void setExpirationYear(int expiration){
        this.expirationYear = expiration;
    }
}

```
```java
public class MainApp {
    public static void main (String[] args){
        SoftwareRegistration sr = new SoftwareRegistration(2020);
        sr.setExpirationYear(2050);
        
        System.out.println(sr.getExpirationYear());
    } 
}
```
# Variable de classe

```java
public class SoftwareRegistration{ 
     
    private int expirationYear;
    // variable de classe : créer grace au mot clée static, commune a toute les instances de classe
    private static int numberOfRegistration = 3;

    public SoftwareRegistration(int expiration){
        if(numberOfRegistration > 0){
            this.expirationYear = expiration;
            numberOfRegistration--;
            System.out.println("Logiciel validé (expiration : " + this.expirationYear + ")");
        }else {
            System.out.println("Maximum de validations effectuées");
        }
    }

    public int getExpirationYear(){
        return this.expirationYear;
    }
    // getter de la varible de classe
    public static int getNumberOfRegistration(){
        // le mot clée this n'est pas nécéssaire ici
        // car ce n'est pas un attribue mais une variable de classe
        return numberOfRegistration;
    }


   
}
```
```java
public class MainApp {
    public static void main (String[] args){
        System.out.println("ENREGISTREMENT : " + SoftwareRegistration.getNumberOfRegistration());

        SoftwareRegistration sr = new SoftwareRegistration(2020);
        System.out.println("ENREGISTREMENT : " + SoftwareRegistration.getNumberOfRegistration());

        SoftwareRegistration sr2 = new SoftwareRegistration(2022);
        System.out.println("ENREGISTREMENT : " + SoftwareRegistration.getNumberOfRegistration());

        SoftwareRegistration sr3 = new SoftwareRegistration(2024);
        System.out.println("ENREGISTREMENT : " + SoftwareRegistration.getNumberOfRegistration());
        
        SoftwareRegistration sr4 = new SoftwareRegistration(2026);

    } 
}
```
