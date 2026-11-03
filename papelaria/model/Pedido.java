
package model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    // Constantes do frete
    private static final double FRETE_GRATIS_A_PARTIR = 150.00;
    private static final double VALOR_FRETE = 12.90;

    private List<ItemPedido> itens;

    // Construtor
    public Pedido() {
        itens = new ArrayList<>();
    }

    // Adiciona um item ao pedido
    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    // Calcula a soma dos valores líquidos
    public double calcularTotalItens() {
        double soma = 0.0;

        for (ItemPedido item : itens) {
            soma += item.calcularValorLiquido();
        }

        return soma;
    }

    // Calcula o frete
    public double calcularFrete() {
        return calcularFrete(calcularTotalItens());
    }

    // Calcula o frete conforme o valor dos itens
    public double calcularFrete(double valorItens) {
        if (valorItens >= FRETE_GRATIS_A_PARTIR) {
            return 0.0;
        } else {
            return VALOR_FRETE;
        }
    }

    // Exibe o resumo completo do pedido
    public void exibirResumo() {

        for (ItemPedido item : itens) {
            item.exibirLinha();
        }

        double soma = calcularTotalItens();
        double frete = calcularFrete();

        System.out.printf("%nItens:  R$ %.2f%n", soma);
        System.out.printf("Frete:  R$ %.2f%n", frete);
        System.out.printf("Total do pedido: R$ %.2f%n", soma + frete);
    }
}
