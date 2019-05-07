package calculariva;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CalcularIva extends JFrame implements ActionListener
{
    private JLabel mensaje;
    private JButton boton;
    private JTextField valor1, subtotal, total;
    private JComboBox iva;
    public String selectIva;
    
    public CalcularIva()
    {
        super();
        configurarVentana();
        crearComponentes();
    }
    
    private void configurarVentana()
    {
        this.setTitle("CALCULADORA DE IVA");//Titulo de ventana
        this.setSize(500,300);//Tamaño de ventana
        this.setLocationRelativeTo(null);//Localización de ventana
        this.setLayout(null);//Cuadricular la ventana para las posiciones
        this.setResizable(true);//Poder cambiar el tamaño de la pantalla
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//El boton de cerrar funciona 
    }
    
     private void crearComponentes()
    {
        mensaje = new JLabel();
        mensaje.setText("$");
        mensaje.setBounds(30, 30, 180, 30);
        this.add(mensaje);
        
        valor1 = new JTextField();
        valor1.setBounds(85, 30, 100, 30);
        this.add(valor1); 
        
        mensaje = new JLabel();
        mensaje.setText("IVA");
        mensaje.setBounds(30, 70, 100, 30);
        this.add(mensaje); 
        
        String[] ivaList= new String[] {"Seleccione IVA","16","8"};
        JComboBox<String> iva = new JComboBox<>(ivaList);
        iva.setBounds(85,70,120,30);
        iva.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                        selectIva = iva.getItemAt(iva.getSelectedIndex());
                }
        });
        this.add(iva);
        
        mensaje = new JLabel();
        mensaje.setText("Subtotal");
        mensaje.setBounds(30, 110, 100, 30);
        this.add(mensaje);
        
        subtotal = new JTextField();
        subtotal.setBounds(85, 110, 100, 30);
        subtotal.setEditable(false);
        this.add(subtotal);
        
        mensaje = new JLabel();
        mensaje.setText("Total");
        mensaje.setBounds(30, 150, 100, 30);
        this.add(mensaje);
        
        total = new JTextField();
        total.setBounds(85, 150, 100, 30);
        total.setEditable(false);
        this.add(total);
        
        boton = new JButton();
        boton.setText("Calcular");
        boton.setBounds(75, 190, 120, 30);
        boton.addActionListener(this);
        this.add(boton);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        double dinero = Double.parseDouble(valor1.getText());

        try
        {
            double subt = dinero * (Double.parseDouble(selectIva)/100);
            subtotal.setText(String.valueOf(subt));
            double tot = subt + (Double.parseDouble(valor1.getText()));
            total.setText(String.valueOf(tot));
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this, "Datos no validos");
        }        
    }
    
    public static void main(String[] args)
    {
        CalcularIva ventana = new CalcularIva();
        ventana.setVisible(true);
    }
}
