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
                int contagiados =0;
                for (int f=0;f<e.size();f++){
                    if(Integer.parseInt(e.get(f))<2){
                        ++contagiados;
                    }
                }
                JOptionPane.showMessageDialog(null , "La cantidad de posibles contagiados es: "+contagiados , "ESTADISTICAS DEL COVID19" , JOptionPane.ERROR_MESSAGE);
                dispose();
            }
        };
       
        ActionListener contagiado = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {    
                estado=1;
                btn_china.setEnabled(false);
                btn_italia.setEnabled(false);
                btn_espana.setEnabled(false);
                btn_francia.setEnabled(false);
                btn_eeuu.setEnabled(false);
                btn_otro.setEnabled(false);
            }
        };
            
        ActionListener no_contagiado = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {    
                estado=2;
                btn_china.setEnabled(false);
                btn_italia.setEnabled(false);
                btn_espana.setEnabled(false);
                btn_francia.setEnabled(false);
                btn_eeuu.setEnabled(false);
                btn_otro.setEnabled(false);
            }
        };
        
        ActionListener recomendaciones = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (estado<2){
                    JOptionPane.showMessageDialog(null , "Buenos dìas. \nLamentamos informale que usted muy posiblemente este contagiado,\nle recomendamos que se remita al centro de salud mas cercano, usando tapaboca, guantes y lavando sus manos regularmente.\nMuchas gracias.","RECOMENDACIONES", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null , "Posiblemente este sano. Guarde cuarentena por favor ","RECOMENDACIONES",JOptionPane.ERROR_MESSAGE);
                }
            }
        };
             
        btn_recomendaciones.addActionListener(recomendaciones);
        btn_resultados.addActionListener(resultados);
         btn_china.addActionListener(contagiado);
         btn_italia.addActionListener(contagiado);
         btn_espana.addActionListener(contagiado);
         btn_francia.addActionListener(contagiado);
         btn_eeuu.addActionListener(contagiado);
         btn_otro.addActionListener(no_contagiado);
        
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
