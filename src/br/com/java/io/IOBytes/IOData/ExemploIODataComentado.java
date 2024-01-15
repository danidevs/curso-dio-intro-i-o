package br.com.java.io.IOBytes.IOData;

import java.io.*;
import java.util.Scanner;


public class ExemploIODataComentado {
    public static void incluirProduto() throws IOException, EOFException {
        File f = new File("Documentos"); 
        PrintStream ps = new PrintStream(System.out, true); 

    
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(f.getPath())); 

        Scanner scan = new Scanner(System.in); 

        ps.print("Nome do produto: "); 
        String nome = scan.next(); 
        dos.writeUTF(nome); 

        ps.print("Quantidade: "); 
        int quantidade = scan.nextInt();  
        dos.writeInt(quantidade); 

        ps.print("Tamanho: "); 
        char tamanho = (char) System.in.read(); 
        dos.writeChar(tamanho); 

        ps.print("Preço: "); 
        double preco = scan.nextDouble(); 
        dos.writeDouble(preco); 


        ps.printf("O arquivo %s foi criado com %d bytes no diretório '%s'.\n",
                f.getName(), f.length(), f.getAbsolutePath()); 

        lerArquivoBin(f.getPath()); 

        scan.close(); 
        dos.close(); 

        ps.close(); 
    }

    public static void lerArquivoBin(String arquivo) throws IOException {

        File f = new File(arquivo); 
        try (PrintStream ps = new PrintStream(System.out)) {
        }

        
        DataInputStream dis = new DataInputStream(new FileInputStream(f.getPath())); 

      
        String nome;
        int quantidade;
        char tamanho;
        double preco;

        
        nome = dis.readUTF(); 
        quantidade = dis.readInt(); 
        tamanho = dis.readChar(); 
        preco = dis.readDouble();
        System.out.printf("\nNome..................: %s\n", nome);
        System.out.printf("Quantidade............: %d\n", quantidade);
        System.out.printf("Tamanho...............: %s\n", tamanho);
        System.out.printf("Preço.................: %f\n", preco);

 

    }

    public static void main(String[] args) throws IOException {
        incluirProduto();
    }
}