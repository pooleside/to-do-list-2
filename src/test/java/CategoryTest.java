import org.junit.*;
import java.util.ArrayList;
import static org.junit.Assert.*;
import static org.fluentlenium.core.filter.FilterConstructor.*;

public class categoryTest {


  @Test
  public void category_instantiatesCorrectly_true(){
    category mycategory = new category("dynamite");
    assertEquals(true, mycategory instanceof category); //checking if an instance of the class will show up, therefore true.
  }

  @Test
  public void category_instantiatesWithDescription_true() {
    category mycategory = new category ("garden");
    assertEquals("garden", mycategory.getName());
  }

  @Test
  public void getName_returnsName_true() {
    category mycategory = new category("garden");
    assertEquals("garden", mycategory.getName());
  }


  @Test
  public void all_returnsAllInstancesOfcategory_true() {
    category firstcategory = new category("garden");
    category secondcategory = new category("flower");
    assertTrue(category.getAll().contains(firstcategory));
    assertTrue(category.getAll().contains(secondcategory));
  }

  @Test
  public void newId_categoriesInstantiateWithAnID_true() {
    category mycategory = new category("garden");
    assertEquals(category.getAll().size(), mycategory.getId());
  }

  @Test
  public void find_returnscategoryWithSameId_secondcategory() {
    category firstcategory = new category("garden");
    category secondcategory = new category("flower");
    assertEquals(category.find(secondcategory.getId()), secondcategory);
  }

  @Test
  public void find_returnsNullWhenNocategoryFound_null() {
    assertTrue(category.find(999) == null);
  }

  @Test
  public void clear_emptiesAllcategoriesFromArrayList() {
    category mycategory = new category("garden");
    category.clear();
    assertEquals(category.getAll().size(), 0);
  }
  @Rule
  public ClearRule clearRule = new ClearRule();


}
