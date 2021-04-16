//package org.example.nomemientan.infra.handle;
//
//import co.com.recomendador.domain.events.ClienteAgregado;
//import co.com.recomendador.domain.events.RecomendadorCreado;
//import co.com.recomendador.domain.events.SedeAgregada;
//import co.com.recomendador.domain.events.VendedorAgregado;
//import co.com.sofka.domain.generic.DomainEvent;
//import org.example.nomemientan.domain.juego.events.JuegoCreado;
//import org.example.nomemientan.domain.juego.events.JuegoInicializado;
//import org.example.nomemientan.domain.juego.events.JugadorAdicionado;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.event.EventListener;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.data.mongodb.core.query.Update;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.stereotype.Component;
//
//import java.util.*;
//import java.util.logging.Logger;
//
//@Component
//public class RecomendadorMaterialize {
//
//    private static final String COLLECTION_NAME = "recomendadores";
//    private static final Logger logger = Logger.getLogger(org.example.nomemientan.infra.handle.RecomendadorMaterialize.class.getName());
//
//    @Autowired
//    @Qualifier("mongoTemplateQueries")
//    private MongoTemplate mongoTemplate;
//
//    @Async
//    @EventListener
//    public void handleEventRecomendadorCreado(RecomendadorCreado recomendadorCreadoCreado) {
//        logger.info("****** Handle event RecomendadorCreado ");
//        Map<String, Object> data = new HashMap<>();
//        data.put("_id", recomendadorCreadoCreado.getRecomendadorId().value());
//        data.put("Generado", false);
//        mongoTemplate.save(data, COLLECTION_NAME);
//    }
//
//    @Async
//    @EventListener
//    public void handleEventSedeAgregada(SedeAgregada sedeAgregada) {
//        logger.info("****** Handle event sedeAgregada");
//        Update update = new Update();
//        update.set("sede",sedeAgregada.getSede().value());
//
//        mongoTemplate.updateFirst(getFilterByAggregateId(sedeAgregada), update, COLLECTION_NAME);
//    }
//
//
//    @Async
//    @EventListener
//    public void handleEventVendedorAgregado(VendedorAgregado vendedorAgregado) {
//        logger.info("****** Handle event vendedorAgregado");
//        Update update = new Update();
//        var id =vendedorAgregado.getVendedor().identity();
//        update.set("Vendedor."+id+".nombre",vendedorAgregado.getVendedor().getNombre().value());
//        update.set("Vendedor."+id+".cedula",vendedorAgregado.getVendedor().getCedula().value());
//        mongoTemplate.updateFirst(getFilterByAggregateId(vendedorAgregado), update, COLLECTION_NAME);
//    }
//
//    @Async
//    @EventListener
//    public void handleClienteAgregado(ClienteAgregado clienteAgregado) {
//        logger.info("****** Handle event vendedorAgregado");
//        Update update = new Update();
//        var id =vendedorAgregado.getVendedor().identity();
//        update.set("Vendedor."+id+".nombre",vendedorAgregado.getVendedor().getNombre().value());
//        update.set("Vendedor."+id+".cedula",vendedorAgregado.getVendedor().getCedula().value());
//        mongoTemplate.updateFirst(getFilterByAggregateId(vendedorAgregado), update, COLLECTION_NAME);
//    }
//
//
//    private Query getFilterByAggregateId(DomainEvent event) {
//        return new Query(
//                Criteria.where("_id").is(event.aggregateRootId())
//        );
//    }
//
//
//
//}