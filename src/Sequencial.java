public class Sequencial {
	// DIMENSOES DAS MATRIZES
	public static final int[] SIZE = {2000, 1000, 500, 100};
	public static final int INTERATIONS = 10;
	// QUANTIDADE DE THREADS
	public static final int QNTDTHREADS = 8;
	
	// ESTRUTURAS DE DADOS COMPARTILHADA
	public static int[][] m1;
	public static int[][] m2;
	public static int[][] mres;
	public static Thread[] threadsArr = new Thread[QNTDTHREADS];
	
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
				
				int intervalo = SIZE[m]/QNTDTHREADS;
				// cria as threads

				long inicio = System.nanoTime();
				
				for(int c=0;c<QNTDTHREADS;c++){
					threadsArr[c] = new Thread(new MultiplicaMatriz(c*intervalo,c*intervalo + intervalo));
				}
				
				//starta as threads
				for(int c=0;c<QNTDTHREADS;c++){
					threadsArr[c].start();
				}
				
				//join threads
				try {
					for(int c=0;c<QNTDTHREADS;c++){
						threadsArr[c].join();
					}
				} catch (Exception e) {
					System.out.println("Erro: "+ e.getMessage().toString());
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