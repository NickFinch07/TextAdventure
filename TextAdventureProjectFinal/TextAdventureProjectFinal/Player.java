public class Player
{
  String name;
  int health;
  int enemyHealth;
  int numOfTouchesLanded;

  public Player(String playerName, int startingHealth, int startingEnemyHealth)
  {
    name = playerName;
    health = startingHealth;
    enemyHealth = startingEnemyHealth;
  }

  public String getName()
  {
    return name;
  }

  public void changeName(String newName)
  {
    name = newName;
  }

  public int getHealth()
  {
    return health;
  }

  public void takeDamage(int damage)
  {
    health = health - damage;
  }

  public int getEnemyHealth()
  {
    return enemyHealth;
  }

  public void damageEnemy(int enemyDamage)
  {
    enemyHealth = enemyHealth - enemyDamage;
  }

  public int getTouchesLanded()
  {
    return numOfTouchesLanded;
  }

  public void addToTouchTotal(int n)
  {
    numOfTouchesLanded += n;
  }
}