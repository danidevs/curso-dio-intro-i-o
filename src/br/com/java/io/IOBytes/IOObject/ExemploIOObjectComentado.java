package br.com.java.io.IOBytes.IOObject;

import java.io.*;


public class ExemploIOObjectComentado {
    public static void serealizarObjeto() {
        File f = new File("gato");
       
        GatoComentado gatoComentado = new GatoComentado("Jon", "tigrado", 19, true);

        ObjectOutputStream oos = null; 

        try { 
            OutputStream os = new FileOutputStream(f.getAbsolutePath());
            oos = new ObjectOutputStream(os); 
            oos.writeObject(gatoComentado); 
        } catch (FileNotFoundException e) { 
          
            System.out.printf("Arquivo %s não encontrado! Verifique o diretório %s", f.getName(), e.getMessage());
          
        } catch (IOException e) { 
            
            System.out.printf("Não foi possível criar o arquivo \"%s\".", f.getName());
            e.printStackTrace();
        } finally { 
            try { 
                oos.close();
            } catch (IOException e) { 
                System.out.printf("Erro ao fechar o arquivo \"%s\".",f.getName());
               
            }
        }
    }

    public static void desserializarObjeto(String arquivo) {
        File f = new File(arquivo);

        ObjectInputStream ois = null;
        try { 
            InputStream is = new FileInputStream(f.getName()); 
            ois = new ObjectInputStream(is); 
            GatoComentado gatoComentado = (GatoComentado) ois.readObject(); 

            
            System.out.printf("\nNome..................: %s\n", gatoComentado.getNome());
            System.out.printf("Idade............: %d\n", gatoComentado.getIdade());
            System.out.printf("Cor...............: %s\n", gatoComentado.getCor());
            System.out.printf("Castrado...............: %s\n", gatoComentado.isCastrado());
            System.out.printf("Ronrona...............: %s\n", gatoComentado.isRonrona());

        } catch (FileNotFoundException e) { 
            System.out.printf("Arquivo %s não encontrado! Verifique o diretório %s", f.getName(), e.getMessage());
            
        } catch (ClassNotFoundException e) {
            System.out.printf("Não foi possível ler o objeto do arquivo \"%s\".", f.getName());
            
        } catch (IOException e) { 
            System.out.printf("Não foi possível abrir o arquivo \"%s\".", f.getName());
            
        } finally { 
            try { 
                ois.close(); 
            } catch (IOException e) { 
                System.out.printf("Erro ao fechar o arquivo \"%s\".",f.getName());
               
            }
        }
    }

        public static void main (String[]args){
            serealizarObjeto();
            //desserializarObjeto("Documentos");
        }
}