import java.util.*;
class Banco {
    Map<Integer, Conta> contas = new HashMap<>();
    int contadorContas = 1000;
    final String SENHA_GERENTE = "admin123";


    public Conta criarConta(String nome, String cpf, String email, String endereco, String senha) {
        int numero = contadorContas++;
        Conta c = new Conta(nome, cpf, email, endereco, senha, numero);
        contas.put(numero, c);
        return c;
    }


    public Conta buscarConta(int numero) {
        return contas.get(numero);
    }
}
