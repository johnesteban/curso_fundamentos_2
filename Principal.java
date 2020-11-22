import java.util.Date;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
public class Principal
{

    public static void main(String[]args){
        System.out.println("***********************************************************************");
        System.out.println("*                              MENU                                   *");
        System.out.println("* 0-Salir del programa                                                *");
        System.out.println("* 1-Mostrar las posiciones libres del parqueadero                     *");
        System.out.println("* 2-Agregar un nuevo vehiculo omitiendo el valor comercial            *");
        System.out.println("* 3-Agregar un nuevo vehiculo sin omitir el valor comercial           *");
        System.out.println("* 4-Imprimir la informacion de todos los vehiculos parqueados         *");
        System.out.println("* 5-Mostrar la cantidad de vehiculos que han sido parqueados          *");
        System.out.println("* 6-Consultar el estado de un espacio (Libre u ocupado)               *");
        System.out.println("* 7-Mostrar el estado de todos los sensores                           *");
        System.out.println("* 8-Mostrar la informacion de los vehiculos de un color ingresado     *");
        System.out.println("* 9-Mostrar los vehiculos parqueados ordenados por su valor comercial *");
        System.out.println("* 10-Desocupar un espacio y mostrar el valor a pagar                  *");
        System.out.println("* 11-Exportar en un .txt la información de todos los vehiculos        *");
        System.out.println("***********************************************************************"+"\n");
        Principal.mostrarMenu();
    }

    public static void mostrarMenu(){
        Scanner scan=new Scanner(System.in);
        System.out.println("Ingrese la cantidad de espacios que tendra el parqueadero: ");
        int espacios=scan.nextInt();
        System.out.println("Ingrese el valor a pagar por hora para los carros: ");
        double valorHoraC=scan.nextDouble();
        System.out.println("Ingrese el valor a pagar por hora para las motos: ");
        double valorHoraM=scan.nextDouble();
        Vehiculo.vehiculos=new Vehiculo[espacios];
        Sensor.sensores=new Sensor[espacios];
        System.out.println("Ingrese la opcion que desea: ");
        int opcion=scan.nextInt();
        String tipoVehiculo="";
        String textofichero="";
        while(opcion!=0){
            switch(opcion){
                case 1:
                System.out.println(Sensor.sensorLibre());
                break;
                case 2:
                System.out.println("Ingrese el espacio donde desea parquear: ");
                int n=scan.nextInt(); 

                if(n<0 || n>=espacios){
                    System.out.println("Espacio inexistente");
                    break;
                }
                else if(Sensor.sensores[n]!=null){
                    System.out.println("El espacio esta ocupado, no se puede realizar la accion");
                    break;
                }
                System.out.println("Ingrese si su vehiculo es carro o moto:");
                tipoVehiculo=scan.next();

                if(tipoVehiculo.equalsIgnoreCase("Moto")) {
                    System.out.println("Ingrese la placa: ");
                    String placa=scan.next();
                    System.out.println("Ingrese la marca: ");
                    String marca=scan.next();
                    System.out.println("Ingrese el color: ");
                    String color=scan.next();
                    Vehiculo.vehiculos[n]= new Moto(placa,marca,color);

                }
                else if(tipoVehiculo.equalsIgnoreCase("Carro")){
                    System.out.println("Ingrese la placa: ");
                    String placa=scan.next();
                    System.out.println("Ingrese la marca: ");
                    String marca=scan.next();
                    System.out.println("Ingrese el color: ");
                    String color=scan.next();
                    Vehiculo.vehiculos[n]=new Carro(placa,marca,color);
                } 
                else {
                    System.out.println("El tipo de vehiculo ingresado no es compatible con ningun tipo de vehiculo");
                    break;
                }
                Sensor.sensores[n]= new Sensor(1);
                System.out.println(Vehiculo.vehiculos[n].toString());
                textofichero+=Vehiculo.vehiculos[n].toString()+"\n";
                break;

                case 3:
                System.out.println("Ingrese el espacio donde desea parquear: ");
                n=scan.nextInt();
                if(n<0 || n>=espacios){
                    System.out.println("Espacio inexistente");
                    break;
                }
                else if(Sensor.sensores[n]!=null){
                    System.out.println("El espacio esta ocupado, no se puede realizar la accion");
                    break;
                }

                System.out.println("Ingrese si su vehiculo es carro o moto:");
                tipoVehiculo=scan.next();

                if(tipoVehiculo.equalsIgnoreCase("Moto")) {
                    System.out.println("Ingrese la placa: ");
                    String placa=scan.next();
                    System.out.println("Ingrese la marca: ");
                    String marca=scan.next();
                    System.out.println("Ingrese el color: ");
                    String color=scan.next();
                    System.out.println("Ingrese el valor comercial: ");
                    int valor=scan.nextInt();
                    Vehiculo.vehiculos[n]= new Moto(placa,marca,color,valor);

                }
                else if(tipoVehiculo.equalsIgnoreCase("Carro")){
                    System.out.println("Ingrese la placa: ");
                    String placa=scan.next();
                    System.out.println("Ingrese la marca: ");
                    String marca=scan.next();
                    System.out.println("Ingrese el color: ");
                    String color=scan.next();
                    System.out.println("Ingrese el valor comercial: ");
                    int valor=scan.nextInt();
                    Vehiculo.vehiculos[n]=new Carro(placa,marca,color, valor);
                } 
                else {
                    System.out.println("El tipo de vehiculo ingresado no es compatible con ningun tipo de vehiculo");
                    break;
                }

                Sensor.sensores[n]= new Sensor(1);
                System.out.println(Vehiculo.vehiculos[n].toString());
                textofichero+=Vehiculo.vehiculos[n].toString()+"\n";
                break;

                case 4:
                System.out.println(Vehiculo.toStringVehiculos());
                break;
                case 5:
                if(Vehiculo.cantidadVehiculos()==0){
                    System.out.println("Aun no hay vehiculos parqueados");
                }
                else{
                    System.out.println("La cantidad de vehiculos que han sido parqueados es: "+Vehiculo.cantidadVehiculos());
                }
                break;
                case 6:
                System.out.println("Ingrese el número del espacio que desea consultar: ");
                int espacio=scan.nextInt();
                if(espacio>=espacios || espacio<0){
                    System.out.println("El espacio es inexistente");
                }
                else if(Sensor.sensores[espacio]==null){
                    System.out.println("Libre");
                }
                else{
                    System.out.println(Sensor.sensores[espacio].toString());
                } 
                break;
                case 7:
                System.out.println("El estado de los sensores respecto a cada posición es:"+"\n"+Sensor.sensoresEstado());
                break;
                case 8:
                System.out.println("Ingrese el color del vehiculo: ");
                String color=scan.next();
                System.out.println(Vehiculo.toStringColor(color));
                break;
                case 9:
                if(Vehiculo.cantidad==0){
                    System.out.println("Aun no hay vehiculos parqueados");
                }
                else{
                    System.out.println("Los vehiculos ordenados de menor a mayor segun su valor comercial tienen el siguiente orden:"+"\n"+Vehiculo.ordenarValor());
                }
                break;

                case 10:
                System.out.println("Ingrese el espacio que desea desocupar: ");
                int espacioD=scan.nextInt();
                
                if(espacioD<0 || espacioD>=espacios){
                    System.out.println("Este espacio no existe");
                    break;
                }
                else if(Vehiculo.vehiculos[espacioD]==null){
                    System.out.println("Este espacio ya esta libre, imposible desocupar");
                    break;
                }
                else{
                    Date fechaSalida=new Date();
                    Date fechaEntrada=Vehiculo.vehiculos[espacioD].fechaCreada;
                    double difanio=fechaSalida.getYear()-fechaEntrada.getYear();
                    double difmes=fechaSalida.getMonth()-fechaEntrada.getMonth();
                    double difdia=fechaSalida.getDate()-fechaEntrada.getDate();
                    double difhora=fechaSalida.getHours()-fechaEntrada.getHours();
                    double difminutos=fechaSalida.getMinutes()-fechaEntrada.getMinutes();
                    double difsegundos=fechaSalida.getSeconds()-fechaEntrada.getSeconds();

                    double totalanio=difanio*8760;
                    double totalmes=difmes*720;
                    double totaldia=difdia*24;
                    double totalminutos=difminutos/60;
                    double totalsegundos=difsegundos/3600;
                    double totalPago=totalanio+totalmes+totaldia+totalminutos+totalsegundos;

                    if(Vehiculo.vehiculos[espacioD].getTipo().equalsIgnoreCase("carro")){
                        totalPago=totalPago*valorHoraC;
                    }
                    else if(Vehiculo.vehiculos[espacioD].getTipo().equalsIgnoreCase("moto")){
                        totalPago=totalPago*valorHoraM;
                    }
                    System.out.println("El total a pagar es de $"+totalPago);

                    Vehiculo.vehiculos[espacioD]=null;
                    Sensor.sensores[espacioD]=null;

                }
                break;
                case 11:
                try{
                    FileWriter fichero=new FileWriter("C:/Users/LENOVO/Desktop/fichero.txt");
                    fichero.write(textofichero);
                    fichero.close();
                }catch(Exception e){
                    System.out.println("Ha sucedido un error: "+e);
                }
                System.out.println("Revise la información de los vehiculos parqueados en su archivo de texto");
                break;
                default:
                System.out.println("Comando incorrecto");
                break;
            }
            System.out.println("Ingrese nuevamente una opcion: ");
            opcion=scan.nextInt();
        }

    }
}