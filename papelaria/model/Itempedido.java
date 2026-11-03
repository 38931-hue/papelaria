
package model;

public class ItemPedido {

    // Constantes para evitar números mágicos
    private static final double DESCONTO_KIT = 0.15;
    private static final double DESCONTO_QUANTIDADE = 0.08;
    private static final int QUANTIDADE_MINIMA_DESCONTO = 10;

    private static final String FORMATO_LINHA =
            "%-20s %3d un | bruto R$ %7.2f | desc R$ %6.2f | R$ %7.2f%n";

    // Atributos privados (encapsulamento)
    private String descricao;
    private double valorUnitario;
    private int quantidade;
    private boolean kit;

    // Construtor
    public ItemPedido(String descricao, double valorUnitario,
                      int quantidade, boolean kit) {
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
        this.kit = kit;
    }

    // Calcula o valor bruto
    public double calcularValorBruto() {
        return valorUnitario * quantidade;
    }

    // Calcula o desconto
    public double calcularDesconto() {
        double bruto = calcularValorBruto();

        if (kit) {
            return bruto * DESCONTO_KIT;
        } else if (quantidade >= QUANTIDADE_MINIMA_DESCONTO) {
            return bruto * DESCONTO_QUANTIDADE;
        } else {
            return 0.0;
        }
    }

    // Calcula o valor líquido
    public double calcularValorLiquido() {
        return calcularValorBruto() - calcularDesconto();
    }

    // Exibe a linha do produto
    public void exibirLinha() {
        System.out.printf(FORMATO_LINHA,
                descricao,
                quantidade,
                calcularValorBruto(),
                calcularDesconto(),
                calcularValorLiquido());
    }
}
