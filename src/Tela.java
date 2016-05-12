

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class Tela extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	JList<Musicas> musicasDispField = new JList<Musicas>();
	JList<Musicas> minhasMusField = new JList<Musicas>();
	JList<Musicas> playlistField = new JList<Musicas>();
	DefaultListModel<Musicas> listaDisplay = new DefaultListModel<Musicas>();
	DefaultListModel<Musicas> listaDisplay1 = new DefaultListModel<Musicas>();
	DefaultListModel<Musicas> listaDisplay2 = new DefaultListModel<Musicas>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 940, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		JButton btnGet = new JButton("GET");
		btnGet.setAction(action_1);
		
		JToggleButton tglbtnBuy = new JToggleButton("Buy");
		tglbtnBuy.setAction(action);
		
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setAction(action_2);
		
		
		JLabel lblMsicasDisponveis = new JLabel("M\u00FAsicas Dispon\u00EDveis");
		lblMsicasDisponveis.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblSuasMsicas = new JLabel("Suas M\u00FAsicas");
		lblSuasMsicas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblPlaylist = new JLabel("Playlist");
		lblPlaylist.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(musicasDispField, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnGet)
						.addComponent(tglbtnBuy))
					.addGap(46)
					.addComponent(minhasMusField, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnAdicionar)
					.addGap(40)
					.addComponent(playlistField, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(15, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(36)
					.addComponent(lblMsicasDisponveis)
					.addGap(242)
					.addComponent(lblSuasMsicas)
					.addPreferredGap(ComponentPlacement.RELATED, 264, Short.MAX_VALUE)
					.addComponent(lblPlaylist)
					.addGap(90))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(257)
					.addComponent(btnAdicionar)
					.addContainerGap(301, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMsicasDisponveis)
						.addComponent(lblSuasMsicas)
						.addComponent(lblPlaylist))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(playlistField, GroupLayout.PREFERRED_SIZE, 506, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(minhasMusField, GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(musicasDispField, GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(btnGet)
										.addGap(183)
										.addComponent(tglbtnBuy))))
							.addGap(30))))
		);
		contentPane.setLayout(gl_contentPane);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Comprar");
			putValue(SHORT_DESCRIPTION, "Comprar música");
		}
		public void actionPerformed(ActionEvent e) {
			List<Musicas> lista = null;
			try {
				lista = new Stream().lerLista();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			listaDisplay1.addElement(musicasDispField.getSelectedValue());
			minhasMusField.setModel(listaDisplay1);
			listaDisplay.remove(listaDisplay.indexOf(musicasDispField.getSelectedValue()));
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Gerar lista");
			putValue(SHORT_DESCRIPTION, "Gera a lista de músicas disponíveis");
		}
		public void actionPerformed(ActionEvent e) {
			try {
				if (listaDisplay.size()>0){
					listaDisplay = new DefaultListModel<Musicas>();
					
				}
				List<Musicas> lista = new Stream().lerLista();
				for (Musicas musicas : lista) {
					listaDisplay.addElement(musicas);
				}
				musicasDispField.setModel(listaDisplay);

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Adicionar");
			putValue(SHORT_DESCRIPTION, "Adicionar a playlist");
		}
		public void actionPerformed(ActionEvent e) {
			listaDisplay2.addElement(minhasMusField.getSelectedValue());
			playlistField.setModel(listaDisplay2);
		}
	}
}
