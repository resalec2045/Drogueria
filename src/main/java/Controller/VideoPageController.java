package Controller;

import Utils.NavBar;
import javafx.fxml.FXML;
import javafx.scene.web.WebView;

    public class VideoPageController {
        @FXML
        private WebView webView;

        public void initializeWithUrl(String url) throws Exception {
            webView.getEngine().load(url);
        }
        @FXML
        public void navToHome() {
            NavBar navBar = new NavBar();
            navBar.navigateToHomePage();
            webView.getEngine().load(null);
        }

        @FXML
        public void navToLogin() {
            NavBar navBar = new NavBar();
            navBar.navigateToLogin();
        }
    }
