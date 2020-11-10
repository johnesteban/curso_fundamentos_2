
public class Bichos
{
   private int salud;
   private String nombre;
   public Bichos(){
       this.salud=0;
       this.nombre="B";
   }
   public Bichos(int salud){
       this.salud=salud;
   }
   public void setSalud(int salud){
       this.salud=salud;
   }
   public int getSalud(){
       return this.salud;
   }
   @Override
   public String toString(){
       return this.nombre+"-"+this.salud;
    }
   public static void atacar(Bichos p){
       p.setSalud(p.getSalud()-5);
    }
}
