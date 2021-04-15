package co.com.recomendador.useCases;

import co.com.recomendador.domain.command.CrearRecomendador;
import co.com.recomendador.domain.valueObjets.Cilindraje;
import co.com.recomendador.domain.valueObjets.Precio;
import co.com.recomendador.domain.valueObjets.TipoMoto;
import co.com.recomendador.domain.events.RecomendadorCreado;
import co.com.recomendador.domain.valueObjets.MotoId;
import co.com.recomendador.domain.valueObjets.Nombre;
import co.com.recomendador.domain.valueObjets.RecomendadorId;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Objects;

class CrearRecomendadorUseCaseTest {

    @Test
    void CrearRecomendador(){

        var command = new CrearRecomendador(RecomendadorId.of("R001"),generarNombres(), generarPrecios(), generarTipoMotos(), generarCilindraje());
        var useCase = new CrearRecomendadorUseCase();

        var events =  UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var recomendadorCreado = (RecomendadorCreado) events.get(0);

        Assertions.assertTrue(Objects.nonNull(recomendadorCreado.getRecomendadorId().value()));
        Assertions.assertEquals("R001",recomendadorCreado.getRecomendadorId().value());
        Assertions.assertEquals(10,recomendadorCreado.getMotos().size());
//        Assertions.assertEquals("XTZ",recomendadorCreado.getMotos().get("001").getNombre().value());
    }


    private Map<MotoId,Nombre> generarNombres(){

      return Map.of(MotoId.of("001"), Nombre.of("XTZ"),
                MotoId.of("002"),Nombre.of("XR150"),
                MotoId.of("003"),Nombre.of("XRE"),
                MotoId.of("004"), Nombre.of("TTR"),
                MotoId.of("005"),Nombre.of("NMAX"),
                MotoId.of("006"),Nombre.of("BWS"),
                MotoId.of("007"),Nombre.of("DYNAMIC"),
                MotoId.of("008"),Nombre.of("NKD"),
                MotoId.of("009"),Nombre.of("FZ"),
                MotoId.of("010"),Nombre.of("BOXER"));
    }

    private Map<MotoId, Precio> generarPrecios(){

        return Map.of(MotoId.of("001"),Precio.of(7800000),
                MotoId.of("002"),Precio.of(9000000),
                MotoId.of("003"),Precio.of(19500000),
                MotoId.of("004"),Precio.of(7000000),
                MotoId.of("005"),Precio.of(11000000),
                MotoId.of("006"),Precio.of(9000000),
                MotoId.of("007"),Precio.of(5600000),
                MotoId.of("008"),Precio.of(3800000),
                MotoId.of("009"),Precio.of(8000000),
                MotoId.of("010"),Precio.of(3900000));
    }

    private Map<MotoId, TipoMoto> generarTipoMotos(){

        return Map.of(MotoId.of("001"), TipoMoto.of("E"),
                MotoId.of("002"),TipoMoto.of("E"),
                MotoId.of("003"),TipoMoto.of("E"),
                MotoId.of("004"),TipoMoto.of("E"),
                MotoId.of("005"),TipoMoto.of("S"),
                MotoId.of("006"),TipoMoto.of("S"),
                MotoId.of("007"),TipoMoto.of("S"),
                MotoId.of("008"),TipoMoto.of("C"),
                MotoId.of("009"),TipoMoto.of("C"));

    }

    private Map<MotoId, Cilindraje> generarCilindraje(){

        return Map.of(MotoId.of("001"),Cilindraje.of(125),
                MotoId.of("002"),Cilindraje.of(150),
                MotoId.of("003"),Cilindraje.of(300),
                MotoId.of("004"),Cilindraje.of(200),
                MotoId.of("005"),Cilindraje.of(150),
                MotoId.of("006"),Cilindraje.of(125),
                MotoId.of("007"),Cilindraje.of(125),
                MotoId.of("008"),Cilindraje.of(125),
                MotoId.of("009"),Cilindraje.of(150),
                MotoId.of("010"),Cilindraje.of(100));
    }















}