package grafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GUI_principal extends JFrame{

    public int estado=0;
    public int contagiados=0;
    public int contagiadosChina =0;
    public int contagiadosItalia =0;
    public int contagiadosEspana =0;
    public int contagiadosFrancia =0;
    public int contagiadosEEUU =0;
    public int contagiadosOtros=0;
    
    public GUI_principal(ArrayList<String> e){
    
        Color color_griso=new Color(49,49,49);
         Color color_grism=new Color(60,63,65);
         
        this.setTitle("TRIAGE CORONAVIRUS");
        this.setLayout(null);
        this.setSize(700,300);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(color_griso);
    
        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel lbl_texto = new JLabel("¿Viajo recientemente a alguno de los siguientes paises?");
        JButton btn_china = new JButton("China");
        JButton btn_italia = new JButton("Italia");
        JButton btn_espana = new JButton("España");
        JButton btn_francia = new JButton("Francia");
        JButton btn_eeuu = new JButton("EEUU");
        JButton btn_otro = new JButton("Otro");
        JButton btn_recomendaciones = new JButton("Ver recomendaciones");
        JButton btn_resultados = new JButton("Ver resultados");
        
        lbl_texto.setFont(new Font("Berlin Sans FB",Font.PLAIN,20));
        btn_china.setFont(new Font("Berlin Sans FB",Font.PLAIN,16));
        btn_italia.setFont(new Font("Berlin Sans FB",Font.PLAIN,16));
        btn_espana.setFont(new Font("Berlin Sans FB",Font.PLAIN,16));
        btn_francia.setFont(new Font("Berlin Sans FB",Font.PLAIN,16));
        btn_eeuu.setFont(new Font("Berlin Sans FB",Font.PLAIN,16));
        btn_otro.setFont(new Font("Berlin Sans FB",Font.PLAIN,16));
        btn_recomendaciones.setFont(new Font("Berlin Sans FB",Font.PLAIN,16));
        btn_resultados.setFont(new Font("Berlin Sans FB",Font.PLAIN,16));
        
        lbl_texto.setBounds(60, 10, 500, 30);
        panel.setBounds(40, 50, 600, 100);
        btn_china.setBounds(10, 60, 80, 30);
        btn_italia.setBounds(100, 60, 80, 30);
        btn_espana.setBounds(190, 60, 90, 30);
        btn_francia.setBounds(290, 60, 100, 30);
        btn_eeuu.setBounds(400, 60, 80, 30);
        btn_otro.setBounds(490, 60, 70, 30);
        btn_recomendaciones.setBounds(100, 200, 200, 30);
        btn_resultados.setBounds(400, 200, 200, 30);
        
        panel.setBackground(color_grism);
        lbl_texto.setForeground(Color.white);
        
        btn_recomendaciones.setEnabled(false);
        btn_resultados.setEnabled(false);
        
        panel.add(lbl_texto);
        panel.add(btn_china);
        panel.add(btn_italia);
        panel.add(btn_espana);
        panel.add(btn_francia);
        panel.add(btn_eeuu);
        panel.add(btn_otro);
        
        this.add(panel);
        this.add(btn_resultados);
        this.add(btn_recomendaciones);
        
        ActionListener resultados = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                for (int f=0;f<e.size();f++){
                    switch (Integer.parseInt(e.get(f))){
                        case 2:
                            ++contagiadosChina;
                            ++contagiados;
                        break;    
                        case 3:
                            ++contagiadosItalia;
                            ++contagiados;
                        break;
                        case 4:
                            ++contagiadosEspana;
                            ++contagiados;
                        break;
                        case 5:
                            ++contagiadosFrancia;
                            ++contagiados;
                        break;
                        case 6:
                            ++contagiadosEEUU;
                            ++contagiados;
                        break;
                        case 7:
                            ++contagiadosOtros;
                            ++contagiados;
                        break;
                        
                    }
                }
                JOptionPane.showMessageDialog(null , "La cantidad de contagiados en China es: "+contagiadosChina+"\nLa cantidad de contagiados en España es: "+contagiadosEspana+"\n La cantidad de contagiados en Italia es: "+contagiadosItalia+"\nLa cantidad de contagiados en Francia es: "+contagiadosFrancia+"\n La cantidad de contagiados en EEUU es: "+contagiadosEEUU+"\n La cantidad de contagiados en otros paises es : "+contagiadosOtros+"\n La cantidad TOTAL de posibles contagiados es: "+contagiados , "ESTADISTICAS DEL COVID19" , JOptionPane.WARNING_MESSAGE);
                
                dispose();
            }
        };
            
        ActionListener otro = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                btn_china.setEnabled(false);
                btn_italia.setEnabled(false);
                btn_espana.setEnabled(false);
                btn_francia.setEnabled(false);
                btn_eeuu.setEnabled(false);
                btn_otro.setEnabled(false);
                btn_recomendaciones.setEnabled(true);
                int confirmar = JOptionPane.showConfirmDialog(null,"¿Tiene usted sintomas como tos, fiebre o cansancio físico?","SINTOMATOLOGIA",JOptionPane.YES_NO_OPTION);
                if(confirmar==0){
                    estado=7;
                    e.add("7");
                }
                else{
                    estado=1;
                    e.add("1");
                }
            }
        };
        
        ActionListener recomendaciones = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (estado>1){
                    JOptionPane.showMessageDialog(null , "Lamentamos informale que usted muy posiblemente este contagiado de COVID-19\nle recomendamos quedarse en casa y llamar al 123\nPor favor use tapaboca\nMuchas gracias.","RECOMENDACIONES", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null , "Posiblemente este sano\nPor favor guarde cuarentena en su casa y haga un lavado de manos frecuente\nMuchas gracias.","RECOMENDACIONES",JOptionPane.INFORMATION_MESSAGE);
                }
                btn_resultados.setEnabled(true);
            }
        };
        
        ActionListener contadorChina = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                estado=2;
                btn_china.setEnabled(false);
                btn_italia.setEnabled(false);
                btn_espana.setEnabled(false);
                btn_francia.setEnabled(false);
                btn_eeuu.setEnabled(false);
                btn_otro.setEnabled(false);
                btn_recomendaciones.setEnabled(true);
                e.add("2");
            }
        };
        
        ActionListener contadorItalia = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                estado=3;
                btn_china.setEnabled(false);
                btn_italia.setEnabled(false);
                btn_espana.setEnabled(false);
                btn_francia.setEnabled(false);
                btn_eeuu.setEnabled(false);
                btn_otro.setEnabled(false);
                btn_recomendaciones.setEnabled(true);
                e.add("3");
            }
        };
        
        ActionListener contadorEspana = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                estado=4;
                btn_china.setEnabled(false);
                btn_italia.setEnabled(false);
                btn_espana.setEnabled(false);
                btn_francia.setEnabled(false);
                btn_eeuu.setEnabled(false);
                btn_otro.setEnabled(false);
                btn_recomendaciones.setEnabled(true);
                e.add("4");
            }
        };
        
        ActionListener contadorFrancia = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                estado=5;
                btn_china.setEnabled(false);
                btn_italia.setEnabled(false);
                btn_espana.setEnabled(false);
                btn_francia.setEnabled(false);
                btn_eeuu.setEnabled(false);
                btn_otro.setEnabled(false);
                btn_recomendaciones.setEnabled(true);
                e.add("5");
            }
        };
        
        ActionListener contadorEEUU = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                estado=6;
                btn_china.setEnabled(false);
                btn_italia.setEnabled(false);
                btn_espana.setEnabled(false);
                btn_francia.setEnabled(false);
                btn_eeuu.setEnabled(false);
                btn_otro.setEnabled(false);
                btn_recomendaciones.setEnabled(true);
                e.add("6");
            }
        };
        btn_recomendaciones.addActionListener(recomendaciones);
        btn_resultados.addActionListener(resultados);
        btn_china.addActionListener(contadorChina);
        btn_italia.addActionListener(contadorItalia);
        btn_espana.addActionListener(contadorEspana);
        btn_francia.addActionListener(contadorFrancia);
        btn_eeuu.addActionListener(contadorEEUU);
        btn_otro.addActionListener(otro);
        
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}