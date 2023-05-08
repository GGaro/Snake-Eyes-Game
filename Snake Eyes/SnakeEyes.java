import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.util.Random;
public class SnakeEyes extends JFrame implements ChangeListener, ActionListener 
{  
    //Declare Variables

    int ValueColor = 1;
    int D1R;
    int D2R;
    int rolls = 0;
    int sum;
    int D1Rtemp;
    int D2Rtemp;
    boolean win = false;
    boolean point = false;
    boolean end = false;

    //Declare the Buttons

    JButton Play;
    JButton Help;
    JButton Settings;
    JButton X;
    JButton Roll;
    JButton PlayAgain;

    //Declare the Dice

    JButton Diceset11;
    JButton Diceset12;
    JButton Diceset13;
    JButton Diceset14;
    JButton Diceset15;
    JButton Diceset16;

    JButton Diceset21;
    JButton Diceset22;
    JButton Diceset23;
    JButton Diceset24;
    JButton Diceset25;
    JButton Diceset26;

    JButton DiceColorSet;

    //Declare the Panels

    JPanel StartMenu;
    JPanel InSettings;
    JPanel InGame;
    JPanel InGameMenu;
    JPanel DiceResult;
    JPanel ColorText;
    JPanel WhatYouNeedPanel;

    //Declare the Labels

    JLabel How_to;
    JLabel Background;
    JLabel ColorInfo;
    JLabel Result1;
    JLabel Result2;
    JLabel WhatYouNeed;

    //Declare the text fields

    JTextField ColorType;
    JTextField Result;

    //Declare the Images

    ImageIcon back;

    ImageIcon Dice1ico;
    ImageIcon Dice2ico;
    ImageIcon Dice3ico;
    ImageIcon Dice4ico;
    ImageIcon Dice5ico;
    ImageIcon Dice6ico;

    //Declare the Sliders

    JSlider color;

    //Extra Objects

    Random random = new Random();
    TitledBorder title;

    public SnakeEyes()
    {
        setTitle("Snake Eyes");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Preloading assets 
        back = new ImageIcon("Assets/Background/Background.jpg");

        Dice1ico = new ImageIcon("Assets/Dice/1.png");
        Dice2ico = new ImageIcon("Assets/Dice/2.1.png");
        Dice3ico = new ImageIcon("Assets/Dice/3.1.png");
        Dice4ico = new ImageIcon("Assets/Dice/4.png");
        Dice5ico = new ImageIcon("Assets/Dice/5.png");
        Dice6ico = new ImageIcon("Assets/Dice/6.1.png");  

        //Make a How to play

        How_to = new JLabel("<html>Snake-Eyes rules: <br> If you get a 7 or 11 on the first roll you win, if you get 2 , 3 or 12 you lose,<br> if you get any other number then you have to reroll it again in order to win,<br> however if you get a 7 on a roll after the first one then you lose.</html>");
        How_to.setVisible(false);
        How_to.setEnabled(false);
        How_to.setForeground(Color.WHITE);

        //Make the Dice 

        Diceset11 = new JButton(Dice1ico);
        Diceset12 = new JButton(Dice2ico);
        Diceset13 = new JButton(Dice3ico);
        Diceset14 = new JButton(Dice4ico);
        Diceset15 = new JButton(Dice5ico);
        Diceset16 = new JButton(Dice6ico);

        Diceset11.setBackground(Color.WHITE);
        Diceset12.setBackground(Color.WHITE);
        Diceset13.setBackground(Color.WHITE);
        Diceset14.setBackground(Color.WHITE);
        Diceset15.setBackground(Color.WHITE);
        Diceset16.setBackground(Color.WHITE);

        Diceset11.setEnabled(false);
        Diceset12.setEnabled(false);
        Diceset13.setEnabled(false);
        Diceset14.setEnabled(false);
        Diceset15.setEnabled(false);
        Diceset16.setEnabled(false);

        Diceset21 = new JButton(Dice1ico);
        Diceset22 = new JButton(Dice2ico);
        Diceset23 = new JButton(Dice3ico);
        Diceset24 = new JButton(Dice4ico);
        Diceset25 = new JButton(Dice5ico);
        Diceset26 = new JButton(Dice6ico);

        Diceset21.setBackground(Color.WHITE);
        Diceset22.setBackground(Color.WHITE);
        Diceset23.setBackground(Color.WHITE);
        Diceset24.setBackground(Color.WHITE);
        Diceset25.setBackground(Color.WHITE);
        Diceset26.setBackground(Color.WHITE);

        Diceset21.setEnabled(false);
        Diceset22.setEnabled(false);
        Diceset23.setEnabled(false);
        Diceset24.setEnabled(false);
        Diceset25.setEnabled(false);
        Diceset26.setEnabled(false);

        DiceColorSet = new JButton(Dice5ico);
        DiceColorSet.setBackground(Color.WHITE);
        DiceColorSet.setEnabled(false);

        //Add the Buttons

        Play = new JButton("Play");
        Help = new JButton("Help");
        Settings = new JButton("Settings");
        X = new  JButton("X");
        Roll = new JButton("Roll");
        PlayAgain = new JButton("Play Again");

        //Buttons Settings

        Play.setBorderPainted(false);
        Help.setBorderPainted(false);
        Settings.setBorderPainted(false);
        X.setVisible(false);
        X.setEnabled(false);
        PlayAgain.setVisible(false);
        PlayAgain.setEnabled(false);

        //Add the Text Fields

        ColorType = new JTextField(6);
        ColorType.setText("White");
        ColorType.setEditable(false);

        Result = new JTextField(20);
        Result.setText("Roll a 7 or 11 to win!");
        Result.setEditable(false);

        //Add the Sliders

        color = new JSlider(SwingConstants.HORIZONTAL, 1, 13, 1);

        //Slider Settings

        color.setMajorTickSpacing(1);  
        color.setSnapToTicks(true);

        //Add the Panels

        StartMenu = new JPanel();
        InSettings = new JPanel();
        InGame = new JPanel();
        InGameMenu = new JPanel();
        DiceResult = new JPanel();
        ColorText = new JPanel();
        WhatYouNeedPanel = new JPanel();

        //Add the Labels

        Background = new JLabel(back);
        ColorInfo = new JLabel("Color: ");
        Result1 = new JLabel();
        Result2 = new JLabel();
        WhatYouNeed = new JLabel("What you need: ");
        WhatYouNeed.setForeground(Color.white);
        Result1.setBackground(Color.WHITE);
        Result2.setBackground(Color.WHITE);

        //Set Up the Panels
        StartMenu.setLayout(new BoxLayout(StartMenu, BoxLayout.Y_AXIS));
        StartMenu.add(Play);
        StartMenu.add(Help);
        StartMenu.add(Settings);
        StartMenu.setOpaque(false);

        ColorText.setLayout(new BoxLayout(ColorText, BoxLayout.X_AXIS));
        ColorText.add(ColorInfo);
        ColorText.add(ColorType);
        ColorText.setOpaque(false);

        InSettings.setLayout(new BoxLayout(InSettings, BoxLayout.Y_AXIS));
        InSettings.add(ColorText);
        InSettings.add(color);
        InSettings.add(DiceColorSet);  

        InSettings.setEnabled(false);
        InSettings.setVisible(false);

        WhatYouNeedPanel.setLayout(new BoxLayout(WhatYouNeedPanel, BoxLayout.Y_AXIS));
        WhatYouNeedPanel.add(WhatYouNeed);
        WhatYouNeedPanel.add(Result);
        WhatYouNeedPanel.setOpaque(false);

        InGameMenu.setLayout(new FlowLayout());
        InGameMenu.add(WhatYouNeedPanel);
        InGameMenu.add(Roll);
        InGameMenu.add(PlayAgain);
        InGameMenu.setOpaque(false);

        InGame.setLayout(new BoxLayout(InGame, BoxLayout.X_AXIS));
        InGame.add(InGameMenu);
        InGame.setOpaque(false);

        DiceResult.setLayout(new BoxLayout(DiceResult, BoxLayout.X_AXIS));
        DiceResult.add(Result1);
        DiceResult.add(Result2);
        DiceResult.add(InGame);
        DiceResult.setEnabled(false);
        DiceResult.setVisible(false);
        DiceResult.setOpaque(false);

        //Add Title Borders

        TitledBorder title = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Snake Eyes", TitledBorder.CENTER, TitledBorder.TOP);
        StartMenu.setBorder(title);
        How_to.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), null, TitledBorder.LEFT, TitledBorder.TOP));
        InSettings.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Settings", TitledBorder.LEFT, TitledBorder.TOP));  
        Result1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), null, TitledBorder.LEFT, TitledBorder.TOP));
        Result2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), null, TitledBorder.LEFT, TitledBorder.TOP));

        //Add Listeners

        Play.addActionListener(this);
        Help.addActionListener(this);
        Settings.addActionListener(this);
        X.addActionListener(this);
        Roll.addActionListener(this);
        PlayAgain.addActionListener(this);

        color.addChangeListener(this);

        //Add Action Commands

        Play.setActionCommand("Play");
        Help.setActionCommand("Help");
        Settings.setActionCommand("Settings");
        X.setActionCommand("X");
        Roll.setActionCommand("Roll");
        PlayAgain.setActionCommand("PlayAgain");

        //Add the things to the screen

        setContentPane(Background);
        getContentPane().setLayout(new GridBagLayout());
        getContentPane().add(StartMenu);
        getContentPane().add(How_to);
        getContentPane().add(InSettings);
        getContentPane().add(DiceResult);
        getContentPane().add(X);

    }

    public void actionPerformed(ActionEvent e)
    {    
        if(e.getActionCommand().equals("Play"))
        {
            StartMenu.setVisible(false);
            StartMenu.setEnabled(false); 
            setSize(1024, 768);
            X.setVisible(true);
            X.setEnabled(true);
            DiceResult.setEnabled(true);
            DiceResult.setVisible(true);
        }

        if(e.getActionCommand().equals("Help"))
        {
            //Disable the buttons 

            StartMenu.setVisible(false);
            StartMenu.setEnabled(false);

            //Enable the How to 

            How_to.setVisible(true);
            How_to.setEnabled(true);
            X.setVisible(true);
            X.setEnabled(true);
        }

        if(e.getActionCommand().equals("Settings"))
        {
            //Disable the buttons 

            StartMenu.setVisible(false);
            StartMenu.setEnabled(false);

            //Enable the Settings 

            InSettings.setEnabled(true);
            InSettings.setVisible(true);
            X.setVisible(true);
            X.setEnabled(true);
        }

        if(e.getActionCommand().equals("X"))
        {
            //Enable the buttons
            setContentPane(Background);
            setSize(new Dimension(500,280));

            StartMenu.setVisible(true);
            StartMenu.setEnabled(true);

            //Disable the other panels

            How_to.setVisible(false);
            How_to.setEnabled(false);
            InSettings.setEnabled(false);
            InSettings.setVisible(false);
            X.setVisible(false);
            X.setEnabled(false);
            DiceResult.setEnabled(false);
            DiceResult.setVisible(false);
            rolls = 0;
            Result.setText("Roll a 7 or 11 to win!");
            Result1.setIcon(null);
            Result2.setIcon(null);
            Roll.setEnabled(true);
            InGame.remove(Diceset11);
            InGame.remove(Diceset12);
            InGame.remove(Diceset13);
            InGame.remove(Diceset14);
            InGame.remove(Diceset15);
            InGame.remove(Diceset16);
            InGame.remove(Diceset21);
            InGame.remove(Diceset22);
            InGame.remove(Diceset23);
            InGame.remove(Diceset24);
            InGame.remove(Diceset25);
            InGame.remove(Diceset26);
            win = false;
            PlayAgain.setEnabled(false);
            PlayAgain.setVisible(false);
            end = false;
        }

        if(e.getActionCommand().equals("Roll"))
        {
            PlayAgain.setEnabled(false);
            PlayAgain.setVisible(false);
            InGame.remove(Diceset11);
            InGame.remove(Diceset12);
            InGame.remove(Diceset13);
            InGame.remove(Diceset14);
            InGame.remove(Diceset15);
            InGame.remove(Diceset16);
            InGame.remove(Diceset21);
            InGame.remove(Diceset22);
            InGame.remove(Diceset23);
            InGame.remove(Diceset24);
            InGame.remove(Diceset25);
            InGame.remove(Diceset26);

            D1R = ((int)(6 * random.nextDouble() + 1));
            D2R = ((int)(6 * random.nextDouble() + 1));         
            sum = D1R + D2R;

            if(rolls == 1)
            {
                if(D1R == D1Rtemp)
                {
                    if(D2R == D2Rtemp)    
                    {
                        win = true;
                        end = true;
                    }
                }
                if(D1R == D2Rtemp)
                {
                    if(D2R == D1Rtemp)    
                    {
                        win = true;
                        end = true;
                    }
                }
            }

            if((rolls == 0 && (sum == 2 || sum == 3 || sum == 12)) || (rolls == 1 && sum == 7))
            {
                Roll.setEnabled(false);
                Result.setText("Unfortunately you lost");
                end = true;
            }
            else if ( win || (rolls == 0 && (sum == 7 || sum == 11)))
            {
                Roll.setEnabled(false);
                Result.setText("Congratulations you win!");
                end = true;
            }
            else if (rolls == 0)
            {
                point = true;
                D1Rtemp = D1R;
                D2Rtemp = D2R;
                Result.setText("You need to roll a "+D1Rtemp+" and a "+ D2Rtemp +" to win!");
            }

            if(D1R == 1)
            {
                InGame.add(Diceset11);
                if(point)
                {
                    Result1.setIcon(Dice1ico);
                }
            }
            else if(D1R == 2)
            {
                InGame.add(Diceset12);
                if(point)
                {
                    Result1.setIcon(Dice2ico);
                }
            }
            else if(D1R == 3)
            {
                InGame.add(Diceset13);
                if(point)
                {
                    Result1.setIcon(Dice3ico);
                }
            }
            else if(D1R == 4)
            {
                InGame.add(Diceset14);
                if(point)
                {
                    Result1.setIcon(Dice4ico);
                }
            }
            else if(D1R == 5)
            {
                InGame.add(Diceset15); 
                if(point)
                {
                    Result1.setIcon(Dice5ico);
                }
            }
            else 
            {
                InGame.add(Diceset16);
                if(point)
                {
                    Result1.setIcon(Dice6ico);
                }
            }

            if(D2R == 1)
            {
                InGame.add(Diceset21);
                if(point)
                {
                    Result2.setIcon(Dice1ico);
                }
            }
            else if(D2R == 2)
            {
                InGame.add(Diceset22);
                if(point)
                {
                    Result2.setIcon(Dice2ico);
                }
            }
            else if(D2R == 3)
            {
                InGame.add(Diceset23);
                if(point)
                {
                    Result2.setIcon(Dice3ico);
                }
            }
            else if(D2R == 4)
            {
                InGame.add(Diceset24); 
                if(point)
                {
                    Result2.setIcon(Dice4ico);
                }
            }
            else if(D2R == 5)
            {
                InGame.add(Diceset25); 
                if(point)
                {
                    Result2.setIcon(Dice5ico);
                }
            }
            else 
            {
                InGame.add(Diceset26);
                if(point)
                {
                    Result2.setIcon(Dice6ico);
                }
            }

            InGame.revalidate();
            InGame.repaint();
            rolls = 1;
            point = false;

            if(end == true)
            {
                PlayAgain.setEnabled(true);
                PlayAgain.setVisible(true);
            }

        }

        if(e.getActionCommand().equals("PlayAgain"))
        {
            rolls = 0;
            Result.setText("Roll a 7 or 11 to win!");
            Result1.setIcon(null);
            Result2.setIcon(null);
            Roll.setEnabled(true);
            InGame.remove(Diceset11);
            InGame.remove(Diceset12);
            InGame.remove(Diceset13);
            InGame.remove(Diceset14);
            InGame.remove(Diceset15);
            InGame.remove(Diceset16);
            InGame.remove(Diceset21);
            InGame.remove(Diceset22);
            InGame.remove(Diceset23);
            InGame.remove(Diceset24);
            InGame.remove(Diceset25);
            InGame.remove(Diceset26);
            win = false;
            PlayAgain.setEnabled(false);
            PlayAgain.setVisible(false);
            end = false;
        }

    }

    public void stateChanged(ChangeEvent e)
    {
        ValueColor = color.getValue();

        if(ValueColor == 1)
        {
            Diceset11.setBackground(Color.WHITE);
            Diceset12.setBackground(Color.WHITE);
            Diceset13.setBackground(Color.WHITE);
            Diceset14.setBackground(Color.WHITE);
            Diceset15.setBackground(Color.WHITE);
            Diceset16.setBackground(Color.WHITE);

            Diceset21.setBackground(Color.WHITE);
            Diceset22.setBackground(Color.WHITE);
            Diceset23.setBackground(Color.WHITE);
            Diceset24.setBackground(Color.WHITE);
            Diceset25.setBackground(Color.WHITE);
            Diceset26.setBackground(Color.WHITE);

            DiceColorSet.setBackground(Color.WHITE);

            Result1.setBackground(Color.WHITE);
            Result2.setBackground(Color.WHITE);

            ColorType.setText("White");
        }
        else if(ValueColor == 2)
        {
            Diceset11.setBackground(Color.BLACK);
            Diceset12.setBackground(Color.BLACK);
            Diceset13.setBackground(Color.BLACK);
            Diceset14.setBackground(Color.BLACK);
            Diceset15.setBackground(Color.BLACK);
            Diceset16.setBackground(Color.BLACK);

            Diceset21.setBackground(Color.BLACK);
            Diceset22.setBackground(Color.BLACK);
            Diceset23.setBackground(Color.BLACK);
            Diceset24.setBackground(Color.BLACK);
            Diceset25.setBackground(Color.BLACK);
            Diceset26.setBackground(Color.BLACK);

            DiceColorSet.setBackground(Color.BLACK);

            Result1.setBackground(Color.BLACK);
            Result2.setBackground(Color.BLACK);

            ColorType.setText("Black");
        }
        else if(ValueColor == 3)
        {
            Diceset11.setBackground(Color.BLUE);
            Diceset12.setBackground(Color.BLUE);
            Diceset13.setBackground(Color.BLUE);
            Diceset14.setBackground(Color.BLUE);
            Diceset15.setBackground(Color.BLUE);
            Diceset16.setBackground(Color.BLUE);

            Diceset21.setBackground(Color.BLUE);
            Diceset22.setBackground(Color.BLUE);
            Diceset23.setBackground(Color.BLUE);
            Diceset24.setBackground(Color.BLUE);
            Diceset25.setBackground(Color.BLUE);
            Diceset26.setBackground(Color.BLUE);

            DiceColorSet.setBackground(Color.BLUE);

            Result1.setBackground(Color.BLUE);
            Result2.setBackground(Color.BLUE);

            ColorType.setText("Blue");
        }
        else if(ValueColor == 4)
        {
            Diceset11.setBackground(Color.CYAN);
            Diceset12.setBackground(Color.CYAN);
            Diceset13.setBackground(Color.CYAN);
            Diceset14.setBackground(Color.CYAN);
            Diceset15.setBackground(Color.CYAN);
            Diceset16.setBackground(Color.CYAN);

            Diceset21.setBackground(Color.CYAN);
            Diceset22.setBackground(Color.CYAN);
            Diceset23.setBackground(Color.CYAN);
            Diceset24.setBackground(Color.CYAN);
            Diceset25.setBackground(Color.CYAN);
            Diceset26.setBackground(Color.CYAN);

            DiceColorSet.setBackground(Color.CYAN);

            Result1.setBackground(Color.CYAN);
            Result2.setBackground(Color.CYAN);

            ColorType.setText("Cyan");
        }
        else if(ValueColor == 5)
        {
            Diceset11.setBackground(Color.DARK_GRAY);
            Diceset12.setBackground(Color.DARK_GRAY);
            Diceset13.setBackground(Color.DARK_GRAY);
            Diceset14.setBackground(Color.DARK_GRAY);
            Diceset15.setBackground(Color.DARK_GRAY);
            Diceset16.setBackground(Color.DARK_GRAY);

            Diceset21.setBackground(Color.DARK_GRAY);
            Diceset22.setBackground(Color.DARK_GRAY);
            Diceset23.setBackground(Color.DARK_GRAY);
            Diceset24.setBackground(Color.DARK_GRAY);
            Diceset25.setBackground(Color.DARK_GRAY);
            Diceset26.setBackground(Color.DARK_GRAY);

            DiceColorSet.setBackground(Color.DARK_GRAY);

            Result1.setBackground(Color.DARK_GRAY);
            Result2.setBackground(Color.DARK_GRAY);

            ColorType.setText("Dark Gray");
        }
        else if(ValueColor == 6)
        {
            Diceset11.setBackground(Color.GRAY);
            Diceset12.setBackground(Color.GRAY);
            Diceset13.setBackground(Color.GRAY);
            Diceset14.setBackground(Color.GRAY);
            Diceset15.setBackground(Color.GRAY);
            Diceset16.setBackground(Color.GRAY);

            Diceset21.setBackground(Color.GRAY);
            Diceset22.setBackground(Color.GRAY);
            Diceset23.setBackground(Color.GRAY);
            Diceset24.setBackground(Color.GRAY);
            Diceset25.setBackground(Color.GRAY);
            Diceset26.setBackground(Color.GRAY);

            DiceColorSet.setBackground(Color.GRAY);

            Result1.setBackground(Color.GRAY);
            Result2.setBackground(Color.GRAY);

            ColorType.setText("Gray");
        }
        else if(ValueColor == 7)
        {
            Diceset11.setBackground(Color.GREEN);
            Diceset12.setBackground(Color.GREEN);
            Diceset13.setBackground(Color.GREEN);
            Diceset14.setBackground(Color.GREEN);
            Diceset15.setBackground(Color.GREEN);
            Diceset16.setBackground(Color.GREEN);

            Diceset21.setBackground(Color.GREEN);
            Diceset22.setBackground(Color.GREEN);
            Diceset23.setBackground(Color.GREEN);
            Diceset24.setBackground(Color.GREEN);
            Diceset25.setBackground(Color.GREEN);
            Diceset26.setBackground(Color.GREEN);

            DiceColorSet.setBackground(Color.GREEN);

            Result1.setBackground(Color.GREEN);
            Result2.setBackground(Color.GREEN);

            ColorType.setText("Green");
        }
        else if(ValueColor == 8)
        {
            Diceset11.setBackground(Color.LIGHT_GRAY);
            Diceset12.setBackground(Color.LIGHT_GRAY);
            Diceset13.setBackground(Color.LIGHT_GRAY);
            Diceset14.setBackground(Color.LIGHT_GRAY);
            Diceset15.setBackground(Color.LIGHT_GRAY);
            Diceset16.setBackground(Color.LIGHT_GRAY);

            Diceset21.setBackground(Color.LIGHT_GRAY);
            Diceset22.setBackground(Color.LIGHT_GRAY);
            Diceset23.setBackground(Color.LIGHT_GRAY);
            Diceset24.setBackground(Color.LIGHT_GRAY);
            Diceset25.setBackground(Color.LIGHT_GRAY);
            Diceset26.setBackground(Color.LIGHT_GRAY);

            DiceColorSet.setBackground(Color.LIGHT_GRAY);

            Result1.setBackground(Color.LIGHT_GRAY);
            Result2.setBackground(Color.LIGHT_GRAY);

            ColorType.setText("Light Gray");
        }
        else if(ValueColor == 9)
        {
            Diceset11.setBackground(Color.MAGENTA);
            Diceset12.setBackground(Color.MAGENTA);
            Diceset13.setBackground(Color.MAGENTA);
            Diceset14.setBackground(Color.MAGENTA);
            Diceset15.setBackground(Color.MAGENTA);
            Diceset16.setBackground(Color.MAGENTA);

            Diceset21.setBackground(Color.MAGENTA);
            Diceset22.setBackground(Color.MAGENTA);
            Diceset23.setBackground(Color.MAGENTA);
            Diceset24.setBackground(Color.MAGENTA);
            Diceset25.setBackground(Color.MAGENTA);
            Diceset26.setBackground(Color.MAGENTA);

            DiceColorSet.setBackground(Color.MAGENTA);

            Result1.setBackground(Color.MAGENTA);
            Result2.setBackground(Color.MAGENTA);

            ColorType.setText("Magenta");
        }
        else if(ValueColor == 10)
        {
            Diceset11.setBackground(Color.ORANGE);
            Diceset12.setBackground(Color.ORANGE);
            Diceset13.setBackground(Color.ORANGE);
            Diceset14.setBackground(Color.ORANGE);
            Diceset15.setBackground(Color.ORANGE);
            Diceset16.setBackground(Color.ORANGE);

            Diceset21.setBackground(Color.ORANGE);
            Diceset22.setBackground(Color.ORANGE);
            Diceset23.setBackground(Color.ORANGE);
            Diceset24.setBackground(Color.ORANGE);
            Diceset25.setBackground(Color.ORANGE);
            Diceset26.setBackground(Color.ORANGE);

            DiceColorSet.setBackground(Color.ORANGE);

            Result1.setBackground(Color.ORANGE);
            Result2.setBackground(Color.ORANGE);

            ColorType.setText("Orange");
        }
        else if(ValueColor == 11)
        {
            Diceset11.setBackground(Color.PINK);
            Diceset12.setBackground(Color.PINK);
            Diceset13.setBackground(Color.PINK);
            Diceset14.setBackground(Color.PINK);
            Diceset15.setBackground(Color.PINK);
            Diceset16.setBackground(Color.PINK);

            Diceset21.setBackground(Color.PINK);
            Diceset22.setBackground(Color.PINK);
            Diceset23.setBackground(Color.PINK);
            Diceset24.setBackground(Color.PINK);
            Diceset25.setBackground(Color.PINK);
            Diceset26.setBackground(Color.PINK);

            DiceColorSet.setBackground(Color.PINK);

            Result1.setBackground(Color.PINK);
            Result2.setBackground(Color.PINK);

            ColorType.setText("Pink");
        }
        else if(ValueColor == 12)
        {
            Diceset11.setBackground(Color.RED);
            Diceset12.setBackground(Color.RED);
            Diceset13.setBackground(Color.RED);
            Diceset14.setBackground(Color.RED);
            Diceset15.setBackground(Color.RED);
            Diceset16.setBackground(Color.RED);

            Diceset21.setBackground(Color.RED);
            Diceset22.setBackground(Color.RED);
            Diceset23.setBackground(Color.RED);
            Diceset24.setBackground(Color.RED);
            Diceset25.setBackground(Color.RED);
            Diceset26.setBackground(Color.RED);

            DiceColorSet.setBackground(Color.RED);

            Result1.setBackground(Color.RED);
            Result2.setBackground(Color.RED);

            ColorType.setText("Red");
        }
        else
        {
            Diceset11.setBackground(Color.YELLOW);
            Diceset12.setBackground(Color.YELLOW);
            Diceset13.setBackground(Color.YELLOW);
            Diceset14.setBackground(Color.YELLOW);
            Diceset15.setBackground(Color.YELLOW);
            Diceset16.setBackground(Color.YELLOW);

            Diceset21.setBackground(Color.YELLOW);
            Diceset22.setBackground(Color.YELLOW);
            Diceset23.setBackground(Color.YELLOW);
            Diceset24.setBackground(Color.YELLOW);
            Diceset25.setBackground(Color.YELLOW);
            Diceset26.setBackground(Color.YELLOW);

            DiceColorSet.setBackground(Color.YELLOW);

            Result1.setBackground(Color.YELLOW);
            Result2.setBackground(Color.YELLOW);

            ColorType.setText("Yellow");
        }

    }

    public static void main(String[] args)
    {
        SnakeEyes frame = new SnakeEyes();
        frame.setSize(500,280);

        frame.setResizable(false);

        frame.setVisible(true);
    }
}
