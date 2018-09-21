

public class MultiplicaMatriz implements Runnable {
	int valorInicial;
	int valorFinal;
	

	MultiplicaMatriz(int valorInicial, int valorFinal) {
		super();
		this.valorInicial = valorInicial;
		this.valorFinal = valorFinal;
	}


	@Override
	public void run() {
		for (int i = valorInicial; i < valorFinal; i++) {
			for (int j = 0; j < Sequencial.m2[0].length; j++) {
				Sequencial.mres[i][j] = 0;
				for (int k = 0; k < Sequencial.m2.length; k++) {
					Sequencial.mres[i][j] += Sequencial.m1[i][k] * Sequencial.m2[k][j];
				}
			}
		}

	}

}
