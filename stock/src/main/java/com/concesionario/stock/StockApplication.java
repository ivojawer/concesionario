package com.concesionario.stock;

import com.concesionario.stock.data.*;
import com.concesionario.stock.dominio.entidades.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class StockApplication {


	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(StockApplication.class, args);
		seed(applicationContext);
	}

	private static void seed(ApplicationContext applicationContext) {
		PaisRepository paisRepository = applicationContext.getBean(PaisRepository.class);
		ProvinciaRepository provinciaRepository = applicationContext.getBean(ProvinciaRepository.class);
		LocalidadRepository localidadRepository = applicationContext.getBean(LocalidadRepository.class);

		// paises
		Pais argentina = paisRepository.save(new Pais("Argentina"));
		Pais brasil = paisRepository.save(new Pais("Brasil"));
		Pais uruguay = paisRepository.save(new Pais("Uruguay"));

		// provincias arg
		Provincia bsas = provinciaRepository.save(new Provincia(argentina, "Buenos Aires"));
		Provincia cordoba = provinciaRepository.save(new Provincia(argentina, "Córdoba"));
		Provincia mendoza = provinciaRepository.save(new Provincia(argentina, "Mendoza"));

		// localidades arg
		Localidad laplata = localidadRepository.save(new Localidad("La Plata", bsas));
		localidadRepository.save(new Localidad("Mar del Plata", bsas));
		localidadRepository.save(new Localidad("Córdoba Capital", cordoba));
		localidadRepository.save(new Localidad("Villa Carlos Paz", cordoba));
		localidadRepository.save(new Localidad("Mendoza Capital", mendoza));

		// provincias br
		Provincia saoPaulo = provinciaRepository.save(new Provincia(brasil, "São Paulo"));
		Provincia rio = provinciaRepository.save(new Provincia(brasil, "Rio de Janeiro"));

		// localidades br
		localidadRepository.save(new Localidad("São Paulo", saoPaulo));
		localidadRepository.save(new Localidad("Campinas", saoPaulo));
		localidadRepository.save(new Localidad("Rio de Janeiro", rio));
		localidadRepository.save(new Localidad("Niterói", rio));

		// provincias uruguay
		Provincia montevideo = provinciaRepository.save(new Provincia(uruguay, "Montevideo"));
		Provincia canelones = provinciaRepository.save(new Provincia(uruguay, "Canelones"));

		// localidades uruguay
		Localidad montevideoLoc = localidadRepository.save(new Localidad("Montevideo", montevideo));
		localidadRepository.save(new Localidad("Las Piedras", canelones));
		localidadRepository.save(new Localidad("Canelones", canelones));


		SucursalRepository sucursalRepository = applicationContext.getBean(SucursalRepository.class);

		Sucursal centro = sucursalRepository.save(new Sucursal(laplata, "Centro de Distribucion", "Av. Siempre Viva 123", new Date(2010, Calendar.JANUARY,23), 5, null));
		Sucursal sucMotvid = sucursalRepository.save(new Sucursal(montevideoLoc, "Montevideo", "Rambla 14444", new Date(2019, Calendar.OCTOBER,14), 10, 31));
		StockRepository stockRepository = applicationContext.getBean(StockRepository.class);
		stockRepository.save(new Stock(1L, sucMotvid , 1));
		stockRepository.save(new Stock(1L, centro , 30));

	}

}
