package application;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TrocoGulosoController {

	@FXML
	private Label res;

	@FXML
	private TextField conta;

	@FXML
	private TextField Pagamento;

	@FXML
	private Button btnCalcular;
	
	@FXML
	void procuraTroco(ActionEvent event) {
		if (Double.parseDouble(Pagamento.getText()) < Double.parseDouble(conta.getText())) {
			res.setText("\nPagamento insuficiente, faltam R$"+ String.format("%.2f", Double.parseDouble(conta.getText()) - Double.parseDouble(Pagamento.getText())));
		}else {
			
			int nota[] = {100, 50, 20, 10, 5, 2, 1};
			int centavos[] = {50, 25, 10, 5, 1};
			
			String result;
			double troco;
			int i, vlr, ct;

			troco = Double.parseDouble(Pagamento.getText()) - Double.parseDouble(conta.getText());
			result ="\nTroco = R$"+ String.format("%.2f", troco) +"\n\n";
			
			vlr = (int)troco;
			
			i = 0;
			
			while (vlr != 0) {
				ct = vlr / nota[i]; 
				if (ct != 0) {
					result = result + (ct +"nota(s) de R$"+ nota[i] +"\n");
					vlr = vlr % nota[i]; 
				}
				i = i + 1; 
			}

			result = result +"\n";

			vlr = (int)Math.round((troco - (int)troco) * 100);
			i = 0;
			while (vlr != 0) {
				ct = vlr / centavos[i]; 
				if (ct != 0) {
					result = result + (ct +"moeda(s) de"+ centavos[i] +
							"centavo(s)\n");
					vlr = vlr % centavos[i]; 
				}
				i = i + 1; 
			}
			this.res.setText(result);
		}
	}
}
