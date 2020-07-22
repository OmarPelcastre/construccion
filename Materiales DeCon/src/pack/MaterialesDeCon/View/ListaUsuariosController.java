package pack.MaterialesDeCon.View;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import pack.MaterialesDeCon.Main;
import pack.MaterialesDeCon.Model.Conexion;
import pack.MaterialesDeCon.Model.Producto;
import pack.MaterialesDeCon.Model.Usuario;

public class ListaUsuariosController {
	ObservableList<Usuario> lista = FXCollections.observableArrayList();
	Main main;
	Connection conn=null;
    Conexion con = new Conexion();
    Producto productito;
    Usuario usuario;
    
    @FXML
    private AnchorPane listaPane, editUserPane; 
    
    @FXML
    private TableView<Usuario> tablaProductos;

    @FXML
    private TableColumn<Usuario, String> tableId;

    @FXML
    private TableColumn<Usuario, String> tableNombre;

    @FXML
    private TableColumn<Usuario, String> tableApellidos;

    @FXML
    private TableColumn<Usuario, String> tablePuesto;

  
    @FXML
    private JFXButton eliminar;

    @FXML
    private JFXButton modificar;

    @FXML
    private JFXButton salir;
    
    
    static String c;
    
 
    @FXML
	public void initialize() throws SQLException {
//		agregar();
//		select();
//		tableId.setCellValueFactory(cellData->cellData.getValue().getIdProducto());
//		tableNombre.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getNombreoProperty()));
//		tableApellidos.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getIdCategoriaProperty()));
//		tablePuesto.setCellValueFactory(c-> new SimpleFloatProperty(c.getValue().getPrecioUnitarioProperty()));
//		listaPane.setVisible(true);
//		
//		seleccion();
		 editUserPane.setVisible(false);

		
	}
    
    public void iniciar(ActionEvent e) throws SQLException {
    	eliminar();
    	
    }
	
	public void select() throws SQLException {
//		String consulta = "select * from MaterialesDeCon.dbo.Producto";
//		conn = con.getConexion();
//		Statement st = conn.createStatement();
//		ResultSet rs = st.executeQuery(consulta);
//		while(rs.next()) {
//			lista.add(new Producto(rs.getString(2), rs.getString(1), rs.getString(3), rs.getString(4), rs.getInt(6), rs.getFloat(5)));
//		}
	}
	public void agregar() {
		tablaProductos.setItems(lista);
	}

	
	public void seleccion() throws SQLException{
//		tablaProductos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Producto>() {
//
//			@Override
//			public void changed(ObservableValue<? extends Producto> observable, Producto oldValue, Producto newValue) {
//				// TODO Auto-generated method stub
//					c=newValue.getIdProductoProperty();
//				
//				
//			}
//		});
	}
	
	
	public void eliminar() throws SQLException{
		String consulta = "delete from MaterialesDeCon.dbo.Producto where idProducto ='"+c+"'";
		conn = con.getConexion();
		PreparedStatement st = conn.prepareStatement(consulta);
		st.executeUpdate();
		
		
	}
	public void setMain(Main main) {
			this.main=main;
	}
	
	private void ocultar() {
		listaPane.setVisible(false);
		editUserPane.setVisible(false);
	}
	
	@FXML
	public void editUser() {
		ocultar();
		editUserPane.setVisible(true);
	}
	
	
	///// edicion de Usuario
	
	@FXML
    private JFXTextField editNombre, editApellidos, editPuesto;

	
	@FXML
	public void guardarEdicionUsuario(){
		String nombre = editNombre.getText();
		String apellidos = editApellidos.getText();
		String puesto  = editPuesto.getText();
		
		System.out.println(nombre);
		System.out.println(apellidos);
		System.out.println(puesto);
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Éxito");
		alert.setHeaderText(null);
		alert.setContentText("El Usuario se ha modificado correctamente");
		alert.showAndWait();
		
		ocultar();
		listaPane.setVisible(true);
	}
	
	@FXML
	public void cancelar() {
		editNombre.setText("");
		editApellidos.setText("");
		editPuesto.setText("");
		ocultar();
		listaPane.setVisible(true);
	}
}
	
