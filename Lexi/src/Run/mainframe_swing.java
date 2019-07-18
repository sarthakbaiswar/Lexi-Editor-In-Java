/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Run;

import Utilities.Observer;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import structure.*;
import Utilities.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author Sarthak
 */
public class mainframe_swing extends JFrame implements KeyListener, ActionListener, Observer{
    
    private static final int TOP_MARGIN = 20;
    private static final int LEFT_MARGIN = 5;
    private Graphics graphics;
    private Controls controls;
    private Composition composed;
    private JFileChooser jFileChooser;
    private JMenuItem imageMenuItem;
    private JMenuItem aboutMenuItem;
    private JMenuItem exitMenuItem;
    private JMenuItem scrollMenuItem;
    private JMenuItem borderMenuItem;
    private JMenuItem saveMenuItem;
    private JMenuItem openMenuItem;
    private Compositor compositor;
    private int x1, y1, x2, y2;

    public mainframe_swing(Composition composed, Controls controls){		
        super();		

        this.composed = composed;
        this.controls = controls;
        this.composed.attach(this);
        this.compositor = new SimpleCompositor();

        this.setTitle("Lexi Editor");		
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBounds(500, 1000, 1000, 500);
        this.setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();		
        this.setJMenuBar(menuBar);

        JMenu FileMenu = new JMenu("File");
        menuBar.add(FileMenu);

        this.saveMenuItem = new JMenuItem(Constants.SaveText);
        this.saveMenuItem.addActionListener(this);
        FileMenu.add(this.saveMenuItem);

        this.openMenuItem = new JMenuItem(Constants.OpenText);
        this.openMenuItem.addActionListener(this);
        FileMenu.add(this.openMenuItem);

        this.imageMenuItem = new JMenuItem("Insert Image");
        this.imageMenuItem.addActionListener(this);
        FileMenu.add(imageMenuItem);		

        this.scrollMenuItem = new JMenuItem(Constants.ScrollOnText);
        this.scrollMenuItem.addActionListener(this);
        FileMenu.add(this.scrollMenuItem);
        
        this.borderMenuItem = new JMenuItem(Constants.BorderActivated);
        this.borderMenuItem.addActionListener(this);
        FileMenu.add(this.borderMenuItem);


        this.exitMenuItem = new JMenuItem("Exit");
        this.exitMenuItem.addActionListener(this);
        FileMenu.add(exitMenuItem);

        JMenu HelpMenu = new JMenu("Help");
        menuBar.add(HelpMenu);

        this.aboutMenuItem = new JMenuItem("About");
        this.aboutMenuItem.addActionListener(this);
        HelpMenu.add(aboutMenuItem);

        this.addKeyListener(this);
//        this.addComponentListener(this);

        this.setVisible(true);	

        this.x1 = this.y1 = -10;
        this.x2 = this.y2 = -20;

        this.graphics = this.getGraphics();
        this.controls.setGraphics(graphics);
    }	
        
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.imageMenuItem)){
            this.onInsertImageMenuItemClick(e);
        }
        else if (e.getSource().equals(this.scrollMenuItem)){
            this.handleScrolling();
        }
        else if (e.getSource().equals(this.borderMenuItem)){
            this.putborder();
        }
        else if (e.getSource().equals(this.aboutMenuItem)){
            JOptionPane.showMessageDialog(this, "Lexi editor implementation - By Sarthak Baiswar & Sushant Kumar", "Lexi", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (e.getSource().equals(this.exitMenuItem)){
            this.composed.detach(this);
            this.dispose();
        }
        else if (e.getSource().equals(this.saveMenuItem)) {
            this.handleSaveMenuItemClick();
        }
        else if (e.getSource().equals(this.openMenuItem)) {
            this.handleOpenMenuItemClick();
        }

    }
    
    @Override
    public void update(ChangeArgs args) {
        this.repaint();
    }

    private void putborder(){
        this.controls.onMenuItemPressed(new MenuArgs(this.borderMenuItem));
        if (this.borderMenuItem.getText() == Constants.BorderDeactivated){
                this.borderMenuItem.setText(Constants.BorderActivated);			
        }
        else{
                this.borderMenuItem.setText(Constants.BorderDeactivated);
        }
        this.repaint();
    }
    
    
    private void handleScrolling(){
        this.controls.onMenuItemPressed(new MenuArgs(this.scrollMenuItem));
        if (this.scrollMenuItem.getText() == Constants.ScrollOffText){
                this.scrollMenuItem.setText(Constants.ScrollOnText);			
        }
        else{
                this.scrollMenuItem.setText(Constants.ScrollOffText);
        }

        this.repaint();
    }
    
    private int getLeft(){
	return this.getInsets().left + LEFT_MARGIN;
    }
	
    private int getTop(){
        return this.getInsets().top + this.getJMenuBar().getHeight() + TOP_MARGIN;
    }

        
    private void onInsertImageMenuItemClick(ActionEvent evt){

        if (this.jFileChooser == null){
                this.jFileChooser = new JFileChooser();			
        }
        if(jFileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            try {
                String fullFilePath = jFileChooser.getSelectedFile().getAbsolutePath();
                ImageArgs args = new ImageArgs(this.getGraphics(), this.getTop(), this.getLeft(), this.getContentPane().getWidth(),
                                this.getContentPane().getHeight(), fullFilePath);
                this.controls.onImageInserted(args);

            }catch (Exception ex){
                ex.printStackTrace();				
            }
        }
    }
	
    private void handleSaveMenuItemClick() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Xml files", "xml");
        fileChooser.setFileFilter(filter);
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            this.controls.onSaveMenuItemClick(fileChooser.getSelectedFile().getAbsolutePath());
        }
    }

    private void handleOpenMenuItemClick() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Xml files", "xml");
        fileChooser.setFileFilter(filter);
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {			
            this.controls.onLoadMenuItemClick(fileChooser.getSelectedFile().getAbsolutePath());
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        KeyArgs param = new KeyArgs(this.graphics, this.getTop(), this.getLeft(), this.getContentPane().getWidth(),this.getContentPane().getHeight(), e, this.getFont());
        this.controls.onKeyPressed(param);
        this.repaint(1);	
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    
    /*Graphics method overriden*/
    @Override
    public void update(Graphics g){
        this.paint(g);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        ViewArgs param = new ViewArgs(this.graphics, this.getTop(), this.getLeft(), this.getWidth(),this.getHeight());
        List<Row> rows = this.compositor.compose(this.composed.getChildren(), param);
        this.controls.handleDocInput(rows, param);
    } 
  
}
