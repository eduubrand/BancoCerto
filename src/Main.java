import javax.swing.JOptionPane;
public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        BancoTeste.MenuConta menuConta = new BancoTeste.MenuConta();


        while (true) {
            String opc = JOptionPane.showInputDialog(
                    "MENU PRINCIPAL:\n1 - Criar conta (Gerente)\n2 - Acessar conta\n3 - Sair do programa");


            if (opc == null) continue; // Se o usuário fechou o diálogo, volta ao menu


            if (opc.equals("1")) {
                String senhaGer = JOptionPane.showInputDialog("Senha do gerente:");
                if (senhaGer == null || !banco.SENHA_GERENTE.equals(senhaGer)) {
                    JOptionPane.showMessageDialog(null, "Senha incorreta!");
                    continue;
                }


                String nome = JOptionPane.showInputDialog("Nome:");
                if (nome == null) continue;
                String cpf = JOptionPane.showInputDialog("CPF:");
                if (cpf == null) continue;
                String email = JOptionPane.showInputDialog("Email:");
                if (email == null) continue;
                String endereco = JOptionPane.showInputDialog("Endereço:");
                if (endereco == null) continue;
                String senha = JOptionPane.showInputDialog("Senha da conta:");
                if (senha == null) continue;


                Conta nova = banco.criarConta(nome, cpf, email, endereco, senha);
                JOptionPane.showMessageDialog(null, "Conta criada! Número: " + nova.numero);


            } else if (opc.equals("2")) {
                String numStr = JOptionPane.showInputDialog("Número da conta:");
                if (numStr == null || !numStr.matches("[0-9]+")) {
                    JOptionPane.showMessageDialog(null, "Número inválido!");
                    continue;
                }


                int num = Integer.parseInt(numStr);
                Conta c = banco.buscarConta(num);
                if (c == null) {
                    JOptionPane.showMessageDialog(null, "Conta inexistente!");
                    continue;
                }


                String senhaAcc = JOptionPane.showInputDialog("Senha:");
                if (senhaAcc == null || !c.senha.equals(senhaAcc)) {
                    JOptionPane.showMessageDialog(null, "Senha incorreta!");
                    continue;
                }


                menuConta.abrir(c, banco);


            } else if (opc.equals("3")) {
                JOptionPane.showMessageDialog(null, "Encerrando...");
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
    }
}