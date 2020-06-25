package pack.MaterialesDeCon.View;


import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
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
   
 
    //static float cantidadInicial= Float.parseFloat(JOptionPane.showInputDialog(null, "Inserte el ingreso del dia: "));
	static float cantidadInicial = 0;
	
	public void cagarMenuUsuario(ActionEvent event) {
		verficarBotones();
		regisUser.setVisible(true);
		infoUser.setVisible(true);
	}
	
	public void cagarProductos(ActionEvent event) {
		verficarBotones();
		registroProducto.setVisible(true);
		acero.setVisible(true);
		madera.setVisible(true);
		azulejo.setVisible(true);
		cemento.setVisible(true);
		pintura.setVisible(true);
		lamina.setVisible(true);
	}
	
	public void cagarCaja(ActionEvent event) {
		verficarBotones();
		compra.setVisible(true);
		caja.setVisible(true);
	}
	
	public void cagarProveedores(ActionEvent event) {
		verficarBotones();
		regSuppiler.setVisible(true);
		seeSuppiler.setVisible(true);
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
	void cargarVenta(ActionEvent event) {
		Stage s = (Stage)compra.getScene().getWindow();
    	s.close();
		main.cargarVenta();
	}
	
	@FXML
	void cargarCaja(ActionEvent event) {
		main.cagarCorteCaja();
	}
	
	
	public void verficarBotones() {
		regisUser.setVisible(false);
		infoUser.setVisible(false);
		acero.setVisible(false);
		madera.setVisible(false);
		azulejo.setVisible(false);
		cemento.setVisible(false);
		pintura.setVisible(false);
		lamina.setVisible(false);
		registroProducto.setVisible(false);
		seeSuppiler.setVisible(false);
		regSuppiler.setVisible(false);
		caja.setVisible(false);
		compra.setVisible(false);
	}
	
	public Float ingresoInicial() {
		return cantidadInicial;
	}

	public void setMain(Main main) {
		this.main= main;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		TextInputDialog dialog = new TextInputDialog("Cantidad de Efectivo en caja");
		dialog.setTitle("Espere");
		dialog.setHeaderText("Por favor introduzca la cantidad de dinero en caja");
		dialog.setContentText("Cantidad:");

		// Traditional way to get the response value.
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
		    System.out.println("Cantidad de dinero " + result.get());
		    cantidadInicial = Float.parseFloat(result.get());
		}

//		// The Java 8 way to get the response value (with lambda expression).
//		result.ifPresent(name -> System.out.println("Your name: " + name));
	}
}
