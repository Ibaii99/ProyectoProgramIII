package ventanas;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.sun.prism.paint.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.BorderLayout;

public class MenuAmistoso extends JFrame {
	/**
	 * @author Jorge
	 *
	 */
	public int anchura;
	public int altura;
	public int getAnchura() {
		return anchura;
	}
	public void setAnchura(int anchura) {
		this.anchura = anchura;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	

	public MenuAmistoso(int anchura, int altura) {
		setSize(626, 458);
		ImageIcon imageIcon = new ImageIcon(MenuAmistoso.class.getResource("/iconos/stadiumAmistoso.png"));
		Image image = imageIcon.getImage();
		
		Image newimg = image.getScaledInstance(anchura, altura,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		ImageIcon icRsz = new ImageIcon(newimg); 
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		final JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);
		
		final JComboBox cbLocal = new JComboBox();
		cbLocal.setBounds(120, 224, 150, 22);
		panel.add(cbLocal);
		
		final JButton btnIniciarAmistoso = new JButton("Iniciar amistoso");
		btnIniciarAmistoso.setBounds(207, 271, 159, 27);
		panel.add(btnIniciarAmistoso);
		btnIniciarAmistoso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Partido partido = new Partido(); //aqu� meter quiz� un constructor entre equipos
			}
		});
		btnIniciarAmistoso.setFont(new Font("Arial Black", Font.PLAIN, 13));
		
		final JLabel lblVisitante = new JLabel("Visitante");
		lblVisitante.setBounds(356, 203, 65, 19);
		panel.add(lblVisitante);
		lblVisitante.setFont(new Font("Arial Black", Font.PLAIN, 13));
		
		final JComboBox cbVisitante = new JComboBox();
		cbVisitante.setBounds(300, 224, 150, 22);
		panel.add(cbVisitante);
		
		final JLabel lblLocal = new JLabel("Local");
		lblLocal.setBounds(155, 203, 40, 19);
		panel.add(lblLocal);
		lblLocal.setFont(new Font("Arial Black", Font.PLAIN, 13));
		
		
		final JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 0, 0);
		panel.add(lblFondo);
		
			lblFondo.setIcon(icRsz);
			
			final JLabel lblEqL = new JLabel("");
			lblEqL.setBounds(130, 96, 100, 100);
			
			panel.add(lblEqL);
			
			final JLabel lblEqV = new JLabel("");
			lblEqV.setBounds(334, 96, 100, 100);
			panel.add(lblEqV);
		
			ImageIcon imageIconL = new ImageIcon(Inicio.class.getResource("/iconos/equipos/ala.png"));
			Image imagenResizL = imageIconL.getImage();
			Image iResizeoL = imagenResizL.getScaledInstance((int) Math.round(100*getWidth()/626), (int) Math.round(100*getWidth()/626),  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
			ImageIcon iiResizeoL = new ImageIcon(iResizeoL); 
			lblEqL.setIcon(iiResizeoL);
			
			ImageIcon imageIconV = new ImageIcon(Inicio.class.getResource("/iconos/equipos/rso.png"));
			Image imagenResizV = imageIconV.getImage();
			Image iResizeoV = imagenResizL.getScaledInstance((int) Math.round(100*getWidth()/626), (int) Math.round(100*getWidth()/626),  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
			ImageIcon iiResizeoV = new ImageIcon(iResizeoV); 
			lblEqV.setIcon(iiResizeoV);
			
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {
				ImageIcon imageIconR = new ImageIcon(Inicio.class.getResource("/iconos/stadiumAmistoso.png"));
				Image imagenResiz = imageIconR.getImage();
				
				Image iResizeo = imagenResiz.getScaledInstance(getWidth(), getHeight(),  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
				ImageIcon iiResizeo2 = new ImageIcon(iResizeo); 
				panel.setSize(getSize());
				lblFondo.setIcon(iiResizeo2);
				
				lblFondo.setBounds(0, 0, getWidth(), getHeight());
				getContentPane().revalidate();
				getContentPane().setSize(getSize());
				int nuevaFuente = (13*getWidth()/626);
				int nuevaAnchura =  (80*getWidth()/626);
				int nuevaAltura =  (20*getWidth()/626);
				int nuevaAnchuraBtn =  (159*getWidth()/626);
				int nuevaAlturaBtn =  (30*getWidth()/626);
				int nuevaAnchuraCb =  (150*getWidth()/626);
				int nuevaAlturaCb =  (22*getWidth()/626);
				int ladoIconoH = (int) Math.round(100*getWidth()/626);
				int ladoIconoV = (int) Math.round(100*getHeight()*1.36/626);
				lblLocal.setFont(new Font("Arial Black", Font.PLAIN, nuevaFuente));
				lblVisitante.setFont(new Font("Arial Black", Font.PLAIN, nuevaFuente));
				cbVisitante.setBounds((int) Math.round(((getWidth()/2)+(getWidth()*0.01))), (int) Math.round(((getHeight()/2)-(getHeight()*0.01))), nuevaAnchuraCb, nuevaAlturaCb);
				lblVisitante.setBounds((int) Math.round(((getWidth()/2)+(getWidth()*0.05))), (int) Math.round(((getHeight()/2)-(getHeight()*0.075))), nuevaAnchura, nuevaAltura);
				cbLocal.setBounds((int) Math.round(((getWidth()/2)-(getWidth()*0.31))), (int) Math.round(((getHeight()/2)-(getHeight()*0.01))), nuevaAnchuraCb, nuevaAlturaCb);
				lblLocal.setBounds((int) Math.round(((getWidth()/2)-(getWidth()*0.25))), (int) Math.round(((getHeight()/2)-(getHeight()*0.075))), nuevaAnchura, nuevaAltura);
				btnIniciarAmistoso.setBounds((int) Math.round(((getWidth()/2)-(getWidth()*0.15))), (int) Math.round(((getHeight()/2)+(getHeight()*0.2))), nuevaAnchuraBtn, nuevaAlturaBtn);
				btnIniciarAmistoso.setFont(new Font("Arial Black", Font.PLAIN, nuevaFuente));
				
				ImageIcon imageIconL = new ImageIcon(Inicio.class.getResource("/iconos/equipos/ala.png"));
				Image imagenResizL = imageIconL.getImage();
				Image iResizeoL = imagenResizL.getScaledInstance(ladoIconoH, ladoIconoV,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
				ImageIcon iiResizeoL = new ImageIcon(iResizeoL); 
				lblEqL.setIcon(iiResizeoL);
				lblEqL.setBounds((int) Math.round(((getWidth()/2)-(getWidth()*0.29))), (int) Math.round(((getHeight()/2)-(getHeight()*0.25))), ladoIconoH, ladoIconoV);
				
				ImageIcon imageIconV = new ImageIcon(Inicio.class.getResource("/iconos/equipos/rso.png"));
				Image imagenResizV = imageIconV.getImage();
				Image iResizeoV = imagenResizV.getScaledInstance(ladoIconoH, ladoIconoV,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
				ImageIcon iiResizeoV = new ImageIcon(iResizeoV); 
				lblEqV.setIcon(iiResizeoV);
				lblEqV.setBounds((int) Math.round(((getWidth()/2)+(getWidth()*0.02))), (int) Math.round(((getHeight()/2)-(getHeight()*0.25))), ladoIconoH, ladoIconoV);
				
				revalidate();
			}
		});
	}
}
