package br.com.java.io.IOBytes;

import java.io.*;


public class ExemploIOBytes {
    public static void copiarArquivo() throws IOException {
        File f = new File("/home/cami/git/curso-dio-intro-java-io/recomendacoes-copy.txt");
        String nomeArquivo = f.getName();

       
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f.getName()));

        String nomeArquivoCopy = nomeArquivo.substring(0, nomeArquivo.indexOf("-")).concat("-copy2.txt");
        File fcopy = new File(nomeArquivoCopy);

       
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(nomeArquivoCopy));

        int line = 0;
        while((line = bis.read()) != -1) {
            bos.write((char) line);
            bos.flush();
        }

        bis.close();
        bos.close();

        PrintStream ps = new PrintStream(System.out);
        ps.printf("Arquivo %s copiado com sucesso e está no diretório %s com %d bytes ",
                fcopy.getName(), fcopy.getPath(), fcopy.length());
    }

    public static void main(String[] args) throws IOException {
        copiarArquivo();
    }
}