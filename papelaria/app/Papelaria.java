
package app;

import model.ItemPedido;
import model.Pedido;

public class Papelaria {

    public static void main(String[] args) {

        System.out.println("=== PAPELARIA PONTO FINAL ===\n");

        // Criação do pedido
        Pedido pedido = new Pedido();

        // Criação dos itens
        ItemPedido item1 = new ItemPedido(
                "Caderno 10 materias", 24.90, 1, false);

        ItemPedido item2 = new ItemPedido(
                "Lapis grafite", 1.50, 12, false);

        ItemPedido item3 = new ItemPedido(
                "Kit escolar basico", 84.00, 1, true);

        ItemPedido item4 = new ItemPedido(
                "Caneta azul", 2.80, 10, false);

        // Adiciona os itens ao pedido
        pedido.adicionarItem(item1);
        pedido.adicionarItem(item2);
        pedido.adicionarItem(item3);
        pedido.adicionarItem(item4);

        // Exibe o resumo
        pedido.exibirResumo();
    }
}
