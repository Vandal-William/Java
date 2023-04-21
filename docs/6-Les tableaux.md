# Les Tableaux

```java
public class MainApp {
    public static void main (String[] args){
      
        // créer un tableau de nombre
        int tab[] = new int[3];
        //ou
        int tab2[] = new int[]{1, 2, 3};
        //ou
        int tab3[] = {1, 2, 3};
        // ou 
        int[] tab4, tab5 = new int[3];
        //ou 
        int tab6[]; // pour juste initialiser un 
        
        //accéder aux éléments du tableau
        System.out.println(tab3[0]);

        // Parcourir un tableau avec for
        for(int i = 0; i< tab3.length; i++){
            System.out.println(tab3[i]);
        }

        // autre synthaxe pour parcourir un tableau
        // a utiliser de préférence, equivalent a foreach
        for(int element : tab3){
            System.out.println(element);
        }

        // tableau a 2 dimention
        int[][] tab7 = {
            {1, 2, 3},
            {4, 5, 6}
        };

        // accéder aux element d'un tableau a 2 dimention
        System.out.println(tab7[1][1]);

        //parcourrir un tableau a 2 dimentions
        for(int i = 0; i < tab7.length; i++){
            for(int j = 0; j < tab7[i].length; j++){
                System.out.println(tab7[i][j]);
            }
        }

        //ou
        for(int[] i : tab7){
            for(int number : i){
                System.out.println(number);
            }
        }
        //appel de la méthode
        printTab(tab3);
    } 
    
    // Les tableau dans les méthode
    public static void printTab(int[] t){

        for(int element : t){
            System.out.println(element);
        }
        
    }
    
}
```