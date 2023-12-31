import java.util.Scanner;
import java.util.Random;
import java.util.HashMap;
import java.util.stream.*;

public class Sprint {
	
	public static void main(String[] args) {
	Scanner entrada = new Scanner(System.in);
	
	int[] lista1 = new int[6];
	int[] lista2 = new int[7];
	int[] lista3 = new int[5];
	int[] listaMax = new int[lista1.length + lista2.length + lista3.length];
	int[] listaMinutos = new int[99];
	int j = 0;
	HashMap<Integer,Boolean> dupe = new HashMap<>();
	
	System.out.println("----------LISTA 1 (6 salas)----------");
	for(int i = 0; i < lista1.length; i++) {
		System.out.println("Insira mais " + (6-i) + " salas");
		System.out.print("Insira o numero da sala: ");
		lista1[i] = entrada.nextInt();
		if (lista1[i] < 1 || lista1[i] > 99) {
			System.out.println("Sala Inválida, insira uma sala entre 1 e 99.");
			i--;
		}
	}
	System.out.println("----------LISTA 2 (7 salas)----------");
	for(int i = 0; i < lista2.length; i++) {
		System.out.println("Insira mais " + (7-i) + " salas");
		System.out.print("Insira o numero da sala: ");
		lista2[i] = entrada.nextInt();
		if (lista2[i] < 1 || lista2[i] > 99) {
			System.out.println("Sala Inválida, insira uma sala entre 1 e 99.");
			i--;
		}
	}
	System.out.println("----------LISTA 3 (5 salas)----------");
	for(int i = 0; i < lista3.length; i++) {
		System.out.println("Insira mais " + (5-i) + " salas");
		System.out.print("Insira o numero da sala: ");
		lista3[i] = entrada.nextInt();
		if (lista3[i] < 1 || lista3[i] > 99) {
			System.out.println("Sala Inválida, insira uma sala entre 1 e 99.");
			i--;
		}
	}
	for (int i = 0; i < 99; i++) {
		listaMinutos[i] = new Random().nextInt((15 - 5) +1) + 5;
	}
	int soma = IntStream.of(listaMinutos).sum();
	for (int i = 0; i < 7; i++) {
		if (i < lista1.length){
			if (dupe.get(lista1[i]) == null) {
				listaMax[j] = lista1[i];
				j++;
				dupe.put(lista1[i], true);
			}
		}
		if (i < lista2.length) {
			if (dupe.get(lista2[i]) == null) {
				listaMax[j] = lista2[i];
				j++;
				dupe.put(lista2[i], true);
			}
		}
		if (i < lista3.length){
			if (dupe.get(lista3[i]) == null) {
				listaMax[j] = lista3[i];
				j++;
				dupe.put(lista3[i], true);
			}
	}
	}
	System.out.println("Levariam " + (soma / 60) + " horas : " + (soma % 60) + (" minutos para desinfetar todas as 99 salas."));
	int[] listaUnica = new int[j];
	int[] minutosUnico = new int[j];
	for (int i = 0; i < listaUnica.length; i++) {
		listaUnica[i] = listaMax [i];
		System.out.println("A sala " + listaUnica[i] + " levará " + listaMinutos[listaUnica[i]] + " minutos para ser desinfetada.");
		minutosUnico[i] = listaMinutos[listaUnica[i]];
	}
	int somaUnica = IntStream.of(minutosUnico).sum();
	System.out.println("Levarão " + (somaUnica / 60) + " horas : " + (somaUnica % 60) + (" minutos para desinfetar as salas marcadas."));
	entrada.close();
	}
}
