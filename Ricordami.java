import java.time.LocalTime;

public class Ricordami {
    public class OrarioGiaPassato extends Exception {}
    public class OrarioNonValido extends Exception {}
	private int ore;
	private int minuti;
	private void setOre(int hh) {ore = hh;}
	private void setMinuti(int mm) {minuti = mm;}
	public LocalTime getOrario() { return LocalTime.of(ore,minuti);}
	
	public int getMinutiRimasti() throws OrarioGiaPassato {
		LocalTime adesso = LocalTime.now();
		int valore = adesso.getHour() * 60 + adesso.getMinute();
        if( ( valore ) > ( ore*60 + minuti) )		
		    throw new OrarioGiaPassato();		       
        return ( ore*60 + minuti - valore );
	} 
	
	public Ricordami(int hh, int mm) throws OrarioNonValido, OrarioGiaPassato {
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
