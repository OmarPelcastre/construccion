package pack.MaterialesDeCon.View;


import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pack.MaterialesDeCon.Main;

public class PrincipalMenuController implements Initializable{
	Main main;
	@FXML
    private JFXButton productos;

    @FXML
    private JFXButton usuario;

    @FXML
    private JFXButton regisUser;

    @FXML
    private JFXButton infoUser;

    @FXML
    private JFXButton cemento;

    @FXML
    private JFXButton madera;

    @FXML
    private JFXButton acero;

    @FXML
    private JFXButton azulejo;

    @FXML
    private JFXButton pintura;

    @FXML
    private JFXButton lamina;
    @FXML
    private JFXButton registroProducto;
    @FXML
    private JFXButton compra;
    @FXML
    private JFXButton caja;
    @FXML
    private JFXButton seeSuppiler;
    @FXML
    private JFXButton regSuppiler;
    
    @FXML
    private AnchorPane userPane, provedoresPane, ventaPane, materialesPane, showUserInfoPane,
    addUserPane, addProveedorPane, editProveedorPane;
   
    @FXML
    private JFXTextField campoNombre, campoApellido, campoPuesto;
    @FXML
    private JFXTextField campoEmpresa, campoNombreContacto, campoTelefonoContacto;
        
    @FXML
    private JFXPasswordField campoPassword, campoPassword2;
 
    //static float cantidadInicial= Float.parseFloat(JOptionPane.showInputDialog(null, "Inserte el ingreso del dia: "));
	static float cantidadInicial = 0;
	
	public void cagarMenuUsuario(ActionEvent event) {
		verificarBotones();
		userPane.setVisible(true);
	}
	
	public void cagarProductos(ActionEvent event) {
		verificarBotones();
		registroProducto.setVisible(true);
		materialesPane.setVisible(true);
	}
	
	public void cagarCaja(ActionEvent event) {
		verificarBotones();
		ventaPane.setVisible(true);
	}
	
	public void cagarProveedores(ActionEvent event) {
		verificarBotones();
		provedoresPane.setVisible(true);
	}
	
	@FXML
	void cagarRegisProduc(ActionEvent event) {
		main.cagarRegistroProducto();
	}
	
	@FXML
	void cagarListaMateriales(ActionEvent event) {
		main.cargarListaMateriales();
	}
	
	@FXML
	void cargarListaProveedores() {
		main.cargarListaProveedores();
	}
	
	@FXML
	void cargarVenta(ActionEvent event) {
		Stage s = (Stage)compra.getScene().getWindow();
    	s.close();
		main.cargarVenta();
	}
	
	@FXML
	void cargarCaja(ActionEvent event) {
		main.cagarCorteCaja();
	}
	
	@FXML
	void cargarTickets() {
		main.cargarListaTickets();
	}
	
	public void verificarBotones() {
		provedoresPane.setVisible(false);
		ventaPane.setVisible(false);
		materialesPane.setVisible(false);
		userPane.setVisible(false);
		showUserInfoPane.setVisible(false);
		addUserPane.setVisible(false);
		addProveedorPane.setVisible(false);
		
	}
	
	public Float ingresoInicial() {
		return cantidadInicial;
	}

	public void setMain(Main main) {
		this.main= main;
	}
	
	@FXML
	public void showUserInfo() {
		verificarBotones();
		showUserInfoPane.setVisible(true);
	}
	
	@FXML
	public void cargarRegistroUsuario() {
		verificarBotones();
		addUserPane.setVisible(true);
	}
	
	@FXML
	public void registrarUsuario() {
		String nombre = campoNombre.getText();
		String apellido = campoApellido.getText();
		String puesto = campoPuesto.getText();
		
		System.out.println(nombre);
		System.out.println(apellido);
		System.out.println(puesto);
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Éxito");
		alert.setHeaderText(null);
		alert.setContentText("El usuario se ha registrado correctamente");
		alert.showAndWait();
		
		verificarBotones();
		userPane.setVisible(true);
	}
	
	@FXML
	public void registrarProveedor() {
		String empresa = campoEmpresa.getText();
		String nombre = campoNombreContacto.getText();
		String telefono  = campoNombreContacto.getText();
		
		System.out.println(empresa);
		System.out.println(nombre);
		System.out.println(telefono);
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Éxito");
		alert.setHeaderText(null);
		alert.setContentText("El proveedor se ha registrado correctamente");
		alert.showAndWait();
		
		verificarBotones();
		provedoresPane.setVisible(true);

		
	}
	
	@FXML
	public void cargarRegistroProveedor() {
		verificarBotones();
		addProveedorPane.setVisible(true);
	}
	
	
	@FXML
	public void showUsers() {
		main.cargarListaUsuarios();
	}
	
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		TextInputDialog dialog = new TextInputDialog("Cantidad de Efectivo en caja");
		dialog.setTitle("Espere");
		dialog.setHeaderText("Por favor introduzca la cantidad de dinero en caja");
		dialog.setContentText("Cantidad:");

		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
		    System.out.println("Cantidad de dinero " + result.get());
		    cantidadInicial = Float.parseFloat(result.get());
		}

		verificarBotones();
		acero.setVisible(true);
		madera.setVisible(true);
		azulejo.setVisible(true);
		cemento.setVisible(true);
		pintura.setVisible(true);
		lamina.setVisible(true);
		compra.setVisible(true);
		caja.setVisible(true);
		regSuppiler.setVisible(true);
		seeSuppiler.setVisible(true);
		regisUser.setVisible(true);
		infoUser.setVisible(true);
	}
}
