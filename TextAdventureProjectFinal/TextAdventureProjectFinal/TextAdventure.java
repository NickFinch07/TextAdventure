import java.util.*;

public class TextAdventure 
{
  FancyConsole console;
  Scanner inScanner;
  Player fencer;
  int randNum;
  String input;

  public TextAdventure()
  {
    console = new FancyConsole("Fencing Tournament!", 800, 800);
    inScanner = new Scanner(System.in);
    fencer = new Player("Your Name", 10, 10);
  }

  public void play()
  {
    // start of adventure. You can change this if you like
    console.setImage("DefaultPosition.png");

    // ask the user for their name.
    System.out.println("What is your name?\n");
    input = inScanner.nextLine();

    // Change fencer's name
    fencer.changeName(input);
    
    // describe the starting situation. Feel free to change this
    System.out.println("Welcome, "+ fencer.getName() +", to your first Fencing competition! \n Your first fight is against your average Joe \n What will be your first action? \nAttack: Attempt to land a hit on your opponent \nDefend: Even if your opponent attacks, you won't be punished for blocking \nParry: If your opponent attacks, you'll land a devastating counter-attack, but be sure he IS attacking!\n");

    // get user input and go to the appropriate zone based on their input
    defaultOption();
    

  }

    private void defaultOption(){
        while (!(input.equals("quit"))){
        System.out.println("What will you do?: ");
        input = inScanner.nextLine();
        if (input.equals("Attack") || input.equals("Defend") || input.equals("Parry")) {
            break;
        }
        System.out.print("Invalid Action. ");
    }
    if (input.equals("Attack")){
        randNum = (int)(Math.random() * 3) + 1;
        if (randNum == 1) {
            attackAttack();
        }
        else if (randNum == 2) {
            attackDefend();
        }
        else if (randNum == 3) {
            attackParry();
        }

    }
    else if (input.equals("Defend")) {
        randNum = (int)(Math.random() * 3) + 1;
        if (randNum == 1) {
            defendAttack();
        }
        else if (randNum == 2) {
            defendDefend();
        }
        else if (randNum == 3) {
            defendParry();
        }

    }

    else if (input.equals("Parry")) {
        randNum = (int)(Math.random() * 3) + 1;
        if (randNum == 1) {
            parryAttack();
        }
        else if (randNum == 2) {
            parryDefend();
        }
        else if (randNum == 3) {
            parryParry();
        }

    }
    }

    private void optionIfOpponentDefended(){
        while (!(input.equals("quit"))){
        System.out.println("What will you do?: ");
        input = inScanner.nextLine();
        if (input.equals("Attack") || input.equals("Defend") || input.equals("Parry")) {
            break;
        }
        System.out.print("Invalid Action. ");
    }
    if (input.equals("Attack")){
        randNum = (int)(Math.random() * 2) + 1;
        if (randNum == 1) {
            attackAttack();
        }
        else if (randNum == 2) {
            attackParry();
        }

    }
    else if (input.equals("Defend")) {
        randNum = (int)(Math.random() * 2) + 1;
        if (randNum == 1) {
            defendAttack();
        }
        else if (randNum == 2) {
            defendParry();
        }

    }
    
    else if (input.equals("Parry")) {
        randNum = (int)(Math.random() * 2) + 1;
        if (randNum == 1) {
            parryAttack();
        }
        else if (randNum == 2) {
            parryParry();
        }
    }
    }

    private void checkIfGameEnded() {
        if (fencer.getHealth() <= 0 || fencer.getEnemyHealth() <= 0) {
            gameEnd();
        }
    }

    private void attackAttack()
  {
    // change image
    console.setImage("attackAttack.png");

    // describe the area/situation to the user. 
    // Give them options for choices.
    System.out.println("Both you and your opponent attacked! You collide into each other.");
    fencer.takeDamage(1);
    System.out.println("");
    System.out.println("You took 1 damage. \nYour health: " + fencer.getHealth());
    fencer.damageEnemy(1);
    System.out.println("");
    System.out.println("You dealt 1 damage! \nEnemy Health: " + fencer.getEnemyHealth());

    // Take action or go to another zone based on their choice
    checkIfGameEnded();
    defaultOption();
  }

    private void attackDefend() {
    // change image
    // ADD CODE HERE
    console.setImage("attackDefend.png");

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE
    System.out.println("You attacked but your opponent defended! He blocked successfully but cannot do it again for 1 turn.");
    System.out.println("");
    System.out.println("You took 0 damage. \nYour health: " + fencer.getHealth());
    System.out.println("");
    System.out.println("You dealt 0 damage. \nEnemy Health: " + fencer.getEnemyHealth());

    // Take action or go to another zone based on their choice
    checkIfGameEnded();
    optionIfOpponentDefended();
  }

  private void attackParry()
  {
    // change image
    console.setImage("attackParry.png");

    // describe the area/situation to the user. 
    // Give them options for choices.
    System.out.println("You attacked but your opponent parried!");
    System.out.println("");
    fencer.takeDamage(1);
    System.out.println("Counterattack! You took 1 damage. \nYour health: " + fencer.getHealth());
    System.out.println("");
    System.out.println("You dealt 0 damage. \nEnemy Health: " + fencer.getEnemyHealth());
    // Take action or go to another zone based on their choice
    checkIfGameEnded();
    defaultOption();
    
  }

  private void defendAttack()
  {
    // change image
    console.setImage("defendAttack.png");

    // describe the area/situation to the user. 
    // Give them options for choices.
    System.out.println("Your opponent attacked but you defended successfully!");
    System.out.println("");
    System.out.println("You took 0 damage. \nYour health: " + fencer.getHealth());
    System.out.println("");
    System.out.println("You dealt 0 damage. \nEnemy Health: " + fencer.getEnemyHealth());

    // Take action or go to another zone based on their choice
    checkIfGameEnded();
    defaultOption();
    
  }

  private void defendDefend()
  {
    // change image
    console.setImage("defendDefend.png");

    // describe the area/situation to the user. 
    // Give them options for choices.
    System.out.println("Both you and your opponent went on the defense. You both just stood there, menacingly");
    System.out.println("");
    System.out.println("You took 0 damage. \nYour health: " + fencer.getHealth());
    System.out.println("");
    System.out.println("You dealt 0 damage. \nEnemy Health: " + fencer.getEnemyHealth());

    // Take action or go to another zone based on their choice
    checkIfGameEnded();
    defaultOption();
    
  }

  private void defendParry()
  {
    // change image
    console.setImage("defendParry.png");

    // describe the area/situation to the user. 
    // Give them options for choices.
    System.out.println("Your opponent expected you to attack and tried to parry, but you didn't fall for it!");
    System.out.println("");
    System.out.println("You took 0 damage. \nYour health: " + fencer.getHealth());
    System.out.println("");
    fencer.damageEnemy(2);
    System.out.println("You took advantage of your opponents failed parry. You dealt 2 damage. \nEnemy Health: " + fencer.getEnemyHealth());

    // Take action or go to another zone based on their choice
    checkIfGameEnded();
    defaultOption();
    
  }

  private void parryAttack()
  {
    // change image
    console.setImage("parryAttack.png");

    // describe the area/situation to the user. 
    // Give them options for choices.
    System.out.println("Counterattack! You successfully parried your opponent because they tried to attack!");
    System.out.println("");
    System.out.println("You took 0 damage. \nYour health: " + fencer.getHealth());
    System.out.println("");
    fencer.damageEnemy(2);
    System.out.println("You took advantage of your opponents failed attack. You dealt 2 damage. \nEnemy Health: " + fencer.getEnemyHealth());

    // Take action or go to another zone based on their choice
    checkIfGameEnded();
    defaultOption();
    
  }

  private void parryDefend()
  {
    // change image
    console.setImage("parryDefend.png");

    // describe the area/situation to the user. 
    // Give them options for choices.
    System.out.println("You expected your opponent to attack and tried to parry, but he didn't fall for it!");
    System.out.println("");
    fencer.takeDamage(2);
    System.out.println("He swiftly attacked you once you missed your parry. You took 2 damage. \nYour health: " + fencer.getHealth());
    System.out.println("");
    System.out.println("You dealt 0 damage. \nEnemy Health: " + fencer.getEnemyHealth());

    // Take action or go to another zone based on their choice
    checkIfGameEnded();
    defaultOption();
    
  }

  private void parryParry()
  {
    // change image
    console.setImage("parryParry.png");

    // describe the area/situation to the user. 
    // Give them options for choices.
    System.out.println("You expected your opponent to attack and tried to parry, but he also parried! Nothing Happened.");
    System.out.println("");
    System.out.println("You took 0 damage. \nYour health: " + fencer.getHealth());
    System.out.println("");
    System.out.println("You dealt 0 damage. \nEnemy Health: " + fencer.getEnemyHealth());


    // Take action or go to another zone based on their choice
    checkIfGameEnded();
    defaultOption();
    
  }

  private void gameEnd()
  {
    System.out.println("Game Over");
    if (fencer.getHealth() <= 0) {
      System.out.println("You lose!");
    }
    else if (fencer.getEnemyHealth() <= 0) {
      System.out.println("You win!");
    }
    input = "quit";

    inScanner.close();
  }
} 