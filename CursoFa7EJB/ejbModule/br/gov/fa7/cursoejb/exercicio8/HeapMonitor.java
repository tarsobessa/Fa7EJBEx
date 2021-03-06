package br.gov.fa7.cursoejb.exercicio8;

import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Singleton;

/**
 * Imprime no console dados de uso da memória da JVM.
 *
 */
@Singleton
@LocalBean
public class HeapMonitor {

	public static final int MB = 1024 * 1024;
	/**
	 * A cada minuto, imprime dados de uso memória da JVM.
	 */
	@Schedule(minute = "*", hour = "*", persistent = false)
	public void printStats() {

		Runtime runtime = Runtime.getRuntime();
		System.out.println("\n[Estatísticas de Memória]");
		System.out.println(
				String.format(
				"[Memória total: %d MB]"
				+ "\n[Memória usada: %d MB]"
				+ "\n[Memória livre: %d MB]"
				+ "\n[Memória máxima: %d MB]",
				runtime.totalMemory() / MB,
				(runtime.totalMemory() - runtime.freeMemory()) / MB,
				runtime.freeMemory() / MB,
				runtime.maxMemory() / MB));
	}

}
