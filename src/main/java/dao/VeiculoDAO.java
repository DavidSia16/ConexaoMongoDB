package dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import model.Veiculo;
import org.bson.Document;

import java.util.Arrays;

public class VeiculoDAO {
    private MongoCollection<Document> docsVeiculo;

    public VeiculoDAO(ConexaoMongo connection) {

        this.docsVeiculo = connection.getDatabase().getCollection("veiculos");
    }


    public void initVeiculo() {
        Veiculo car3 = new Veiculo("Spin activ7", "GM", "FTG-7b22", 2020);
        Veiculo car2 = new Veiculo("Etios XLS", "Toyota", "GRJ-0b23", 2018);
        Veiculo car4 = new Veiculo("Mobi", "Fiat", "AGG-9b33", 2018);

        docsVeiculo.insertMany(Arrays.asList(car2.toDocument(), car4.toDocument(), car3.toDocument()));
        System.out.println("Veículos iniciais inseridos com sucesso!");
    }

    public void createVeiculo(Veiculo veiculo) {
        docsVeiculo.insertOne((Document) veiculo.toDocument());
        System.out.println("Veículo inserido: " + veiculo);
    }

    public void readVeiculo() {
        System.out.println("\nVeículos cadastrados:");
        for (Document doc : docsVeiculo.find()) {
            System.out.println(Veiculo.fromDocument(doc));
        }
    }

    public void updateVeiculo(String modelo, String novaPlaca, int novoAnoFabricacao) {
        docsVeiculo.updateOne(
                Filters.eq("modelo", modelo),
                Updates.combine(
                        Updates.set("placa", novaPlaca),
                        Updates.set("anoFabricacao", novoAnoFabricacao)
                )
        );
        System.out.println("Veículo " + modelo + " atualizado.");
    }

    public void updateVeiculoFull(String modelo, String novaPlaca, String novoFabricante, int novoAnoFabricacao) {
        docsVeiculo.updateOne(
                Filters.eq("modelo", modelo),
                Updates.combine(
                        Updates.set("placa", novaPlaca),
                        Updates.set("fabricante", novoFabricante),
                        Updates.set("anoFabricacao", novoAnoFabricacao)
                )
        );

        System.out.println("Veículo " + modelo + " atualizado completamente.");
    }

    public void deleteVeiculo(String modelo) {
        docsVeiculo.deleteOne(Filters.eq("modelo", modelo));
        System.out.println("Veículo " + modelo + " apagado.");
    }
}