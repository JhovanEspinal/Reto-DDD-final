package co.com.recomendador.infra.handle;

import co.com.recomendador.domain.events.*;
import co.com.recomendador.domain.valueObjets.Presupuesto;
import co.com.sofka.domain.generic.DomainEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.logging.Logger;

@Component
public class RecomendadorMaterialize {

    private static final String COLLECTION_NAME = "recomendadores";
    private static final Logger logger = Logger.getLogger(RecomendadorMaterialize.class.getName());

    @Autowired
    @Qualifier("mongoTemplateQueries")
    private MongoTemplate mongoTemplate;

    @Async
    @EventListener
    public void handleEventRecomendadorCreado(RecomendadorCreado recomendadorCreadoCreado) {
        logger.info("****** Handle event RecomendadorCreado ");
        Map<String, Object> data = new HashMap<>();
        data.put("_id", recomendadorCreadoCreado.getRecomendadorId().value());
        data.put("Generado", false);
        mongoTemplate.save(data, COLLECTION_NAME);
    }

    @Async
    @EventListener
    public void handleEventSedeAgregada(SedeAgregada sedeAgregada) {
        logger.info("****** Handle event sedeAgregada");
        Update update = new Update();
        update.set("sede",sedeAgregada.getSede().value());

        mongoTemplate.updateFirst(getFilterByAggregateId(sedeAgregada), update, COLLECTION_NAME);
    }


    @Async
    @EventListener
    public void handleEventVendedorAgregado(VendedorAgregado vendedorAgregado) {
        logger.info("****** Handle event vendedorAgregado");
        Update update = new Update();
        var id =vendedorAgregado.getVendedorid().value();
        update.set("Vendedor."+id+".nombre",vendedorAgregado.getNombre().value());
        update.set("Vendedor."+id+".cedula",vendedorAgregado.getCedula().value());
        mongoTemplate.updateFirst(getFilterByAggregateId(vendedorAgregado), update, COLLECTION_NAME);
    }

    @Async
    @EventListener
    public void handleClienteAgregado(ClienteAgregado clienteAgregado) {
        logger.info("****** Handle event vendedorAgregado");
        Update update = new Update();
        var id = clienteAgregado.getCliente().identity();
        update.set("Cliente."+id+".nombre",clienteAgregado.getCliente().getNombre().value());
        update.set("Cliente."+id+".cedula",clienteAgregado.getCliente().getCedula().value());
        mongoTemplate.updateFirst(getFilterByAggregateId(clienteAgregado), update, COLLECTION_NAME);
    }

    @Async
    @EventListener
    public void handleTipoMotoAgregado(TipoMotoAgregado tipoMotoAgregado) {
        logger.info("****** Handle event tipoMotoAgregado");
        Update update = new Update();

        update.set("TipoMoto.",tipoMotoAgregado.getTipoMoto().value());
        mongoTemplate.updateFirst(getFilterByAggregateId(tipoMotoAgregado), update, COLLECTION_NAME);
    }

    @Async
    @EventListener
    public void handlePresupuestoAgregado(PresupuestoAgregado presupuestoAgregado) {
        logger.info("****** Handle event presupuestoAgregado");
        Update update = new Update();

        update.set("Presupuesto.",presupuestoAgregado.getPresupuesto().value());
        mongoTemplate.updateFirst(getFilterByAggregateId(presupuestoAgregado), update, COLLECTION_NAME);
    }

    @Async
    @EventListener
    public void handleCilindrajeAgregado(CilindrajeAgregado cilindrajeAgregado) {
        logger.info("****** Handle event cilindrajeAgregado");
        Update update = new Update();

        update.set("Cilindraje.",cilindrajeAgregado.getCilindraje().value());
        mongoTemplate.updateFirst(getFilterByAggregateId(cilindrajeAgregado), update, COLLECTION_NAME);
    }

    @Async
    @EventListener
    public void handleMotosDeinifidas(MotosDefinidas motosDefinidas) {
        logger.info("****** Handle event motosDefinidas");
        Update update = new Update();

        update.set("MotosDefinidas.",motosDefinidas.getMotosF());
        mongoTemplate.updateFirst(getFilterByAggregateId(motosDefinidas), update, COLLECTION_NAME);
    }


    private Query getFilterByAggregateId(DomainEvent event) {
        return new Query(
                Criteria.where("_id").is(event.aggregateRootId())
        );
    }



}