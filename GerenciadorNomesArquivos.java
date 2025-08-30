import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorNomesArquivos implements GerenciadorNomes {
    private File arquivo;

    public GerenciadorNomesArquivos(String caminhoArquivo) {
        this.arquivo = new File(caminhoArquivo);

        try {
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Erro ao criar arquivo: " + e.getMessage());
        }
    }

    public List<String> obterNomes() {
        List<String> nomes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                nomes.add(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }

        return nomes;
    }

    public void adicionarNome(String nome) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo, true))) {
            bw.write(nome);
            bw.newLine(); 
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
}
