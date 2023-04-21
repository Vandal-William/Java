# Les boucles

## while

```java
public class MainApp {
    public static void main (String[] args){
        int i = 0;

        while (i != 10){
            System.out.println(i);
            if(i == 5){
                break; // stop la boucle
            }
            i++;
        }
    }
}
```
## do while

```java
public class MainApp {
    public static void main (String[] args){
        int i = 0;

        do{
            i++;
            System.out.println(i);
        }while (i != 1);
    }
}
```
## for

```java
public class MainApp {
    public static void main (String[] args){
        int i;

        for(i = 0; i !=10; i++){
            System.out.println(i);
        }
    }
}
```