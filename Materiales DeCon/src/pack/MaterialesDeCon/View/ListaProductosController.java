package pack.MaterialesDeCon.View;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import pack.MaterialesDeCon.Main;
import pack.MaterialesDeCon.Model.Conexion;
import pack.MaterialesDeCon.Model.Producto;

public class ListaProductosController {
	ObservableList<Producto> lista = FXCollections.observableArrayList();
	Main main;
	Connection conn=null;
    Conexion con = new Conexion();
    Producto productito;
    @FXML
    private TableView<Producto> tablaProductos;

    @FXML
    private TableColumn<Producto, String> idCategoria;

    @FXML
    private TableColumn<Producto, String> nombreProducto;

    @FXML
    private TableColumn<Producto, String> categoriaProducto;

    @FXML
    private TableColumn<Producto, Number> price;

    @FXML
    private TableColumn<Producto, Number> existencia;

    @FXML
    private TableColumn<Producto, String> proveedor;
    @FXML
    private JFXButton eliminar;

    @FXML
    private JFXButton modificar;

    @FXML
    private JFXButton salir;
    
    static String c;
    
 
    @FXML
	public void initialize() throws SQLException {
		agregar();
		select();
		idCategoria.setCellValueFactory(cellData->cellData.getValue().getIdProducto());
		nombreProducto.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getNombreoProperty()));
		categoriaProducto.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getIdCategoriaProperty()));
		price.setCellValueFactory(c-> new SimpleFloatProperty(c.getValue().getPrecioUnitarioProperty()));
		existencia.setCellValueFactory(c-> new SimpleIntegerProperty(c.getValue().getExistenciaProperty()));
		proveedor.setCellValueFactory(new PropertyValueFactory<Producto, String>("idProvedor"));
		editPane.setVisible(false);

		seleccion();
		
	}
    
    public void iniciar(ActionEvent e) throws SQLException {
    	eliminar();
    	
    }
	
	public void select() throws SQLException {
		String consulta = "select * from MaterialesDeCon.dbo.Producto";
		conn = con.getConexion();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(consulta);
		while(rs.next()) {
			lista.add(new Producto(rs.getString(2), rs.getString(1), rs.getString(3), rs.getString(4), rs.getInt(6), rs.getFloat(5)));
		}
	}
	public void agregar() {
		tablaProductos.setItems(lista);
	}

	
	public void seleccion() throws SQLException{
		tablaProductos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Producto>() {

			@Override
			public void changed(ObservableValue<? extends Producto> observable, Producto oldValue, Producto newValue) {
				// TODO Auto-generated method stub
					c=newValue.getIdProductoProperty();
				
				
			}
		});
	}
	
	@FXML
	public void agregarProducto() {
		main.cagarRegistroProducto();
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
	 
	 
	 
	
	 ////////////// Editar
	 
	 @FXML 
	 AnchorPane materialesPane, editPane;
	 
	 @FXML
	 JFXTextField editNombre, editPrecio, editExistencia;
	 
	 @FXML
	 JFXComboBox editCategoria, editProveedor;
	 
	 private void ocultar() {
		 materialesPane.setVisible(false);
		 editPane.setVisible(false);
	 }
	 
	 @FXML
	 public void showEditView() {
		 ocultar();
		 editPane.setVisible(true);
	 }
	 
	 @FXML
	 public void editarProducto() {
		 String nombre = editNombre.getText();
		 float precio = Float.valueOf(editPrecio.getText());
		 int existencia = Integer.valueOf(editExistencia.getText());
		 
		 Alert alert = new Alert(AlertType.INFORMATION);
		 alert.setTitle("Éxito");
		 alert.setHeaderText(null);
		 alert.setContentText("El producto se ha modificado correctamente");
		 alert.showAndWait();
			
		 ocultar();
		 materialesPane.setVisible(true);
	 }
	 
	 @FXML
	 public void cancelar() {
		 ocultar();
		 materialesPane.setVisible(true);
	 }
	 
	 
	 
	 
}
