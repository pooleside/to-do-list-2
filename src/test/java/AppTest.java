import java.util.ArrayList;
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void rootTest() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("Dictionary");
      //pageSource means html
  }

  @Test
  public void categoryIsCreatedTest(){
    goTo("http://localhost:4567/");//going to the home page-indicated by one slash / after server name
    click("a", withText("Add a new category"));
    fill("#name").with("garden");  //fill the input that has the ID of "description" with "Call home" on home.vtl page
    submit(".btn"); //on home.vtl page find type= "submit" with class btn.  The dot signifies "look for a class" Example line...<button type="submit" class="btn">GO!</button>
    assertThat(pageSource()).contains("Your category");
    //assertThat means "look for", pageSource is html
  }

  @Test
  public void categoryIsDisplayedTest() {
  goTo("http://localhost:4567/categories/new");
  fill("#name").with("garden");
  submit(".btn");
  click("a", withText("View categories"));
  assertThat(pageSource()).contains("garden");
  }

  @Test
  public void multiplecategoriesAreDisplayedTest(){
  goTo("http://localhost:4567/categories/new");
  fill("#name").with("garden");
  submit(".btn");
  goTo("http://localhost:4567/categories/new");
  fill("#name").with("tree");
  submit(".btn");
  click("a", withText("View categories"));    //Use 'click 'when you want to click a link.  "a" is referring to the html anchor tag.
  assertThat(pageSource()).contains("garden");
  assertThat(pageSource()).contains("tree");
  }

  @Test
  public void categorieshowPageDisplaysDescription() {
  goTo("http://localhost:4567/categories/new");
  fill("#name").with("garden");
  submit(".btn");
  click("a", withText("View categories"));
  click("a", withText("garden"));
  assertThat(pageSource()).contains("garden");
  }

 }
