package lista2;

import java.util.Arrays;
import java.util.Scanner;

public class Utilidades {
	// 1)
	public static int somatorio(int[] vetor) {
		int soma = 0;
		for (int i = 2; i < vetor.length - 2; i++) {
			soma += vetor[i];
		}
		return soma;
	}

	// 2)
	public static void numerosPares(int inicio, int fim) {
		for (int i = inicio; i <= fim; i++) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
		}

		System.out.println();
	}

	// 3)
	public static double media(int[] vetor1, int[] vetor2) {
		int soma = 0;

		int count = 0;

		for (int i = 0; i < vetor1.length; i++) {
			soma += vetor1[i];
			count++;
		}

		for (int i = 0; i < vetor2.length; i++) {
			soma += vetor2[i];
			count++;
		}

		if (count == 0) {
			return 0;
		}

		return (double) soma / count;
	}

	// 4)
	public static double mediaPonderada(int[] notas, int[] pesos) {
		if (notas.length != pesos.length || notas.length == 0) {
			System.out
					.println("Os vetores de notas e pesos devem ter o mesmo tamanho e não podem estar vazios.");
		}

		double somaPonderada = 0;
		double somaPesos = 0;
		for (int i = 0; i < notas.length; i++) {
			somaPonderada += notas[i] * pesos[i];
			somaPesos += pesos[i];
		}

		if (somaPesos == 0) {
			return 0;
		}

		return somaPonderada / somaPesos;
	}

	// 5)
	public static int contarElemento(int[] vetor1, int[] vetor2, int elemento) {
		int count = 0;
		for (int i = 0; i < vetor1.length; i++) {
			if (vetor1[i] == elemento) {
				count++;
			}
		}

		for (int i = 0; i < vetor2.length; i++) {
			if (vetor2[i] == elemento) {
				count++;
			}
		}

		return count;
	}

	// 6)
	public static int[] copiaVetor(int[] vetor) {
		int[] copia = new int[vetor.length];

		for (int i = 0; i < vetor.length; i++) {
			copia[i] = vetor[i];
		}

		return copia;
	}

	// 7)
	public static int[] ordenacaoCrescente(int[] vetor) {
		int[] copia = copiaVetor(vetor);
		Arrays.sort(copia);

		return copia;
	}

	// 8)
	public static boolean estaOrdenado(int[] vetor) {
		for (int i = 1; i < vetor.length; i++) {
			if (vetor[i] < vetor[i - 1]) {
				return false;
			}
		}

		return true;
	}

	// 9)
	public static int kEsimoMaior(int[] vetor, int k) {
		if (k > vetor.length || k <= 0) {
			System.out.println("Valor de k inválido.");
		}

		int[] copia = ordenacaoCrescente(vetor);

		return copia[vetor.length - k];
	}

	// 10)
	public static int kEsimoMenor(int[] vetor, int k) {
		if (k > vetor.length || k <= 0) {
			System.out.println("Valor de k inválido.");
		}

		int[] copia = ordenacaoCrescente(vetor);

		return copia[k - 1];
	}

	// 11)
	public static boolean saoIguais(int[] vetor1, int[] vetor2) {
		return Arrays.equals(vetor1, vetor2);
	}

	// 12)
	public static double potenciacao(double base, int expoente) {
		if (expoente == 0) {
			return 1;
		}

		double resultado = 1;
		for (int i = 1; i <= Math.abs(expoente); i++) {
			resultado *= base;
		}

		if (expoente < 0) {
			resultado = 1 / resultado;
		}

		return resultado;
	}

	// 13)
	public static boolean ehPrimo(int numero) {
		if (numero <= 1) {
			return false;
		}

		for (int i = 2; i <= Math.sqrt(numero); i++) {
			if (numero % i == 0) {
				return false;
			}
		}

		return true;
	}

	// 14)
	public static int[] buscarOcorrencias(int[] vetor1, int[] vetor2) {
		int[] ocorrenciasTemp = new int[Math.min(vetor1.length, vetor2.length)];
		int count = 0;

		for (int i = 0; i < vetor1.length; i++) {
			int num = vetor1[i];

			for (int j = 0; j < vetor2.length; j++) {
				if (num == vetor2[j]) {
					boolean encontrado = false;

					for (int k = 0; k < count; k++) {
						if (ocorrenciasTemp[k] == num) {
							encontrado = true;
							break;
						}
					}
					if (!encontrado) {
						ocorrenciasTemp[count] = num;
						count++;
					}
					break;
				}
			}
		}

		int[] ocorrencias = new int[count];
		System.arraycopy(ocorrenciasTemp, 0, ocorrencias, 0, count);

		return ocorrencias;
	}

	// 15)
	public static int[] removerElemento(int[] vetor, int elemento) {
		int count = 0;

		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i] == elemento) {
				count++;
			}
		}

		int[] resultado = new int[vetor.length - count];
		int index = 0;

		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i] != elemento) {
				resultado[index] = vetor[i];
				index++;
			}
		}

		return resultado;
	}

	// 16)
	public static boolean ehPalindromo(String texto) {
		String textoReverso = new StringBuilder(texto).reverse().toString();
		return texto.equals(textoReverso);
	}

	// 17)
	public static boolean ehNumeroPrimo(int numero) {
		if (numero <= 1) {
			return false;
		}

		for (int i = 2; i <= Math.sqrt(numero); i++) {
			if (numero % i == 0) {
				return false;
			}
		}

		return true;
	}

	// 18
	public static String inverterString(String texto) {
		return new StringBuilder(texto).reverse().toString();
	}

	// 19)
	public static double calcularJurosCompostos(double valorInicial,
			double taxaJuros, int numPeriodos) {
		if (numPeriodos < 1) {
			System.out.println("O número de períodos deve ser pelo menos 1.");
		}
		return valorInicial * Math.pow(1 + taxaJuros, numPeriodos);
	}

	// 20)
	public static boolean ehNumeroPerfeito(int numero) {
		if (numero <= 1) {
			return false;
		}

		int somaDivisores = 1;
		for (int i = 2; i <= Math.sqrt(numero); i++) {
			if (numero % i == 0) {
				somaDivisores += i;
				if (i != numero / i) {
					somaDivisores += numero / i;
				}
			}
		}

		return somaDivisores == numero;
	}

	// 21)
	public static int[] diminuirVetor(int tamanhoInicial) {
		if (tamanhoInicial < 1) {
			System.out.println("O tamanho inicial deve ser pelo menos 1.");

		}

		int[] vetor = new int[tamanhoInicial];

		for (int i = 0; i < tamanhoInicial; i++) {
			vetor[i] = tamanhoInicial - i;
		}

		return vetor;
	}

	// 22 a)
	public static void imprimirPadraoNumerico(int linhas, int colunas) {
		for (int i = 0; i < linhas; i++) {
			for (int j = 0; j < colunas; j++) {
				if (j <= i) {
					System.out.print(j);
				} else {
					System.out.print(" ");
				}
				
				System.out.print("\t");
			}
			
			System.out.println();
		}
	}

	// 22 (b)
	public static void imprimirPadraoCaracteres(int linhas, int colunas) {
		char[] caracteres = { '@', '*' };
		int indiceCaractere = 0;

		for (int i = 0; i < linhas; i++) {
			for (int j = 0; j < colunas; j++) {
				System.out.print(caracteres[indiceCaractere]);
				indiceCaractere = (indiceCaractere + 1) % 2;
			}
			
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] vetor1 = { 1, 3, 3, 2, 5 };
		int[] vetor2 = { 1, 2, 3, 2, 4 };
		int[] vetor3 = { 1, 2, 4 };

		int elemento = 2;
		int base = 2;
		int expoente = 3;
		int numero = 7;
		String palavra = "erick";

		double valorInicial = 1000;
		double taxaJuros = 0.05;
		int numPeriodos = 3;
		int numeroPerfeito = 6;
		int tamanhoInicial = 5;

		System.out.println("Somatório: " + somatorio(vetor1));
		System.out.print("Números Pares: ");
		numerosPares(1, 10);
		System.out.println("Média: " + media(vetor1, vetor2));
		System.out.println("Média Ponderada: "
				+ mediaPonderada(new int[] { 7, 8, 6 }, new int[] { 2, 3, 1 }));
		System.out.println("Contagem de Elementos: "
				+ contarElemento(vetor1, vetor2, elemento));
		System.out.println("Cópia de Vetor: "
				+ Arrays.toString(copiaVetor(vetor1)));
		System.out.println("Ordenação Crescente: "
				+ Arrays.toString(ordenacaoCrescente(vetor1)));
		System.out.println("Está Ordenado: " + estaOrdenado(vetor1));
		System.out.println("K-ésimo Maior: " + kEsimoMaior(vetor1, 2));
		System.out.println("K-ésimo Menor: " + kEsimoMenor(vetor1, 2));
		System.out.println("São iguais: " + saoIguais(vetor1, vetor2));
		System.out.println("Potenciação: " + potenciacao(base, expoente));
		System.out.println("É primo: " + ehPrimo(numero));
		System.out.println("Busca por ocorrências: "
				+ Arrays.toString(buscarOcorrencias(vetor1, vetor3)));
		System.out.println("Remoção de elemento: "
				+ Arrays.toString(removerElemento(vetor1, 2)));
		System.out.println("É palíndromo: " + ehPalindromo(palavra));
		System.out.println("É número primo: " + ehNumeroPrimo(numero));
		System.out.println("Inversão de string: " + inverterString(palavra));
		System.out.println("Cálculo de Juros Compostos: "
				+ calcularJurosCompostos(valorInicial, taxaJuros, numPeriodos));
		System.out.println("É número perfeito: "
				+ ehNumeroPerfeito(numeroPerfeito));
		System.out.println("Diminuição do vetor: "
				+ Arrays.toString(diminuirVetor(tamanhoInicial)));

		System.out.print("Digite o número de linhas: ");
		int linhas = scanner.nextInt();

		System.out.print("Digite o número de colunas: ");
		int colunas = scanner.nextInt();

		System.out.println("Padrão Numérico:");
		imprimirPadraoNumerico(linhas, colunas);

		System.out.println("\nPadrão de Caracteres:");
		imprimirPadraoCaracteres(linhas, colunas);

		scanner.close();
	}
}
