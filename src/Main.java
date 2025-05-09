import adapter.PessoaCsvAdapter;

public class Main {
    public static void main(String[] args) {
        PessoaCsvAdapter pessoaCsvAdapter = new PessoaCsvAdapter("src/pessoas.csv");

        pessoaCsvAdapter.listarPessoas()
                .forEach(pessoa -> System.out.println(pessoa.toString()));
    }
}