import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SeleniumTest {

  private WebDriver driver;
  private Select recipesDropdown;
  private Select levainIngredientDropdown;
  private Select doughIngredientDropdown;
  private WebElement levainInputQuantity;
  private WebElement doughInputQuantity;
  private WebElement addToLevainButton;
  private WebElement addToDoughButton;
  private WebElement recipeNameInput;
  private WebElement saveRecipeButton;
  private WebElement scalingSwitch;
  private WebElement deleteRecipe;
  private WebElement recipeName;
  WebElement inputNumLoaves;
  WebElement inputDropWeight;
  WebElement costPerLoaf;
  WebElement costPerBatch;

  @Before
  public void beforeClass() {
    driver = new ChromeDriver();

  }

  @Test
  public void testA_canSelectWalnutSourdough()  {
    driver.get("http://localhost:3000/view");
    driver.manage().window().maximize();
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    recipesDropdown = new Select(driver.findElement(By.id("recipe-selector")));
    recipesDropdown.selectByVisibleText("Walnut Sourdough");
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    recipeName = driver.findElement(By.id("recipeName"));
    assertEquals("Walnut Sourdough", recipeName.getText());
  }

  @Test
  public void testB_canSelectCiabatta()  {
    driver.get("http://localhost:3000/view");
    driver.manage().window().maximize();
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    recipesDropdown = new Select(driver.findElement(By.id("recipe-selector")));
    recipesDropdown.selectByVisibleText("Ciabatta");
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    recipeName = driver.findElement(By.id("recipeName"));
    assertEquals("Ciabatta", recipeName.getText());
  }

  @Test
  public void testC_canSelectFocaccia()  {
    driver.get("http://localhost:3000/view");
    driver.manage().window().maximize();
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    recipesDropdown = new Select(driver.findElement(By.id("recipe-selector")));
    recipesDropdown.selectByVisibleText("Focaccia");
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    recipeName = driver.findElement(By.id("recipeName"));
    assertEquals("Focaccia", recipeName.getText());
  }

  @Test
  public void testD_canScaleBeetroot()  {
    driver.get("http://localhost:3000/view");
    driver.manage().window().maximize();
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    recipesDropdown = new Select(driver.findElement(By.id("recipe-selector")));
    recipesDropdown.selectByVisibleText("Beetroot, Pumpkin Seed & Cumin Sourdough");
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    recipeName = driver.findElement(By.id("recipeName"));
    assertEquals("Beetroot, Pumpkin Seed & Cumin Sourdough", recipeName.getText());
    scalingSwitch = driver.findElement(By.id("react-switch-label"));
    scalingSwitch.click();
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    inputNumLoaves = driver.findElement(By.id("numLoaves"));
    inputDropWeight = driver.findElement(By.id("dropWeight"));
    inputNumLoaves.sendKeys("5");
    inputDropWeight.sendKeys("800");
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    costPerLoaf = driver.findElement(By.id("cost-per-loaf"));
    costPerBatch = driver.findElement(By.id("cost-per-batch"));
    assertEquals("Ingredient cost/loaf = £1.47", costPerLoaf.getText());
    assertEquals("£7.35", costPerBatch.getText());
  }


  @Test
  public void testE_canDeleteTourte()  {
    driver.get("http://localhost:3000/view");
    driver.manage().window().maximize();
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    recipesDropdown = new Select(driver.findElement(By.id("recipe-selector")));
    recipesDropdown.selectByVisibleText("Tourte au Seigle");
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    deleteRecipe = driver.findElement(By.id("recipe-delete"));
    deleteRecipe.click();
    Alert alert = driver.switchTo().alert();
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    alert.accept();

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    Boolean foundFlag = false;

    List<WebElement> recipes=recipesDropdown.getOptions();

    for(int i=0; i < recipes.size(); i++) {
      if (recipes.get(i).getText().equals("Tourte au Seigle")){
        foundFlag = true;
      }
    }
    assertEquals(false, foundFlag);

  }


  @Test
  public void testF_canCreateRecipe()  {
    driver.get("http://localhost:3000/create");
    driver.manage().window().maximize();
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    levainIngredientDropdown  = new Select(driver.findElement(By.id("levain-select")));
    doughIngredientDropdown  = new Select(driver.findElement(By.id("dough-select")));
    levainInputQuantity = driver.findElement(By.id("levain-input"));
    doughInputQuantity  = driver.findElement(By.id("dough-input"));
    addToLevainButton = driver.findElement(By.id("levain-button"));
    addToDoughButton = driver.findElement(By.id("dough-button"));
    recipeNameInput = driver.findElement(By.id("save-recipe-name"));
    saveRecipeButton = driver.findElement(By.id("save-recipe-button"));

    levainIngredientDropdown .selectByVisibleText("Flour - Strong Bread");
    levainInputQuantity.clear();
    levainInputQuantity.sendKeys("50");
    addToLevainButton.click();

    levainIngredientDropdown .selectByVisibleText("Water");
    levainInputQuantity.clear();
    levainInputQuantity.sendKeys("40");
    addToLevainButton.click();

    levainIngredientDropdown .selectByVisibleText("Starter - Wheat");
    levainInputQuantity.clear();
    levainInputQuantity.sendKeys("10");
    addToLevainButton.click();

    doughIngredientDropdown .selectByVisibleText("Flour - Strong Bread");
    doughInputQuantity.clear();
    doughInputQuantity.sendKeys("450");
    addToDoughButton.click();


    doughIngredientDropdown .selectByVisibleText("Water");
    doughInputQuantity.clear();
    doughInputQuantity.sendKeys("340");
    addToDoughButton.click();

    doughIngredientDropdown .selectByVisibleText("Sea Salt");
    doughInputQuantity.clear();
    doughInputQuantity.sendKeys("10");
    addToDoughButton.click();

    recipeNameInput.sendKeys("White Sourdough");
    saveRecipeButton.click();

    Alert alert = driver.switchTo().alert();
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    alert.accept();

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    driver.get("http://localhost:3000/view");
    driver.manage().window().maximize();
    recipesDropdown = new Select(driver.findElement(By.id("recipe-selector")));
    recipesDropdown.selectByVisibleText("White Sourdough");
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    recipeName = driver.findElement(By.id("recipeName"));
    assertEquals("White Sourdough", recipeName.getText());
  }

  @After
  public void after()  {
    driver.quit();
  }
}

