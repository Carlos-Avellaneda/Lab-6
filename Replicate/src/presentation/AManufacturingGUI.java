package presentation;
import domain.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class AManufacturingGUI extends JFrame{  
    public static final int SIDE=11;

    public final int SIZE;
    private JButton ticTacButton;
    private JPanel  controlPanel;
    private PhotoAManufacturing photo;
    private AManufacturing aManufacturing;
    private JMenuBar menuBar;
    private JMenu menuFile;
    private JMenuItem menuItemNew, menuItemOpen, menuItemSave, menuItemExit, menuItemExport, menuItemImport;
   
    
    private AManufacturingGUI() {
        aManufacturing=new AManufacturing();
        SIZE=aManufacturing.getSize();
        prepareElements();
        prepareActions();
    }
    
    private void prepareElements() {
        setTitle("aManufacturing celular");
        photo=new PhotoAManufacturing(this);
        ticTacButton=new JButton("Tic-tac");
        setLayout(new BorderLayout());
        add(photo,BorderLayout.NORTH);
        add(ticTacButton,BorderLayout.SOUTH);
        setSize(new Dimension(SIDE*SIZE+15,SIDE*SIZE+72)); 
        setResizable(false);
        photo.repaint();
        prepareElementsMenu();
    }

    private void prepareElementsMenu() {
        menuBar = new JMenuBar();
        menuFile = new JMenu("Archivo");
        menuItemNew = new JMenuItem("Nuevo");
        menuItemOpen = new JMenuItem("Abrir");
        menuItemSave = new JMenuItem("Guardar como");
        menuItemExit = new JMenuItem("Salir");
        menuItemExport = new JMenuItem("Exportar Como");
        menuItemImport = new JMenuItem("Importar");


        if (menuFile != null) {
            menuFile.add(menuItemNew);
            menuFile.add(menuItemOpen);
            menuFile.add(menuItemSave);
            menuFile.add(menuItemImport);
            menuFile.add(menuItemExport);
            menuFile.addSeparator();
            menuFile.add(menuItemExit);
        }

        menuBar.add(menuFile);
        setJMenuBar(menuBar);
    }

    private void prepareActions(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);       
        ticTacButton.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    ticTacButtonAction();
                }
            });
        prepareActionsMenu();
    }

    private void prepareActionsMenu() {
        menuItemExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(
                        AManufacturingGUI.this,
                        "¿Está seguro de que desea salir?",
                        "Confirmar salida",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirm == JOptionPane.YES_OPTION) {
                    dispose(); // Cierra la ventana
                    System.exit(0);
                }
            }
        });

        menuItemNew.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                aManufacturing = new AManufacturing(); // Reinicia el juego o la aplicación
                photo.repaint(); // Vuelve a dibujar la interfaz
            }
        });

        menuItemOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(AManufacturingGUI.this);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    JOptionPane.showMessageDialog(AManufacturingGUI.this,
                            "La funcionalidad 'Abrir' esta en construcción.\nArchivo seleccionado: " + selectedFile.getName(),
                            "Abrir archivo", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        menuItemImport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(AManufacturingGUI.this);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    JOptionPane.showMessageDialog(AManufacturingGUI.this,
                            "La funcionalidad 'Importar' esta en construcción.\nArchivo seleccionado: " + selectedFile.getName(),
                            "Abrir archivo", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        menuItemSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showSaveDialog(AManufacturingGUI.this);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    JOptionPane.showMessageDialog(AManufacturingGUI.this,
                            "La funcionalidad 'Guardar' esta en construcción.\nArchivo seleccionado: " + selectedFile.getName(),
                            "Guardar archivo", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        menuItemExport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showSaveDialog(AManufacturingGUI.this);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    JOptionPane.showMessageDialog(AManufacturingGUI.this,
                            "La funcionalidad 'Exportar' esta en construcción.\nArchivo seleccionado: " + selectedFile.getName(),
                            "Guardar archivo", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    private void ticTacButtonAction() {
        aManufacturing.ticTac();
        photo.repaint();
    }

    public AManufacturing getaManufacturing(){
        return aManufacturing;
    }
    
    public static void main(String[] args) {
        AManufacturingGUI ca=new AManufacturingGUI();
        ca.setVisible(true);
    }  
}

class PhotoAManufacturing extends JPanel{
    private AManufacturingGUI gui;

    public PhotoAManufacturing(AManufacturingGUI gui) {
        this.gui=gui;
        setBackground(Color.white);
        setPreferredSize(new Dimension(gui.SIDE*gui.SIZE+10, gui.SIDE*gui.SIZE+10));         
    }


    public void paintComponent(Graphics g){
        AManufacturing aManufacturing=gui.getaManufacturing();
        super.paintComponent(g);
         
        for (int c=0;c<=aManufacturing.getSize();c++){
            g.drawLine(c*gui.SIDE,0,c*gui.SIDE,aManufacturing.getSize()*gui.SIDE);
        }
        for (int f=0;f<=aManufacturing.getSize();f++){
            g.drawLine(0,f*gui.SIDE,aManufacturing.getSize()*gui.SIDE,f*gui.SIDE);
        }       
        for (int f=0;f<aManufacturing.getSize();f++){
            for(int c=0;c<aManufacturing.getSize();c++){
                if (aManufacturing.getThing(f,c)!=null){
                    g.setColor(aManufacturing.getThing(f,c).getColor());
                    if (aManufacturing.getThing(f,c).shape()==Thing.SQUARE){                  
                        if (aManufacturing.getThing(f,c).isActive()){
                            g.fillRoundRect(gui.SIDE*c+1,gui.SIDE*f+1,gui.SIDE-2,gui.SIDE-2,2,2);
                        }else{
                            g.drawRoundRect(gui.SIDE*c+1,gui.SIDE*f+1,gui.SIDE-2,gui.SIDE-2,2,2);    
                        }
                    }else {
                        if (aManufacturing.getThing(f,c).isActive()){
                            g.fillOval(gui.SIDE*c+1,gui.SIDE*f+1,gui.SIDE-2,gui.SIDE-2);
                        } else {
                            g.drawOval(gui.SIDE*c+1,gui.SIDE*f+1,gui.SIDE-2,gui.SIDE-2);
                        }
                    }
                }
            }
        }
    }
}