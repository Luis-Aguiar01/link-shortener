package br.edu.ifsp.dsw1.model.dao.link;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

// Essa foi a nossa solução para o problema de gerar todas as combinações de 5 caracteres, para então, 
// ir para 6. Não conseguimos pensar em um algoritmo que fizesse isso de forma eficiênte. Pensamos em
// deixar um looping rodando até encontrar uma combinação que ainda não tivesse sido gerada. No entanto,
// isso tem um sério problema de escalabilizade, porque conforme uma grande parte das combinações possível
// foram geradas, começa ter um atraso muito grande para gerar novos links curtos. Pensamos em fazer uma 
// verificação da quantidade de links gerados, e com isso, incrementarmos a variável no próprio command
// que gerar esses links. No entanto, considerando um ambiente multithread, não daria para incrementar
// uma variável estática no próprio command. A nossa solução, portanto, é executada do lado o servidor.
// Pesquisando, encontramos essa forma de executar uma ação agendada, que verifica a quantiade de links
// atualmente cadastrados, e, se estiver em 50% do máximo possível com 5 caracteres, ele incrementa para
// 6. Não sabemos se é uma boa solução, se possui falhas ou não, mas foi o que conseguimos pensar.

@WebListener
public class CheckLinkListener implements ServletContextListener {
	private ScheduledExecutorService scheduler;
	private static int urlSize = 5;

	@Override
	public void contextInitialized(ServletContextEvent event) {
		scheduler = Executors.newSingleThreadScheduledExecutor();
		scheduler.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				var dao = new LinkDAOFactory().factory();
				// 63 é a soma de todos os caracteres possível.
				if (dao.count() > Math.pow(63, urlSize) * 0.5) {
					urlSize = getUrlSize() + 1;
				}
			}
		}, 0, 30, TimeUnit.MINUTES); // Executa a cada 30 minutos a verificação.
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		scheduler.shutdownNow();
	}

	public static int getUrlSize() {
		return urlSize;
	}
}
