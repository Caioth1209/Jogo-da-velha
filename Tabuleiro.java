import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tabuleiro {

    private static JFrame frame;
    private static JPanel panel;

    private static JButton botao_00;
    private static JButton botao_01;
    private static JButton botao_02;

    private static JButton botao_10;
    private static JButton botao_11;
    private static JButton botao_12;

    private static JButton botao_20;
    private static JButton botao_21;
    private static JButton botao_22;

    private static JLabel labelVez;

    public Tabuleiro(){
        initComponents();
    }

    public JButton[][] casaBotao = new JButton[3][3];

    private void initComponents(){
        frame = new JFrame();
        panel = new JPanel();

        frame.setTitle("Jogo da Velha");
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        panel.setLayout(null);

        labelVez = new JLabel();
        labelVez.setBounds(100,10,100,30);
        labelVez.setFont(new Font("sans-serif",1,14));
        panel.add(labelVez);

        casaBotao[0][0] = botao_00;
        casaBotao[0][1] = botao_01;
        casaBotao[0][2] = botao_02;
        casaBotao[1][0] = botao_10;
        casaBotao[1][1] = botao_11;
        casaBotao[1][2] = botao_12;
        casaBotao[2][0] = botao_20;
        casaBotao[2][1] = botao_21;
        casaBotao[2][2] = botao_22;

        jogar();

        frame.setVisible(true);
    }

    final String jogador1 = "X";
    final String jogador2 = "O";

    String vez = jogador1;

    String ganhador = "";

    public void jogar(){

        labelVez.setText("JOGADOR: " + vez);

        casaBotao[0][0] = new JButton();
        casaBotao[0][0].setBounds(50,50,100,100);
        casaBotao[0][0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               checaVez(casaBotao[0][0]);
            }
        });
        panel.add(casaBotao[0][0]);

        casaBotao[0][1] = new JButton();
        casaBotao[0][1].setBounds(145,50,100,100);
        casaBotao[0][1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checaVez(casaBotao[0][1]);
            }
        });
        panel.add(casaBotao[0][1]);

        casaBotao[0][2] = new JButton();
        casaBotao[0][2].setBounds(240,50,100,100);
        casaBotao[0][2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checaVez(casaBotao[0][2]);
            }
        });
        panel.add(casaBotao[0][2]);

        casaBotao[1][0] = new JButton();
        casaBotao[1][0].setBounds(50,145,100,100);
        casaBotao[1][0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checaVez(casaBotao[1][0]);
            }
        });
        panel.add(casaBotao[1][0]);

        casaBotao[1][1] = new JButton();
        casaBotao[1][1].setBounds(145,145,100,100);
        casaBotao[1][1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checaVez(casaBotao[1][1]);

            }
        });
        panel.add(casaBotao[1][1]);

        casaBotao[1][2] = new JButton();
        casaBotao[1][2].setBounds(240,145,100,100);
        casaBotao[1][2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checaVez(casaBotao[1][2]);
            }
        });
        panel.add(casaBotao[1][2]);

        casaBotao[2][0] = new JButton();
        casaBotao[2][0].setBounds(50,240,100,100);
        casaBotao[2][0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checaVez(casaBotao[2][0]);
            }
        });
        panel.add(casaBotao[2][0]);

        casaBotao[2][1] = new JButton();
        casaBotao[2][1].setBounds(145,240,100,100);
        casaBotao[2][1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checaVez(casaBotao[2][1]);
            }
        });
        panel.add(casaBotao[2][1]);

        casaBotao[2][2] = new JButton();
        casaBotao[2][2].setBounds(240,240,100,100);
        casaBotao[2][2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checaVez(casaBotao[2][2]);
            }
        });
        panel.add(casaBotao[2][2]);
    }

    public void mudarVez() {

        if (vez.equalsIgnoreCase(jogador2)) {
            vez = jogador1;
        } else {
            vez = jogador2;
        }

        labelVez.setText("JOGADOR: " + vez);

    }

    public void checaVez(JButton b){

        if (vez.equalsIgnoreCase(jogador1)){
            b.setText(vez);
            b.setEnabled(false);
            b.setFont(new Font("sans-serif",2,30));

            if (!verificaGanhador(vez)){
                mudarVez();
            }


        } else {
            b.setText(vez);
            b.setEnabled(false);
            b.setFont(new Font("sans-serif",2,30));


            if (!verificaGanhador(vez)){
                mudarVez();
            }
        }

    }

    public boolean verificaGanhador(String jogador){

        int horizontal = 0;
        int vertical = 0;
        boolean velha = true;
        boolean vence = false;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (casaBotao[i][j].getText().equals(jogador)){
                    horizontal++;
                }
                if (casaBotao[j][i].getText().equals(jogador)){
                    vertical++;
                }

                if (casaBotao[0][0].getText().equals(jogador) && casaBotao[1][1].getText().equals(jogador)
                        && casaBotao[2][2].getText().equals(jogador)){

                    ganhador = jogador;
                    vence = true;

                } else {

                    if (casaBotao[0][2].getText().equals(jogador) && casaBotao[1][1].getText().equals(jogador)
                            && casaBotao[2][0].getText().equals(jogador)){

                        ganhador = jogador;
                        vence = true;
                    }
                }
                if (casaBotao[i][j].getText().equals("")){
                    velha = false;
                }
            }

            if (horizontal == 3 || vertical == 3){
                ganhador = jogador;
                vence = true;
            } else {
                horizontal = 0;
                vertical = 0;
            }
        }

        if (vence){
            vence();
            frame.setVisible(false);
            Tabuleiro t = new Tabuleiro();
        } else {
            if (velha){
                velha();
                vence = true;
                frame.setVisible(false);
                Tabuleiro t = new Tabuleiro();
            }
        }

        return vence;

    }

    public void vence(){
        JOptionPane.showMessageDialog(frame,"PARABÉNS " + ganhador + ", VOCÊ GANHOU!");

    }

    public void velha(){
        JOptionPane.showMessageDialog(frame,"DEU VELHA!");
    }
}