
public class BichosNormales extends Bichos
{
    private String nombre;
    public BichosNormales(){
       super(10);
       this.nombre="BN";
    }
    @Override
    public String toString(){
       return this.nombre+"-"+this.getSalud();
    }
    
}