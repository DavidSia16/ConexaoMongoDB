package util;

import dao.ConexaoMongo;
import dao.VeiculoDAO;
import model.Veiculo;

public class TesteConecaoMongo {
    public static void main(String[] args) {
        ConexaoMongo conexao = new ConexaoMongo();
        VeiculoDAO operations = new VeiculoDAO(conexao);
        Veiculo carNovo = new Veiculo("Onix plus", "GM", "ADF-9974", 2025);
       // operations.initVeiculo();
        operations.deleteVeiculo("Mobi");
        operations.readVeiculo();
    }
}
