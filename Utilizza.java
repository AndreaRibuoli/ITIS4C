class Utilizza {
   public Utilizza() {
   }
   
   public static void main(String args[]) {
	   Contare es1 = new Contare(2, 3, 4);
	   System.out.println("Risultano attive " + Contare.getCounter() + " classi" );
	   Contare es2 = new Contare(3, 4, 5);
	   System.out.println("Risultano attive " + Contare.getCounter() + " classi" );
   }	    
}
