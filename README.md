# JetSpace (Team 8)

## Team members

| Name          | Student ID    |  XP Core Value  |
| ------------- |---------------| --------------- |
| BingJiun Miu  | 015235233     |  Feedback       |
| Di Chen       | 015905760     |  Simplicity     |
| Jing Shu      | 015941146     |  Communication  |
| Yiyang Yin    | 015973217     |  Courage        |

## About the project
## Description 

## Feature Set
- Support both one player and two players mode
- Support player-to-player rescue in two-players mode
- Automatic level upgrade 
- Automatic buff objects release
- Shot obstacles to gain scores 
- Get buff objects to speedup/ shorten cooldown after shooting

## Links to project videos
* [Stand-up meeting](https://youtu.be/Z2-zADDSuik)

## Project architecture
### UI Wireframes
* Start Screen
  <img width="1101" alt="image" src="https://user-images.githubusercontent.com/90799662/166169722-7d798897-a194-4922-ae7c-b6aeb8873104.png">

* Game Screen - Two Players Mode
  <img width="1102" alt="image" src="https://user-images.githubusercontent.com/90799662/166169943-604959a9-48a6-45b2-8359-6fb50b59ebd6.png">

* Game Over Screen
  <img width="1101" alt="image" src="https://user-images.githubusercontent.com/90799662/166169680-c3ddc250-e7e0-40f3-920d-d47129e36a8e.png">

### High level diagrams


## Key feature designs
### Abstract Factory Pattern
The factory method is used to create item objects (button, label) for different screens: Menu Screen, Game Over Screen and Leaderboard Screen.
* AbstractFactory(IGlyphFactory): declares an interface for operations that create products.
* ConcreteFactory(MenuScreenGlyphFactory, GameOverScreenGlyphFactory, and LeaderboardScreenGlyphFactory): implements the factory method to create the concrete products for specific screen. So, the clients (Screens) could just use these products and be independent of how its products are created, composed and represented.
* AbstractProduct (Button, Label): declares an interface for a type of product object.
* ConcreteProduct (eg: startButton, tryAgainButton, screenTitle): defines a product object to be created by the corresponding concrete factory.
* Client(MenuScreen,GameOverScreen and LeaderboardScreen): uses a set of related products created in ConcreteFactory and doesn’t need to know how these products are created.

![image](https://user-images.githubusercontent.com/98684620/165898089-7f72e115-d58a-4c6e-8538-fb194c2a3705.png)

### Singleton Pattern
#### Factories as singletons
* An application typically needs only one instance of a ConcreteFactory per product family. So it’s usually best implemented as a singleton.
* In this project, MenuScreenGlyphFactory, GameOverScreenGlyphFactory, and LeaderboardScreenGlyphFactory are all implemented as singletons.

#### Settings as a singleton
* Users can select play mode in Menu Screen, which is stored in Settings Class.
* Settings must be exactly one instance of a class, and should be easily accessible to different Screens. 
* So it's perfectly implemented as a singleton
                                      
![image](https://user-images.githubusercontent.com/98684620/165899251-bd6243cf-52d1-429b-9af0-ec27061999df.png)
#### Subclasses of Buff as a singleton
* The user can get one buff object from the same class at a time, but there could be two buff objects from different classes.
* Introduced singleton pattern for subclasses of `Buff` to control the realse of buff object.

### Composite Pattern
Different items should be displayed in Menu Screen. Composite pattern is used to let client treat these objects uniformly. The key of the Composite pattern is the interface IDisplayComponent, which declares operations that all composite object share for accessing and managing its child components, and also defines operation (setLocation()) that is specific to graphical objects.

![image](https://user-images.githubusercontent.com/98684620/165987438-2153fcbd-dbd5-4303-8d69-b070df2f4eaf.png)

### Observer Pattern
#### Observer for Stopping Game
* Once game is over, current screen should be set to GameOver screen and all moving object should be stopped.
* To make sure all related objects will be stopped at the same time, we introduced observer pattern.

#### Observer for Upgrading Level
* Once the user has gained a specific amount of scores, it will trigger the level upgrade system and change the level state.
* To avoid tight coupling of socres and updating level, we introduced observer pattern.

### State Machine Pattern
* Totally we designed three levels, each level will add more obstacles than the previous one.
* To allow later extension, we introduced state machine pattern.

## Project backlog and chart
* [Sprint Task Sheet](https://docs.google.com/spreadsheets/d/1DDuHcrnP0oVV-RvFCs6CP5kt70owV9LetTp2wmWGdMA/edit#gid=0)
* Burn down chart

![Team 8 Burndown Chart](https://user-images.githubusercontent.com/90799662/167264001-e2251ba1-6fbe-429f-bef4-d10d6df2b987.svg)

* Weekly Scrum Task Board
   * Week 1
![image](https://user-images.githubusercontent.com/98684620/163939113-03e051f9-5370-4ed9-a92e-e52039ae3223.png)

   * Week 2
![image](https://user-images.githubusercontent.com/98684620/165194777-f464028b-ddce-4831-a19e-d856caa20d46.png)

   * Week 3
![image](https://user-images.githubusercontent.com/98684620/166723448-c5ab79a9-fbee-4cc7-91bb-33557c332211.png)

## Individual Contributions and team journals
### Contributions

### Journals
* [BingJiun Miu's Journal](https://github.com/nguyensjsu/sp22-202-team-8/blob/main/journals/BingJiun%20Miu_Project_Journal.md)
* [Di Chen's Journal](https://github.com/nguyensjsu/sp22-202-team-8/blob/main/journals/Di%20Chen_Project_Journal.md)
* [Jing Shu's Journal](https://github.com/nguyensjsu/sp22-202-team-8/blob/main/journals/Jing%20Shu_Project_Journal.md)
* [Yiyang Yin's Journal](https://github.com/nguyensjsu/sp22-202-team-8/blob/main/journals/Yiyang%20Yin_Project_Journal.md)
