import java.util.Scanner;
public class PrincipalBichos
{
    public static Bichos[][] bichos=new Bichos[2][2];
    public static void main(String[]args){
        Scanner scan=new Scanner(System.in);
        int numeroAleatorio=(int)(Math.random()*4+1);
        System.out.println(numeroAleatorio);
        for(int i=0;i<numeroAleatorio;i++){
            int numeroAleatorio2=(int)(Math.random()*2+1);
            System.out.println(numeroAleatorio2);
            for(int j=0;j<bichos.length;j++){
                for(int k=0;k<bichos[j].length;k++){
                    if(numeroAleatorio2==1 && bichos[j][k]==null){
                        bichos[j][k]=new BichosNormales();
                        break;
                    }
                    else if(numeroAleatorio2==2 && bichos[j][k]==null){
                        bichos[j][k]=new BichosAliens();
                        break;
                    }
                }
                if(i<=1){
                    break;
                }
            }
        }
        PrincipalBichos.mostrarTablero();
       while(true){
            int contador=0;
            System.out.println("Ingrese el numero de la fila sobre la cual desea disparar la bala: ");
            int fila=scan.nextInt();
            System.out.println("Ingrese el numero de la columna sobre la cual desea disparar la bala: ");
            int columna=scan.nextInt();
            if(fila<=1 && columna<=1){
            if(bichos[fila][columna]!=null){
                Bichos.atacar(bichos[fila][columna]);
                if(bichos[fila][columna].getSalud()<=0){
                bichos[fila][columna]=null;
              }
            }
          }
          else{
              System.out.println("No se encontro la fila y columna ingresada, ingreselas de nuevo");
            }
           for(int i=0;i<bichos.length;i++){
                for(int j=0;j<bichos[i].length;j++){
                    if(bichos[i][j]==null){
                        contador++;
                    }
                }
           }
           if(contador==4){
                System.out.println("Game over");
                break;
           }
            PrincipalBichos.mostrarTablero();
        

      }

   } 
   
    public static void mostrarTablero(){
        for(int i=0;i<bichos.length;i++){
            System.out.println("-------------");
            System.out.print("|");
            for(int j=0;j<bichos[i].length;j++){
                if(bichos[i][j]!=null){
                    if(bichos[i][j].getSalud()>=10){
                    System.out.print(bichos[i][j].toString()+"|");
                }
                else if(bichos[i][j].getSalud()<10){
                    System.out.print(bichos[i][j].toString()+" |");
                }
              }
                else{
                    System.out.print("     |");
                }
            }
            System.out.println();
        }
        System.out.println("-------------");
    }
}

