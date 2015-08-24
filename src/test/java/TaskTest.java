import java.time.LocalDateTime;
import org.junit.*;
import static org.junit.Assert.*;
import static org.fluentlenium.core.filter.FilterConstructor.*;

public class taskTest {


  @Test
  public void task_instantiatesCorrectly_true(){
    task mytask = new task("garden tool");
    assertEquals(true, mytask instanceof task); //checking if an instance of the class will show up, therefore true.
  }

  @Test
  public void task_instantiatesWithDescription_true() {
    task mytask = new task ("garden tool");
    assertEquals("garden tool", mytask.getDescription());
  }
  @Test
  public void isCompleted_isFalseAfterInstantiaon_false() {
    task mytask = new task("garden tool");
    assertEquals(false, mytask.isCompleted());
  }


  @Test
  public void all_returnsAllInstancesOfcategory_true() {
    category firstcategory = new category("garden");
    category secondcategory = new category("flower");
    assertTrue(category.getAll().contains(firstcategory));
    assertTrue(category.getAll().contains(secondcategory));
  }

  @Test
  public void newId_taskInstantiateWithAnID_true() {
    task mytask = new task("garden tool");
    assertEquals(task.getAll().size(), mytask.getId());
  }

  @Test
  public void find_returnscategoryWithSameId_secondcategory() {
    category firstcategory = new category("garden");
    category secondcategory = new category("flower");
    assertEquals(category.find(secondcategory.getId()), secondcategory);
  }

  @Test
  public void find_returnsNullWhenNotaskFound_null() {
    assertTrue(task.find(999) == null);
  }

  @Test
  public void clear_emptiesAlltasksFromArrayList() {
    task mytask = new task("garden tool");
    task.clear();
    assertEquals(task.getAll().size(), 0);
  }
  @Rule
  public ClearRule clearRule = new ClearRule();


}
