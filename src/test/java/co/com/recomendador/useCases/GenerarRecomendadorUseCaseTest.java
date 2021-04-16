package co.com.recomendador.useCases;

import co.com.recomendador.domain.Recomendador;
import co.com.recomendador.domain.command.IndicarCilindraje;
import co.com.recomendador.domain.entities.Cliente;
import co.com.recomendador.domain.entities.Moto;
import co.com.recomendador.domain.entities.Vendedor;
import co.com.recomendador.domain.events.*;
import co.com.recomendador.domain.valueObjets.*;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GenerarRecomendadorUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void GenerarRecomendor() {

        var recomendadorId = RecomendadorId.of("R001");
        var moto = new Moto(MotoId.of("045"),Nombre.of("XTZ"),Precio.of(15000000),TipoMoto.of("e"),Cilindraje.of(250));
        var motos = new HashMap<MotoId, Moto>();
        motos.put(MotoId.of("001"), new Moto(MotoId.of("001"), Nombre.of("XTZ"), Precio.of(7800000), TipoMoto.of("E"), Cilindraje.of(125)));
        motos.put(MotoId.of("002"), new Moto(MotoId.of("002"), Nombre.of("XR"), Precio.of(9000000), TipoMoto.of("E"), Cilindraje.of(150)));
        motos.put(MotoId.of("003"), new Moto(MotoId.of("003"), Nombre.of("XRE"), Precio.of(19500000), TipoMoto.of("E"), Cilindraje.of(300)));
        motos.put(MotoId.of("004"), new Moto(MotoId.of("004"), Nombre.of("TTR"), Precio.of(7000000), TipoMoto.of("E"), Cilindraje.of(200)));
        motos.put(MotoId.of("005"), new Moto(MotoId.of("005"), Nombre.of("NMAX"), Precio.of(11000000), TipoMoto.of("S"), Cilindraje.of(150)));
        motos.put(MotoId.of("006"), new Moto(MotoId.of("006"), Nombre.of("BWS"), Precio.of(9000000), TipoMoto.of("S"), Cilindraje.of(125)));
        motos.put(MotoId.of("007"), new Moto(MotoId.of("007"), Nombre.of("DYNAMIC"), Precio.of(5600000), TipoMoto.of("S"), Cilindraje.of(125)));
        motos.put(MotoId.of("009"), new Moto(MotoId.of("008"), Nombre.of("NKD"), Precio.of(3800000), TipoMoto.of("E"), Cilindraje.of(125)));
        motos.put(MotoId.of("008"), new Moto(MotoId.of("009"), Nombre.of("FZ"), Precio.of(8000000), TipoMoto.of("E"), Cilindraje.of(150)));
        motos.put(MotoId.of("010"), new Moto(MotoId.of("010"), Nombre.of("BOXER"), Precio.of(3900000), TipoMoto.of("E"), Cilindraje.of(100)));



        var event = new MotoDefinida(recomendadorId,moto);
        var useCase = new GenerarRecomendadorUseCase();

        when(repository.getEventsBy(recomendadorId.value())).thenReturn(eventStored(recomendadorId, motos, moto));
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(recomendadorId.value())
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var recomendadorGenerado = (RecomendadorGenerado) events.get(0);

        Assertions.assertEquals("R001", recomendadorGenerado.getRecomendadorId().value());


    }

    private List<DomainEvent> eventStored(RecomendadorId recoId, Map<MotoId, Moto> motos, Moto moto) {

        return List.of(
                new RecomendadorCreado(recoId, motos),
                new VendedorAgregado(RecomendadorId.of("R012"),VendedorId.of("012"), Nombre.of("Jhovan"), Cedula.of("123456789")),
                new ClienteAgregado(RecomendadorId.of("R012"), new Cliente(ClienteId.of("032"), Nombre.of("David"), Cedula.of("4532578"), Telefono.of("25614"))),
                new TipoMotoAgregado(RecomendadorId.of("012"),new TipoMoto("C")),
                new PresupuestoAgregado(RecomendadorId.of("012"),new Presupuesto(6000000)),
                new CilindrajeAgregado(RecomendadorId.of("012"), new Cilindraje(250)),
                new MotoDefinida(RecomendadorId.of("012"),new Moto(MotoId.of("045"),Nombre.of("TORNADO"),Precio.of(15000000),TipoMoto.of("e"),Cilindraje.of(250))));
    }




    }
