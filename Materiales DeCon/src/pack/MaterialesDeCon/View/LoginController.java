package pack.MaterialesDeCon.View;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import pack.MaterialesDeCon.Main;

public class LoginController {
	Main main;
	
	@FXML
	private Button access;
	@FXML
	private JFXTextField user;
	@FXML
	private JFXPasswordField password;
	
	@FXML
	void cagarMenu(ActionEvent event) {
		System.out.println("Login");
		main.loadMenu();
	}
	
	public void setMain(Main main) {
		this.main= main;
	}

}
