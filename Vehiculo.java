import java.util.Date;
public class Vehiculo
{
    public static Vehiculo[] vehiculos;
    public static int cantidad=0;
    private String placa;
    private String marca;
    private String color;
    private int valorComercial;
    protected Date fechaCreada;
    
    public Vehiculo(){
        this(null,null,null,0);
    }

    public Vehiculo(String p,String m,String c){
        this(p,m,c,30000000);
    }

    public Vehiculo(String p,String m, String c, int v){
        this.placa=p;
        this.marca=m;
        this.color=c;
        this.valorComercial=v;
        cantidad++;
        fechaCreada=new Date();
    }

    public void setPlaca(String p){
        this.placa=p;
    }

    public String getPlaca(){
        return this.placa;
    }

    public void setMarca(String m){
        this.marca=m;
    }

    public String getMarca(){
        return this.marca;
    }

    public void setColor(String c){
        this.color=c;
    }

    public String getColor(){
        return this.color;
    }

    public void setvalorComercial(int v){
        this.valorComercial=v;
    }

    public int getvalorComercial(){
        return this.valorComercial;
    }
    
    public String getTipo(){
        return "Vehiculo";
    }

    public String toString(){
        return "Placa:"+this.getPlaca()+", Marca:"+this.getMarca()+", Color:"+this.getColor()+", Valor comercial:"+this.getvalorComercial();
    }

    public static String toStringVehiculos(){
        String cadena="";
        int j=0;
        for(int i=0;i<vehiculos.length;i++){
            if(vehiculos[i]!=null){
                cadena+="**El vehiculo en la posicion "+i+" tiene la siguiente informacion"+"\n"+vehiculos[i].toString()+"\n";
                j++;
            }
        }
        if(j==0){
            cadena="Aun no hay vehiculos parqueados ";
        }
        cadena=cadena.substring(0,cadena.length()-1);
        return cadena;
    }

    public static int cantidadVehiculos(){
        return Vehiculo.cantidad;
    }

    public static String toStringColor(String color){
        String cadena="";
        int j=0;
        for(int i=0;i<vehiculos.length;i++){
            if((vehiculos[i]!=null) && (vehiculos[i].getColor().equalsIgnoreCase(color))){
                cadena+="**El vehiculo en la posicion "+i+" tiene la siguiente informacion"+"\n"+vehiculos[i].toString()+"\n";
                j++;
            }
        }
        if(j==0){
            cadena="No existen vehiculos con el color ingresado ";
        }
        cadena=cadena.substring(0,cadena.length()-1);
        return cadena;
    }

    public static String ordenarValor(){
        String cadena="";
        Vehiculo temp;
        int n=vehiculos.length;
        int posmenor;
        for(int i=0;i<n-1;i++){
            posmenor=i;
            if(vehiculos[i]!=null){
                for(int j=i+1;j<n;j++){
                    if((vehiculos[j]!=null) && (vehiculos[j].getvalorComercial()<vehiculos[posmenor].getvalorComercial())){
                        posmenor=j;
                    }
                }
            }
            temp=vehiculos[i];
            vehiculos[i]=vehiculos[posmenor];
            vehiculos[posmenor]=temp;
        }
        for(int i=0; i<n; i++){
            if(vehiculos[i]!=null){
                cadena+=vehiculos[i].toString()+"\n";
            }
        }
        cadena=cadena.substring(0,cadena.length()-1);
        return cadena;//COMO REORDENAR EL ARREGLO(?)
    }

}