package windowbuilder.janela;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class janela extends JFrame {

	
	
	private JPanel contentPane;
	private JTextField textField_nome;
	private JTextField textField_snome;
	private JTextField textField_idade;
	private JTextField textField_id;
	private JTextField textField_telefone;
	private JTable table;
	
	ContatoDao dao = new ContatoDao();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					janela frame = new janela();
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
	public janela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 723, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_id = new JLabel("id:");
		label_id.setBounds(10, 14, 46, 14);
		contentPane.add(label_id);
		
		textField_id = new JTextField();
		textField_id.setBounds(33, 11, 100, 20);
		contentPane.add(textField_id);
		textField_id.setColumns(10);
		
		JLabel label_nome = new JLabel("nome:");
		label_nome.setBounds(10, 37, 46, 14);
		contentPane.add(label_nome);
		
		textField_nome = new JTextField();
		textField_nome.setBounds(10, 62, 123, 20);
		contentPane.add(textField_nome);
		textField_nome.setColumns(10);
		
		JLabel label_sobrenome = new JLabel("sobrenome");
		label_sobrenome.setBounds(10, 93, 100, 14);
		contentPane.add(label_sobrenome);
		
		textField_snome = new JTextField();
		textField_snome.setBounds(10, 118, 123, 20);
		contentPane.add(textField_snome);
		textField_snome.setColumns(10);
		
		JLabel label_idade = new JLabel("idade:");
		label_idade.setBounds(10, 149, 123, 14);
		contentPane.add(label_idade);
		
		textField_idade = new JTextField();
		textField_idade.setBounds(10, 174, 123, 20);
		contentPane.add(textField_idade);
		textField_idade.setColumns(10);
		
		JLabel label_telefone = new JLabel("telefone:");
		label_telefone.setBounds(10, 205, 46, 14);
		contentPane.add(label_telefone);
		
		textField_telefone = new JTextField();
		textField_telefone.setBounds(10, 230, 123, 20);
		contentPane.add(textField_telefone);
		textField_telefone.setColumns(10);
		
		JButton btnAdicionar = new JButton("adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = textField_nome.getText();
				String sobrenome = textField_snome.getText();
				int idade = Integer.parseInt(textField_idade.getText());
				String telefone = textField_telefone.getText();
				
				Contato c1 = new Contato();
				
				c1.setNome(nome);
				c1.setSobrenome(sobrenome);
				c1.setIdade(idade);
				c1.setTelefone(telefone);
				
				dao.salvarDao(c1);
				
				limpaRegistros();
				JOptionPane.showMessageDialog(btnAdicionar, "Usuário adicionado com sucesso.");
			}
		});
		btnAdicionar.setBounds(10, 277, 89, 23);
		contentPane.add(btnAdicionar);
		
		JButton btnListar = new JButton("listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				int num = table.getSelectedRow();
				
				textField_id.setText(table.getValueAt(num, 0).toString());
				textField_nome.setText(table.getValueAt(num, 1).toString());
				textField_snome.setText(table.getValueAt(num, 2).toString());
				textField_idade.setText(table.getValueAt(num, 3).toString());
				textField_telefone.setText(table.getValueAt(num, 4).toString());
				
			}
		});
		btnListar.setBounds(109, 277, 89, 23);
		contentPane.add(btnListar);
		
		JButton btnEditar = new JButton("editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				long id = Long.parseLong(textField_id.getText());
				String nome = textField_nome.getText();
				String sobrenome = textField_snome.getText();
				int idade = Integer.parseInt(textField_idade.getText());
				String telefone = textField_telefone.getText();
				
				Contato c1 = new Contato();
				
				c1.setId(id);
				c1.setNome(nome);
				c1.setSobrenome(sobrenome);
				c1.setIdade(idade);
				c1.setTelefone(telefone);
				
				dao.editarDao(c1);
				
				limpaRegistros();
				JOptionPane.showMessageDialog(btnEditar, "Usuário alterado com sucesso.");
			}
		});
		btnEditar.setBounds(218, 277, 89, 23);
		contentPane.add(btnEditar);
		
		JButton btnApagar = new JButton("apagar");
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int num = table.getSelectedRow();
				
				System.out.println(table.getValueAt(num, 0));
				
				long id = (long) table.getValueAt(num, 0);
				
				dao.deletarDao(id);
				limpaRegistros();
				JOptionPane.showMessageDialog(btnApagar, "Usuário deletado com sucesso.");
			}
		});
		btnApagar.setBounds(331, 277, 89, 23);
		contentPane.add(btnApagar);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(164, 11, 509, 238);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Nome", "Sobrenome", "Idade", "Telefone"
			}
		) {
			Class[] columnTypes = new Class[] {
				Long.class, String.class, String.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		mostraRegistros();
	}
	
	public void limpaTela() {
		textField_id.setText("");
		textField_nome.setText("");
		textField_snome.setText("");
		textField_idade.setText("");
		textField_telefone.setText("");
	} 
	
	public void mostraRegistros() {
		
		List<Contato> contatos = dao.consultarDao();
		
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		
		for(Contato contato: contatos) {
			
			modelo.addRow(new Object[] {contato.getId(),
					contato.getNome(),
					contato.getSobrenome(),
					contato.getIdade(),
					contato.getTelefone()});
		}
		
	}
	
	public void limpaRegistros(){
				
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
			modelo.setNumRows(0);
		
		limpaTela();
		mostraRegistros();	
	}
}