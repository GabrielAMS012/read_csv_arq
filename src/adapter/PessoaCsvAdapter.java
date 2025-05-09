package adapter;

import model.Pessoa;
import repository.RepositorioDePessoas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class PessoaCsvAdapter implements RepositorioDePessoas {
    private String csvUrl;

    public PessoaCsvAdapter(String csvUrl) {
        this.csvUrl = csvUrl;
    }

    public void setCsvUrl(String csvUrl) {
        this.csvUrl = csvUrl;
    }

    @Override
    public List<Pessoa> listarPessoas() {
        return this.adaptaCsv(this.csvUrl);
    }

    private List<Pessoa> adaptaCsv(String csvFile) {
        BufferedReader bufferedReader;
        String linha;
        List<Pessoa> listaDePessoas = new ArrayList<>();
        try {
            bufferedReader = new BufferedReader(new FileReader(csvFile));

            while((linha = bufferedReader.readLine()) != null) {
                String[] infos = linha.split(",");
                if(!infos[0].equalsIgnoreCase("NOME"))
                    listaDePessoas.add(new Pessoa(infos[0], Integer.parseInt(infos[1]), infos[2]));
            }
            listaDePessoas.removeFirst();
            return listaDePessoas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
