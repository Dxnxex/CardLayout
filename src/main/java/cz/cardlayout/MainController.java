package cz.cardlayout;

import javafx.fxml.FXML;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainController {

    @FXML
    private ImageView imageView;

    @FXML
    private GridPane gridPane;

    // Seznam pro uchovávání obrázků
    private List<Image> images = new ArrayList<>();
    private List<String> supportedFormats = new ArrayList<>(Arrays.asList("*.png", "*.jpg", "*.jpeg", "*.gif"));


    public void initialize() {

        //Nahrát uložené obrázky do paměti
        loadImages();
        showImages();
    }


    /***
     * Vytvoří okno pro vyhledání obrázku a následné zkopírování (Upload do složky aplikace)
     */
    public void uploadImage() {

        // FileChooser pro výběr obrázku
        FileChooser fileChooser = new FileChooser();

            //Titulek okna při výběru
            fileChooser.setTitle("Vyber obrázek pro layout");

            //Podporované formáty
            FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter("Obrázky", supportedFormats);
            fileChooser.getExtensionFilters().add(imageFilter);

                // Získání vybraného souboru
                File selectedFile = fileChooser.showOpenDialog(imageView.getScene().getWindow());
                System.out.println("Selected file:" + selectedFile);

                if (selectedFile != null) {

                    saveImageToDisk(selectedFile);

                }


    }

    /***
     *  Vytvoření kopie obrázku do složky aplikace a následné nahrání do paměti
     * @param sourceFile
     */
    private void saveImageToDisk(File sourceFile) {
        try {

            // Definuj složku pro uložení obrázku a případné vytvoření složek.
            File destinationFile = new File("images/" + sourceFile.getName());
            destinationFile.getParentFile().mkdirs();

            // Uložení obrázku do souborů aplikace
            Files.copy(sourceFile.toPath(), destinationFile.toPath());
            System.out.println("Obrázek uložen na disk: " + destinationFile.getAbsolutePath());

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Chyba při ukládání obrázku.");
            }


            //Nahrání obrázků do paměti
            loadImages();

    }

    /***
     * Nahrání obrázků ze souboru do paměti
     */
    private void loadImages() {

        File folder = new File("images");

        File[] listOfFiles = folder.listFiles();
        images.clear();

        //Vypsání uložených obrázků
        for (File file : listOfFiles) {

            System.out.println(file.getName());
            System.out.println(file.getAbsolutePath() + "\n");

            Image image = new Image(file.toURI().toString());
            images.add(image);

            showImages();

        }
    }


    /***
     *  Zobrazení obrázku v GRIDU
     */
    private void showImages() {

        gridPane.getChildren().clear();

        //Setup
        int col = 0;

        //Přidání obrázku do gridu s pevnou výškou
        for(Image img:images){

            ImageView imageView = new ImageView(img);

            imageView.setFitHeight(80);
            imageView.setPreserveRatio(true);
            gridPane.add(imageView,col,0);

            //After
            col++;
        }

    }






}


