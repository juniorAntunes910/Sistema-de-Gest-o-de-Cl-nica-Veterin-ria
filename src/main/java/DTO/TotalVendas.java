package DTO;

public record TotalVendas(
        String nomeVeterinario,
        int totalConsultas,
        double totalFaturado
){
    public TotalVendas(String nomeVeterinario, int totalConsultas, double totalFaturado) {
        this.nomeVeterinario = nomeVeterinario;
        this.totalConsultas = totalConsultas;
        this.totalFaturado = totalFaturado;
    }

    @Override
    public String nomeVeterinario() {
        return nomeVeterinario;
    }

    @Override
    public int totalConsultas() {
        return totalConsultas;
    }

    @Override
    public double totalFaturado() {
        return totalFaturado;
    }

    @Override
    public String toString() {
        return "TotalVendas{" +
                "nomeVeterinario='" + nomeVeterinario + '\'' +
                ", totalConsultas=" + totalConsultas +
                ", totalFaturado=" + totalFaturado +
                '}';
    }
}


