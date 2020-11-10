
public class Sensor
{
    public static Sensor[] sensores;
    private int estado;

    public Sensor(){
        this(0);
    }

    public Sensor(int e){
        this.estado=e;
    }

    public void setEstado(int e){
        this.estado=e;
    }

    public int getEstado(){
        return this.estado;
    }

    public String toString(){
        String cadena="Libre";
        if(this.estado==1){
            cadena="Ocupado";
        }
        return cadena;
    }

    public static String sensorLibre(){
        String numcadena="Las posiciones libres del parqueadero son:"+"\n";
        int j=0;
        for(int i=0;i<sensores.length;i++){
            if(sensores[i]==null){
                numcadena+=i+"\n"; 
                j++;
            }
        }
        if(j==0){
            numcadena="No existen posiciones libres ";
        }
        numcadena=numcadena.substring(0,numcadena.length()-1);
        return numcadena;
    }

    public static String sensoresEstado(){
        String numcadena="";
        for(int i=0;i<sensores.length;i++){
            if(sensores[i]==null){
                numcadena+=i+"-Libre\n";
            }
            else{
                numcadena+=i+"-Ocupado\n";
            }
        }
        numcadena=numcadena.substring(0,numcadena.length()-1);
        return numcadena;
    }
}
