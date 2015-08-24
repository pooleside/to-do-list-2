import java.time.LocalDateTime;
import java.util.ArrayList;


public class Task {
  private static ArrayList<Task> instances = new ArrayList<Task>();
//these are the properties (buckets) where the class stores data
  private String mDescription;
  private LocalDateTime mCreatedAt;
  private boolean mCompleted;
  private int mId;

  //This is the constructor.  It creates a new category instance.
  public Task (String description) {
    mDescription = description;  //Filling the properties with parameter value
        mCompleted = false;  //giving it an initial value
    instances.add(this); //adding itself to a list.  When we are working inside an object we use keycategory 'this' to reference that object
    mId = instances.size(); //instances is the list.  Size is how many items are in the list.  Example: If there are 5 instances it will have any ID of 5
                            //Using the count as the ID at the time of creation.  You add it and then say "how big is it?"
  }
      //Method section
      //Method that gets the string from the properties.
      public String getDescription() {
        return mDescription; // do not put = because just returning a variable that is
                        //already filled by the constructor.  This is why we
                        //have a constructor.  We have created our getDescription
                        //method.
      }

      public LocalDateTime getCreatedAt() {
        return mCreatedAt;
      }

      public boolean isCompleted() {
        return mCompleted;
      }

      public int getId() {
        return mId;
      }

      public static ArrayList<Task> getAll() {
        return instances;
      }

      public void completecategory () {
        mCompleted = true;
      }

      public static Task find(int id) {          //the try-catch work flow.  Why do we use this?
        try{                                     //a way to catch user input mistakes and avoid error screen
          return instances.get(id -1);           //We tell java to 'try' to run a block of code and then to
        } catch (IndexOutOfBoundsException e) {  //catch certain exceptions and run some other code instead
          return null;                           //we use -1 because ArrayLists use the 0 index.  We will get
        }                                        //an IndexOutOfBoundsException and return null (nothing)
      }                                          //When we catch an exception we are creating an Excepion object
                                                //If you wanted to look at them(the mistakes the application in catching) use System.out.println(e.getStackTrace) in place of return null
      public static void clear () {
        instances.clear();
      }
}
