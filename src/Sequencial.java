/**
  Programa em Java correspondente à versão sequencial da multiplicação de matrizes.
  @autor Roland Teodorowitsch
  @version 4 set. 2018
 */

public class Sequencial {

  // DIMENSOES DAS MATRIZES
  public static final int[] SIZE = {100, 500, 1000, 2000};
  public static final int INTERATIONS = 10;
  // ESTRUTURAS DE DADOS COMPARTILHADA
  public static int[][] m1;
  public static int[][] m2;
  public static int[][] mres;

  public static void main(String[] args) {

  	for(int m=0;m<SIZE.length;m++) {
	  for(int l=0;l<INTERATIONS;l++) {
		// INICIALIZA OS ARRAYS A SEREM MULTIPLICADOS
	    m1 = new int[SIZE[m]][SIZE[m]];
	    m2 = new int[SIZE[m]][SIZE[m]];
	    mres = new int[SIZE[m]][SIZE[m]];
	    if (m1[0].length != m2.length || mres.length != m1.length || mres[0].length != m2[0].length) {
	       System.err.println("Impossivel multiplicar matrizes: parametros invalidos.");
	       System.exit(1);
	    }
	    int k=1;
	    
	    ArrayFiller.Fill(k, SIZE[m], m1, m2);
	
	    // PREPARA PARA MEDIR TEMPO
	    long inicio = System.nanoTime(); 
	
	    // REALIZA A MULTIPLICACAO
	    for (int i=0 ; i<mres.length; i++) {
	        for (int j=0 ; j<mres[0].length; j++) {
	            mres[i][j] = 0;
	            for (k=0 ; k<m2.length; k++) {
	                mres[i][j] += m1[i][k] * m2[k][j];
	            }
	        }
	    }
	
	    // OBTEM O TEMPO
	    long fim = System.nanoTime();
	    double total = (fim-inicio)/1000000000.0;
	    
	    WriteToFile.LogTime(SIZE[m], total);
	
	    // VERIFICA SE O RESULTADO DA MULTIPLICACAO ESTA CORRETO
	    ArrayFiller.Check(SIZE[m], mres, k);
	    
	    // MOSTRA O TEMPO DE EXECUCAO
	    System.out.printf("%f",total);
	  	}
	  }
  }
}