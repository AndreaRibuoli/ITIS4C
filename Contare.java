public class Contare {
   private static int counter = 0;
   private float a; // coefficiente X^2
   private float b; // coefficiente X
   private float c; // costante
   
   public static int getCounter() {
	   return counter;
   }	   
   
   public Contare(int pa, int pb, int pc) {
	   a = pa; b = pb; c = pc;
	   counter++;	
   }
   
   public static void main(String args[]) {
	   Contare es1 = new Contare(2, 3, 4);
	   System.out.println("Risultano attive " + getCounter() + " classi" );
	   Contare es2 = new Contare(3, 4, 5);
	   System.out.println("Risultano attive " + getCounter() + " classi" );
   }	    
}
