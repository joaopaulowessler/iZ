package iz;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Sintatico {
    
    int    regra = 0;
    int    vpos  = 0;
    String descricao = "";
    String pilha     = "";
    
    String[] producoes;
    String[] tokens;
    String[] vlinha_token;
    
    String[]        vetor = new String[77];
    String[] vetProducoes = new String[90];
    
    int[][] tabParsing = new int[100][100];
    
    ArrayList<Integer> sintatico = new ArrayList<Integer>();
    
    public Sintatico(){
        gravaTokens();
        gravaTabParsing();
        gravaVetProducoes();
        
        sintatico.add(44);
        sintatico.add(48);
        
        pilha(); // Armazena alterações na pilha, para mostrar no programa        
    }    
    
    String validaSintatico(String vtoken){
        String vretorno = "";
        
        tokens = vtoken.split("@;");
        
        for (int i = 0; i < tokens.length; i++){
            vlinha_token = tokens[i].split("-");
            
            if (vlinha_token.length > 2)
                descricao = vlinha_token[2];
            else 
                descricao = "";
                
            vretorno = verificaSintatico(Integer.parseInt(vlinha_token[0]),Integer.parseInt(vlinha_token[1]),descricao);
            
            if (vretorno.contains("ERRO"))
                return vretorno;
        }

        return pilha;
    }
    
    String verificaSintatico(int vlinha, int vtoken, String vdestoken){

        int x = sintatico.get(sintatico.size() -1); //topo da pilha
	int a = vtoken; // recebe o símbolo da entrada
        
        do{
            if (x == 15){                
                sintatico.remove(sintatico.size() -1);  //Retire o elemento do topo da pilha
                x = sintatico.get(sintatico.size() -1); //X recebe o topo da pilha                
                pilha();   // Armazena alterações na pilha, para mostrar no programa
            }
            else{
                if (x < 48){
                    if (x == a){
                        sintatico.remove(sintatico.size() -1); // Retire o elemento do topo da pilha
                        pilha();   // Armazena alterações na pilha, para mostrar no programa
                        return ""; // Volta para o Léxico
                    }
                    else{
                        return "ERRO - Existe erro sintático na linha: " + String.valueOf(vlinha);
                    }
                }
                else{
                    regra = tabParsing[x][a];
                            
                    if (regra != 0){
                        sintatico.remove(sintatico.size() -1); //Retire o elemento do topo da pilha
                        pilha(); // Armazena alterações na pilha, para mostrar no programa
                        
                        /*Armazena na pilha as novas regras*/
                        producoes = vetProducoes[regra].split(";");
                        
                        vpos = producoes.length - 1;
                        for (int i = 0; i < producoes.length; i++){
                            sintatico.add(Integer.parseInt(producoes[vpos]));
                            vpos--;
                        }
                        
                        pilha(); // Armazena alterações na pilha, para mostrar no programa
                        
			x = sintatico.get(sintatico.size() -1); //X recebe o topo da pilha
                    } else {
                        return "ERRO - Existe erro sintático na linha: " + String.valueOf(vlinha);
                    }
                }
            }
        }while (x != 44);

        return "";
    }

    void pilha(){
        for (int i = 0; i < sintatico.size(); i++){
            pilha += String.valueOf(sintatico.get(i));
            
            if (i != (sintatico.size() - 1))
                pilha += ",";
        }

        pilha += ";";
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
    
    void gravaTabParsing(){
        tabParsing[48][2]  = 1;
        tabParsing[49][2]  = 3;
        tabParsing[49][3]  = 3;
        tabParsing[49][7]  = 2;
        tabParsing[49][12] = 3;
        tabParsing[49][13] = 3;
        tabParsing[49][17] = 3;
        tabParsing[49][23] = 3;
        tabParsing[49][44] = 3;
        tabParsing[50][2]  = 13;
        tabParsing[50][3]  = 13;
        tabParsing[50][12] = 13;
        tabParsing[50][13] = 19;
        tabParsing[50][17] = 13;
        tabParsing[50][23] = 13;
        tabParsing[51][13] = 31;
        tabParsing[52][38] = 4;
        tabParsing[52][40] = 5;
        tabParsing[53][3]  = 8;
        tabParsing[53][12] = 6;
        tabParsing[53][17] = 7;
        tabParsing[53][23] = 9;
        tabParsing[54][2]  = 10;
        tabParsing[54][3]  = 10;
        tabParsing[54][7]  = 11;
        tabParsing[54][12] = 10;
        tabParsing[54][13] = 10;
        tabParsing[54][17] = 10;
        tabParsing[54][23] = 10;
        tabParsing[54][44] = 10;
        tabParsing[55][7]  = 12;
        tabParsing[56][2]  = 15;
        tabParsing[56][3]  = 18;
        tabParsing[56][12] = 14;
        tabParsing[56][17] = 17;
        tabParsing[56][23] = 16;
        tabParsing[57][36] = 26;
        tabParsing[57][43] = 27;
        tabParsing[58][5]  = 20;
        tabParsing[58][6]  = 21;
        tabParsing[58][7]  = 22;
        tabParsing[58][8]  = 23;
        tabParsing[58][9]  = 24;
        tabParsing[58][42] = 25;
        tabParsing[59][3]  = 28;
        tabParsing[59][12] = 28;
        tabParsing[59][17] = 28;
        tabParsing[59][23] = 28;
        tabParsing[60][37] = 29;
        tabParsing[60][42] = 30;
        tabParsing[61][1]  = 52;
        tabParsing[61][5]  = 37;
        tabParsing[61][6]  = 37;
        tabParsing[61][7]  = 37;
        tabParsing[61][8]  = 37;
        tabParsing[61][9]  = 37;
        tabParsing[61][14] = 49;
        tabParsing[61][16] = 64;
        tabParsing[61][20] = 67;
        tabParsing[61][21] = 69;
        tabParsing[61][22] = 68;
        tabParsing[61][24] = 39;
        tabParsing[61][37] = 38;
        tabParsing[61][43] = 37;
        tabParsing[62][18] = 32;
        tabParsing[62][35] = 33;
        tabParsing[63][5]  = 75;
        tabParsing[63][6]  = 75;
        tabParsing[63][7]  = 75;
        tabParsing[63][8]  = 75;
        tabParsing[63][9]  = 75;
        tabParsing[63][24] = 76;
        tabParsing[63][43] = 75;
        tabParsing[64][29] = 40;
        tabParsing[64][37] = 40;
        tabParsing[64][42] = 40;
        tabParsing[64][43] = 41;
        tabParsing[65][5]  = 44;
        tabParsing[65][6]  = 46;
        tabParsing[65][7]  = 48;
        tabParsing[65][8]  = 47;
        tabParsing[65][9]  = 45;
        tabParsing[66][40] = 43;
        tabParsing[66][42] = 42;
        tabParsing[67][26] = 56;
        tabParsing[67][27] = 55;
        tabParsing[67][28] = 53;
        tabParsing[67][30] = 58;
        tabParsing[67][32] = 57;
        tabParsing[67][45] = 54;
        tabParsing[68][19] = 50;
        tabParsing[68][37] = 51;
        tabParsing[69][5]  = 59;
        tabParsing[69][6]  = 60;
        tabParsing[69][7]  = 63;
        tabParsing[69][8]  = 62;
        tabParsing[69][9]  = 61;
        tabParsing[70][33] = 65;
        tabParsing[70][46] = 66;
        tabParsing[71][31] = 72;
        tabParsing[71][37] = 70;
        tabParsing[72][31] = 73;
        tabParsing[72][37] = 73;
        tabParsing[72][40] = 74;
        tabParsing[73][5]  = 80;
        tabParsing[73][6]  = 80;
        tabParsing[73][7]  = 80;
        tabParsing[73][8]  = 80;
        tabParsing[73][9]  = 80;
        tabParsing[73][43] = 80;
        tabParsing[74][29] = 79;
        tabParsing[74][34] = 77;
        tabParsing[74][37] = 79;
        tabParsing[74][42] = 79;
        tabParsing[74][47] = 78;
        tabParsing[75][5]  = 84;
        tabParsing[75][6]  = 85;
        tabParsing[75][7]  = 86;
        tabParsing[75][8]  = 88;
        tabParsing[75][9]  = 87;
        tabParsing[75][43] = 89;
        tabParsing[76][29] = 81;
        tabParsing[76][34] = 81;
        tabParsing[76][37] = 81;
        tabParsing[76][39] = 83;
        tabParsing[76][41] = 82;
        tabParsing[76][42] = 81;
        tabParsing[76][47] = 81;
    }
    
    void gravaVetProducoes(){
        vetProducoes[1]	 = 	"2;10;36;49;50;51;35";
        vetProducoes[2]	 =	"7;52;38;53;37;54";
        vetProducoes[3]	 =	"15";
        vetProducoes[4]	 =	"15";
        vetProducoes[5]	 =	"40;7;52";
        vetProducoes[6]	 =	"12";
        vetProducoes[7]	 =	"17";
        vetProducoes[8]	 =	"3";
        vetProducoes[9]	 =	"23";
        vetProducoes[10] =	"15";
        vetProducoes[11] =	"55;38;53;37;54";
        vetProducoes[12] =	"7;52";
        vetProducoes[13] =	"56;7;57;36;49;50;51;4;43;58;42;35;50";
        vetProducoes[14] =	"12";
        vetProducoes[15] =	"2";
        vetProducoes[16] =	"23";
        vetProducoes[17] =	"17";
        vetProducoes[18] =	"3";
        vetProducoes[19] =	"15";
        vetProducoes[20] =	"5";
        vetProducoes[21] =	"6";
        vetProducoes[22] =	"7";
        vetProducoes[23] =	"8";
        vetProducoes[24] =	"9";
        vetProducoes[25] =	"15";
        vetProducoes[26] =	"15";
        vetProducoes[27] =	"43;59;42";
        vetProducoes[28] =	"53;60";
        vetProducoes[29] =	"37;53;60";
        vetProducoes[30] =	"15";
        vetProducoes[31] =	"13;61;37;62;18";
        vetProducoes[32] =	"15";
        vetProducoes[33] =	"61;37;62";
        vetProducoes[34] =	"7;29;63";
        vetProducoes[35] =	"9;29;63";
        vetProducoes[36] =	"8;29;63";
        vetProducoes[37] =	"63;29;63";
        vetProducoes[38] =	"15";
        vetProducoes[39] =	"24;7;64";
        vetProducoes[40] =	"15";
        vetProducoes[41] =	"43;65;66;42";
        vetProducoes[42] =	"15";
        vetProducoes[43] =	"40;65;66";
        vetProducoes[44] =	"5";
        vetProducoes[45] =	"9";
        vetProducoes[46] =	"6";
        vetProducoes[47] =	"8";
        vetProducoes[48] =	"7";
        vetProducoes[49] =	"14;43;7;67;36;61;37;62;35;68";
        vetProducoes[50] =	"19;36;61;37;62;35";
        vetProducoes[51] =	"15";
        vetProducoes[52] =	"1;43;7;67;42;36;61;37;62;35";
        vetProducoes[53] =	"28;69";
        vetProducoes[54] =	"45;69";
        vetProducoes[55] =	"27;69";
        vetProducoes[56] =	"26;69";
        vetProducoes[57] =	"32;69";
        vetProducoes[58] =	"30;69";
        vetProducoes[59] =	"5";
        vetProducoes[60] =	"6";
        vetProducoes[61] =	"9";
        vetProducoes[62] =	"8";
        vetProducoes[63] =	"7";
        vetProducoes[64] =	"16;43;7;29;69;37;7;67;37;70;42;36;61;37;62;35";
        vetProducoes[65] =	"33;5";
        vetProducoes[66] =	"46;5";		
        vetProducoes[67] =	"20;36;61;37;62;35;1;43;7;67;42";
        vetProducoes[68] =	"22;25;7";
        vetProducoes[69] =	"21;31;11;71";
        vetProducoes[70] =	"15";
        vetProducoes[71] =	"31;7;72;71";
        vetProducoes[72] =	"31;11;71";
        vetProducoes[73] =	"15";
        vetProducoes[74] =	"40;7;72";
        vetProducoes[75] =	"73;74";
        vetProducoes[76] =	"24;7;64";
        vetProducoes[77] =	"34;73;74";
        vetProducoes[78] =	"47;73;74";
        vetProducoes[79] =	"15";
        vetProducoes[80] =	"75;76";
        vetProducoes[81] =	"15";
        vetProducoes[82] =	"41;75;76";
        vetProducoes[83] =	"39;75;76";
        vetProducoes[84] =	"5";
        vetProducoes[85] =	"6";
        vetProducoes[86] =	"7";
        vetProducoes[87] =	"9";
        vetProducoes[88] =	"8";
        vetProducoes[89] =	"43;63;42";
    }    
}
