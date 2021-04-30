package controller;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Contato;
import model.ContatoDao;

public class AgendaController implements Initializable{
		//tabs
	    @FXML
	    private Tab tab_edita;
	
	    @FXML
	    private Tab tab_cadastro;
	
	    @FXML
	    private Tab tab_consulta;
	
	    @FXML
	    private Button bt_edicao;

	    @FXML
	    private Button bt_cancel;

	    @FXML
	    private Button bt_deletar;

	    @FXML
	    private Button bt_cadastro;
	    
	    //text fields cadastro
	    @FXML
	    private TextField cad_id;
	    
	    @FXML
	    private TextField cad_nome;

	    @FXML
	    private TextField cad_sobrenome;
	    
	    @FXML
	    private TextField cad_idade;
	    
	    @FXML
	    private TextField cad_telefone;

	    //text fields editar	
	    @FXML
	    private TextField edit_id;
	   
	    @FXML
	    private TextField edit_nome;
	    
	    @FXML
	    private TextField edit_sobrenome;
	    
	    @FXML
	    private TextField edit_idade;
	    
	    @FXML
	    private TextField edit_telefone;

	    //colunas tabela
	    @FXML
	    private TableView<Contato> agenda;
	    
	    @FXML
	    private TableColumn<Contato, Long> list_id;
	    
	    @FXML
	    private TableColumn<Contato, String> list_nome;

	    @FXML
	    private TableColumn<Contato, String> list_sobrenome;

	    @FXML
	    private TableColumn<Contato, Integer> list_idade;
	    
	    @FXML
	    private TableColumn<Contato, String> list_telefone;

	    private ContatoDao dao;
	    
	    @Override
		public void initialize(URL arg0, ResourceBundle arg1) {	
		
	    	dao = new ContatoDao();
	    	
	        list_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		    
		    list_nome.setCellValueFactory(new PropertyValueFactory<>("nome"));

		    list_sobrenome.setCellValueFactory(new PropertyValueFactory<>("sobrenome"));

		    list_idade.setCellValueFactory(new PropertyValueFactory<>("idade"));
		    
		    list_telefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
		    
		    exibir();
			
		  
		}
	    
	    @FXML
	    void cadastroContato(ActionEvent event) {
	    	
	    	if(cad_id.getText().isEmpty()) {
	    		
		    	Contato contato = new Contato();
	    		
		    	contato.setNome(cad_nome.getText());
		    	contato.setSobrenome(cad_sobrenome.getText());
		    	contato.setIdade(Integer.parseInt(cad_idade.getText()));
		    	contato.setTelefone(cad_telefone.getText());
		    	
		    	try {
				
		    		dao.salvarDao(contato);
		    		
		    		mensagem("Contato salvo com sucesso");
		    		limpaFormulario();
		    		exibir();
		    		
				} catch (Exception e) {

					e.printStackTrace();
					
				}
	    		
	    	}else {
	    		System.out.println(cad_id.getText());
	    		mensagemErro("Esse cadastro já existe");
	    	}
	    	
	    }
	
	    @FXML
	    void visualizarCadastro(ActionEvent event) {

	    	if(agenda.getSelectionModel().getSelectedItem()==null) {
	    		mensagemErro("Não existe nenhum registro selecionado");
	    	}else {
	    		
	    		Contato contato = agenda.getSelectionModel().getSelectedItem();
	    		
	    		cad_id.setText(contato.getId().toString());
	    		cad_nome.setText(contato.getNome());
	    		cad_sobrenome.setText(contato.getSobrenome());
	    		cad_idade.setText(String.valueOf(contato.getIdade()));
	    		cad_telefone.setText(contato.getTelefone());
	    	}
	    	
	    	
	    }

	    @FXML 
	    void editarCadastro(ActionEvent event){
	    	Contato contato = new Contato();
    		
	    	contato.setId(Long.parseLong(cad_id.getText()));
	    	contato.setNome(cad_nome.getText());
	    	contato.setSobrenome(cad_sobrenome.getText());
	    	contato.setIdade(Integer.parseInt(cad_idade.getText()));
	    	contato.setTelefone(cad_telefone.getText());
	    
	    	try {
			
	    		dao.editarDao(contato);
	    		
	    		mensagem("Contato editado com sucesso");
	    		limpaFormulario();
	    		exibir();
			} catch (Exception e) {

				e.printStackTrace();
				
			}
	    }
	    
	    @FXML
	    void apagarCadastro(ActionEvent event) {
	    	
	    	if(agenda.getSelectionModel().getSelectedItem()== null){
	    		System.out.println("Não há funcionário selecionado");
	    	}else {
	    		if(mensagemConfirmacao("Deseja realmente apagar esse cadastro?")) {
	    		
	    			dao.deletarDao(agenda.getSelectionModel().getSelectedItem().getId());
	    			exibir();
	    			
	    		}
	    	}
	    }
	    
	    @FXML
	    void exibir() {
	    	
	    	List<Contato> lista = dao.consultarDao();
	    	
	    	if(!lista.isEmpty()) {
	    		agenda.setItems(FXCollections.observableList(lista));
	    	}
	    	
	    }
	    
	    @FXML
	    void limpaFormulario() {

	    	cad_id.clear();
	    	
	    	cad_nome.clear();

	  	    cad_sobrenome.clear();
	  	    
	  	    cad_idade.clear();
	  	    
	  	    cad_telefone.clear();

	    }
	
	    private void mensagem(String informacao) {
	    	Alert alert = new Alert(AlertType.INFORMATION);
	    	alert.setTitle("Mensagem do sistema");
	    	alert.setHeaderText(null);
	    	alert.setContentText(informacao);
	    	
	    	alert.showAndWait();
	    }
	    
	    private void mensagemErro(String informacao) {
	    	Alert alert = new Alert(AlertType.ERROR);
	    	alert.setTitle("Mensagem do sistema");
	    	alert.setHeaderText(null);
	    	alert.setContentText(informacao);
	    	
	    	alert.showAndWait();
	    }
	    
	    private boolean mensagemConfirmacao(String informacao) {
	    	Alert alert = new Alert(AlertType.CONFIRMATION);
	    	alert.setTitle("Mensagem do sistema");
	    	alert.setHeaderText(null);
	    	alert.setContentText(informacao);
	    	
	    	Optional<ButtonType> opcao = alert.showAndWait();
	    	
	    	if(opcao.get() == ButtonType.OK) {
	    		return true;
	    	}else {
	    		return false;
	    	}
	    }

}
