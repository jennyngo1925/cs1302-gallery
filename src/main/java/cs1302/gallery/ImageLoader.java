package cs1302.gallery;

import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.Priority;

/**
 * Custom component for the {@code VBox} class shorter.
 */
public class ImageLoader extends VBox {

    /** The container for the url textfield and the load image button. */
    HBox urlLayer;
    String URL;
    Button searchButton;
    
    /** The container for the loaded image. */
    ImageView imgView;

   /** A default image which loads when the application starts. */
    private static final String DEFAULT_IMG =
        "http://cobweb.cs.uga.edu/~mec/cs1302/gui/default.png";

    /** Default height and width for Images. */
    private static final int DEF_HEIGHT = 100;
    private static final int DEF_WIDTH = 100;

    /** Makes the Vbox the root and subgraph. */
    public ImageLoader() {
        super();
        this.urlLayer = new HBox(10);
        Image img = new Image(DEFAULT_IMG, DEF_HEIGHT, DEF_WIDTH, false, false);
        this.imgView = new ImageView(img);
        this.imgView.setPreserveRatio(true);
        EventHandler<ActionEvent> loadImgHandler = this::loadImage;
        //searchButton.setOnAction(this::loadImage);
        this.getChildren().addAll(urlLayer, imgView);
    } // ImageLoader

    public ImageLoader(Button searchButton) {
        this();
        this.searchButton = searchButton;
    } // ImageLoader
    
    public ImageLoader(String URL) {
        this();
        this.URL = URL;
    } // ImageLoader
    
    /**
     * Loads the image.
     *
     * @param e source event
     */ 
    private void loadImage(ActionEvent e) {

        try {
            Image newImg = new Image(URL, DEF_HEIGHT, DEF_WIDTH, false, false);
            this.imgView.setImage(newImg);
        } catch (IllegalArgumentException iae) {
            System.out.println("The supplied URL is invalid");
        } // try
        
    } // loadImage
    
} // ImageLoader
