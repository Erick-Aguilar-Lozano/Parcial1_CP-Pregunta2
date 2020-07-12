/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Erick
 */
public class principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leer datos=new Leer();
		System.out.println("Ingrese la expresión aritmetica: ");
		String expresionAritmetica=datos.datoStr();
		listaSimNor expreArit=new listaSimNor();
		String preparado=expreArit.preparaCadena(expresionAritmetica);
		expreArit.llenaLista(preparado);
		boolean a=expreArit.valida();
		String respuesta=expreArit.resolver(a);
		System.out.println(" = "+respuesta);	
	}

}
