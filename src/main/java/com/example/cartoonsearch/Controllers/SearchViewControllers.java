package com.example.cartoonsearch.Controllers;

import com.example.cartoonsearch.APIResponse;
import com.example.cartoonsearch.APIUtility;
import com.example.cartoonsearch.Cartoon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchViewControllers implements Initializable {

    @FXML
    private TextField searchTextField;

    @FXML
    private ListView<Cartoon> initialCartoonDataListView;

    @FXML
    private ImageView posterImageView;

    @FXML
    private Label errMsgLabel;

    @FXML
    private Button getDetailsButton;

    @FXML
    private void getSearchResults() throws IOException, InterruptedException {
        initialCartoonDataListView.getItems().clear();

        APIResponse apiResponse = APIUtility.getCartoonsFromOMDB(searchTextField.getText());
        if (apiResponse.getSearch() != null)
        {
            initialCartoonDataListView.getItems().addAll(apiResponse.getSearchSorted());
            setMovieFound(true, false);
        }
        else
            setMovieFound(false, false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       setMovieFound(false, false);
        errMsgLabel.setVisible(false);

        initialCartoonDataListView.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldMovie, movieSelected) -> {
                    try{

                        posterImageView.setImage(new Image(movieSelected.getImageUrl()));
                        setMovieFound(true,true);
//                        throw new Exception("invalid image");
                    }catch(Exception e)
                    {
                        posterImageView.setImage(new Image("images/defaultPoster.jpg"));
                    }
                });
    }

    /**
     * This method will turn visual element to be visible or not visible depending
     * on the state of the GUI
     **/

    private void setMovieFound(boolean movieFound, boolean movieSelected)
    {
        initialCartoonDataListView.setVisible(movieFound);
        getDetailsButton.setVisible(movieSelected);
        posterImageView.setVisible(movieSelected);
        errMsgLabel.setVisible(!movieFound);
    }

    @FXML
    private void getCartoonDetails(ActionEvent event) throws IOException, InterruptedException {
        String movieId = initialCartoonDataListView.getSelectionModel().getSelectedItem().getMalId();
        //SceneChanger.changeScenes(event, "movie-details-view.fxml", movieId);
    }




}

