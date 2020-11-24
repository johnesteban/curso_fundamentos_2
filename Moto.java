
public class Moto extends Vehiculo{

	public Moto(){	
	}
	
	public Moto(String p,String m,String c) {
	 super(p,m,c);
	}
	
	public Moto(String p,String m, String c, int v) {
	 super(p,m,c,v);
	}
	@Override
	public String getTipo(){
	    return "Moto";
	 }
	@Override
	public String toString(){
		return "Fecha y hora de ingreso: "+this.fechaCreada+"\n"+"Tipo de vehiculo: "+this.getTipo()+", Placa:"+this.getPlaca()+", Marca:"+this.getMarca()+", Color:"+this.getColor()+", Valor comercial:"+this.getvalorComercial();
	}
}