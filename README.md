# ITIS4C
Appunti per lezioni


### confronto tra costruttori

a pagina **A86**:

``` java
public class Mensola {
    
  private static final int MAX_NUM_VOLUMI=15;
  private Libro volumi[];
  public Mensola() {
    volumi = new Libro[MAX_NUM_VOLUMI];    
  }
  . . .
}    
```
a pagina **A92** (l'associazione tra le classi *Scaffale* e *Mensola* 
è di tipo **compositivo**):

``` java
public class Scaffale {
    
  private static final int NUM_RIPIANI=5;
  private Mensola ripiani[];
  public Scaffale() {
    int ripiano;  
    ripiani = new Mensola[NUM_RIPIANI];  
    for (ripiano=0; ripiano<NUM_RIPIANI; ripiano++) {
      ripiani[ripiano] = new Mensola();  
    }    
  }
  . . .
}    
```

### attenzione coi costruttori di copia

### stringhe Java e Unicode

``` sh
javac Comprensione.java
java Comprensione
------------------------
Io vivo in Italia (🇮🇹)
------------------------
```

Perchè la lunghezza del tratteggio eccede la stringa se il codice Java è il seguente?

``` java
public class Comprensione {
	public static void main (String[] args) {
		String messaggio = "Io vivo in Italia (🇮🇹)";
		int len = messaggio.length();
		for(int i=0; i<len; i++) System.out.print("-");
		System.out.println("");
		System.out.println(messaggio);
		for(int i=0; i<len; i++) System.out.print("-");
		System.out.println("");		
	}
}
```

### Eccezioni

``` java
import java.time.LocalTime;

public class Ricordami {
    public class OrarioGiaPassato extends Exception {}
    public class OrarioNonValido extends Exception {}
	private int ore;
	private int minuti;
	private void setOre(int hh) {ore = hh;}
	private void setMinuti(int mm) {minuti = mm;}
	public LocalTime getOrario() { return LocalTime.of(ore,minuti);}
	
	public int getMinutiRimasti() 
	           throws OrarioGiaPassato {
		LocalTime adesso = LocalTime.now();
		int valore = adesso.getHour() * 60 + adesso.getMinute();
        if( ( valore ) > ( ore*60 + minuti) )		
		    throw new OrarioGiaPassato();		       
        return ( ore*60 + minuti - valore );
	} 
	
	public Ricordami(int hh, int mm) 
	       throws OrarioNonValido, OrarioGiaPassato {
		if( hh<0 || hh>23 || mm<0 || mm>59)
		    throw new OrarioNonValido();
		LocalTime adesso = LocalTime.now();
        if( ( adesso.getHour() * 60 + adesso.getMinute() ) > (hh*60+mm) )		
		    throw new OrarioGiaPassato();
		ore = hh;
		minuti = mm;           
	}	
	
	public static void main(String[] args) throws OrarioNonValido, OrarioGiaPassato {		
//      Ricordami t0 = new Ricordami( 7, 30);
        Ricordami t1 = new Ricordami(13, 49);
        System.out.println("Sono rimasti " + t1.getMinutiRimasti() + " minuti.");
//      Ricordami t2 = new Ricordami(25, 30);
	}	
}
```