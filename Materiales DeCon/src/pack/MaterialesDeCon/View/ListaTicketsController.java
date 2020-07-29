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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import pack.MaterialesDeCon.Main;
import pack.MaterialesDeCon.Model.Conexion;
import pack.MaterialesDeCon.Model.Producto;

public class ListaTicketsController {
	ObservableList<Producto> lista = FXCollections.observableArrayList();
	Main main;
	Connection conn=null;
    Conexion con = new Conexion();
    Producto productito;
    
    @FXML
    private AnchorPane listaPane, editProveedorPane; 
    
    @FXML
    private TableView<Producto> tablaProductos;

    @FXML
    private TableColumn<Producto, String> tablaId;

    @FXML
    private TableColumn<Producto, String> tablaSubTotal, tablaIVA;

    @FXML
    private TableColumn<Producto, String> tablaTotal;

    @FXML
    private TableColumn<Producto, String> tablaPago, tablaCambio;

  
    

    @FXML
    private JFXButton salir;
    
    
    static String c;
    
 
    @FXML
	public void initialize() throws SQLException {
//		agregar();
//		select();
//		idCategoria.setCellValueFactory(cellData->cellData.getValue().getIdProducto());
//		nombreProducto.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getNombreoProperty()));
//		categoriaProducto.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getIdCategoriaProperty()));
//		price.setCellValueFactory(c-> new SimpleFloatProperty(c.getValue().getPrecioUnitarioProperty()));
//		
//		
//		seleccion();
		ocultar();
		listaPane.setVisible(true);
		
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
		editProveedorPane.setVisible(false);
	}
	
	@FXML
	public void editProveedor() {
		ocultar();
		editProveedorPane.setVisible(true);
	}
	
	
	///// edicion de proveedor
	
	@FXML
    private JFXTextField editEmpresa, editContacto, editTelefono, editDireccion, editCiudad, editCodigo;

	
	@FXML
	public void guardarEdicionProveedor(){
		String empresa = editEmpresa.getText();
		
		
		System.out.println(empresa);
		
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Éxito");
		alert.setHeaderText(null);
		alert.setContentText("El proveedor se ha modificado correctamente");
		alert.showAndWait();
		
		ocultar();
		listaPane.setVisible(true);

	}
	
	@FXML
	public void cancelar() {
		editEmpresa.setText("");
		
		ocultar();
		listaPane.setVisible(true);
	}
}
	
