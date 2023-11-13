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