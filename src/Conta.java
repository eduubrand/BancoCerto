class Conta {
    String nome, cpf, email, endereco, senha;
    int numero;
    double saldo;


    public Conta(String nome, String cpf, String email, String endereco, String senha, int numero) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.endereco = endereco;
        this.senha = senha;
        this.numero = numero;
        this.saldo = 0;
    }
}