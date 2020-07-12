/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Erick
 */
public class listaSimNor extends pilaExpre{
private nodoExpN p;
	
	public listaSimNor() {
		p=null;
	}
	public boolean esVacia(){
		boolean x=p==null ? true: false;
		return x;
	}
	public nodoExpN getp(){
		return p;
	}
	public void adiprimero (String it)
        {   nodoExpN x = new nodoExpN();
            x.setNum(it);
            x.setSig(getp());
            p= x;
        }
	public nodoExpN posicion(int pos)
	{	int i;
		nodoExpN q= getp();
		for(i=1;i<=pos-2;i++)
		 { q= q.getSig();}
	    return(q);
        }
	public void adiultimoEA(String it)
	{   nodoExpN x = new nodoExpN();
		x.setNum(it);
		if(esVacia())
		  { 
			adiprimero(it);
			}
		else
		  { nodoExpN q=posicion(contar()+1); 
	  	    q.setSig(x);
          }	    				
	}
	public int contar()
	{	int c= 0;		
		nodoExpN q= getp();
		while(q!=null)
		  { c++;
		    q= q.getSig();
	      }
		return(c);
	}
	public void mostrar()
	{   
		nodoExpN q= getp();
	    String it;
	    while(q!=null){
	    	it= q.getNum();
	    	q= q.getSig();	    	
	    }		
	    
	}	
	//METODOS PROPIOS DE LA CALCULADORA

	String preparaCadena(String ExpreAr){
		String x="";
		char a=' ';
		char b=' ';
		for(int i=0;i<ExpreAr.length()-1;i++)
		{
			a=ExpreAr.charAt(i);
			b=ExpreAr.charAt(i+1);
			
			if((a=='('&&b=='-'))
			{
				x+=a;
				x+='0';
			}
			else
			{
				if(a=='-'&&i==0){
					x+='0';
				}
				x+=a;
			}	
		}
		x+=b;
		return x;
	}
	boolean valida(){
		nodoExpN q=getp();
		int tamaño=contar();
		String it;
		boolean sw=true;
		for(int i=1;i<=tamaño;i++)
		{
			it=q.getNum();
			System.out.print(it);
			String it2=enviaKaesimo(i+1);
			if(esSigno(it)&&esSigno(it2))
			{
				System.out.println("operación no valida");
				sw=false;
			}
			if(it.equals("(")&&it2.equals("(")){
				System.out.println("operación no valida");
				sw=false;
			}
			if(esSigno(it)&&i==tamaño){
				System.out.println("operación no valida");
				sw=false;
			}
			if(!it.equals("(")&&!it.equals(")")&&!esSigno(it)){
				if(puntosDob(it)==false){
					sw=false;
					System.out.println("operacion no valida");
				}
			}
			if(tamaño==1)
				sw=false;
			
				
			q=q.getSig();
		}
		return sw;
	}
	boolean puntosDob(String it){
		char a=' ';
		int cont=0;
		boolean aux=true;
		for(int i=0;i<it.length()-1;i++){
			a=it.charAt(i);
			if(a=='.'){
				cont++;
			}
		}
		if(cont>1)
			aux=false;
		return aux;
	}
	boolean esNumero(String x)  //VERIFICA SI ES NUMERO
	{
		boolean k=false;
		if(x.equals("0")||x.equals("1")||x.equals("2")||x.equals("3")||x.equals("4")||x.equals("5")||x.equals("6")||x.equals("7")||x.equals("8")||x.equals("9")||x.equals(".")){
			k=true;
		}
		return k;
	}
	
	
	void llenaLista(String expreAr)
	{
		String x;
		String insert="";
		
		expreAr=expreAr+" ";
		
		for(int i=0;i<expreAr.length()-1;i++)
		{
			x=expreAr.substring(i+1, i+2);			
			if(esNumero(x)&&(esNumero(expreAr.substring(i, i+1))))	
				insert+=expreAr.substring(i,i+1);
			else					
			{
				insert+=expreAr.substring(i,i+1);
				adiultimoEA(insert);				
				insert="";				
			}
		}
	}
	
	void limpiar(){	
			p=null;
	}
	
	public String enviaKaesimo(int k){	//METODO ELIMINA KAESIMO
		int conta=1;
		String it= new String();
		nodoExpN q=getp();
		boolean sw=true;
		while(q!=null&&sw==true){
			if(k==conta){
				it=q.getNum();
				sw=false;
				q=q.getSig();
			}
			else{
				conta++;
				q=q.getSig();
			}
		}
		return(it);
	}
	public listaSimNor aLista(pilaExpre p){	//SE PASA DATOS DE PILA A LISTA
		pilaExpre aux=new pilaExpre();
		listaSimNor l=new listaSimNor();
		while(!p.esvacia()){
			aux.insertar(p.eliminar());
		}
		while(!aux.esvacia())
		{
			l.adiultimoEA(aux.eliminar());
		}
		return l;
	}
	boolean esSigno(String x){
		boolean k=false;
		if(x.equals("+")||x.equals("-")||x.equals("*")||x.equals("/"))
		{
			k=true;
		}
		return k;
	}
	String operacionP(listaSimNor p)	//REALIZA OPERACION
	{
		String k="";
		pilaExpre total=new pilaExpre();
		float a=1;
		float b=1;
		int tamaño=p.contar();
		nodoExpN q=getp();
		for(int i=1;i<=tamaño;i++)
		{
			b=1;
			if(esSigno(p.enviaKaesimo(i)))
			{
				k=p.enviaKaesimo(i+1);
				if(p.enviaKaesimo(i).equals("-"))
				{
					b=-1;
				}
				a=Float.parseFloat(total.eliminar())+(Float.parseFloat(k)*b);
				i=i+1;
			}
			else
			{
				a=Float.parseFloat(p.enviaKaesimo(i));
			}
			total.insertar(Float.toString(a));
			q=q.getSig();
		}
		k=total.eliminar();
		return k;
	}
	String operacionl(listaSimNor l){		//Operaciones en los parentesis
		pilaExpre p=new pilaExpre();
		listaSimNor w=new listaSimNor();
		String k="";
		String s="";
		float a;
		float b=1;
		int tamaño=l.contar();
		nodoExpN q=l.getp();
		for(int i=1;i<=tamaño;i++)
		{
			k=l.enviaKaesimo(i);
			if(k.equals("*")||k.equals("/"))
			{
				b=1;
				a=Float.parseFloat(p.eliminar());
				s=l.enviaKaesimo(i+1);
				if(s.equals("-")){
					b=-1;
					s=l.enviaKaesimo(i+2);
					i=i+2;
				}
				else
				{
					i++;
				}
				if(k.equals("*"))
				{
					a*=(Float.parseFloat(s)*b);
				}
				else{
					a/=(Float.parseFloat(s)*b);
				}
				k=Float.toString(a);
			}
			q=q.getSig();
			p.insertar(k);
		}
		w=aLista(p);		
		s=operacionP(w);	
		return s;
	}
	String resolver(boolean a)	
	{
		String resultado;
		String it="";
		nodoExpN q=getp();
		int tamaño=contar();
		pilaExpre pila=new pilaExpre();
		pilaExpre pila2=new pilaExpre();
		listaSimNor p=new listaSimNor();
		p.limpiar();
		if(a==true){
		for(int i=1;i<=tamaño;i++)
		{
			it=enviaKaesimo(i);
			if(it.equals(")"))
			{
				p.limpiar();
				it=pila.eliminar();
				while(!it.equals("("))
				{
					pila2.insertar(it);
					it=pila.eliminar();
				}
				while(!pila2.esvacia())
				{
					p.adiultimoEA(pila2.eliminar());
				}
				it=operacionl(p);
				pila.insertar(it);
				p.limpiar();
			}
			else{
				pila.insertar(it);
			}
			q=q.getSig();
		}
		}	
		while(!pila.esvacia())
		{
			pila2.insertar(pila.eliminar());
		}
		while(!pila2.esvacia())
		{
			p.adiultimoEA(pila2.eliminar());
		}
		resultado=operacionl(p);
		return resultado;
	}
}
