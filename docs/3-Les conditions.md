# Les conditions

== : égal en valeur  
=== : égale en type et en valeur  
!= : différent de  
<  : inférieur à  
<= : inférieur ou égale à  
">" :  superieur à  
">=" : superieur ou égale à  
!  :   inverse de  

&& : ET  
|| : OU  

```java
public class MainApp {
    public static void main (String[] args){
       int value = 23;

       if (value == 16 ){
            System.out.println(value);
       } else if(value < 24){
            System.out.println("c'est plus petit que 24 c'est : " + value);
       }else{
            System.out.println("je ce n'est pas 16");
       }
    }
}
```
```java
public class MainApp {
    public static void main (String[] args){
       String choice = "je sais pas";

       switch(choice){
            case "y":
                System.out.println("vous accépter");
                break;
            case "n":
                System.out.println("vous refuser");
                break;
            default:
                System.out.println("veuiller choisir entre 'y' et 'n'");
                break;
       }

      
    }
}
```