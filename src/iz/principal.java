package iz;

import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class principal extends javax.swing.JFrame {
    
    String[] vetor          = new String[49];
    String   vpos           = "";
    String   vpos_acum      = "";
    String   vvar           = "abcdefghijklmnopqrstuvxzyw0123456789-_";
    String   numint         = "0123456789";
    String   numdec         = "0123456789.";
    String   simbol         = "=<>+-{};:/*()!,";
    String   vacumtokens    = "";
    String   vacum_variavel = ""; 
    String   vacum_string   = "";
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
    
    String[] vettokens;
    String[] vlinha_token;
    String[] linhas;        
    
    private DefaultTableModel tabela;
    
    public principal() {
        initComponents();
        this.setLocationRelativeTo(this);
        gravaTokens();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPrinc = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTexto = new javax.swing.JTextArea();
        jAbas = new javax.swing.JTabbedPane();
        JPanesAnalise = new javax.swing.JScrollPane();
        JTableToken = new javax.swing.JTable();
        jPanelErros = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextoErros = new javax.swing.JTextArea();
        JMenuPrincipal = new javax.swing.JMenuBar();
        JMenuArquivo = new javax.swing.JMenu();
        jMenuNovo = new javax.swing.JMenuItem();
        JMenuSalvar = new javax.swing.JMenuItem();
        JMenuFechar = new javax.swing.JMenuItem();
        JMenuExecutar = new javax.swing.JMenu();
        jMenuExec = new javax.swing.JMenuItem();
        jmenuSobre = new javax.swing.JMenu();
        jMenuSob = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Compilado Léxico");

        jTexto.setColumns(20);
        jTexto.setRows(5);
        jTexto.setText("@wsa@cxs=\n\n");
        jScrollPane1.setViewportView(jTexto);

        JTableToken.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        JTableToken.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Linha", "Código", "Token"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JPanesAnalise.setViewportView(JTableToken);

        jAbas.addTab("Análise Léxica", JPanesAnalise);

        jTextoErros.setEditable(false);
        jTextoErros.setColumns(20);
        jTextoErros.setFont(new java.awt.Font("Monospaced", 0, 15)); // NOI18N
        jTextoErros.setRows(5);
        jScrollPane2.setViewportView(jTextoErros);

        javax.swing.GroupLayout jPanelErrosLayout = new javax.swing.GroupLayout(jPanelErros);
        jPanelErros.setLayout(jPanelErrosLayout);
        jPanelErrosLayout.setHorizontalGroup(
            jPanelErrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 699, Short.MAX_VALUE)
            .addGroup(jPanelErrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelErrosLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2)
                    .addContainerGap()))
        );
        jPanelErrosLayout.setVerticalGroup(
            jPanelErrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
            .addGroup(jPanelErrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelErrosLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jAbas.addTab("Erros", jPanelErros);

        javax.swing.GroupLayout jPanelPrincLayout = new javax.swing.GroupLayout(jPanelPrinc);
        jPanelPrinc.setLayout(jPanelPrincLayout);
        jPanelPrincLayout.setHorizontalGroup(
            jPanelPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jAbas))
                .addContainerGap())
        );
        jPanelPrincLayout.setVerticalGroup(
            jPanelPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jAbas, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jAbas.getAccessibleContext().setAccessibleName("Análise Léxica");

        JMenuArquivo.setText("Arquivo");

        jMenuNovo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuNovo.setText("Novo");
        jMenuNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuNovoActionPerformed(evt);
            }
        });
        JMenuArquivo.add(jMenuNovo);

        JMenuSalvar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        JMenuSalvar.setText("Salvar");
        JMenuSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenuSalvarActionPerformed(evt);
            }
        });
        JMenuArquivo.add(JMenuSalvar);

        JMenuFechar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        JMenuFechar.setText("Fechar");
        JMenuArquivo.add(JMenuFechar);

        JMenuPrincipal.add(JMenuArquivo);

        JMenuExecutar.setText("Executar");

        jMenuExec.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, 0));
        jMenuExec.setText("Executar");
        jMenuExec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuExecActionPerformed(evt);
            }
        });
        JMenuExecutar.add(jMenuExec);

        JMenuPrincipal.add(JMenuExecutar);

        jmenuSobre.setText("Sobre");

        jMenuSob.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jMenuSob.setText("Sobre");
        jMenuSob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSobActionPerformed(evt);
            }
        });
        jmenuSobre.add(jMenuSob);

        JMenuPrincipal.add(jmenuSobre);

        setJMenuBar(JMenuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelPrinc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrinc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuNovoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuNovoActionPerformed

    private void JMenuSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuSalvarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JMenuSalvarActionPerformed

    private void jMenuSobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSobActionPerformed
        JOptionPane.showMessageDialog(null,"Desenvolvedores: João Paulo Wessler e Tiago Behenck dos Santos");
    }//GEN-LAST:event_jMenuSobActionPerformed

    private void jMenuExecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuExecActionPerformed
        String verro = "";
        gravaTokens();
        LimparTabela();        
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
        
        jTextoErros.setText("");
        jAbas.setSelectedIndex(0);
        
        if (jTexto.getText().isEmpty()){
            jAbas.setSelectedIndex(1);
            jTextoErros.setText("ERRO - Nenhum programa foi informado!");
            return;
        }
        
        /** DIVIDE TODO PROGRAMA EM LINHAS **/
        linhas = jTexto.getText().split("\n");
        
        /** LENDO TODAS AS LINHAS **/
        for (int i = 0; i < linhas.length; i++){
            
            vabre_comentario_linha = false;
            
            linhas[i] = linhas[i].trim();
            
            /** LENDO OS CARACTERES DE CADA LINHA **/
            for (int y = 0; y < linhas[i].length(); y++){
                
                vpos = linhas[i].substring(y, y + 1);
                
                verro = "";
                verro = valida(linhas[i],vpos,i+1,y);
                
                if (!verro.isEmpty()){
                    jAbas.setSelectedIndex(1);
                    jTextoErros.setText(verro);
                    return;
                }
            }
            
            if (!vpos_acum.isEmpty()){
                jAbas.setSelectedIndex(1);
                jTextoErros.setText("ERRO - Comando: " + vpos_acum + " não encontrado!");
                return;
            }            
        }
        
        /** VERIFICA SE FICOU ALGUMA ABERTURA DE LITERAL E STRING EM ABERTO **/
        if (vabre_literal){
            jAbas.setSelectedIndex(1);
            jTextoErros.setText("ERRO - Existe abertura de String sem fechamento!");
            return;
        }
        
        if (vabre_string){
            jAbas.setSelectedIndex(1);
            jTextoErros.setText("ERRO - Existe abertura de Char sem fechamento!");
            return;
        }
        
        /** ADICIONA FINAL DE ARQUIVO A VARIAVEL DE TOKENS **/
        vacumtokens += String.valueOf(linhas.length) + "-48;";
        
        /** VALIDA QTD DE CHAVES E COMENTARIOS **/
        if (vqtabre_chave != vqtfech_chave){
            jAbas.setSelectedIndex(1);
            jTextoErros.setText("ERRO - Número de aberturas e fechamento de chaves divergem!");
            return;
        }
        
        if (vqtabre_comen != vqtfech_comen){
            jAbas.setSelectedIndex(1);
            jTextoErros.setText("ERRO - Número de aberturas e fechamento de comentários divergem!"); 
            return;
        }
        
        /** LE TODOS OS TOKENS ENCONTRADOS E MOSTRA NA TABELA **/
        if (!vacumtokens.isEmpty()){
            vettokens = vacumtokens.split(";");
            
            for (int i = 0; i < vettokens.length; i++){
                
                vlinha_token = vettokens[i].split("-");
                         
                JTableToken.setValueAt(vlinha_token[0], i, 0);
                JTableToken.setValueAt(vlinha_token[1], i, 1);
                JTableToken.setValueAt(vetor[Integer.parseInt(vlinha_token[1])], i, 2);
            }
        }
    }//GEN-LAST:event_jMenuExecActionPerformed
    
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
            if (vabre_literal)
                vabre_literal  = false;
            else{
                if (!vpos_acum.trim().isEmpty())
                    return "ERRO - Comando: " + vpos_acum + " descohecido. Linha: " + String.valueOf(i);
                                    
                vabre_literal  = true;
                
                vacumtokens += Integer.toString(i) + "-" + Integer.toString(11) + ";";
                vpos_acum = "";
            }
            
            return "";
        }
        
        if (vabre_literal)
            return "";
        
        /** TRATAMENTO CHAR/STRING **/
        if ((vabre_string) && (!vpos.equals("'"))){            
            vacum_string += vpos;            
            return "";
        }
        
        if (vpos.equals("'")){
            if (vabre_string){
                vabre_string = false;
                
                if (vacum_string.length() > 1)
                    vacumtokens += Integer.toString(i) + "-" + Integer.toString(9) + ";";
                else
                    vacumtokens += Integer.toString(i) + "-" + Integer.toString(8) + ";";
                
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

                    vacumtokens += Integer.toString(i+1) + "-" + Integer.toString(7) + ";";
                    vacum_variavel = "";
                    vabre_variavel = false;                    
                }
        
                return "";
            }
            else{
                if (vacum_variavel.length() < 1)
                    return "ERRO - Informe corretamente o nome da variável. Linha: " + String.valueOf(i);
                
                vacumtokens += Integer.toString(i) + "-" + Integer.toString(7) + ";";                
                vacum_variavel = "";
                
                if (!vpos.equals("@"))
                    vabre_variavel = false;
            }            
        }
        
        if (vpos.equals("@")){
            vabre_variavel = true;        
            return "";
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
            vacumtokens += Integer.toString(i) + "-" + Integer.toString(vtoken) + ";";
            vpos_acum = "";
        }
        
        /** CASO RETORNO SEJA NEGATIVO, SIGNIFICA QUE EXISTE ERRO **/
        if (vtoken < 0)            
            return "ERRO - Comando descohecido. Linha: " + String.valueOf(i);
        
        return "";
    }
    
    int procuraToken(String vlinha, String vcomando, int i, int y){
        int vcont = 0;
        boolean vachou = false;
        String vaux = "";
        
        for (int x = 1; x< vetor.length; x++){  
            
            if (vetor[x].length() > vcomando.length()){
                
                vaux  = vcomando;
                vcont = 0;
                
                if (!vaux.equals(vetor[x].substring(0,vaux.length())))
                    continue;
                
                do{
                    if ((y + vcont + 1) <= vlinha.length()){
                        
                        vaux = vcomando + vlinha.substring(y+1,y+vcont+1);
                        
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
        
        for (int x = 1; x< vetor.length; x++){
            if (vetor[x].equals(vcomando))
                return x;
        }
        
        return -1; 
    }
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu JMenuArquivo;
    private javax.swing.JMenu JMenuExecutar;
    private javax.swing.JMenuItem JMenuFechar;
    private javax.swing.JMenuBar JMenuPrincipal;
    private javax.swing.JMenuItem JMenuSalvar;
    private javax.swing.JScrollPane JPanesAnalise;
    private javax.swing.JTable JTableToken;
    private javax.swing.JTabbedPane jAbas;
    private javax.swing.JMenuItem jMenuExec;
    private javax.swing.JMenuItem jMenuNovo;
    private javax.swing.JMenuItem jMenuSob;
    private javax.swing.JPanel jPanelErros;
    private javax.swing.JPanel jPanelPrinc;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTexto;
    private javax.swing.JTextArea jTextoErros;
    private javax.swing.JMenu jmenuSobre;
    // End of variables declaration//GEN-END:variables

    void setLocationRelativeTo() {
        throw new UnsupportedOperationException("Not supported yet.");
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
        vetor[48] = "$";
    }
    
    void LimparTabela() {  
        int linhas = 0;  
        int colunas = 0;  
        String zer = null;  
  
        for (linhas = 0; linhas <= JTableToken.getRowCount() - 1; linhas++) {  
            for (colunas = 0; colunas <= JTableToken.getColumnCount() - 1; colunas++) {  
                JTableToken.setValueAt(zer, linhas, colunas);  
            }  
        }  
    }
}
