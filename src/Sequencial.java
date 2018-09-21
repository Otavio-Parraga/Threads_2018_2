/**
 * Programa em Java correspondente à versão sequencial da multiplicação de
 * matrizes.
 * 
 * @autor Roland Teodorowitsch
 * @version 4 set. 2018
 */

public class Sequencial {

	// DIMENSOES DAS MATRIZES
	public static final int[] SIZE = { 2000};
	public static final int INTERATIONS = 10;
	// ESTRUTURAS DE DADOS COMPARTILHADA
	public static int[][] m1;
	public static int[][] m2;
	public static int[][] mres;
	// QUANTIDADE DE THREADS
	public static final int QNTDTHREADS = 1;

	public static void main(String[] args) {

		for (int m = 0; m < SIZE.length; m++) {
			for (int l = 0; l < INTERATIONS; l++) {
				// INICIALIZA OS ARRAYS A SEREM MULTIPLICADOS
				m1 = new int[SIZE[m]][SIZE[m]];
				m2 = new int[SIZE[m]][SIZE[m]];
				mres = new int[SIZE[m]][SIZE[m]];
				if (m1[0].length != m2.length || mres.length != m1.length || mres[0].length != m2[0].length) {
					System.err.println("Impossivel multiplicar matrizes: parametros invalidos.");
					System.exit(1);
				}
				int k = 1;

				ArrayFiller.Fill(k, SIZE[m], m1, m2);

				// PREPARA PARA MEDIR TEMPO
				long inicio = System.nanoTime();

//				 REALIZA MULTIPLICACAO
				Thread t1 = new Thread(new MultiplicaMatriz(0,500));
				t1.start();
				Thread t2 = new Thread(new MultiplicaMatriz(500,1000));
				t2.start();
				Thread t3 = new Thread(new MultiplicaMatriz(1000,1500));
				t3.start();
				Thread t4 = new Thread(new MultiplicaMatriz(1500,2000));
				t4.start();
				
				try {
				t1.join();
				t2.join();
				t3.join();
				t4.join();
				} catch (Exception e) {
					
				}
				
				// OBTEM O TEMPO
				long fim = System.nanoTime();
				double total = (fim - inicio) / 1000000000.0;

				// VERIFICA SE O RESULTADO DA MULTIPLICACAO ESTA CORRETO
				ArrayFiller.Check(SIZE[m], mres, k);

				WriteToFile.LogTime(SIZE[m], total, QNTDTHREADS);

				// MOSTRA O TEMPO DE EXECUCAO
				System.out.printf("%f", total);
			}
		}
	}
}