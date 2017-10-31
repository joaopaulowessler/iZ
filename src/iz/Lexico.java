package iz;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Lexico {
    
    String[] vetor          = new String[77];
    String   vpos           = "";
    String   vpos_acum      = "";
    String   vvar           = "abcdefghijklmnopqrstuvxzyw0123456789-_";
    String   vnum           = "0123456789.";    
    String   vacumtokens    = "";
    String   vacum_variavel = ""; 
    String   vacum_string   = "";
    String   vacum_literal  = "";
    String   vacum_numero   = "";
    int      vqtabre_chave  = 0;
    int      vqtfech_chave  = 0;        
    int      vqtabre_comen  = 0;
    int      vqtfech_comen  = 0;    
    
    boolean vabre_string;
    boolean vabre_literal;
    boolean vabre_comentario_linha;
    boolean vabre_comentario;
    boolean vfecha_comentario;
    boolean vabre_variavel;
    boolean vabre_numero;
    
    String[] vettokens;
    String[] vlinha_token;
    String[] linhas;        
    
    private String caminho = "";
    private boolean open = false;
    
    private DefaultTableModel tabela;
    
    String vtexto = "";
    
    public Lexico(){        
        
    }
    
    String validaLexico(String vtexto){
        String verro = "";
        gravaTokens();
        vacumtokens       = "";
        vqtabre_chave     = 0;
        vqtfech_chave     = 0;
        vqtabre_comen     = 0;
        vqtfech_comen     = 0;
        vabre_comentario  = false;
        vfecha_comentario = false;
        vabre_literal     = false;
        vfecha_comentario = false;
        vpos_acum         = "";
        vabre_string      = false;
        vacum_string      = "";  
        vabre_variavel    = false;
        vacum_variavel    = "";
        vabre_numero      = false;
        vacum_numero      = "";  
                
       this.vtexto = vtexto;
       
        /** DIVIDE TODO PROGRAMA EM LINHAS **/
        linhas = vtexto.split("\n");
        
        /** LENDO TODAS AS LINHAS **/
        for (int i = 0; i < linhas.length; i++){
            
            vabre_comentario_linha = false;
            
            linhas[i] = linhas[i].trim();
            
            /** LENDO OS CARACTERES DE CADA LINHA **/
            for (int y = 0; y < linhas[i].length(); y++){
                
                vpos = linhas[i].substring(y, y + 1).toLowerCase();
                
                verro = "";
                verro = valida(linhas[i],vpos,i+1,y);
                
                if (!verro.isEmpty()){
                    return verro;
                }
            }
            
            if (!vpos_acum.isEmpty()){
                return "ERRO - Comando: " + vpos_acum + " não encontrado!";
            }            
        }
        
        /** VERIFICA SE FICOU ALGUMA ABERTURA DE LITERAL E STRING EM ABERTO **/
        if (vabre_literal){
            return "ERRO - Existe abertura de String sem fechamento!";
        }
        
        if (vabre_string){
            return "ERRO - Existe abertura de Char sem fechamento!";
        }
        
        /** ADICIONA FINAL DE ARQUIVO A VARIAVEL DE TOKENS **/
        vacumtokens += String.valueOf(linhas.length) + "-44-&@;";
        
        /** LE TODOS OS TOKENS ENCONTRADOS E MOSTRA NA TABELA **/
        if (!vacumtokens.isEmpty()){
            return vacumtokens;            
        }
        
        return "ERRO - Ocorreu algum problema na extração do Léxico";
    }
    
    String valida(String vlinha, String vpos, int i, int y){
        int vtoken   = 0;
        String verro = "";
                
        /** TRATAMENTO DE COMENTARIOS LINHA/BLOCO **/
        if (vabre_comentario_linha)
            return "";
        
        if ((vpos.equals("/")) && (!vabre_literal) && (!vabre_string)){
            if ((y>0) && (vlinha.substring(y-1,y).equals("*")) && (vfecha_comentario))
                return "";

            if ((vlinha.length()-1!=y) && (vlinha.substring(y+1,y+2).equals("/"))){
                vabre_comentario_linha = true;
                return "";
            }
            
            if ((vlinha.length()-1!=y) && (vlinha.substring(y+1,y+2).equals("*"))){
                vqtabre_comen ++;

                if (vabre_comentario)
                    return "ERRO - Tentando abrir bloco de comentário, " +
                           "sem fechar o antecessor. Linha: " + String.valueOf(i);

                vabre_comentario = true;
                return "";
            }                                        
        }
        
        if ((vpos.equals("*")) && (!vabre_literal) && (!vabre_string)){
            
            if ((y>0) && (vlinha.substring(y-1,y).equals("/")) && (vabre_comentario))
                return "";
            
            if ((vlinha.length()-1!=y) && (vlinha.substring(y+1,y+2).equals("/"))){
                vqtfech_comen ++;
            
                if (!vabre_comentario)
                    return "ERRO - Tentando fechar bloco de comentário, " +
                           "sem mesmo abri-lo. Linha: " + String.valueOf(i);

                vabre_comentario  = false;
                vfecha_comentario = true;
                return "";
            }
        }
        
        if (vabre_comentario)
            return "";
        
        /** TRATAMENTO LITERAL **/
        if (vpos.equals("\"") && (!vabre_string)){
            
            if (vabre_literal){
                vabre_literal  = false;
                vacumtokens += Integer.toString(i) + "-" + Integer.toString(11) + "-" + vacum_literal.trim() + "@;";
            }
            else{
                if (!vpos_acum.trim().isEmpty())
                    return "ERRO - Comando: " + vpos_acum + " descohecido. Linha: " + String.valueOf(i);
                
                vabre_literal  = true;
                
                vpos_acum     = "";
                vacum_literal = "";
            }
            
            return "";
        }
        
        if (vabre_literal){
            vacum_literal += vpos;
            return "";            
        }            
        
        /** TRATAMENTO CHAR/STRING **/
        if ((vabre_string) && (!vpos.equals("'"))){            
            vacum_string += vpos;            
            return "";
        }
        
        if (vpos.equals("'")){
            if (vabre_string){
                vabre_string = false;
                
                if (!validaCapacidade("STRING",vacum_string).isEmpty())
                    return "ERRO - Limite de caracteres excedido. Linha: " + String.valueOf(i);
                
                if (vacum_string.trim().length() > 1)
                    vacumtokens += Integer.toString(i) + "-" + Integer.toString(9) + "-" + vacum_string.trim() + "@;";
                else
                    vacumtokens += Integer.toString(i) + "-" + Integer.toString(8) + "-" + vacum_string.trim() + "@;";
                
                vacum_string = "";
            }
            else{
                if (!vpos_acum.trim().isEmpty())
                    return "ERRO - Comando: " + vpos_acum + " descohecido. Linha: " + String.valueOf(i);
                
                vabre_string = true;
            }
            
            return "";
        }
        
        /** TRATA VARIAVEL **/
        if (vabre_variavel){
            
            if (vvar.contains(vpos)){
                vacum_variavel += vpos.trim();
                
                /** CASO SEJA FINAL DE LINHA E SEJA ABERTURA DE VARIAVEL,
                    CRIA NOVO TOKEN E ZERA VARIAVEIS **/
                if (y == (vlinha.length() -1)){

                    vacumtokens += Integer.toString(i+1) + "-" + Integer.toString(7) + "-" + vacum_variavel + "@;";
                    vacum_variavel = "";
                    vabre_variavel = false;                    
                }
        
                return "";
            }
            else{
                if (vacum_variavel.length() < 1)
                    return "ERRO - Informe corretamente o nome da variável. Linha: " + String.valueOf(i);
                
                vacumtokens += Integer.toString(i) + "-" + Integer.toString(7) + "-" + vacum_variavel + "@;";          
                vacum_variavel = "";
                
                if (!vpos.equals("@"))
                    vabre_variavel = false;
            }            
        }
        
        if (vpos.equals("@")){
            vabre_variavel = true;        
            return "";
        }
        
        /** TRATA NUMEROS INTEIROS/DECIMAIS **/
        if (vnum.contains(vpos))
            vabre_numero = true;
        
        if (vabre_numero){
            
            /** VALIDA SE CARACTERE LIDO É UM NUMERO **/
            if (vnum.contains(vpos)){
                vacum_numero += vpos;
                
                /** CASO SEJA FINAL DE LINHA E SEJA ABERTURA DE NUMERO,
                    CRIA NOVO TOKEN E ZERA VARIAVEIS **/
                if (y == vlinha.length()-1){
                    if (!validaNumero(vacum_numero).isEmpty()) 
                        return "ERRO - Informe o Inteiro/Decimal corretamente. Linha: " + String.valueOf(i);
                    
                    if (vacum_numero.contains(".")){
                        if (!validaCapacidade("NUMERO-FLOAT",vacum_numero).isEmpty())
                        return "ERRO - Limite de números Inteiro/Decimal excedido. Linha: " + String.valueOf(i);
                        
                        vacumtokens += Integer.toString(i) + "-" + Integer.toString(6) + "-" + vacum_numero + "@;";
                    }
                    else{
                        if (!validaCapacidade("NUMERO-INTE",vacum_numero).isEmpty())
                        return "ERRO - Limite de números Inteiro/Decimal excedido. Linha: " + String.valueOf(i);
                        
                        vacumtokens += Integer.toString(i) + "-" + Integer.toString(5) + "-" + vacum_numero + "@;";                    
                    }
                    
                    vacum_numero = "";
                    vabre_numero = false;
                }
                    
                return "";
            }
            /** CASO NAO SEJA NUMERO, ARMAZENA UM NOVO TOKEN, DEVIDO AS POSICOES ANTERIORES 
             * SEREM UM INT/FLOAT **/
            else{
                if (!validaNumero(vacum_numero).isEmpty()) 
                    return "ERRO - Informe o Inteiro/Decimal corretamente. Linha: " + String.valueOf(i);
                
                if (!validaCapacidade("NUMEROS",vacum_numero).isEmpty())
                    return "ERRO - Limite de números Inteiro/Decimal excedido. Linha: " + String.valueOf(i);
                
                if (vacum_numero.contains(".")){
                    if (!validaCapacidade("NUMERO-FLOAT",vacum_numero).isEmpty())
                    return "ERRO - Limite de números Inteiro/Decimal excedido. Linha: " + String.valueOf(i);

                    vacumtokens += Integer.toString(i) + "-" + Integer.toString(6) + "-" + vacum_numero + "@;";
                }
                else{
                    if (!validaCapacidade("NUMERO-INTE",vacum_numero).isEmpty())
                    return "ERRO - Limite de números Inteiro/Decimal excedido. Linha: " + String.valueOf(i);

                    vacumtokens += Integer.toString(i) + "-" + Integer.toString(5) + "-" + vacum_numero + "@;";                    
                }
                
                vacum_numero = "";
                vabre_numero = false;
            }            
        }        
        
        /** CASO POSICAO VPOS FOR BRANCO E VPOS_ACUM TIVER VALOR, 
            SIGNIFICA QUE TEM ERRO */
        if (vpos.trim().isEmpty()){
            if (!vpos_acum.trim().isEmpty())
                return "ERRO - Comando: " + vpos_acum + " descohecido. Linha: " + String.valueOf(i);                
            
            return "";
        }        
        
        /** SOMA QTD DE CHAVES ABERTAS/FECHADAS **/
        if (vpos.equals("{")) 
           vqtabre_chave ++;
        
        if (vpos.equals("}"))
           vqtfech_chave ++;        
        
        vpos_acum += vpos.trim();
        
        /** CHAMA FUNCAO PARA PROCURAR OS TOKENS **/
        vtoken = procuraToken(vlinha,vpos_acum,i,y);
        
        /** CASO POSITIVO, SIGNIFICA QUE 
            FOI ENCONTRADO TOKEN E ACUMULA NO VETOR DE TOKENS **/
        if (vtoken > 0){
            vacumtokens += Integer.toString(i) + "-" + Integer.toString(vtoken) + "-" + vpos_acum + "@;";
            vpos_acum = "";
        }
        
        /** CASO RETORNO SEJA NEGATIVO, SIGNIFICA QUE EXISTE ERRO **/
        if (vtoken < 0)            
            return "ERRO - Comando descohecido. Linha: " + String.valueOf(i);
        
        return "";
    }
    
    void gravaTokens(){
        vetor[1]  = "while";				
        vetor[2]  = "void";			
        vetor[3]  = "string";			
        vetor[4]  = "return";				
        vetor[5]  = "numerointeiro";							
        vetor[6]  = "numerofloat";							
        vetor[7]  = "nomevariavel";							
        vetor[8]  = "nomedochar";						
        vetor[9]  = "nomedastring";							
        vetor[10] = "main";			
        vetor[11] = "literal";					
        vetor[12] = "integer";					
        vetor[13] = "inicio";
        vetor[14] = "if";		
        vetor[15] = "î";		
        vetor[16] = "for";			
        vetor[17] = "float";			
        vetor[18] = "fim";			
        vetor[19] = "else";			
        vetor[20] = "do";		
        vetor[21] = "cout";			
        vetor[22] = "cin";			
        vetor[23] = "char";			
        vetor[24] = "callfuncao";						
        vetor[25] = ">>";		
        vetor[26] = ">=";		
        vetor[27] = ">";	
        vetor[28] = "==";		
        vetor[29] = "=";	
        vetor[30] = "<=";		
        vetor[31] = "<<";		
        vetor[32] = "<";	
        vetor[33] = "++";		
        vetor[34] = "+";	
        vetor[35] = "}";	
        vetor[36] = "{";	
        vetor[37] = ";";	
        vetor[38] = ":";	
        vetor[39] = "/";	
        vetor[40] = ",";	
        vetor[41] = "*";	
        vetor[42] = ")";	
        vetor[43] = "(";	
        vetor[44] = "$";	
        vetor[45] = "!=";		
        vetor[46] = "--";		
        vetor[47] = "-";
        vetor[48] = "BLOCO";
        vetor[49] = "DCLVAR";
        vetor[50] = "DCLFUNC";
        vetor[51] = "CORPO";
        vetor[52] = "REPIDENT";
        vetor[53] = "TIPO";
        vetor[54] = "LDVAR";
        vetor[55] = "LID";
        vetor[56] = "TIPO_RETORNO";
        vetor[57] = "DEFPAR";
        vetor[58] = "VALORRETORNO";
        vetor[59] = "PARAM";
        vetor[60] = "LPARAM";
        vetor[61] = "COMANDO";
        vetor[62] = "REPCOMANDO";
        vetor[63] = "EXPRESSAO";
        vetor[64] = "PARAMETROS";
        vetor[65] = "TPARAM";
        vetor[66] = "REPPAR";
        vetor[67] = "COMPARACAO";
        vetor[68] = "ELSEPARTE";
        vetor[69] = "CONTCOMPARACAO";
        vetor[70] = "INCREMENTO";
        vetor[71] = "SEQCOUT";
        vetor[72] = "SEQUENCIA";
        vetor[73] = "TERMO";
        vetor[74] = "REPEXP";
        vetor[75] = "FATOR";
        vetor[76] = "REPTERMO";
    }
    
    String validaCapacidade(String tipo, String valor){
        int   vint = 0;
        float vflo = 0;
        
        /** CASO FOR STRING, VALIDA SE QTD DE CARACTERES
         * EXCEDEU O LIMITE **/
        if ((tipo.equals("STRING")) &&
            (valor.length() > 65536))
            return "ERRO";
        
        /** CASO FOR NUMERO, USA NumberFormatException
         * VALIDACAO DO PROPIO JAVA **/
        if (tipo.equals("NUMERO-FLOAT")){
            try {
                vflo = Float.parseFloat(valor);
                /*vint = Integer.parseInt(valor);*/
            } catch (NumberFormatException ex) {  
                return "ERRO";
            }
        }
        
        if (tipo.equals("NUMERO-INTE")){
            try {
                vint = Integer.parseInt(valor);
                /*vint = Integer.parseInt(valor);*/
            } catch (NumberFormatException ex) {  
                return "ERRO";
            }
        }
        
        return "";
    }
    
    int procuraToken(String vlinha, String vcomando, int i, int y){
        int vcont = 0;
        boolean vachou = false;
        String vaux = "";
        
        /** PERCORE VETOR DE TOKENS **/
        for (int x = 1; x< vetor.length; x++){  
            
            /** SO ENTRA SE LENGTH DO TOKEN FOR MAIOR 
             * QUE O COMANDO PASSADO PARA FUNCAO **/
            
            /** AQUI VALIDARA SE O CAMANDO PERTENCE A TOKENS COM LENGTH MAIORES. 
             * POR O SIMBOLO +, ELE PODE SER + OU ++ DEPENDENDO A PROXIMA POSICAO, 
             É ISSO O OBJETIVO DESSA LOGICA**/
            if (vetor[x].length() > vcomando.length()){
                
                vaux  = vcomando;
                vcont = 0;
                
                if (!vaux.equals(vetor[x].substring(0,vaux.length())))
                    continue;
                
                do{
                    if ((y + vcont + 1) <= vlinha.length()){
                        
                        vaux = vcomando + vlinha.substring(y+1,y+vcont+1).toLowerCase();
                        
                        if (!vaux.equals(vetor[x].substring(0,vaux.length())))
                            break;                    
                        
                        if (vaux.equals(vetor[x]))                    
                            return 0;
                        
                        if (vaux.length() < vlinha.length())
                            vcont ++;
                        else
                            break;
                    }
                    else
                        break;
                    
                }while(true);    
            }    
        }
        
        /** PERCORRE TODOS OS TOKENS, E FAZ UMA COMPARACAO SIMPLES **/
        for (int x = 1; x< vetor.length; x++){
            if (vetor[x].equals(vcomando))
                return x;
        }
        
        return -1; 
    }
    
    String validaNumero(String vnumero){
        int vx = 0;
        
        /** VALIDA SE NO MESMO NUMERO EXISTE MAIS DE UM PONTO,
         * SE SIM, RETORNA ERRO **/
        for (int vi = 0; vi < vnumero.length(); vi++){

            if (vnumero.substring(vi, vi + 1).equals("."))    
                vx ++;
        }
        
        if (vx > 1)
            return "ERRO";
        else 
            return "";
    }
}
