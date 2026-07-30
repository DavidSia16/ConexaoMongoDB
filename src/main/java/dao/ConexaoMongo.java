package dao;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class ConexaoMongo {

    private static final String USERNAME = "SEU_USUARIO";
    private static final String PASSWORD = "SEU_PASSWORD";
    private static final String CLUSTER_URL = "cluster0.in3aftt.mongodb.net";
    private static final String DATABASE_NAME = "Cluster0";

    private MongoClient mongoClient;
    private MongoDatabase database;

    public ConexaoMongo() {
        try {

            String connectionString = String.format(
                    "mongodb+srv://%s:%s@%s/%s?retryWrites=true&w=majority&appName=Cluster0",
                    USERNAME, PASSWORD, CLUSTER_URL, DATABASE_NAME
            );

            ConnectionString connString = new ConnectionString(connectionString);
            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(connString)
                    .build();


            mongoClient = MongoClients.create(settings);
            database = mongoClient.getDatabase(DATABASE_NAME);

            System.out.println("Conexão OK!");
        } catch (Exception e) {
            System.out.println("Erro ao conectar ao banco de dados:");
            e.printStackTrace();
        }
    }

    public MongoDatabase getDatabase() {
        return database;
    }
}