public class Carro extends Vehiculo{
	public Carro(){	
	}
	
	public Carro(String p,String m,String c) {
	 super(p,m,c);
	}
	
	public Carro(String p,String m, String c, int v) {
	 super(p,m,c,v);
	}
	@Override
	public String getTipo(){
	    return "Carro";
	 }
	@Override
	public String toString() {
		return "Fecha y hora de ingreso: "+this.fechaCreada+"\n"+"Tipo de vehiculo: "+this.getTipo()+" Placa:"+this.getPlaca()+", Marca:"+this.getMarca()+", Color:"+this.getColor()+", Valor comercial:"+this.getvalorComercial();
	}
}
