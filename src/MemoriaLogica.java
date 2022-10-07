import java.util.*;

public class MemoriaLogica{

    public static void main(String[] args){
	
	Scanner sc = new Scanner(System.in);

	Map<String, String> instrucciones = new HashMap<String, String>();
	Map<String, String> memorias = new HashMap<String, String>();
	String indice;
	String cont;

	char tipoOrden;
	String objetivoOrden = "";
	String aux = "";

	int ac = 0;

	// Creando los Map
	System.out.print("Introduzca el número de Instrucciones: ");
	int numIns = sc.nextInt(); // 4
	System.out.println();
	
	System.out.print("Introduzca el número de espacios de memoria: ");
	int numMem = sc.nextInt(); // 3
	System.out.println();

	// Rellenando el Map de instrucciones
	for (int i = 0; i < numIns; i++) {
	    System.out.print("Introduzca el índice de la instruccion " + i + ": ");
	    indice = sc.next();
	    System.out.println();
	    System.out.print("Introduzca la instruccion " + i + ": ");
	    cont = sc.next();
	    System.out.println();
	    instrucciones.put(indice, cont);
	}
	System.out.println();

	// Rellenando el Map de memorias
	for (int i = 0; i < numMem; i++){
	    System.out.print("Introduzca el índice de la memoria " + i + ": ");
	    indice = sc.next();
	    System.out.println();
	    System.out.print("Introduzca la memoria " + i + ": ");
	    cont = sc.next();
	    System.out.println();
	    memorias.put(indice, cont);
	}
	System.out.println();

	// Proceso de orden
	for (Map.Entry<String, String> x : instrucciones.entrySet()) {
	    // obtención de las partes de la instruccion
	    objetivoOrden = x.getValue().substring(1,4);
	    tipoOrden = x.getValue().charAt(0);
	    
	    switch(tipoOrden) {
		case '1':
		    aux = memorias.get(objetivoOrden);
		    ac = Integer.parseInt(aux.substring(2,4));
		    break;

		case '2':
		    aux = "00" + String.valueOf(ac);
		    memorias.put(objetivoOrden, aux);
		    break;

		case '3':
		    aux = memorias.get(objetivoOrden);
		    ac = Integer.parseInt(aux.substring(2,4)) + ac;
		    break;

		case '4':
		    aux = memorias.get(objetivoOrden);
		    ac = ac - Integer.parseInt(aux.substring(2,4));
		    break;

		default:
		    System.out.println("Esa orden no es reconocida");
		    break;
	    }

	}

	System.out.println("\nMemoria Resultante:");
	for (Map.Entry<String, String> x : memorias.entrySet()) {
	    System.out.println(x.getKey() + "\t" + x.getValue());
	}
	System.out.println("");

    }

}

