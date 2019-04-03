import java.awt.event.KeyEvent;
import javax.swing.UIManager;

public class Translator {

	public static void translator() {
		
		UIManager.put("OptionPane.yesButtonText", "Tak");
		UIManager.put("OptionPane.yesButtonMnemonic",""+KeyEvent.VK_T);
		UIManager.put("OptionPane.noButtonText", "Nie");
		UIManager.put("OptionPane.noButtonMnemonic",""+KeyEvent.VK_N);
		
        UIManager.put("FileChooser.lookInLabelText","Szukaj w");
        UIManager.put("FileChooser.lookInLabelMnemonic",""+KeyEvent.VK_W);
        UIManager.put("FileChooser.saveInLabelText","Zapisz w");
        UIManager.put("FileChooser.saveInLabelMnemonic",""+KeyEvent.VK_W);
        UIManager.put("FileChooser.fileNameLabelText","Nazwa pliku:");
        UIManager.put("FileChooser.filesOfTypeLabelText","Pliki typu:");
        
        UIManager.put("FileChooser.upFolderToolTipText","Poziom wy¿ej");
        UIManager.put("FileChooser.homeFolderToolTipText","Pulpit");
        UIManager.put("FileChooser.newFolderToolTipText","Nowy katalog");
        UIManager.put("FileChooser.listViewButtonToolTipText","Lista");
        UIManager.put("FileChooser.detailsViewButtonToolTipText","Szczegó³y");
        
        UIManager.put("FileChooser.fileNameHeaderText","Nazwa");
        UIManager.put("FileChooser.fileSizeHeaderText","Rozmiar");
        UIManager.put("FileChooser.fileTypeHeaderText","Typ");
        UIManager.put("FileChooser.fileDateHeaderText","Modyfikacja");
        UIManager.put("FileChooser.fileAttrHeaderText","Atrybuty");
        
        UIManager.put("FileChooser.newFolderErrorText","B³¹d podczas tworzenia katalogu");

        UIManager.put("FileChooser.saveButtonText","Zapisz");
        UIManager.put("FileChooser.saveButtonMnemonic",""+KeyEvent.VK_Z);

        UIManager.put("FileChooser.openButtonText","Otwórz");
        UIManager.put("FileChooser.openButtonMnemonic",""+KeyEvent.VK_O);
        
        UIManager.put("FileChooser.cancelButtonText","Anuluj");
        UIManager.put("FileChooser.cancelButtonMnemonic",""+KeyEvent.VK_A);
        
        UIManager.put("FileChooser.openDialogTitleText","Otwieranie");
        UIManager.put("FileChooser.saveDialogTitleText","Zapisywanie");
        UIManager.put("FileChooser.saveButtonToolTipText","Zapisanie pliku");
        UIManager.put("FileChooser.openButtonToolTipText","Otwarcie pliku");
        UIManager.put("FileChooser.cancelButtonToolTipText","Rezygnacja");
        UIManager.put("FileChooser.acceptAllFileFilterText","Wszystkie pliki");

		
	}
	
}


