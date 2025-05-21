import components.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

public class ProfileTest extends BaseTest {
    private LoginPage loginPage;
    private final String correctEmail = "daniil.butchenko@rambler.ru";
    private final String correctPassword = "test12345";

    @BeforeEach
    public void setUp() throws MalformedURLException {
        loginPage = new LoginPage(driver);
    }

    /*
        A5, A7, A8, A12 criterias.
    */
    @Test
    public void profileAboutMeForm_FillWithTextAndSave_TextStaysAfterReloading() {
        // Arrange
        var oldText = "oldText";
        var newText = "newText";

        // Act & Assert
        loginPage.login(correctEmail, correctPassword);
        loginPage.waitForLoginToComplete();
        var profilePage = loginPage.getHeader().openProfile();

        profilePage.fillAboutMeText(oldText);
        profilePage.refresh();
        Assertions.assertEquals(oldText, profilePage.getAboutMeText());


        profilePage.fillAboutMeText(newText);
        profilePage.refresh();
        Assertions.assertEquals(newText, profilePage.getAboutMeText());
    }
}
