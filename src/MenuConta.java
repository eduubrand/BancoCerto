import javax.swing.JOptionPane;

public class MenuConta {

    public static void abrir(Conta conta, Banco banco) {
        int opcao = 0;

        while (opcao != 5) {
            String menu = "--- MENU DA CONTA ---" +
                    "\n1 - Depositar" +
                    "\n2 - Sacar" +
                    "\n3 - Transferir" +
                    "\n4 - Mostrar informações da conta" +
                    "\n5 - Sair";

            String escolha = JOptionPane.showInputDialog(menu);
            opcao = Integer.parseInt(escolha);

            if (opcao == 1) {
                String valorStr = JOptionPane.showInputDialog("Valor para depósito:");
                double valor = Double.parseDouble(valorStr);
                conta.saldo += valor;
                JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso!");

            } else if (opcao == 2) {
                String valorStr = JOptionPane.showInputDialog("Valor para saque:");
                double valor = Double.parseDouble(valorStr);

                if (valor <= conta.saldo) {
                    conta.saldo -= valor;
                    JOptionPane.showMessageDialog(null, "Saque realizado!");
                } else {
                    JOptionPane.showMessageDialog(null, "Saldo insuficiente!");
                }

            } else if (opcao == 3) {
                String numeroDestinoStr = JOptionPane.showInputDialog("Número da conta destino:");
                int numDestino = Integer.parseInt(numeroDestinoStr);

                Conta destino = banco.buscarConta(numDestino);

                if (destino == null) {
                    JOptionPane.showMessageDialog(null, "Conta destino não encontrada!");
                } else {
                    String senha = JOptionPane.showInputDialog("Digite sua senha:");

                    if (senha.equals(conta.senha)) {
                        String valorStr = JOptionPane.showInputDialog("Valor a transferir:");
                        double valor = Double.parseDouble(valorStr);

                        if (valor <= conta.saldo) {
                            conta.saldo -= valor;
                            destino.saldo += valor;
                            JOptionPane.showMessageDialog(null, "Transferência concluída!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Saldo insuficiente!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Senha incorreta!");
                    }
                }

            } else if (opcao == 4) {
                JOptionPane.showMessageDialog(null,
                        "Nome: " + conta.nome +
                                "\nCPF: " + conta.cpf +
                                "\nEmail: " + conta.email +
                                "\nEndereço: " + conta.endereco +
                                "\nNúmero da Conta: " + conta.numero +
                                "\nSaldo: R$ " + conta.saldo);

            } else if (opcao == 5) {
                JOptionPane.showMessageDialog(null, "Saindo da conta...");
            } else {
                JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
    }
}