package com.example.cartoonsearch.Controllers;

import com.example.cartoonsearch.APIUtility;
import com.example.cartoonsearch.CartoonDetails;
import com.example.cartoonsearch.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class CartoonViewController {

    @FXML
    private Label cartoonTitleLabel;

    @FXML
    private Label episodeLabel;

    @FXML
    private Label airingLabel;

    @FXML
    private Label typeLabel;

    @FXML
    private Label scoreLabel;

    @FXML
    private Label startDateLabel;

    @FXML
    private Label endDateLabel;

    @FXML
    private ListView<String> synopsisListView;

    @FXML
    private ImageView imageView;


    @FXML

    void returnToBack(ActionEvent event) throws IOException, InterruptedException {
        SceneChanger.changeScenes(event,"search-view.fxml");

    }

    public void loadMovieDetails(String movieID) {

        CartoonDetails cartoon = null;
        try {
            cartoon = APIUtility.getCartoonDetails(cartoon.getMalId());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cartoonTitleLabel.setText(cartoon.getTitle());
        episodeLabel.setText(cartoon.getEpisodes());
        airingLabel.setText(cartoon.getAiring());
        typeLabel.setText(cartoon.getType());
        scoreLabel.setText(cartoon.getScore());
        startDateLabel.setText(cartoon.getStartDate());
        endDateLabel.setText(cartoon.getEndDate());
        synopsisListView.getItems().addAll(cartoon.getSynopsis());
        try{
            imageView.setImage(new Image(cartoon.getImageUrl()));
        }catch(Exception e)
        {
            imageView.setImage(new Image("default.jpg"));
        }
    }

}
