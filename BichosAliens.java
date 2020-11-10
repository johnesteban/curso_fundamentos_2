
public class BichosAliens extends Bichos
{
   private String nombre;
   public BichosAliens(){
       super(20);
       this.nombre="BA";
   }
   @Override
   public String toString(){
       return this.nombre+"-"+this.getSalud();
    }
   
}