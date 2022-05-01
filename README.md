# JetSpace (Team 8)

## Team members

| Name          | Student ID    |  XP Core Value  |
| ------------- |---------------| --------------- |
| BingJiun Miu  | 015235233     |  Feedback       |
| Di Chen       | 015905760     |  Simplicity     |
| Jing Shu      | 015941146     |  Communication  |
| Yiyang Yin    | 015973217     |  Courage        |

## About the project


## Links to project videos
* [Stand-up meeting](https://youtu.be/Z2-zADDSuik)

## Project architecture
### UI Wireframes
* Start Screen
![image](https://user-images.githubusercontent.com/98684620/166135322-bd7f4c1d-7fd7-43d6-b952-761a55ff7e66.png)


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

### Composite Pattern
Different items should be displayed in Menu Screen. Composite pattern is used to let client treat these objects uniformly. The key of the Composite pattern is the interface IDisplayComponent, which declares operations that all composite object share for accessing and managing its child components, and also defines operation (setLocation()) that is specific to graphical objects.

![image](https://user-images.githubusercontent.com/98684620/165987438-2153fcbd-dbd5-4303-8d69-b070df2f4eaf.png)


## Project backlog and chart
* [Sprint Task Sheet](https://docs.google.com/spreadsheets/d/1DDuHcrnP0oVV-RvFCs6CP5kt70owV9LetTp2wmWGdMA/edit#gid=0)
* Burn down chart

* Weekly Scrum Task Board
   * Week 1
![image](https://user-images.githubusercontent.com/98684620/163939113-03e051f9-5370-4ed9-a92e-e52039ae3223.png)

   * Week 2
![image](https://user-images.githubusercontent.com/98684620/165194777-f464028b-ddce-4831-a19e-d856caa20d46.png)

## Individual Contributions and team journals
### Contributions

### Journals
* [BingJiun Miu's Journal](https://github.com/nguyensjsu/sp22-202-team-8/blob/main/journals/BingJiun%20Miu_Project_Journal.md)
* [Di Chen's Journal](https://github.com/nguyensjsu/sp22-202-team-8/blob/main/journals/Di%20Chen_Project_Journal.md)
* [Jing Shu's Journal](https://github.com/nguyensjsu/sp22-202-team-8/blob/main/journals/Jing%20Shu_Project_Journal.md)
* [Yiyang Yin's Journal](https://github.com/nguyensjsu/sp22-202-team-8/blob/main/journals/Yiyang%20Yin_Project_Journal.md)
