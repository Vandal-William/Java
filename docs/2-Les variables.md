# variables

## Le nomage 

- Pas de caractère spéciaux 
- Pas d'éspace
- commence par une lettre ou un underscore (_)
- écrit en camel case : uneVaribleUnPeuLongue
- Les class sont en pascal case : MaVariable
- Une variable a toujour un type devant

1.Les nombres

```java
int ageUtilisateur = 25;
```
```java
public class MainApp {
    public static void main (String[] args){
        int ageUtilisateur = 25;
        System.out.println(ageUtilisateur);
    }
}
```

2.Les chaines de charactère 

```java
String prenom = "william";
```

3.Les booleen
```java
booleen isMajeur = true;
```

## Les constante 

variable que ne changera jamais et dont la valeur ne poura etre modifier
par convention une constante s'écrit en majuscule et peut etre espacer de underscore : MA_CONTANTE  

```java
final int NUMBER = 26;
```
```java
public class MainApp {
    public static void main (String[] args){
       final int ONE_NUMBER = 26;
       System.out.println(ONE_NUMBER);
    }
}
```
```java
public class MainApp {
    public static void main (String[] args){
       final int NUMBER = 26;
       // concaténer avec +
       System.out.println("tu as " + NUMBER + " ans");
    }
}
```