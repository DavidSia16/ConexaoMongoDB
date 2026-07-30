package model;

// 1. IMPORT CORRETO DA BSON DOCUMENT
import org.bson.Document;

public class Veiculo {
    private String modelo;
    private String fabricante;
    private String placa;
    private int anoFabricacao;

    public Veiculo() {
    }

    public Veiculo(String modelo, String fabricante, String placa, int anoFabricacao) {
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.placa = placa;
        this.anoFabricacao = anoFabricacao;
    }

    // Getters e Setters
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }
    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

       public Document toDocument() {
        return new Document()
                .append("modelo", this.modelo)
                .append("fabricante", this.fabricante)
                .append("placa", this.placa)
                .append("anoFabricacao", this.anoFabricacao);
    }

    public static Veiculo fromDocument(Document document) {
        return new Veiculo(
                document.getString("modelo"),
                document.getString("fabricante"),
                document.getString("placa"),
                document.getInteger("anoFabricacao")
        );
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "modelo='" + modelo + '\'' +
                ", fabricante='" + fabricante + '\'' +
                ", placa='" + placa + '\'' +
                ", anoFabricacao=" + anoFabricacao +
                '}';
    }
}