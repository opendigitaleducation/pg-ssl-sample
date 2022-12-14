package sample.pgssl.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import sample.pgssl.client.IPostgresClient;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class PgFromBusWorker extends AbstractVerticle {
    public static Logger log = LoggerFactory.getLogger(PgFromBusWorker.class);
    public static final String ADDRESS = "pgssl.bus.worker";
    @Override
    public void start() throws Exception {
        super.start();
        final IPostgresClient client = IPostgresClient.create(vertx, config(), true, true);
        VerticleHelper.createConsumer(vertx, ADDRESS, client, log);
    }
}
